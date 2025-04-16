<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>그로우디 - 비즈니스 성장 파트너</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome 아이콘 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- 사용자 정의 CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <!-- Google Fonts - 둥근 고딕체 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- 헤더 영역 시작 -->
    <header class="fixed-top">
        <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
            <div class="container">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                    <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Growdy 로고" height="40">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" 
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#home">홈</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#services">서비스</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#portfolio">포트폴리오</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#testimonials">고객 후기</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contact">문의하기</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <!-- 헤더 영역 끝 -->
</body>
</html> 