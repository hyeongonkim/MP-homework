# MP-homework
2019-2 Semester, Kookmin Univ. Computer Science, Mobile Programing, Homework, 20163103, 김현곤. 해당 프로젝트는 2019년 2학기 국민대학교 소프트웨어학부 '모바일프로그래밍'의 개인 과제로 제작되었습니다.

## 개발환경
이 프로젝트는 다음 환경에서 개발되었습니다.

```
MacOS 10.15 Catalina
Android Studio
Android 9.0 Pie, minimum 6.0

Android 10.0 Q 이상의 환경에서는 저장소 권한이 강화되어 정상 작동하지 않습니다.
```

## 구현내용
이 프로젝트에서 구현된 내용은 다음과 같습니다.

```
1. 첫번째 화면(Relative Layout, 로그인)
  - 아이디와 비밀번호를 저장할 txt파일을 찾고, 없다면 새로 생성합니다.
  - 로그인을 시도할 때 마다 파일을 열어 해당 계정이 유효한 계정인지 확인합니다.
  - 로그인에 실패하는 경우 케이스를 분리하여 토스트 메시지로 실패 문구를 띄웁니다.
```

```
2. 두번째 화면(Linear Layout, 회원가입)
  - 아이디, 비밀번호, 이름, 전화번호, 주소를 계정정보로 받습니다.
  - 아이디의 경우 중복검사를 시행합니다.
  - 비밀번호의 경우 8자리 이상인지, 특수문자(!, @, #)가 포함되었는지 검사합니다.
  - 검사는 토글버튼을 사용하여 진행되며, 검사 이후에는 텍스트를 에디트할 수 없습니다.
  - 이름, 전화번호, 주소는 공란인 경우만 검사하며, 개인정보 사용동의 라디오 박스를 통해 동의 여부를 검사하고, 아무 문제가 없을 경우 회원 txt파일에 저장합니다.
```

```
3. 세번째 화면(Grid Layout, 웹뷰어)
  - 상하단 두개의 웹뷰를 동시에 보여줍니다.
  - 각각의 Url 텍스트 박스에 원하는 주소를 적고 접속버튼을 누르면 두 사이트를 한번에 접속할 수 있습니다.
  - 로그아웃을 통해 로그인 페이지로 돌아갈 수 있습니다.
```
