# 로그인 기능
## 기능 목록
- 로그인 화면 구현하기
    - 아이디 입력창
    - 패스워드 입력창
    - 로그인 버튼
    - 취소 버튼
- 아이디와 패스워드 정보 기록 → VO
- 사용자 입력받기
  - 아이디 입력
    - 예외 : 아이디에 한글 입력
  - 패스워드 입력
    - 패스워드는 숫자만 가능?
    - ⭐️ 예외 처리 고민 할 것
- 아이디와 패스워드 일치 확인하기
  - 일치
    - 성공 알림
    - 로그 분석 기능 호출
  - 불일치
    - 실패 알림
    - 로그인으로 돌아가기
- 취소 버튼 누르면 종료
***
# 로그 분석 기능
## 기능 목록
- 로그 분석 화면 구현하기
  - view 버튼
    - Dialog 출력 구현
  - report생성 버튼
    - 정상 저장 알림창
  - 라디오 버튼 전체
  - 라디오 버튼 선택 라인
  - 분석할 라인 입력창 시작 라인
    - 예외 : 숫자만 입력 가능
  - 분석할 라인 입력창 끝 라인
    - 예외 : 숫자만 입력 가능
- 분석할 로그 불러오기
- 로그 데이터 단위로 분리하기
  - 최다 사용 키
    - 이름
    - 횟수
  - 브라우저별 접속
    - 횟수
    - 비율
  - 서비스 수행 횟수
    - 성공
    - 실패
  - 요청이 가장 많은 시간
  - 비정상적인 요청
    - 횟수
    - 비율
  - books에 대한 요청 url중 에러
    - 횟수
    - 비율
- 입력되는 라인에 해당하는 정보 출력
  - ⭐️ 오버로드 처리
- 레포트 파일 생성하기
  - c:/dev/report 폴더 생성
  - report_생성날짜.dat 파일 생성
  - 예외 : root 계정인 경우 불가 

## 로그인 기능 흐름
LoginView 실행 → LoginEventController에서 입력받은 정보 처리 → LoginController에서 검증
- 정상 로그인 : LogAnalyzerView 호출
- 오류 : 알림창 → LoginView 재실행