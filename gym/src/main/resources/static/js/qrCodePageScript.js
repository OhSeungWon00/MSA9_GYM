// 카운트다운 타이머
var countdownElement = document.getElementById('countdown');
var unitElement = document.getElementById('unit');
var qrCodeContainer = document.getElementById('qrCodeContainer');
var mainButton = document.getElementById('mainButton');
var URLTEXT = document.getElementById('URLTEXT');
var URLTEXT2 = document.getElementById('URLTEXT2');
var countdown = 60;


// QR 코드 UUID 가져오기
var qrCodeUUID = document.querySelector('input[name="qrCode"]').value;
var csrfToken = document.querySelector('input[name="csrf"]').value;

console.log('qrCodeUUID' + qrCodeUUID);


function updateCountdown() {
    countdown--;
    countdownElement.textContent = countdown;


    // 카운트가 끝나면 모두 숨기게
    if (countdown <= 0) {
        clearInterval(countdownInterval);
        countdownElement.textContent = '만료되었습니다.';
        unitElement.style.display = 'none'; 
        qrCodeContainer.style.display = 'none'; 
        URLTEXT.style.display = 'none'; 
        URLTEXT2.style.display = 'none'; 

        // 서버에 QR 코드 삭제 요청
        deleteQRCode();

    }
}

var countdownInterval = setInterval(updateCountdown, 1000);



// 유효시간 만료 시 qr코드 삭제 요청
function deleteQRCode() {
    fetch('/generate-qr-code/delete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken,
            },
            body: JSON.stringify({
                uuid: qrCodeUUID 
            }) 
        })
        .then(response => {
            if (!response.ok) {
                console.error('QR 코드 삭제 요청 실패');
            } else {
                console.log('QR 코드가 성공적으로 삭제되었습니다.');
            }
        })
        .catch(error => console.error('에러 발생:', error));
}

// 메인 이동
function goToMain() {
    window.location.href = '/';
}
