

<details>
<summary><b>Java</b></summary>

<details>
<summary>01. 자바 실행 원리와 JVM (10.12)</summary>

#### 실행 과정

```
소스 코드(.java) → [javac] 컴파일 → 바이트코드(.class) → [JVM] 실행
```

바이트코드는 OS가 아니라 JVM이 실행하기 때문에, JVM만 있으면 Windows, Mac, Linux 어디서든 같은 .class 파일이 실행된다. (Write Once, Run Anywhere)

#### 소스 코드와 바이트코드

- 소스 코드(.java): 개발자가 직접 작성하는 코드. 사람이 읽을 수 있다.
- 바이트코드(.class): javac가 소스 코드를 변환한 결과물. JVM 전용 중간 언어로, 사람이 직접 작성하거나 수정하지 않는다.

#### JDK / JRE / JVM

JDK ⊃ JRE ⊃ JVM

- JVM: 바이트코드를 실행하는 가상 머신
- JRE: JVM + 기본 라이브러리 (실행 전용)
- JDK: JRE + 개발 도구(javac 등) → 개발자는 JDK를 설치한다

#### JVM 구조

JVM은 크게 세 부분으로 나뉜다.

**1) 클래스 로더**

.class 파일을 메모리로 불러온다. 실행 전 준비 단계.

**2) 런타임 데이터 영역**

프로그램이 실행되는 동안 쓰는 메모리 공간. 변수 같은 데이터가 여기 저장된다.

- Method Area: 클래스 정보, static 변수
- Heap: new로 만든 객체, 인스턴스 변수
- Stack: 메소드 호출 정보, 지역 변수, 매개변수

**3) 실행 엔진**

- 인터프리터: 바이트코드를 한 줄씩 기계어로 바꿔서 바로 실행한다. 시작은 빠르지만 반복되는 코드도 매번 번역해서 느리다.
- JIT 컴파일러: 자주 실행되는 코드를 통째로 기계어로 바꿔 저장해두고 재사용한다. 인터프리터의 속도 문제를 보완한다.
- 가비지 컬렉터(GC): 더 이상 쓰지 않는 메모리를 자동으로 정리한다.

</details>

<details>
<summary>02. 변수 (10.13)</summary>

#### 변수

값을 저장하는 메모리 공간에 붙인 이름. 프로그램이 실행되는 동안 값을 기억해두고 계속 바꿔 쓰기 위해 사용한다.

```java
int hp;        // 선언
hp = 100;      // 초기화 (처음으로 값을 넣는 것)
int mp = 50;   // 선언 + 초기화
```

#### 변수의 종류

| 종류 | 선언 위치 | 저장 영역 | 소멸 |
|---|---|---|---|
| 인스턴스 변수 (멤버 변수) | 클래스 안, 메소드 밖 | Heap | 객체를 더 이상 안 쓰면 GC가 정리 |
| 정적 변수 (static) | 클래스 안, 메소드 밖 | Method Area | 프로그램 종료 시 |
| 지역 변수, 매개변수 | 메소드 안 | Stack | 메소드가 끝나면 자동 삭제 |

#### 클래스 기본 구조

```java
package com.example;              // 클래스의 위치 지정
import java.util.Scanner;         // 다른 클래스를 가져올 때 사용

public class Player {
    String name;                  // 인스턴스 변수 (멤버 변수)
    static int count;             // 정적 변수 - 다른 클래스에서 Player.count로 사용 가능

    public Player() { }           // 생성자

    void attack() { }             // 메소드

    public static void main(String[] args) {
        int hp = 100;             // 지역 변수 - main 안에서만 사용 가능
    }
}
```

#### 메모리와 DB

- 메모리(RAM): 실행 중 사용하는 공간. 빠르지만 프로그램이 끝나면 사라진다. 변수가 저장되는 곳.
- DB / 하드: 오래 보관하는 공간. 꺼져도 남는다.

</details>

<details>
<summary>03. 자료형 (10.13)</summary>

#### 기본형

자료형에 따라 차지하는 메모리 크기가 다르다.

