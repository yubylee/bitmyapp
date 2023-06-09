# bitmyapp

# myapp 프로젝트

## 버전

### 01. 프로젝트 준비

- Gradle 빌드 도구를 이용하여 프로젝트 폴더를 준비하는 방법

### 02. 리터럴과 콘솔 출력

- 실행할 수 있는 클래스를 만드는 방법 = main() 엔트리 포인트 이해
- 콘솔 출력 명령문을 작성하는 방법
- 리터럴 문법을 활용하는 방법
- CLI(command line interface) 환경에서 클래스를 실행하는 방법

### 03. 키보드 입력과 변수, 연산자, 조건문

- 키보드 입력을 받는 방법
- 변수를 사용해 키보드 입력 값을 저장하는 방법
- 조건문을 사용해 실행을 분기하는 방법
- 비교 연산자를 사용하는 방법

### 04. 배열 사용법

- 배열을 이용하여 여러 개의 데이터를 저장하고 꺼내는 방법
- 반복문을 사용하여 특정 명령 블록을 반복적으로 실행하는 방법
- 반복을 종료하는 방법
- final 키워드 사용법
- 문자열 비교

### 05. 메서드 사용법(with static)

- 코드를 관리하기 쉽게 기능 단위로 묶어 분리하기
- 스태틱 메서드 간에 변수를 공유하기: static 변수 사용
- 기존 기능을 유지한채 유지보수 하기 쉽게 코드를 정리하는 것: 리팩토링(refactoring)

### 06. 클래스 사용법 I

- 역할에 따라 메서드를 분류하기

### 07. 클래스 사용법 II

- 클래스 문법을 사용하여 데이터 타입 설계하기
- 클래스와 인스턴스, 레퍼런스의 관계
- 레퍼런스 배열과 인스턴스를 다루는 방법
- 인스턴스의 변수에 값을 넣고 꺼내는 방법

### 08. 메뉴 구성 및 CRUD 구현

- 메뉴를 통해 기능 실행을 제어하는 방법
- 객체를 변경하고 삭제하는 방법
- 리팩토링 기법 연습

### 09. 스태틱 필드의 한계

- 클래스 복제를 이용하여 회원을 일반 학생과 국비지원 학생으로 나눈다.
- 클래스 복제를 이용하여 위탁교육생을 추가한다.
- 클래스 복제 방식의 한계와 문제점 이해
  - 기능 추가/변경/삭제 할 때, 복제해서 만든 모든 코드에도 적용해야 한다.
  - 유지보수가 힘든 구조다.

### 10. 인스턴스 필드와 인스턴스 메서드 사용법, 생성자 사용법

- MemberHandler의 스태틱 필드를 인스턴스 필드로 변경
- MemberHandler의 스태틱 메서드를 인스턴스 메서드로 변경
- MemberHandler에서 프롬프트 제목을 다룰 수 있게 변경
- 생성자를 도입하여 title 필드를 필수 입력으로 설정

### 11. 도메인 클래스에 게터/세터 적용하기

- 캡슐화 문법을 이용하여 필드의 접근을 제어하는 방법
- 메서드를 통해 필드의 값을 설정하고 꺼내는 방법

### 12. 인스턴스 목록을 다루는 코드를 분리: High Cohesion 구현(재사용성 강화)

- GRASP의 OOP 원칙 중에서 High Cohesion을 구현한다.
- BoardHandler의 역할에서 데이터 목록을 다루는 일을 BoardDao로 옮긴다.

### 13. 패키지를 이용하여 클래스를 분류하는 방법 + 접근 제어 조정

- 유지보수하기 좋게 클래스를 역할에 따라 분류한다.
- 패키지 분류에 따라 멤버의 접근 범위를 조정한다.

### 14. 공통 코드(필드,메서드)를 공유하는 방법 : 상속

- 서로 관련된 클래스에 공통으로 나타나는 코드가 있다면 상속을 이용하여 공유한다.
- 일반화(generalization)
  - 클래스들의 공통 코드(필드, 메서드)를 추출하여 별도의 클래스로 정의하는 것.
  - 이렇게 정의한 클래스를 공유하는 것.
- 전문화(specialization)
  - 기존 클래스를 연결하고 필드나 변수를 추가하여 역할을 특화시키는 것.

### 15. 다형성을 이용하여 코드를 재사용하기

- 다형성(polymorphism): 상황에 맞춰 여러 용도로 사용되는 것
  - 다형적 변수(polymorphic variables):
    - 상위 타입의 변수는 하위 타입의 개체를 가리킬 수 있다.
  - 오버라이딩(Overriding)
    - 상속 받은 수퍼 클래스의 메서드를 서브 클래스의 역할에 맞춰 재정의 하는 것.
  - 오버로딩(Overloading)
    - 파라미터의 타입이나 개수, 순서가 다르더라도 같은 기능을 수행하는 메서드에 대해 같은 이름을 부여함으로써 프로그래밍의 일관성을 제공하는 문법
