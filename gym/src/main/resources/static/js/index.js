// 상단으로 이동 버튼
var topBtn = document.getElementById("topBtn");

// 스크롤 시 버튼 
window.onscroll = function () {
    toggleScrollButton();
};

// 스크롤이 20px 이상일 경우 버튼 보이게
function toggleScrollButton() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        topBtn.style.display = "block";  
    } else {
        topBtn.style.display = "none";  
    }
}

// 상단으로 이동
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;  
}

// 페이지 새로고침 시 최상단으로 스크롤
window.onload = function() {
    window.scrollTo(0, 0); 
}

// 화면 이동 시 등장 
window.addEventListener("DOMContentLoaded", () => {
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible');  
            }
        });
    }, {
        threshold: 0.5  // 50% 이상 화면에 보이면 효과 
    });

    const target = document.querySelector('.main-image2');
    if (target) {
        observer.observe(target); 
    } else {
        console.warn("⚠️ '.main-image2' 요소를 찾을 수 없습니다.");
    }
});

// 에러 메시지 
var errorMessage = /*[[${errorMessage}]]*/ '';
if (errorMessage) {
    alert(errorMessage);  
}
