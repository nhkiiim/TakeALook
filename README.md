# 🛍 &nbsp;Take a Look 
- 개인과 개인이 거래 가능한 P2P 라이브 커머스 플랫폼
- 화상 미팅을 통해 실시간으로 거래 물품의 상태와 상대방의 신원을 확인하여 신뢰도 있는 거래를 지원
- 경매 시스템을 차용하여 실시간 가격제안을 통해 원하는 가격 제시
- 낙찰된 구매자와 판매자가 1:1 채팅으로 자동매칭되어 상세 거래 가능

<br>

## 🛠 &nbsp;주요 기술 스택
**_Backend_**
  - Spring Boot
  - JPA(Hibernate)
  - WebSocket
  - STOMP
  - Kurento
  - coturn

**_Frontend_**
  - vue.js
  - Axios
  - element-ui

**_DevOps_**
  - AWS
  - Docker
  - Jenkins
<br>

## 🌐 &nbsp;배포 환경
- __URL__ : https://i5d101.p.ssafy.io:8083/
- __테스트용 아이디__ : (ID: ssafy / PWD: !ssafy1234)
- __배포 여부__ : O
- __접속 가능__ : O
- __HTTPS 적용__ : O 

<br>

## 💡&nbsp;서비스 차별점/독창성
- 개인간 온라인 거래 시 거래 물품의 상태를 제대로 확인하지 못한다는 단점을 보완하여 
  <br>**실시간 미팅과 채팅을 통해 상대방의 신원을 확인하고 거래 물품의 상태를 상세히 확인할 수 있다.** 
  
- 기업을 판매자로 하는 기존 라이브 커머스 플랫폼과는 달리 **개인이 판매자, 구매자 모두가 될 수 있다.**

<br>

## 🧐 &nbsp;기대효과
- 실시간으로 상품과 신원 확인이 가능해 보다 안전한 거래 가능
- 개인이 판매자나 구매자가 되어 원하는 시간과 날짜에 거래 가능
- 가격 제시를 통해 합리적인 가격으로 구매와 판매 가능
- 거래가 성사된 후, 사이트 내 채팅을 통해 쉽고 편하게 연락 가능

<br>

## 🔥 &nbsp;주요 기능
### **1. 회원관리**
> - **회원관리** : 각 데이터를 유효성 검사 후 회원가입, 로그인, 회원정보 수정
>
> <img width="500" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132128225-89d000e0-d602-4723-95cf-ccd0356ca3f2.png">
> <img width="500" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132128230-a9b905c0-06fe-44f7-8388-a85d3e5b9d9e.png">
> <img width="500" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132128229-2dc97604-3f99-4ad0-9e3d-0a38149e7437.png">

<br>

### **2. 판매 상품 등록**
> - **판매 게시글 작성** : 판매 방송을 시작할 시간과 이미지/상품분류/거래시작가격/제품설명 을 입력한 뒤 게시글 등록
>
> <img width="800" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132132361-577a407b-4406-453e-82f3-0d64d7bb4ad5.png">

<br>

### **3. 판매 상품 조회**
> - **검색** : 카테고리, 키워드에 따라 삼품 검색
>
> - **정렬** : 신상품순/높은가격순/낮은가격순/거래시간순 을 기준으로 상품 정렬, JPA를 통해 페이지네이션하여 출력
>
> <img width="800" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132127634-3336d980-49e2-4a8c-9e6b-8ebca5632707.png">

<br>

> - **상품 상세 조회** : 상품 상세 정보와 이미지를 확인 가능하며 찜하여 관심목록에 추가
>
> - **상품 추천** : 동일 카테고리의 상품을 추천
>
> <img width="800" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132128772-e110929c-00b7-4283-a8d7-e43aecc6fcbb.png">
                             
<br>

> - **나의 판매 목록 조회** : 사용자가 판매하기위해 등록해둔 상품과 이미 판매했던 상품을 조회
>
><img width="800" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132133739-6a217a11-b183-48c4-8d5b-e085739fca52.png">

<br>

### **4. 판매 방송(거래 미팅)**
> - **판매 시작** : 예약한 시간 20분 전부터 방 개설이 가능하며 예약한 시간이 지나도 방을 개설하지 않을 경우 이벤트 스케줄러를 통해 거래 완료 처리
>
> - **호가 단위 설정** : 방을 개설하기 전 판매자가 호가 단위를 설정
>
> - **판매 방송 입장** : 판매자는 거래시작 버튼을, 구매자는 입장 버튼을 통해 판매 방송 입장
> 
> <img width="300" alt="스크린샷 2021-09-06 오전 12 56 03" src="https://user-images.githubusercontent.com/59560592/132133307-1778237e-ecf8-4602-862d-e878da829c14.png"><img width="300" alt="스크린샷 2021-09-06 오전 12 56 23" src="https://user-images.githubusercontent.com/59560592/132133310-4f25c001-1c6e-4b77-8e5e-7af59f4ad26e.png">

<br>

> - **판매 방송(판매자)** : 판매자는 판매 상품을 설명한 뒤 카운트 시작 버튼으로 거래 시작 
>
> - **거래 타이머** : 30초의 카운트 동안 가격 제안, 특정 사용자가 가격 제안 시 카운트 초기화, 30초동안 아무 제안이 없을 시 최종 제안자가 낙찰
> 
> <img width="800" alt="스크린샷 2021-09-06 오전 1 01 34" src="https://user-images.githubusercontent.com/59560592/132133490-13737f72-f1e5-4f35-9ddd-1c24cc2f8f78.png">

<br>

> - **판매 방송(구매자)** : 구매자는 30초 안에 + 버튼으로 호가 단위만큼 가격을 높여 제안 가능 
>
> - **채팅** : 판매 방송에서 음성뿐만 아니라 채팅을 통해 구매자와 상호작용 가능
> 
><img width="800" alt="스크린샷 2021-09-06 오전 1 01 07" src="https://user-images.githubusercontent.com/59560592/132133610-b5739275-0cd0-457f-b59b-9ccc472a7015.png">

<br>

### **5. 1:1 채팅**
> - **채팅 목록** : 판매 방송에서 가격이 낙찰되어 구매자가 될 경우 자동으로 채팅 방 생성
>
> - **채팅** : 1:1 채팅을 통해 거래 완료
> 
><img width="400" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132133959-b310819b-5ae5-4b63-b22f-24383175e823.gif">

<br>

### **6. 구매 목록**
> - **나의 구매 목록 조회** : 사용자가 물품을 낙찰했을 경우 구매 목록에 추가, 나의 구매 목록에서 조회 가능
>
> <img width="800" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132132281-22d1a84d-7466-4811-8328-06937fb59c8d.png">

<br>

### **7. 관심 목록**
> - **관심 목록 조회** : 찜 버튼을 눌러 관심 등록한 상품 확인, 찜한 사람의 수는 버튼 옆에 표시
>
> <img width="800" alt="스크린샷" src="https://user-images.githubusercontent.com/59560592/132134267-dd8b7142-917c-4757-b6eb-444726252154.png">

<br>


