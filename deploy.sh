#!/bin/bash

# 배포 스크립트
# 사용법: ./deploy.sh [prod|dev]

# 기본 환경 설정
ENV=${1:-prod}
APP_NAME="growdy"
APP_PATH="/var/www/$APP_NAME"
JAR_FILE="target/$APP_NAME.jar"
LOG_FILE="/var/log/$APP_NAME/deploy.log"
PID_FILE="/var/run/$APP_NAME.pid"

# 로그 디렉토리 생성
mkdir -p /var/log/$APP_NAME

# 로그 함수
log() {
    echo "[$(date +'%Y-%m-%d %H:%M:%S')] $1" | tee -a $LOG_FILE
}

# 애플리케이션 중지 함수
stop_app() {
    if [ -f $PID_FILE ]; then
        PID=$(cat $PID_FILE)
        if kill -0 $PID 2>/dev/null; then
            log "애플리케이션 중지 중... (PID: $PID)"
            kill $PID
            sleep 10
            
            if kill -0 $PID 2>/dev/null; then
                log "애플리케이션이 종료되지 않아 강제 종료합니다."
                kill -9 $PID
            fi
            
            log "애플리케이션이 중지되었습니다."
        else
            log "애플리케이션이 실행 중이 아니지만 PID 파일이 존재합니다. 파일을 삭제합니다."
        fi
        rm -f $PID_FILE
    else
        log "애플리케이션이 실행 중이 아닙니다."
    fi
}

# Maven 빌드 함수
build_app() {
    log "애플리케이션 빌드를 시작합니다. (환경: $ENV)"
    
    if [ "$ENV" == "prod" ]; then
        ./mvnw clean package -Pprod -DskipTests
    else
        ./mvnw clean package -DskipTests
    fi
    
    if [ $? -ne 0 ]; then
        log "빌드에 실패했습니다."
        exit 1
    fi
    
    log "빌드가 완료되었습니다."
}

# 애플리케이션 시작 함수
start_app() {
    log "애플리케이션을 시작합니다. (환경: $ENV)"
    
    if [ "$ENV" == "prod" ]; then
        nohup java -jar -Dspring.profiles.active=prod $JAR_FILE > /var/log/$APP_NAME/app.log 2>&1 &
    else
        nohup java -jar $JAR_FILE > /var/log/$APP_NAME/app.log 2>&1 &
    fi
    
    PID=$!
    echo $PID > $PID_FILE
    
    log "애플리케이션이 시작되었습니다. (PID: $PID)"
    
    # 애플리케이션 상태 확인
    sleep 10
    if kill -0 $PID 2>/dev/null; then
        log "애플리케이션이 정상적으로 실행 중입니다."
    else
        log "애플리케이션 시작에 실패했습니다. 로그를 확인하세요."
        exit 1
    fi
}

# 백업 함수
backup_app() {
    BACKUP_DIR="/var/backups/$APP_NAME"
    BACKUP_FILE="$BACKUP_DIR/$APP_NAME-$(date +'%Y%m%d%H%M%S').jar"
    
    mkdir -p $BACKUP_DIR
    
    if [ -f $JAR_FILE ]; then
        log "이전 버전을 백업합니다."
        cp $JAR_FILE $BACKUP_FILE
        log "백업 완료: $BACKUP_FILE"
        
        # 30일 이상 된 백업 삭제
        find $BACKUP_DIR -name "$APP_NAME-*.jar" -type f -mtime +30 -delete
    else
        log "백업할 이전 버전이 없습니다."
    fi
}

# 메인 실행 부분
log "===== $APP_NAME 배포 스크립트 시작 ($ENV 환경) ====="

# 백업 수행
backup_app

# 애플리케이션 중지
stop_app

# 빌드 수행
build_app

# 애플리케이션 시작
start_app

log "===== $APP_NAME 배포 스크립트 완료 =====" 