| 종류 | 자료형 | 크기 | 비고 |
|---|---|---|---|
| 정수 | byte | 1byte (8bit) | 네트워크, 파일 |
| | short | 2byte | |
| | int | 4byte | 정수 기본 |
| | long | 8byte | 금융, AI, 데이터 분석. 값 뒤에 L |
| 실수 | float | 4byte | 값 뒤에 f |
| | double | 8byte | 실수 기본 |
| 문자 | char | 2byte | 유니코드 |
| 논리 | boolean | 1byte | true / false |

```java
long money = 10000000000L;   // 소문자 l도 되지만 숫자 1이랑 헷갈려서 대문자로 쓴다
float pi = 3.14f;            // f 안 붙이면 double로 인식돼서 에러
double rate = 3.14;
char grade = 'A';            // 문자 1개는 작은따옴표
String name = "Java";        // 문자열은 큰따옴표, String 사용
```

#### 참조형

- 기본형을 제외한 나머지: 클래스(String 등), 배열, 인터페이스
- 값 자체가 아니라 객체가 있는 위치(주소)를 저장한다.
- 문자열은 기본형이 아니라 String을 사용한다.

</details>

<details>
<summary>04. 식별자와 명명 규칙 (10.13)</summary>

#### 식별자

변수, 클래스, 메소드, 인터페이스, 배열에 붙이는 이름.

#### 규칙 (어기면 에러)

- 숫자로 시작할 수 없다. (`1st` X, `st1` O)
- 대소문자를 구분한다. (`age`와 `Age`는 다른 이름)
- 특수문자는 `_`와 `$`만 사용 가능하다.
- 공백을 넣을 수 없다.
- 키워드(int, class 등)는 사용할 수 없다.

#### 개발자 약속

- 변수: 소문자로 시작, 단어가 두 개면 두 번째 단어 첫 글자를 대문자로 (`myAge`)
- 클래스: 대문자로 시작 (`Scanner`)
- 메소드, 배열: 소문자로 시작
- 상수: 전부 대문자 (`MAX_HP`)

</details>

<details>
<summary>05. 키보드 입력 - Scanner (10.13)</summary>

```java
import java.util.Scanner;

Scanner scan = new Scanner(System.in);
int a = scan.nextInt();   // 입력한 정수를 a에 저장
```

- Scanner는 java.util에 있어서 import가 필요하다.

</details>

<details>
<summary>06. 연산자 (10.14)</summary>

#### 연산 우선순위

| 순위 | 연산자 |
|---|---|
| 1 | `( )` |
| 2 | `++` `--` `!` |
| 3 | `*` `/` `%` |
| 4 | `+` `-` |
| 5 | `<` `>` `<=` `>=` |
| 6 | `==` `!=` |
| 7 | `&&` |
| 8 | `\|\|` |
| 9 | `=` `+=` `-=` |

- 우선순위가 같으면 왼쪽부터 계산한다. (대입 연산자만 오른쪽부터)
- 헷갈릴 때는 괄호로 순서를 명확하게 하는 게 좋다.

```java
int a = 5 + 3 * 2;     // 11
int b = (5 + 3) * 2;   // 16
```

#### 증감 연산자 (전위 / 후위)

++는 1 증가, --는 1 감소.

- 전위 `++a`: 먼저 증가시키고 그 값을 사용
- 후위 `a++`: 현재 값을 먼저 사용하고 나중에 증가

```java
int a = 5;
int b = ++a;   // a=6, b=6

int c = 5;
int d = c++;   // c=6, d=5
```

단독으로 쓰면(`a++;` / `++a;`) 결과가 같지만, 다른 연산과 함께 쓰면 결과가 달라진다.

#### 문자열 결합 연산자 (+)

한쪽이라도 문자열이면 더하기가 아니라 이어 붙이기가 되고, 결과는 문자열이 된다.

```java
"점수: " + 100     // "점수: 100"
1 + 2 + "3"        // "33"  (1+2=3 먼저 계산 후 결합)
"1" + 2 + 3        // "123" (처음부터 문자열이라 계속 결합)
```

- 왼쪽부터 순서대로 계산되는 점에 주의
- 문자열에는 -, *, / 사용 불가 (`"10" - 5`는 에러)

#### 논리 연산자

