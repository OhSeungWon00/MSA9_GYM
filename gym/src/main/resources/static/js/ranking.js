document.addEventListener('DOMContentLoaded', function () {
        console.log("Document loaded");

        // 사용자 ID 가져오기
        const myUserId = document.getElementById('my-ranking-btn').getAttribute('data-user-id');
        console.log("로그인한 사용자 ID:", myUserId);

        document.getElementById('my-ranking-btn').addEventListener('click', function () {
            console.log("My ranking button clicked");

            if (myUserId === 'null' || myUserId.trim() === '') {
                alert("로그인이 필요한 기능입니다."); // 로그인하지 않은 경우 표시
            }

            const targetRank = document.getElementById(`rank-${myUserId}`);
            if (!targetRank) {
                console.error("Cannot find the rank element with ID: rank-" + myUserId);
                alert("출석 정보가 존재하지 않습니다."); 
                return;
            }

            console.log("찾은 랭킹 요소:", targetRank);

            // 스크롤 동작
            targetRank.scrollIntoView({
                behavior: 'smooth',
                block: 'center'
            });

            // 하이라이트 효과 
            targetRank.classList.add('highlight');
            setTimeout(() => {
                targetRank.classList.remove('highlight');
            }, 2000); // 2초 후 끝
        });
    });
