# 🏋️ **프리미엄 헬스장 관리 시스템**

![jsp메인](https://chestnut-blinker-ca6.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F8cd794c0-c633-4008-b289-af6deeea8c4d%2Ffe1fbb5b-4dc0-461a-96a4-bcdabb325a44%2Fimage.png?table=block&id=169902bd-b12f-80eb-b7b9-cd98b3b4679a&spaceId=8cd794c0-c633-4008-b289-af6deeea8c4d&width=1420&userId=&cache=v2)

---

## 🎥 **시연 영상 보기**  
[**시연 영상 링크**](#)

---

## 📚 **주제 선정 및 배경**
- 현대인의 건강과 운동에 대한 관심이 높아짐에 따라 헬스장은 필수적인 생활공간이며 이용자가 더욱 편리하게 헬스장을 이용할 수 있도록 하기 위함

---

## 👥 **팀 구성**
| **이름**   | **담당 기능**                       |
|-----------|----------------------------------|
| **오승원** | 메인화면구성, 출석체크(QR), 출석내역관리, 출석랭킹조회, 이용권내역조회 |
| **이세진** | 이용권, 트레이너 프로필, 결제, 구매내역, 매출조회 |
| **홍성윤** | 예약기능, 캘린더API연동, 관리자 페이지 레이아웃 |
| **김도현** | 회원관리, 문의사항 게시판, 회원가입 및 로그인, 커스텀 에러페이지 |
| **조하은** | 회원 일정관리, 트레이너 코멘트관리, 캘린더API연동 |

---

## 🗓️ **프로젝트 기간**
**2024-11-27 ~ 2024-12-13**

---

## 🚀 **프로젝트 수행 절차**
1. **주제선정 및 기획 의도 선정**  
2. **요구사항, 기능 정의서 작성, 피그마 화면 설계**  
3. **ERD 설계 DB, 프로젝트 구조 구축**  
4. **개발 및 테스트**  
5. **수정 및 확정, 결과보고서 작성**

---

<details>
  <summary><h2>🛠️ <strong>개발 환경</strong></h2></summary>
  
  ![개발 환경 이미지](https://chestnut-blinker-ca6.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F8cd794c0-c633-4008-b289-af6deeea8c4d%2Fa15b7295-4884-4d79-a760-47e8a23443c3%2Fimage.png?table=block&id=169902bd-b12f-8054-9a60-fc844af24385&spaceId=8cd794c0-c633-4008-b289-af6deeea8c4d&width=1090&userId=&cache=v2)

</details>

---

<details>
  <summary><h2>📑 <strong>요구사항 정의서</strong></h2></summary>
  
  - 요구사항 정의서  
    ![image](https://github.com/user-attachments/assets/6628cdef-0e84-469a-9f1a-c7409b145b70)

</details>

---

<details>
  <summary><h2>📊 <strong>기능 정의서</strong></h2></summary>
  
  - 사용자(유저) 기능 정의서  
    ![image](https://github.com/user-attachments/assets/36f473e1-be4c-412c-aa74-a4ae4850f6ea)  
  - 관리자 기능 정의서  
    ![image](https://github.com/user-attachments/assets/6e0eef6f-38a4-46fc-9309-9233e7c01a9a)

</details>

---

<details>
  <summary><h2>🗂️ <strong>ERD</strong></h2></summary>
  
  ![ERD 이미지](https://chestnut-blinker-ca6.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F8cd794c0-c633-4008-b289-af6deeea8c4d%2F2317d53d-12bb-40e1-bf7e-43a3f29dda8a%2Fimage.png?table=block&id=16b902bd-b12f-8032-8568-e03391399423&spaceId=8cd794c0-c633-4008-b289-af6deeea8c4d&width=1920&userId=&cache=v2)

</details>

---

<details>
  <summary><h2>🗂️ <strong>테이블 정의서</strong></h2></summary>

  **users **  
  ![파일 1](https://drive.google.com/uc?export=view&id=1uIkf6OmogJD5af0uHBwp7YV3TTbpH3VZ)

  **userAuth**  
  ![파일 2](https://drive.google.com/uc?export=view&id=1jN24i-GWXzEaQF1ihnPVtD_BxswsBx_r)

  **trainer_profile**  
  ![파일 3](https://drive.google.com/uc?export=view&id=1TPs7lZxuO-pEYjJHMdNwJWV61aEUtdf9)

  **ticket**  
  ![파일 4](https://drive.google.com/uc?export=view&id=1scpM-FcbpngM4dxbmNXPtbgUdVckzusZ)

  **reservation**  
  ![파일 5](https://drive.google.com/uc?export=view&id=1xvzmCFNDani9r9_2bwRL4lEzRCZBXmIN)

  **qr_code**  
  ![파일 6](https://drive.google.com/uc?export=view&id=18iWrwLE9zu-smJXRqkG0e2l2ZFN8uTqI)

  **plan**  
  ![파일 7](https://drive.google.com/uc?export=view&id=1b2RnAr5tEDigonnXHQxR9BaWqA42da09)

  **persistent_logins**  
  ![파일 8](https://drive.google.com/uc?export=view&id=18N74mHKPW_teWLFvMnrmO_g9BT7kMB_X)

  **file**  
  ![파일 9](https://drive.google.com/uc?export=view&id=1LZ9m864zA8lH-9QELMlB3eMvwYrSozVY)

  **comment**  
  ![파일 10](https://drive.google.com/uc?export=view&id=1XMzew_jB9ZQr48ADICPEvtZIUg27Fw4E)

  **buy_list**  
  ![파일 11](https://drive.google.com/uc?export=view&id=1jBHzorTvyaTU4mbavzbr8hU-AmjM0GAV)

  **board**  
  ![파일 12](https://drive.google.com/uc?export=view&id=1EttYQgue7v7_pV5ST8ZMe9LE25uHIALg)

  **attendance**  
  ![파일 13](https://drive.google.com/uc?export=view&id=1XhCdlUg7401eCwPyEmInVpV7fgyPHMJJ)

  **answer**  
  ![파일 14](https://drive.google.com/uc?export=view&id=1ecTX_u14K37SFcFf8VHYahDJGN8yru5g)

</details>







---

<details>
  <summary><h2>🖥️ <strong>스토리보드 (화면 설계서)</strong></h2></summary>
  
  - 로그인 화면  
  - 메인 화면  
  - 예약 화면  
  - 관리자 화면  

</details>

---

## 🎯 **주요 기능**
✅ 회원가입 및 로그인/로그아웃  
✅ QR코드 기반 출입 관리  
✅ PT 예약 및 트레이너 스케줄 관리  
✅ 회원 정보 수정 및 권한 관리  
✅ 관리자 페이지를 통한 회원 및 예약 관리  
✅ 이용 통계 제공  

---

<details>
  <summary><h2>📝 <strong>프로젝트 리뷰</strong></h2></summary>
  
  - **🏠 메인 화면:** 메인 페이지에서 핵심 기능에 대한 접근 제공  
  - **🧑‍🤝‍🧑 회원가입:** 신규 사용자 등록 및 정보 입력  
  - **🔑 로그인:** 사용자 로그인 및 세션 유지  
  - **🛡️ 회원정보 수정:** 개인정보 수정 및 업데이트  
  - **📅 PT 예약:** 트레이너와의 PT 일정 예약 및 확인  

</details>

---




