# 메모장
## 구현 기능 목록
***
1. [v]새글 버튼 작동 newMemo()
   - 메모장에 내용이 있을 경우 : 해당 파일 저장 후 JTA 초기화
     - [V]저장여부 묻기 askSave()
     - [V]JTA 초기화 resetJTA()
   - 메모장에 내용이 없을 경우 :
     - [V]JTA 초기화 resetJTA()
     - [V]타이틀 바 "메모장 - 새글"로 설정 setTitleBar()
2. [V]열기 버튼 작동
    - [V]메모장에 내용이 있을 경우 (새글 -> 열기): checkFirstOpen() = true
      - [V]저장여부 묻기 askSave()
      - [V]열기 openMemopad()
    - [V]메모장에 내용이 있을 경우 (열기 -> 열기): checkFirstOpen() = false
      - [V]변경 여부 확인 checkChange()
      - [V]저장 여부 묻기 askSave()
      - [V]열기 openMemopad()
    - [V]메모장에 내용이 없을 경우 :
      - [V]열기 openMemopad()
3. [V]저장 버튼 작동
    - [V]기존에 동일한 이름으로 저장된 파일이 없는 경우 : checkFirstOpen() = true
      - [V]다른 이름으로 저장 수행 saveNewMemo()
    - [V]기존에 동일한 이름으로 저장된 파일이 있는 경우 : checkFirstOpen() = false
      - [V]기존 파일에 덮어쓰기 overWrite()
4. [V]새이름으로 저장 버튼 작동
    - [V]저장 saveNewMemo()
5. [V]종료 버튼 작동
   - [V]현재 글꼴 상태 저장 saveFontInfo()
6. [V]새 메모장 실행
   - [V]이전에 저장된 글꼴 그대로 적용 applyFont()
7. [V]메모장에 글이 있는지 없는지 판단 checkEmpty()
8. [V]메모장 열기 버튼 작동이 처음인지 판단 checkFirstOpen()
   