
## MOVIEWIKI - 영화 포스팅 프로그램


### 프로젝트 기간
- 2022.05.12 ~ 2022.05.16

</br>

### 프로젝트 설명
- 소켓 통신을 사용한 클라이언트의 다중 접속 구현
- 서버 - 클라이언트 / 관리자 프로그램으로 분리
- DB와 연결하여 CRUD 기능 구현

</br>

### 파트 분배
- 하만준 : DB 설계, 소켓 통신을 사용한 양방향 통신/클라이언트의 다중접속 기능
- 박지현 : DB 설계, 관리자 프로그램 GUI, DB Connection, 클라이언트 기능
- 임희진 : DB 설계, 클라이언트 프로그램 GUI, 관리자 측 영화에 대한 CRUD 기능

</br>

### 기능

#### 클라이언트 프로그램
- 영화 정보 조회
- 배우 정보 조회
- 최신 영화 목록 조회
- 영화 및 배우의 상세 정보 검색


#### 관리자 프로그램
- 등록된 영화 목록 조회
- 영화 정보 등록
- 영화 정보 수정 (평점, 매출 등)
- 영화 정보 삭제

</br>

### 화면 구성


#### 클라이언트

- 영화, 배우 목록 각각 JList로 구현
- 리스트의 항목 선택하여 영화, 배우에 대한 검색
- 영화, 배우의 검색 결과에 대한 배우, 영화 정보 재검색

|영화 목록 조회|배우 목록 조회|
|--|--|
|![KakaoTalk_20220801_220912596_02](https://user-images.githubusercontent.com/96460131/182155924-c4c3ebc6-6749-4cda-b5d9-5dff437551b4.gif)|![KakaoTalk_20220801_220022223](https://user-images.githubusercontent.com/96460131/182153814-f3698504-28c5-41c7-a01f-56e972c24d5a.gif)|

<br/>

- 클라이언트의 다중 접속

<img src="https://user-images.githubusercontent.com/96460131/181407536-dbf637e2-1efc-47ea-9191-dc2efb2bd89a.png" width=70% height=70%/>

</br>

#### 관리자
- 영화 데이터 관리


|조회|등록|
|--|--|
|<img src="https://user-images.githubusercontent.com/96460131/181407637-9b3017dd-5831-47c9-939b-6917ecd8df78.png"/>|![KakaoTalk_20220801_220912596_01](https://user-images.githubusercontent.com/96460131/182156758-f0f493bf-e9bc-4997-bdb0-b6dbab2d500e.gif)|

<br/>

|수정|삭제|
|--|--|
|<img src="https://user-images.githubusercontent.com/96460131/181407968-625ede87-3dce-4a76-9a6e-30f832e4df1c.png"/>|<img src="https://user-images.githubusercontent.com/96460131/181408111-ab87ad1b-08de-443b-b775-410c705021bd.png"/>|


</br>
