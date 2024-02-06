# 메모장
## 구현 기능 목록
***
1. [v]새글 버튼 작동 newMemo()
   - 메모장에 내용이 있을 경우 : 해당 파일 저장 후 JTA 초기화
     - []저장여부 묻기 askSave()
     - []파일 다이얼로그 사용하여 저장 (아마도 취소 기능 구현 필요) saveMemopad()
     - [V]JTA 초기화 resetJTA()
   - 메모장에 내용이 없을 경우 :
     - [V]JTA 초기화 resetJTA()
     - [V]타이틀 바 "메모장 - 새글"로 설정 setTitleBar()
2. [V]열기 버튼 작동
    - [V]메모장에 내용이 있을 경우 (새글 -> 열기): checkFirstOpen() = true
      - []저장여부 묻기 askSave()
      - []저장 saveNewMemo()
      - []열기 openMemopad()
    - [V]메모장에 내용이 있을 경우 (열기 -> 열기): checkFirstOpen() = false
      - []변경 여부 확인 checkChange()
      - []저장 여부 묻기 askSave()
      - []저장 saveMemopad()
      - []열기 openMemopad()
    - [V]메모장에 내용이 없을 경우 :
      - []열기 openMemopad()
3. [V]저장 버튼 작동
    - [V]기존에 동일한 이름으로 저장된 파일이 없는 경우 : checkFirstOpen() = true
      - []다른 이름으로 저장 수행 saveNewMemo() - saveMemopad() 재활용?
    - [V]기존에 동일한 이름으로 저장된 파일이 있는 경우 : checkFirstOpen() = false
      - []기존 파일에 덮어쓰기 overWrite()
      - []저장 saveMemopad()
4. [V]새이름으로 저장 버튼 작동
    - [V]저장 saveNewMemo()
5. [V]종료 버튼 작동
   - []현재 글꼴 상태 저장 saveFontInfo()
6. [V]새 메모장 실행
   - []이전에 저장된 글꼴 그대로 적용 applyFont()
7. 메모장에 글이 있는지 없는지 판단 checkEmpty()
8. 메모장 열기 버튼 작동이 처음인지 판단 checkFirstOpen()
   