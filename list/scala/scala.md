
<h1> Scala 언어 학습 </h1>

<br><br>

<h2> 1. Scala 언어란? </h2>

#### - 자바의 많은 부분을 차용
#### - 자바에서의 불편한 요소를 해결하기 위해 변화한 부분이 존재
#### - 스칼라/자바의 코드 및 라이브러리는 상호호환성이 있음
####   (자바/스칼라 모두 .class로 컴파일 될 수 있고 서로 import 가능)


<br><br>

<h2> 2. 자바에서 고쳐진 내용들 </h2>

#### - == 가 String의 값이 같음을 나타냄
#### - 사용자 지정 생성자 작성 시 기본 생성자 생성 안되는 것을 수정
#### - 배열과 함수에서 length 타입 차이 수정 
#### - 불필요하게 긴 문법 해소
####   (예. ArrayList<String> strings = new ArrayList<String>();)
#### - Getter, Setter 작성이 많음을 해소
#### - IO 코드 작성 편리(Scanner, and File IO)
#### - Type Inferencing: 변수 타입을 컴파일러가 알아서 추론해줌


<br><br>

<h2> 3. Scala 표현 및 함수 </h2>

#### - def: 메소드 선언시 주로 사용
    - 함수 명은 def 키워드 다음에 입력
    - 인자는 함수 명 다음에 괄호로 구성(파라미터 이름과 타입은 콜론으로 구분, 타입은 생략 가능)
    - 리턴 타입은 함수 인자 뒤에 콜론으로 선언(생략 가능)
    - Method signature 와 body는 = 로 구분 함(여러 줄에 걸치는 함수는 {} 사용)

![scala](https://github.com/daldalhada/bigdata/blob/main/images/scala/scala(1).png)

<br>

#### - val: 값이 변하지 않는 변수 선언시 사용(상수)
#### - var: 값이 변할 수 있는 변언 선언시 아용(변수)

![scala](https://github.com/daldalhada/bigdata/blob/main/images/scala/scala(2).png)

<br><br>

<h2> 3. Scala Class </h2>

#### - 자바의 클래스와 유사
    - class 클래스명(파라미터) { 바디 }
    - 필드의 기본 접근 제한자 - public (자바의 디폴트 제한자 아님)
    - 파라미터 특성에 따른 getter/setter (var: 자동 생성, val: getter만 생성)

![scala](https://github.com/daldalhada/bigdata/blob/main/images/scala/scala(3).png)

<br><br>

#### - Scala 클래스 생성자
    - 클래스 선언 자체가 클래스 생성자의 역할을 함
    - 클래스 선언시 var, val의 키워드를 사용하면 자동으로 필드로 인식 함

![scala](https://github.com/daldalhada/bigdata/blob/main/images/scala/scala(4).png)

<br><br>

<h2> 4. 익명함수 </h2>

#### - 이름이 없는 함수
    - 입력 인자와 리턴타입으로만 구성
#### - 함수의 실행 문이 짧을 경우 구성하기 좋음
#### - 인자와 함수 실행문은 => 로 구문됨
    - => 좌측은 입력인자
    - => 우측은 함수 실행 코드
    - 예제) x => x*x, (x, y) => x+y