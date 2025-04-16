/**
 * Growdy - 비즈니스 소개 웹사이트
 * 메인 자바스크립트 파일
 */

$(document).ready(function() {
    
    // 스크롤 시 헤더 스타일 변경
    $(window).scroll(function() {
        if ($(this).scrollTop() > 50) {
            $('header').addClass('bg-white shadow-sm');
            $('.navbar').addClass('py-2').removeClass('py-3');
        } else {
            $('header').removeClass('shadow-sm');
            $('.navbar').removeClass('py-2').addClass('py-3');
        }
    });
    
    // 부드러운 스크롤 (앵커 링크)
    $('a[href^="#"]').on('click', function(e) {
        e.preventDefault();
        
        var target = this.hash;
        var $target = $(target);
        
        $('html, body').animate({
            'scrollTop': $target.offset().top - 70
        }, 800, 'swing');
    });
    
    // 고객 후기 슬라이더 (Slick 슬라이더 사용)
    if ($('.testimonials-slider').length) {
        $('.testimonials-slider').slick({
            dots: true,
            infinite: true,
            speed: 300,
            slidesToShow: 3,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 5000,
            responsive: [
                {
                    breakpoint: 992,
                    settings: {
                        slidesToShow: 2
                    }
                },
                {
                    breakpoint: 576,
                    settings: {
                        slidesToShow: 1
                    }
                }
            ]
        });
    }
    
    // 문의 폼 유효성 검사
    $('#contactForm').on('submit', function(e) {
        e.preventDefault();
        
        var isValid = true;
        var name = $('#name').val();
        var email = $('#email').val();
        var subject = $('#subject').val();
        var message = $('#message').val();
        
        // 이름 검사
        if (name === '') {
            isValid = false;
            $('#name').addClass('is-invalid');
        } else {
            $('#name').removeClass('is-invalid').addClass('is-valid');
        }
        
        // 이메일 검사
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (email === '' || !emailRegex.test(email)) {
            isValid = false;
            $('#email').addClass('is-invalid');
        } else {
            $('#email').removeClass('is-invalid').addClass('is-valid');
        }
        
        // 주제 검사
        if (subject === '' || subject === '문의 주제를 선택하세요') {
            isValid = false;
            $('#subject').addClass('is-invalid');
        } else {
            $('#subject').removeClass('is-invalid').addClass('is-valid');
        }
        
        // 메시지 검사
        if (message === '') {
            isValid = false;
            $('#message').addClass('is-invalid');
        } else {
            $('#message').removeClass('is-invalid').addClass('is-valid');
        }
        
        // 폼이 유효한 경우
        if (isValid) {
            // 실제 서버 통신 코드 대신 알림창으로 대체
            alert('문의가 성공적으로 전송되었습니다. 빠른 시일 내에 답변 드리겠습니다.');
            
            // 폼 초기화
            $('#contactForm')[0].reset();
            $('.form-control').removeClass('is-valid');
        }
    });
    
    // 애니메이션 효과 (스크롤 시 요소 나타나기)
    function animateOnScroll() {
        $('.animate-on-scroll').each(function() {
            if ($(this).offset().top < $(window).scrollTop() + $(window).height() - 100) {
                $(this).addClass('animated');
            }
        });
    }
    
    // 초기 실행 및 스크롤 이벤트에 함수 바인딩
    animateOnScroll();
    $(window).scroll(animateOnScroll);
    
}); 