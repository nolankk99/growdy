# Growdy - 비즈니스 소개 웹사이트

스타트업 및 프리랜서를 위한 비즈니스 소개 웹사이트입니다. Spring Boot, Thymeleaf, Bootstrap 5, jQuery, HTML5, CSS3를 활용하여 구현되었습니다.

## 프로젝트 개요

- **목적**: 스타트업 및 프리랜서를 위한 회사 소개 웹사이트
- **기술 스택**: Spring Boot, Thymeleaf, Bootstrap 5, jQuery, HTML5, CSS3

## 주요 기능 및 구성

1. **헤더**: 로고 및 내비게이션 메뉴를 포함
2. **메인 배너(히어로 섹션)**: 브랜드 슬로건과 CTA 버튼 배치
3. **서비스 소개 섹션**: 주요 서비스 3가지 소개 (아이콘 및 설명 포함)
4. **포트폴리오 섹션**: 카드 레이아웃으로 구성된 프로젝트 사례
5. **고객 후기 섹션**: 슬라이더 형태로 구현
6. **문의 폼 섹션**: 이름, 이메일, 메시지 입력 필드 포함
7. **푸터**: 연락처, SNS 아이콘, 저작권 정보 포함

## 디렉토리 구조

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── growdy/
│   │           └── web/
│   │               ├── controller/
│   │               │   ├── HomeController.java
│   │               │   └── ContactController.java
│   │               ├── model/
│   │               │   └── ContactForm.java
│   │               └── GrowdyWebApplication.java
│   └── resources/
│       ├── static/
│       │   ├── css/
│       │   │   └── style.css
│       │   ├── js/
│       │   │   └── script.js
│       │   └── images/
│       ├── templates/
│       │   └── index.html
│       └── application.properties
```

## 설치 및 실행 방법

1. JDK 11 이상과 Maven이 설치되어 있어야 합니다.
2. 프로젝트를 클론하거나 다운로드합니다.
3. 다음 명령어로 애플리케이션을 실행합니다:
   ```
   mvn spring-boot:run
   ```
4. 웹 브라우저에서 `http://localhost:8080`에 접속합니다.

## 사용 기술 및 라이브러리

- **Spring Boot**: 웹 애플리케이션 개발 프레임워크
- **Thymeleaf**: 서버 사이드 Java 템플릿 엔진
- **Bootstrap 5**: 반응형 레이아웃 및 UI 컴포넌트
- **jQuery**: DOM 조작 및 이벤트 처리
- **Font Awesome**: 아이콘 세트
- **Slick Slider**: 고객 후기 슬라이더 구현
- **Lombok**: 자바 코드 간소화를 위한 라이브러리

## 프로젝트 특징

- 모던하고 깔끔한 UI 디자인
- 반응형 레이아웃으로 모든 기기에서 최적화된 사용자 경험 제공
- 브랜드 컬러(#3b82f6)를 활용한 일관된 디자인 적용
- 둥근 고딕체 느낌의 타이포그래피 사용
- Bootstrap의 Grid 시스템을 활용한 레이아웃 구성 