여러 조건을 묶어서 판단할 때 사용한다. 결과는 항상 true 또는 false.

| 연산자 | 의미 | 설명 |
|---|---|---|
| `&&` | AND | 둘 다 true일 때만 true |
| `\|\|` | OR | 하나라도 true면 true |
| `!` | NOT | true와 false를 뒤집음 |

```java
int hp = 30;
int level = 6;

System.out.println(hp > 0 && level >= 6);   // true  (둘 다 참)
System.out.println(hp > 50 || level >= 6);  // true  (하나만 참이어도 됨)
System.out.println(!(hp > 0));              // false (true를 뒤집음)
```

#### 단축 평가 (Short Circuit)

결과가 이미 정해지면 뒤쪽 조건은 계산하지 않는다.

- `A && B`: A가 false면 B는 확인하지 않는다. (어차피 false)
- `A || B`: A가 true면 B는 확인하지 않는다. (어차피 true)

```java
int a = 5;
boolean r = (a > 10) && (++a > 0);   // 앞이 false라 ++a는 실행 안 됨
System.out.println(a);               // 5
```

</details>

<details>
<summary>07. 제어문 (1) 조건문 (10.15)</summary>

#### 제어문

조건에 따라 코드를 다르게 실행하거나, 같은 작업을 반복하거나, 반복을 중단할 때 사용한다.

| 분류 | 문장 | 언제 쓰나 |
|---|---|---|
| 조건문 | if, switch | 조건에 따라 실행할 코드를 고를 때 (예: 회원 / 비회원) |
| 반복문 | for | 반복 횟수가 정해져 있을 때 (예: 화면 출력) |
| | while | 반복 횟수가 정해져 있지 않을 때 (예: DB) |
| | do~while | 조건과 상관없이 반드시 한 번 이상 실행해야 할 때 |
| 반복 제어 | break | 반복을 종료할 때 (예: ESC 누르면 종료) |
| | continue | 특정 부분만 건너뛰고 반복은 계속할 때 |

자주 쓰는 것: if, if~else, for, while, break

#### 조건문 종류

- 단일 조건문: if
- 선택 조건문: if~else
- 다중 조건문: if else / if else

#### 단일 조건문 (if)

```java
if (조건식) {
    // 조건이 true일 때 실행
}
// false면 실행하지 않고 건너뛴다
```

- 조건식은 결과가 반드시 true / false여야 한다. 그래서 비교 연산자, 논리 연산자, 부정 연산자(또는 boolean 변수)를 사용한다.
- 숫자는 조건식으로 쓸 수 없다. (`if (1)`은 에러)

```java
int hp = 0;
if (hp <= 0) {
    System.out.println("게임 오버");
}
```

if를 여러 개 쓰면 각각 독립적으로 검사한다. 앞에서 이미 조건이 맞았어도 뒤에 있는 if까지 전부 검사하기 때문에 느리다.

```java
int score = 85;
if (score >= 90) { System.out.println("A"); }
if (score >= 80 && score < 90) { System.out.println("B"); }
if (score >= 70 && score < 80) { System.out.println("C"); }
// B가 출력된 뒤에도 마지막 if까지 검사한다
```

이렇게 여러 개 중 하나만 고르는 경우에는 다중 조건문을 쓰는 게 낫다.

#### 선택 조건문 (if~else)

조건이 true면 if 블록, false면 else 블록을 실행한다. 둘 중 하나는 반드시 실행된다.

```java
boolean isMember = false;
if (isMember) {
    System.out.println("회원 할인 적용");
} else {
    System.out.println("비회원");
}
```

#### 다중 조건문 (if~else / if~else)

위에서부터 차례로 검사하다가 처음으로 true인 블록 하나만 실행하고 빠져나온다. 전부 false면 else를 실행한다.

```java
int score = 85;
if (score >= 90) {
    System.out.println("A");
} else if (score >= 80) {
    System.out.println("B");   // 여기서 실행하고 끝
} else if (score >= 70) {
    System.out.println("C");
} else {
    System.out.println("F");
}
```

위에서 90 이상은 이미 걸러졌기 때문에 두 번째 조건은 `score >= 80`만 써도 된다.

</details>

</details>
