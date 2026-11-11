

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

<details>
<summary>08. 제어문 (2) switch문 (10.16)</summary>

#### 랜덤 숫자 만들기

```java
int month = (int)(Math.random() * 12) + 1;   // 1~12
```

- Math.random(): 0.0 이상 1.0 미만의 실수
- `* 12` → 0.0 ~ 11.9xx
- `(int)` → 소수점을 버려서 0 ~ 11
- `+ 1` → 1 ~ 12

#### 다중 조건문 예제 (계절)

```java
if (month == 12 || month == 1 || month == 2) {
    System.out.println(month + "월은 겨울입니다.");
} else if (month >= 3 && month <= 5) {
    System.out.println(month + "월은 봄입니다.");
} else if (month >= 6 && month <= 8) {
    System.out.println(month + "월은 여름입니다.");
} else if (month >= 9 && month <= 11) {
    System.out.println(month + "월은 가을입니다.");
} else {
    System.out.println("없는 달입니다.");
}
```

#### switch문

값이 같은지(==)만 비교해서 맞는 case를 실행한다. 범위 비교(>=, <=)가 필요하면 if를 쓴다.

```java
switch (month) {
    case 3: case 4: case 5:
        System.out.println(month + "월은 봄입니다.");
        break;
    case 6: case 7: case 8:
        System.out.println(month + "월은 여름입니다.");
        break;
    case 9: case 10: case 11:
        System.out.println(month + "월은 가을입니다.");
        break;
    case 12: case 1: case 2:
        System.out.println(month + "월은 겨울입니다.");
        break;
    default:
        System.out.println("없는 달입니다.");
}
```

- case를 여러 개 이어 쓰면 그중 하나만 맞아도 실행된다.
- break: switch를 빠져나간다. break가 없으면 그 아래 case 문장까지 이어서 실행된다.
- default: 맞는 case가 없을 때 실행된다. (if문의 else 역할)

#### 화살표 switch (Java 14 이상)

```java
switch (month) {
    case 12, 1, 2 -> System.out.println(month + "월은 겨울입니다.");
    case 3, 4, 5 -> System.out.println(month + "월은 봄입니다.");
    case 6, 7, 8 -> System.out.println(month + "월은 여름입니다.");
    case 9, 10, 11 -> System.out.println(month + "월은 가을입니다.");
    default -> System.out.println("없는 달입니다.");
}
```

- case 값은 쉼표로 묶는다.
- 해당 case만 실행하고 끝나기 때문에 break가 필요 없다.

#### 중괄호 { }

모든 제어문은 { }가 없으면 바로 밑에 있는 문장 1개만 제어한다. 문장이 여러 개면 { }로 묶어야 하고, 1개여도 { }를 쓰는 게 기본이다.

```java
if (hp <= 0)
    System.out.println("게임 오버");   // if에 포함
    System.out.println("다시 시작");   // if와 상관없이 항상 실행
```

#### Scanner 입력 메소드

- 정수: nextInt()
- 실수: nextDouble()
- 논리: nextBoolean()
- 문자열: next() / nextLine()
  - next(): 띄어쓰기 전까지 한 단어
  - nextLine(): 엔터 전까지 한 줄 전체
- 문자(char)를 받는 메소드는 없다. 문자열로 받아서 charAt(0)으로 첫 글자를 꺼낸다.

#### 예제: 입력한 문자 판별

```java
Scanner scan = new Scanner(System.in);
System.out.println("문자 입력");
char c = scan.next().charAt(0);   // 입력한 문자열의 첫 글자

if (c >= 'A' && c <= 'Z') {
    System.out.println(c + " : 대문자");
}
if (c >= 'a' && c <= 'z') {
    System.out.println(c + " : 소문자");
}
if (c >= '0' && c <= '9') {
    System.out.println(c + " : 숫자");
}
if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
    System.out.println(c + " : 기타");
}
```

- char는 내부적으로 유니코드 숫자로 저장돼서 >=, <=로 비교할 수 있다. ('A' = 65, 'a' = 97, '0' = 48)
- 마지막 if는 위의 세 조건이 전부 아닐 때 → 기타
- if 4개가 독립적이라 매번 4번 다 검사한다. else if로 바꾸면 맞는 곳에서 바로 끝나고, 마지막은 else 하나로 처리할 수 있다.

</details>

<details>
<summary>09. 제어문 (3) 반복문 (10.19)</summary>

#### for문

```java
for (int i = 1; i <= 10; i++) {
    System.out.print(i + " ");   // 1 2 3 4 5 6 7 8 9 10
}
```

형식: `for (초기식; 조건식; 증감식)`

실행 순서: 초기식 → 조건식 검사 → true면 실행 → 증감식 → 다시 조건식 검사 → ... → false면 종료

- for문 안에서 선언한 변수(i)는 for문이 끝나면 사라진다. 그래서 for문 밖에서 같은 이름으로 다시 선언할 수 있다.
- 반복 횟수를 알 때 주로 사용한다.
- 사용 예: 화면 UI, 배열 처리, 컬렉션 처리 (배열, 컬렉션 = 여러 개의 데이터를 한 번에 저장하는 공간)

#### while문

```java
int i = 1;
while (i <= 10) {
    System.out.print(i + " ");
    i++;
}
```

- 조건이 true인 동안 계속 반복한다.
- 변수는 while문 밖에서 선언하고, 증감식은 안에서 직접 써야 한다. i++를 빼먹으면 조건이 계속 true라서 무한 반복된다.
- 반복 횟수를 모를 때(가변) 주로 사용한다.
- 사용 예: 파일 입출력, 데이터베이스, 네트워크 서버

#### do~while문

```java
i = 1;
do {
    System.out.print(i + " ");
    i++;
} while (i <= 10);   // 끝에 세미콜론 필수
```

- 먼저 실행하고 나중에 조건을 검사한다. 그래서 반드시 1번 이상 실행된다.
- 사용 예: 게임, 로그인 처리 (일단 한 번 입력받고, 틀리면 다시 입력)

while과 do~while 차이 (조건이 처음부터 false인 경우)

```java
int n = 11;

while (n <= 10) {
    System.out.println("while");      // 한 번도 실행 안 됨
}

do {
    System.out.println("do~while");   // 1번 실행됨
} while (n <= 10);
```

#### 정리

| | for | while | do~while |
|---|---|---|---|
| 조건 검사 | 실행 전 | 실행 전 | 실행 후 |
| 최소 실행 횟수 | 0번 | 0번 | 1번 |
| 주로 쓰는 경우 | 반복 횟수를 알 때 | 반복 횟수를 모를 때 | 반드시 1번은 실행해야 할 때 |

참고: print는 줄바꿈 없이 이어서 출력하고, println은 출력한 뒤 줄을 바꾼다.

</details>
<details>
<summary>10. 제어문 (4) break, continue (10.20)</summary>

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;       // 반복문을 완전히 빠져나간다
    }
    System.out.print(i + " ");
}
// 1 2 3 4

for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;    // 이번 회차만 건너뛰고 다음 반복으로
    }
    System.out.print(i + " ");
}
// 1 3 5 7 9
```

- break: 반복문(또는 switch)을 종료한다. (예: ESC 누르면 종료)
- continue: 아래 문장을 건너뛰고 다음 반복으로 넘어간다. (특정 부분만 제외)
- while에서 continue를 쓸 때 i++가 continue 뒤에 있으면 i가 안 올라가서 무한 반복된다.

</details>

<details>
<summary>11. String (10.20)</summary>

#### String 특징

- 여러 개의 문자를 저장하는 클래스. 문자열은 `""`, 문자는 `''`
- 일반 데이터형처럼 쓰지만 참조형이다.
- final 클래스라서 상속해서 고쳐 쓸 수 없고, 제공하는 메소드를 그대로 사용한다. (표준화)
- 문자열 값 자체도 바뀌지 않는다. toUpperCase(), replace() 같은 메소드는 원본을 바꾸는 게 아니라 새 문자열을 만들어서 돌려준다.

#### 메모리 저장

```
String s = "Java";

  Stack           Heap
 -------        -------
 s: 0x100  ──▶  0x100: "Java"
```

- 변수 s(Stack)에는 주소만 있고, 실제 데이터는 Heap에 있다.
- Heap에 저장은 new로 하고, 해제는 GC가 자동으로 한다. (C는 malloc() / free()로 직접 해제)

#### == 와 equals()

```java
String a = "Java";
String b = "Java";
String c = new String("Java");

a == b        // true   같은 문자열 리터럴은 주소가 같다
a == c        // false  new는 새 메모리 공간을 만든다
a.equals(c)   // true   내용 비교
```

- `==`는 주소 비교, `equals()`는 내용 비교
- 문자열 비교는 항상 equals()를 쓴다. (로그인, 아이디 중복 체크)

#### 메소드 원형 읽는 법

```
char  charAt  (int index)
리턴형  메소드명   매개변수
```

int를 넣으면 char를 돌려준다는 뜻.

#### index

```
H  e  l  l  o     J  a  v  a
0  1  2  3  4  5  6  7  8  9
```

문자열의 index는 0부터 시작한다. (공백도 1칸)

#### 주요 메소드

| 원형 | 기능 |
|---|---|
| `char charAt(int index)` | index 위치의 문자 |
| `int length()` | 문자 개수 |
| `boolean equals(String s)` | 내용이 같은지 |
| `boolean equalsIgnoreCase(String s)` | 대소문자 구분 없이 비교 |
| `boolean contains(String s)` | 포함하는지 |
| `boolean startsWith(String s)` | ~로 시작하는지 |
| `boolean endsWith(String s)` | ~로 끝나는지 |
| `String toUpperCase()` / `toLowerCase()` | 대문자 / 소문자로 변환 |
| `String replace(old, new)` | 문자, 문자열 바꾸기 |
| `String replaceAll(정규식, new)` | 정규식에 맞는 부분 전부 바꾸기 |
| `String substring(int start)` | start부터 끝까지 자르기 |
| `String substring(int start, int end)` | start ~ end-1 자르기 |
| `int indexOf(String s)` | 처음 나오는 위치 (없으면 -1) |
| `int lastIndexOf(String s)` | 마지막으로 나오는 위치 (없으면 -1) |

#### 변환

```java
String ms = "Hello Java";
ms.toUpperCase()               // "HELLO JAVA"
ms.replace('a', 'b')           // "Hello Jbvb"
ms.replace("Java", "Oracle")   // "Hello Oracle"
System.out.println(ms);        // "Hello Java"  원본은 그대로
```

#### replaceAll + 정규식

```java
String s = "ABCD가나다라1234";
s.replaceAll("[가-힣]", "")    // "ABCD1234"      한글 전체 삭제
s.replaceAll("[A-Z]", "")      // "가나다라1234"   대문자 전체 삭제
s.replaceAll("[0-9]", "")      // "ABCD가나다라"   숫자 전체 삭제
s.replaceAll("[^가-힣]", "")   // "가나다라"       한글 빼고 전부 삭제
```

- `[가-힣]` 한글, `[A-Z]` 대문자, `[a-z]` 소문자, `[0-9]` 숫자
- `[^ ]` 괄호 안에 있는 것 제외
- `{1,3}` 1~3번 반복, `\.` 점 문자 그대로
- IP 주소: `[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}` (자바 문자열 안에서는 `\\.`로 쓴다)

#### substring + indexOf

```java
String msg = "hello Java";
msg.substring(6)       // "Java"
msg.substring(0, 5)    // "hello"  (0~4, 끝 번호는 포함 안 함)

String s = "자바.java";
s.substring(s.indexOf(".") + 1)               // "java"  점 다음부터

String path = "c:\\javaDev\\MainClass.java";  // \\는 \ 한 글자
path.substring(path.lastIndexOf("\\") + 1)    // "MainClass.java"  파일명만 추출
```

#### 활용: 웹 크롤링 (Jsoup)

```java
String fd = JOptionPane.showInputDialog("검색어 입력:");
for (int i = 1; i <= 4; i++) {
    Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20261020&hh=14&rtm=Y&pg=" + i).get();
    Elements title = doc.select("table.list-wrap td.info a.title");   // 제목
    Elements singer = doc.select("table.list-wrap a.artist");         // 가수명

    for (int j = 0; j < title.size(); j++) {
        if (title.get(j).text().endsWith(fd)) {
            System.out.println(title.get(j).text() + "(" + singer.get(j).text() + ")");
        }
    }
}
```

- 지니 차트 1~4페이지를 가져와서 검색어로 끝나는 제목만 출력
- 검색어가 들어간 곡을 전부 찾으려면 endsWith 대신 contains
- Jsoup 라이브러리(jar)를 추가해야 사용할 수 있다.

</details>
<details>
<summary>12. String (2), 메소드 (10.21)</summary>

#### 추가 메소드

| 원형 | 기능 |
|---|---|
| `String trim()` / `strip()` | 좌우 공백 제거 |
| `String valueOf(값)` | 모든 데이터형을 문자열로 변환 |
| `String[] split(String s)` | 지정한 문자로 잘라서 배열에 저장 |
| `String join(구분자, 문자열...)` | 여러 문자열을 하나로 묶기 |
| `String format(형식, 값...)` | 형식에 맞게 문자열 만들기 (printf와 같은 형식) |
| `String concat(String s)` | 문자열 결합 (거의 안 쓰고 + 사용) |

```java
"  Java  ".trim()                        // "Java"
String.valueOf(10)                       // "10"
"red,green,blue".split(",")              // {"red", "green", "blue"}
String.join("-", "2026", "10", "21")     // "2026-10-21"
String.format("%.2f", 3.14159)           // "3.14"
```

- valueOf, join, format은 `String.메소드()`로 호출한다.
- split에 `.`을 쓸 때는 `"\\."`로 써야 한다. (그냥 `"."`은 정규식에서 모든 문자라는 뜻)

#### 메소드

특정 기능을 수행하는 명령문의 집합. 라이브러리는 자바에서 만든 클래스이고, 메소드는 그 클래스의 기능이다.

```java
int add(int a, int b) {    // 리턴형 메소드명(매개변수)
    return a + b;          // 리턴형과 같은 데이터형으로 돌려준다
}

int c = add(10, 20);       // 호출할 때는 리턴형을 빼고 쓴다 → 30
```

- 결과값이 없는 메소드는 리턴형이 void
- 메소드 쓸 때 확인할 것: 어떤 클래스 → 어떤 기능 → 매개변수 → 리턴형 → 호출 방법
- 오버로딩: 이름은 같고 매개변수가 다른 메소드 여러 개 (valueOf(int), valueOf(double) ...)

</details>

<details>
<summary>13. 배열 (10.21)</summary>

#### 배열

같은 데이터형의 데이터 여러 개를 모아서 관리한다. (다른 데이터형을 모으면 클래스, 크기가 변하는 건 컬렉션: ArrayList 등)

- 특징: 연속된 메모리라 index로 접근, 크기 고정(선언 후 변경 불가, 늘리려면 더 큰 배열로 복사), 같은 데이터형만 저장
- 장점: 접근이 빠르다, 구조가 단순하다, 메모리 사용량을 예측할 수 있다
- 단점: 추가 / 삭제가 어렵다, 크게 만들면 메모리 낭비, 유연성이 떨어진다

#### 선언과 초기화

```java
int[] a = {10, 20, 30};        // 선언과 동시에 초기화 (값을 알 때)
int[] b = new int[3];          // 기본값으로 생성 (가장 많이 사용) → {0, 0, 0}
int[] c;
c = new int[]{10, 20, 30};     // 선언 먼저, 초기화는 나중에
```

`int a[]`도 되지만 C 방식이다.

new로 만들면 들어가는 기본값

| int | long | double | char | boolean | String (참조형) |
|---|---|---|---|---|---|
| 0 | 0L | 0.0 | '\u0000' | false | null |

null은 주소가 없다는 뜻이고, null인 상태로 사용하면 NullPointerException이 난다.

#### 메모리

```
int[] arr = {10, 20, 30};

  Stack            Heap
 ---------        ----------------
 arr: 0x200  ──▶  0x200: [10][20][30]
                          0   1   2
```

#### for vs for-each

```java
for (int i = 0; i < arr.length; i++) {     // index로 접근 → 값 변경 가능
    System.out.print(arr[i] + " ");
}

for (int n : arr) {                         // 데이터를 하나씩 꺼낸다 → 출력용
    System.out.print(n + " ");
}

System.out.println(Arrays.toString(arr));   // [10, 20, 30]
```

- 배열 크기는 `arr.length` (String은 `length()`, 배열은 괄호 없음)
- 값을 바꿀 때는 일반 for, 출력만 할 때는 for-each
- Arrays를 쓰려면 `import java.util.Arrays;`

#### 예제: 최대값, 최소값과 위치

```java
int max = arr[0];   // 0이 아니라 첫 번째 값으로 시작해야 한다
int min = arr[0];
for (int n : arr) {
    if (n > max) max = n;
    if (n < min) min = n;
}

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == max) {
        System.out.println("max 위치: " + (i + 1));
        break;      // 처음 찾은 위치에서 종료
    }
}
```

#### 예제: 성적 처리

```java
int[] kor = new int[3];        // int kor1, kor2, kor3 대신
int[] total = new int[3];
double[] avg = new double[3];
char[] score = new char[3];

// 반복문 안에서
total[i] = kor[i] + eng[i] + math[i];
avg[i] = total[i] / 3.0;       // 3.0으로 나눠야 소수점까지 나온다
switch (total[i] / 30) {       // 300점 만점 → 0~10
    case 10, 9 -> score[i] = 'A';
    case 8, 7 -> score[i] = 'B';
    case 6, 5 -> score[i] = 'C';
    case 4, 3 -> score[i] = 'D';
    default -> score[i] = 'F';
}

System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-5c\n",
        kor[i], eng[i], math[i], total[i], avg[i], score[i]);
```

printf: `%d` 정수, `%f` 실수, `%c` 문자, `-5`는 왼쪽 정렬 5칸, `.2`는 소수점 둘째 자리까지

#### 예제: 로또 (중복 없는 번호)

```java
int[] lotto = new int[6];
for (int i = 0; i < lotto.length; i++) {
    lotto[i] = (int)(Math.random() * 45 + 1);   // 1~45
    for (int j = 0; j < i; j++) {               // 앞에서 뽑은 번호와 비교
        if (lotto[i] == lotto[j]) {
            i--;     // 중복이면 i를 하나 줄여서 같은 자리를 다시 뽑는다
            break;
        }
    }
}
Arrays.sort(lotto);  // 오름차순 정렬
```

</details>
<details>
<summary>16. 문자열 배열 - 파일 데이터 다루기 (10.23)</summary>

movie.txt는 한 줄이 영화 1개이고, 항목은 `|`로 구분돼 있다.

```
1|쇼생크 탈출|드라마|이미지주소|출연진|개봉일|15세 관람가|감독
```

#### 파일 → 배열

```java
FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
StringBuffer sb = new StringBuffer();
int i = 0;
while ((i = fr.read()) != -1) {     // 한 글자씩 읽기, 파일 끝이면 -1
    sb.append((char) i);
}
fr.close();

String[] movies = sb.toString().split("\n");     // 줄 단위 → 영화 1개씩
String[] title = new String[movies.length];
String[] actor = new String[movies.length];

for (int j = 0; j < movies.length; j++) {
    String[] data = movies[j].split("\\|");      // 항목 단위
    title[j] = data[1];
    actor[j] = data[4];
}
```

- 파일 읽기는 try~catch로 감싸야 한다. (파일이 없을 수도 있어서)
- StringBuffer: 문자열을 계속 이어 붙일 때 사용한다. (String에 +=를 하면 매번 새 문자열이 만들어진다)
- 배열 크기는 1938처럼 직접 쓰지 말고 movies.length로

#### 검색

```java
int count = 0;
for (int j = 0; j < actor.length; j++) {
    if (actor[j].contains(ac)) {     // 입력한 배우 이름이 포함된 영화
        System.out.println(title[j]);
        count++;
    }
}
System.out.println("총 출연작은 " + count + "편입니다.");
```

- 같은 index = 같은 영화. 배열 여러 개를 같이 쓸 때는 index for, 배열 하나만 볼 때는 for-each

#### 페이지 나누기

```java
int totalPage = (int) Math.ceil(title.length / 10.0);   // 1938 / 10.0 = 193.8 → 194
int start = (page - 1) * 10;                            // 출력 시작 위치
```

Math.ceil은 올림. 10으로 나누면 정수 나눗셈이라 193이 돼서 마지막 페이지가 사라진다.

</details>

<details>
<summary>17. 정렬 (10.23)</summary>

- 오름차순(ASC): 작은 값 → 큰 값
- 내림차순(DESC): 큰 값 → 작은 값

두 값 바꾸기 (swap)

```java
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
```

#### 선택 정렬

기준 자리(i)와 그 뒤의 값들(j)을 비교한다. 라운드마다 앞자리부터 고정된다.

```
30 20 50 10 40
1 round: 10 30 50 20 40
2 round: 10 20 50 30 40
3 round: 10 20 30 50 40
4 round: 10 20 30 40 50
```

```java
for (int i = 0; i < arr.length - 1; i++) {        // 기준 자리 0 ~ 3
    for (int j = i + 1; j < arr.length; j++) {    // 비교 대상 i+1 ~ 4
        if (arr[i] > arr[j]) {                    // 내림차순은 <
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
```

- char 배열도 같은 방식으로 정렬된다. (문자는 유니코드 값으로 비교)
- 수업 코드는 비교할 때마다 바로 교환한다. 원래 선택 정렬은 라운드마다 최소값 위치(minIndex)를 찾아서 1번만 교환한다.

#### 버블 정렬

인접한 두 값끼리 비교한다. 라운드마다 가장 큰 값이 맨 뒤로 가서 뒷자리부터 고정된다.

```
30 20 50 10 40
1 round: 20 30 10 40 50
2 round: 20 10 30 40 50
3 round: 10 20 30 40 50
4 round: 10 20 30 40 50
```

```java
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1 - i; j++) {   // 뒤에 고정된 i개는 빼고 비교
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

| | 선택 정렬 | 버블 정렬 |
|---|---|---|
| 비교 | 기준 자리 vs 뒤의 값들 | 인접한 두 값 |
| 고정 | 앞자리부터 | 뒷자리부터 |
| 시간 복잡도 | O(n²) | O(n²) |

실무에서는 `Arrays.sort(arr)`를 쓴다. (오름차순) 정렬 원리는 면접, 코딩테스트용

</details>

<details>
<summary>18. 1~4장 정리 (10.23)</summary>

#### 자바 → 웹 개발 흐름

- 모든 프로그램의 기본: 변수, 연산자, 제어문
- 데이터 묶기: 배열, 클래스 / 명령어 묶기: 메소드 → 객체 지향
- 그다음: 예외처리, 라이브러리(컬렉션, DB 연동)
- 이후 과정: Oracle → HTML/CSS/JavaScript → JSP → Spring, MyBatis/JPA → Spring AI → AWS 배포

#### 삼항 연산자

```java
String result = (score >= 60) ? "합격" : "불합격";   // 조건이 true면 앞, false면 뒤
```

#### 이중 for: 문자 패턴

```java
for (int i = 0; i < 4; i++) {
    char c = 'A';                 // 줄마다 'A'부터 다시 시작
    for (int j = 0; j < 4; j++) {
        System.out.print(c++);
    }
    System.out.println();
}
```

- c를 바깥 for 안에서 선언 → ABCD가 4줄
- c를 바깥 for 밖에서 선언 → ABCD / EFGH / IJKL / MNOP
- 지역 변수는 선언된 { }가 끝나면 사라진다. 그래서 바깥 for 안에서 선언한 c는 줄마다 새로 만들어진다.

</details>
<details>
<summary>19. 메소드 (10.26)</summary>

#### 메소드 규칙

- 클래스 안에만 만들 수 있고, 메소드 안에 메소드는 못 만든다.
- 한 메소드는 한 가지 기능만 → 재사용, 유지보수, 가독성, 반복 제거
- main에서는 메소드 호출만 하고, 처리는 각 메소드에서 한다.
- 메소드가 끝나면 호출한 위치로 돌아온다.

#### 리턴형 / 매개변수 조합

| 리턴형 | 매개변수 | 예 |
|---|---|---|
| O | O | `String substring(int start)` |
| O | X | `double random()` |
| X (void) | O | `void println(String s)` |
| X (void) | X | `void println()` |

- 리턴형(결과값)은 1개만 돌려줄 수 있다. 여러 개면 배열, 컬렉션, 클래스로 묶어서 돌려준다.
- 매개변수(요청값)는 여러 개 가능. 3개 이상이면 보통 배열이나 클래스로 묶는다.
- return 값은 리턴형과 같은 데이터형으로 쓴다. (long 리턴형에 int 값처럼 더 작은 형은 가능)
- void는 return 생략 가능

#### static vs 인스턴스 메소드

- static 메소드: `클래스명.메소드()` (예: Math.random(), String.valueOf())
- 인스턴스 메소드: 객체를 만든 뒤 `객체명.메소드()` (예: s.length())
- 같은 클래스 안의 static 메소드는 `메소드명()`만으로 호출

#### 지역 변수는 호출할 때마다 새로 만들어진다

```java
static int display() {
    int a = 10;
    a++;
    return a;
}

display();   // 11
display();   // 11
```

#### 예제

```java
// 1~n 합. sum()과 이름은 같고 매개변수만 다름 (오버로딩)
static int sum(int n) {
    int s = 0;
    for (int i = 1; i <= n; i++) {
        s += i;
    }
    return s;
}

// 대문자 → 소문자 ('A'=65, 'a'=97, 차이 32)
static char change(char c) {
    return (char)(c + 32);
}

// 문자열 거꾸로 출력
static void reverse(String msg) {
    for (int i = msg.length() - 1; i >= 0; i--) {
        System.out.print(msg.charAt(i));
    }
}

// 배열을 받아서 최대값 리턴
static int max(int[] arr) {
    int m = arr[0];
    for (int n : arr) {
        if (n > m) m = n;
    }
    return m;
}
```

배열은 참조형이라 메소드에 주소가 넘어간다. 그래서 메소드 안에서 `Arrays.sort(arr)`를 하면 원본 배열도 정렬된다.

#### 예제: 로그인

```java
static boolean isLogin(String id, String pwd) {
    final String MID = "hong";     // final: 값을 바꿀 수 없는 상수
    final String PWD = "1234";
    return id.equals(MID) && pwd.equals(PWD);
}
```

#### 예제: 숫자야구 (기능별로 메소드 분리)

| 메소드 | 기능 |
|---|---|
| `int[] rand()` | 1~9 중 중복 없는 숫자 3개 |
| `int[] userInput()` | 세 자리 입력을 검사하고 배열로 나누기 |
| `int hint(int[] com, int[] user)` | 스트라이크, 볼 계산 후 출력, 스트라이크 수 리턴 |
| `boolean exit(int s)` | 3스트라이크면 true |
| `void process()` | 위 메소드를 순서대로 호출 (게임 진행) |

```java
// 자릿수 나누기
user[0] = input / 100;          // 369 → 3
user[1] = (input % 100) / 10;   // 369 → 6
user[2] = input % 10;           // 369 → 9

// 스트라이크, 볼
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (com[i] == user[j]) {
            if (i == j) s++;    // 같은 수, 같은 자리 → 스트라이크
            else b++;           // 같은 수, 다른 자리 → 볼
        }
    }
}
```

- `System.exit(0)`: 프로그램 종료
- 메소드 안에서 자기 자신을 다시 호출하면(재귀 호출) 처음부터 다시 실행된다. 단, 이전 호출이 끝나지 않고 계속 쌓이기 때문에 단순 반복이 목적이면 while이 더 안전하다.

</details>
<details>
<summary>20. 메소드 (2) 활용 (10.27)</summary>

#### 리턴형 고르는 기준

| 결과 | 리턴형 |
|---|---|
| 경우가 2가지 (로그인 성공 / 실패) | boolean |
| 경우가 여러 개 | String |
| 목록 | 배열, 컬렉션 |
| 상세보기 (데이터 여러 개) | 클래스 |
| 나머지 | 기본형 (int, double 등) |

매개변수도 같다. 페이지 변경은 int, 글쓰기나 회원가입처럼 보낼 값이 많으면 클래스로 묶는다.

#### return을 만나면 메소드 종료

```java
static boolean isLogin(String id, String pwd) {
    if (id.equals("admin") && pwd.equals("1234"))
        return true;      // 여기서 메소드 종료
    else
        return false;
}

if (isLogin(id, pwd)) {   // boolean 메소드는 if 조건에 바로 쓸 수 있다
    System.out.println("로그인 되었습니다");
}
```

#### 예제: 배열 통계 메소드

```java
static int hap(int[] arr) {
    int sum = 0;
    for (int n : arr) sum += n;
    return sum;
}

static double avg(int[] arr) {
    return (double) hap(arr) / arr.length;   // 만들어둔 메소드 재사용
}

static int even(int[] arr) {
    int count = 0;
    for (int n : arr) {
        if (n % 2 == 0) count++;              // 홀수는 n % 2 != 0
    }
    return count;
}
```

- max, min은 0이나 110 같은 임의의 값이 아니라 arr[0]으로 시작한다.
- 평균은 10.0 대신 arr.length로 나눠야 배열 크기가 바뀌어도 맞다.

</details>

<details>
<summary>21. 클래스 (10.27)</summary>

#### 클래스와 객체

- 클래스: 객체를 만들기 위한 설계도. 직접 만드는 데이터형(사용자 정의 데이터형)
- 객체: 설계도대로 new로 만든 실체

#### 클래스 종류

| 종류 | 구성 | 이름 예 |
|---|---|---|
| 데이터만 | 변수 | VO, DTO |
| 기능만 | 메소드 | DAO, Service, Manager |
| 혼합 | 변수 + 메소드 | |

#### 클래스 구성

```java
class ClassName {
    변수      // 인스턴스 변수: 객체마다 따로 저장 / static 변수: 1개를 모든 객체가 공유
    생성자    // 변수 초기화
    메소드
}
```

#### 예제

```java
class Student {
    String name;
    int hb;        // 학번
    String sex;

    Student(String n, int h, String s) {   // 생성자
        name = n;
        hb = h;
        sex = s;
    }
}

Student hong = new Student("홍길동", 1, "남자");
Student shim = new Student("심청이", 2, "여자");
System.out.println(hong.name);   // 홍길동
System.out.println(shim.name);   // 심청이
```

```
  Stack              Heap
 hong: 0x100  ──▶  0x100: name="홍길동", hb=1, sex="남자"
 shim: 0x200  ──▶  0x200: name="심청이", hb=2, sex="여자"
```

- 생성자: 클래스 이름과 같고 리턴형이 없다. new로 객체를 만들 때 자동으로 호출된다.
- 생성자는 외부에서 받은 값(입력, 파일, DB)으로 변수를 초기화할 때 쓴다.
- 객체마다 Heap에 따로 만들어져서 hong.name과 shim.name은 서로 다른 값이다. 접근은 `객체명.변수`

</details>
<details>
<summary>22. 클래스 (2) 구성요소, 생성자, this (10.28)</summary>

#### 객체 생명주기

생성 `A a = new A();` → 활용 `a.display()` → 소멸 `a = null;` → 메모리 해제 (GC가 자동으로, `System.gc()`는 요청만)

#### 인스턴스 변수 vs static 변수

```java
class A {
    int b;           // 인스턴스 변수: 객체마다 따로
    static int a;    // static 변수: 모든 객체가 1개를 공유
}

A aa = new A();
A bb = new A();
bb.a = 1000;     // aa.a, bb.a, A.a 전부 1000 (같은 메모리)
bb.b = 200;      // aa.b는 그대로 0
```

- static 변수는 `클래스명.변수`로 쓰는 게 원칙
- static 메소드, static 블록 안에서는 인스턴스 변수와 this를 쓸 수 없다. (객체가 없어도 실행되기 때문)

#### 이름이 같으면 지역 변수가 우선

```java
class A {
    static int a = 10;
    static void display() {
        int a = 20;
        System.out.println(a + A.a);   // 20 + 10 = 30
    }
}
```

멤버 변수는 `클래스명.변수`(static)나 `this.변수`(인스턴스)로 구분한다.

#### 클래스 영역에는 선언만

```java
class A {
    int a = 100;     // O 선언하면서 값 설정
    int b;
    b = 100;         // X 에러. 실행문은 메소드, 생성자, 초기화 블록 안에서만
}
```

#### 변수 초기화 방법

1. 명시적 초기화: `int a = 100;`
2. 초기화 블록: 인스턴스 블록 `{ }`는 객체를 만들 때마다, static 블록 `static { }`은 클래스가 처음 로딩될 때 1번
3. 생성자

인스턴스 변수는 명시적 → 초기화 블록 → 생성자 순서로 실행돼서 생성자에서 넣은 값이 최종 값이 된다.

#### 생성자

- 클래스 이름과 같고 리턴형이 없다. (void를 붙이면 일반 메소드가 된다)
- new로 객체를 만들 때 1번만 호출된다.
- 매개변수를 다르게 해서 여러 개 만들 수 있다. (오버로딩)
- 하나도 안 만들면 매개변수 없는 기본 생성자가 자동으로 만들어진다. 단, 생성자를 하나라도 직접 만들면 자동으로 안 만들어진다.
- 쓰임: 변수 초기화, 시작할 때 필요한 기능 (자동 로그인, 서버 연결, DB 연결)

#### this

객체 자기 자신의 주소. 매개변수와 멤버 변수 이름이 같을 때 구분하는 데 쓴다.

```java
class Student {
    int hakbun;
    String name;
    int kor, eng, math;

    Student(int hakbun, String name, int kor, int eng, int math) {
        this.hakbun = hakbun;     // this.hakbun = 멤버 변수, hakbun = 매개변수
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}

Student s1 = new Student(1, "홍길동", 90, 90, 90);
Student s2 = new Student(2, "심청이", 70, 70, 70);

Student[] std = {s1, s2};         // 객체도 배열로 묶을 수 있다
for (Student s : std) {
    System.out.println(s.hakbun + " " + s.name + " " + s.kor);
}
```

- s1 안에서 this는 s1, s2 안에서 this는 s2
- 이클립스: 우클릭 → Source → Generate Constructor using Fields로 생성자 자동 생성

#### 상속 맛보기

```java
class A { int a, b; }
class B extends A { }    // B는 A의 변수를 물려받는다
```

B 객체를 만들면 A 부분(super)과 B 부분(this)이 같이 만들어진다.

#### 객체지향 3대 특성

| 특성 | 목적 | 방법 |
|---|---|---|
| 캡슐화 | 데이터 보호 | private + getter / setter |
| 상속 | 재사용, 확장 | extends |
| 다형성 | 기능 추가 / 변경 | 오버로딩, 오버라이딩 |

추상화를 넣어서 4대 특성이라고도 한다.

- 접근지정어: public / protected / default / private
- 제어어: static / final / abstract

</details>
<details>
<summary>23. 영화 관리 프로그램 - 클래스 나누기 (10.29)</summary>

| 클래스 | 역할 |
|---|---|
| Movie | 영화 1개의 데이터 (VO) |
| MovieSystem | 데이터 불러오기 + 기능 (목록, 상세, 검색) |
| Main | 메뉴 출력, 입력 받기 |

#### Movie

```java
@Data              // lombok: getter, setter, toString 등 자동 생성
public class Movie {
    private int mno;
    private String title;
    private String genre;
    private String poster;
    private String actor;
    private String regdate;
    private String grade;
    private String director;
}
```

#### MovieSystem

```java
public class MovieSystem {
    private static Movie[] movies;

    static {    // 클래스가 처음 쓰일 때 1번 실행 → 파일 데이터를 미리 불러온다
        try {
            // 파일 읽기는 16번과 같음 → sb
            String[] lines = sb.toString().split("\n");
            movies = new Movie[lines.length];
            for (int i = 0; i < lines.length; i++) {
                String[] info = lines[i].split("\\|");
                movies[i] = new Movie();
                movies[i].setMno(Integer.parseInt(info[0]));   // 문자열 → 정수
                movies[i].setTitle(info[1]);
                movies[i].setGenre(info[2]);
                movies[i].setPoster(info[3]);
                movies[i].setActor(info[4]);
                movies[i].setRegdate(info[5]);
                movies[i].setGrade(info[6]);
                movies[i].setDirector(info[7]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Movie[] movieListData() {               // 목록 → 여러 개라 Movie[]
        return movies;
    }

    public Movie movieDetailData(int mno) {        // 상세 → 1개라 Movie
        return movies[mno - 1];                    // 영화 번호 - 1 = index
    }

    public Movie[] moviesFindData(String fd) {     // 검색
        int count = 0;
        for (Movie m : movies) {
            if (m.getTitle().contains(fd)) count++;       // 1) 개수 세기
        }
        Movie[] result = new Movie[count];               // 2) 딱 맞는 크기로 배열 생성
        int i = 0;
        for (Movie m : movies) {
            if (m.getTitle().contains(fd)) result[i++] = m;   // 3) 담기
        }
        return result;
    }
}
```

- 배열은 크기가 고정이라 검색 결과 개수를 먼저 세야 한다. (나중에 배울 ArrayList는 개수를 몰라도 된다)
- 예외처리 3가지: 복구(try~catch), 회피(throws), 발생(throw)

#### Main

```java
MovieSystem ms = new MovieSystem();
while (true) {
    // 메뉴 출력 후 번호 입력
    if (menu == 4) {
        break;
    } else if (menu == 1) {
        for (Movie m : ms.movieListData()) {
            System.out.println(m.getMno() + "." + m.getTitle());
        }
    }
    // 2: movieDetailData(번호), 3: moviesFindData(검색어)
}
```

</details>

<details>
<summary>24. 캡슐화, 접근지정어, 생성자 오버로딩 (10.29)</summary>

#### 접근지정어

| | 같은 클래스 | 같은 패키지 | 다른 패키지 + 상속 | 전체 |
|---|---|---|---|---|
| private | O | | | |
| default | O | O | | |
| protected | O | O | O | |
| public | O | O | O | O |

- 보통 변수는 private, 생성자, 메소드, 클래스는 public
- default는 아무것도 안 쓴 것

#### 캡슐화: getter / setter

```java
class Sawon {
    private int sabun;                    // 밖에서 s.sabun으로 직접 접근 불가

    public int getSabun() {               // 읽기
        return sabun;
    }
    public void setSabun(int sabun) {     // 쓰기
        this.sabun = sabun;
    }
}

s.setSabun(1);
System.out.println(s.getSabun());
```

lombok을 쓰면 변수 위에 `@Getter` `@Setter`, 또는 클래스 위에 `@Data`만 붙여도 자동으로 만들어진다.

#### 제어어

- static: 공통 (모든 객체가 공유)
- final: 마지막. 변수는 값 변경 불가(상수), 메소드는 오버라이딩 불가, 클래스는 상속 불가
- abstract: 구현 없이 선언만 (추상 메소드, 추상 클래스)

순서는 `접근지정어 제어어 데이터형 이름` (예: `public static final int MAX = 100;`)

#### 생성자 오버로딩, this()

```java
class Sawon {
    private int sabun;
    private String name;
    private String dept;

    public Sawon() {                      // 기본값
        sabun = 1;
        name = "홍길동";
        dept = "개발부";
    }
    public Sawon(int sabun, String name) {
        this.sabun = sabun;
        this.name = name;                 // dept는 초기화 안 돼서 null
    }
    public Sawon(String name, String dept) {
        this();                           // 기본 생성자 먼저 실행 → sabun = 1
        this.name = name;
        this.dept = dept;
    }
}

new Sawon();                  // 1 홍길동 개발부
new Sawon(2, "심청이");       // 2 심청이 null
new Sawon("박문수", "영업부"); // 1 박문수 영업부
```

- this(): 같은 클래스의 다른 생성자 호출. 반드시 생성자의 첫 줄에 쓴다.
- 오버로딩 조건: 같은 클래스, 같은 이름, 매개변수 개수나 데이터형이 다름 (리턴형은 상관없음)

</details>
<details>
<summary>25. 상속, 오버라이딩 (10.30)</summary>

#### package, import

- package: 관련된 클래스를 묶는 폴더. 다른 패키지에서 쓰려면 public이어야 한다.
- import: 다른 패키지의 클래스를 가져온다. `java.util.*`은 그 패키지의 클래스 전부

#### 상속 (extends)

공통 변수와 메소드를 부모 클래스에 모아서 재사용한다.

```
사람: 이름, 성별, 나이
학생 extends 사람   → 학번, 전공만 추가
회사원 extends 사람 → 사번, 부서만 추가
```

- 부모 = super 클래스, 자식 = sub 클래스
- 자바는 단일 상속만 가능 (부모는 1개)
- 생성자, 초기화 블록은 상속되지 않는다.
- private은 상속은 되지만 자식에서 직접 못 쓴다. 자식에서 쓰게 하려면 protected
- is-a: 상속 (학생은 사람이다) / has-a: 포함 (클래스 안에 다른 클래스를 변수로 가진다)
- 단점: 객체를 만들 때 부모 부분까지 메모리에 같이 올라가서 무거워진다. 꼭 필요할 때만 쓴다.

#### 오버라이딩

부모 메소드를 자식에서 다시 정의한다.

```java
class Animal {
    int age = 10;
    public void eat() { System.out.println("먹는다"); }
}

class Pig extends Animal {
    int age = 5;
    public void eat() { System.out.println("돼지처럼 먹는다"); }   // 오버라이딩
}

Animal pig = new Pig();          // 부모 타입 변수에 자식 객체 저장 가능
pig.eat();                       // 돼지처럼 먹는다 → 메소드는 실제 객체(Pig) 기준
System.out.println(pig.age);     // 10 → 변수는 선언한 타입(Animal) 기준
```

조건: 상속 관계, 메소드 이름 / 매개변수 / 리턴형 동일, 접근지정어는 같거나 넓게만 (private < default < protected < public)

#### 오버로딩 vs 오버라이딩

| | 오버로딩 | 오버라이딩 |
|---|---|---|
| 의미 | 같은 이름으로 새 메소드 추가 | 부모 메소드를 다시 정의 |
| 위치 | 같은 클래스 | 상속 관계 |
| 매개변수 | 달라야 한다 | 같아야 한다 |
| 리턴형 | 상관없다 | 같아야 한다 |

둘 다 다형성(기능 추가 / 변경)에 해당한다.

</details>

<details>
<summary>26. 음악 차트 프로그램 - 상속 활용 (10.30)</summary>

| 클래스 | 역할 |
|---|---|
| MusicVo | 노래 1개의 데이터 (@Data) |
| Music | 부모. 공통 데이터(musics 배열)와 기능(목록, 제목 검색, 가수 검색) |
| GenieMusic, MelonMusic | 자식. 생성자에서 각 사이트를 크롤링해서 musics를 채운다 |
| UserMain, MusicList | 실행 (콘솔 / 윈도우 화면) |

```java
public class Music {
    public static MusicVo[] musics = new MusicVo[50];

    public MusicVo[] musicListData() { return musics; }
    public MusicVo[] musicSearchT(String title) { ... }    // 23번 영화 검색과 같은 방식
    public MusicVo[] musicSearchS(String singer) { ... }
}

public class MelonMusic extends Music {
    public MelonMusic() {
        // 멜론 차트 크롤링 → musics[i]에 저장
    }
}

Music music = new MelonMusic();             // new GenieMusic()으로 바꿔도 아래 코드는 그대로
MusicVo[] list = music.musicListData();     // 부모에 있는 메소드를 그대로 사용
list = music.musicSearchT(title);
```

- 사이트마다 다른 부분(크롤링)만 자식에, 같은 부분(목록, 검색)은 부모에 둔다.
- 부모 타입 변수로 받아두면 객체만 바꿔서 다른 사이트 데이터를 쓸 수 있다. (다형성)

#### 크롤링 데이터 처리

```java
poster.get(i).attr("src")        // text()는 글자, attr()은 태그 속성 값 (이미지 주소)

String temp = etc.get(i).text(); // 순위 변동 (숫자 + 상승/하강, 또는 유지)
if (temp.equals("유지")) {
    id = 0;
    state = "유지";
} else {
    id = Integer.parseInt(temp.replaceAll("[^0-9]", ""));   // 숫자만 남기기
    state = temp.replaceAll("[^가-힣]", "");                  // 한글만 남기기
}
```

윈도우 화면(MusicList)은 JFrame에 JTable을 붙이고, `model.addRow(배열)`로 한 줄씩 추가한다.

</details>
<details>
<summary>27. 상속 (2) super, 다형성 (11.02)</summary>

#### 재사용 기법

| 방법 | 관계 | 쓰는 경우 |
|---|---|---|
| 포함 | has-a | 변경 없이 그대로 사용 (`JFrame f = new JFrame();`) |
| 상속 | is-a | 변경해서 사용 (`extends JFrame` + 오버라이딩) |

- 모든 클래스는 Object를 자동으로 상속받는다. (최상위 클래스)
- final 클래스는 상속할 수 없다. (String, Math, System 등 표준화된 클래스)
- 상속 장점: 재사용, 유지보수, 신뢰성(이미 검증된 코드) / 단점: 메모리, 속도, 부모를 수정하면 자식도 영향을 받는다

#### 생성자 호출 순서와 super()

```java
class A {
    public A() { System.out.println("A() Call..."); }
}
class B extends A {
    public B() { System.out.println("B() Call..."); }
}

new B();   // A() Call... → B() Call...  (부모 생성자가 먼저)
```

자식 생성자 첫 줄에 `super()`가 자동으로 들어가서 부모 생성자가 먼저 실행된다.

부모에 매개변수 있는 생성자만 있으면 super(...)를 직접 호출해야 한다. (안 하면 컴파일 에러)

```java
class Human {
    String name, sex, address, phone;
    public Human(String name, String sex, String address, String phone) { ... }
}

class Student extends Human {
    int hakbun;
    public Student(String name, String sex, String address, String phone) {
        super(name, sex, address, phone);   // 공통 변수 초기화는 부모 생성자에 맡긴다
    }
}
```

| | this | super |
|---|---|---|
| 변수, 메소드 | 자기 객체 | 부모 객체 |
| 생성자 호출 | this(): 자기 다른 생성자 | super(): 부모 생성자 |

- this(), super()는 생성자 첫 줄에만 쓸 수 있어서 둘 중 하나만 가능
- static 메소드, static 블록에서는 this, super 사용 불가

#### 다형성: 부모 타입 변수 하나로 여러 자식 객체 다루기

```java
동물 animal = null;           // 아직 객체 없음 (주소 없음)
switch (ani) {
    case "개": animal = new 개(); break;
    case "소": animal = new 소(); break;
    case "말": animal = new 말(); break;
}
animal.run();                     // 입력한 동물의 run() → 실행할 때 결정된다 (동적 바인딩)
System.out.println(animal.a);     // 100 (변수는 선언한 동물 타입 기준)
```

- 부모 타입 변수에 자식 객체를 넣을 수 있다. 반대는 안 되고, 형제끼리도 안 된다. (`남자 a = new 여자();` X)
- 부모 타입 변수로는 부모에 있는 멤버만 쓸 수 있다. 자식에만 있는 메소드는 호출 불가
- case에 없는 값을 입력하면 animal이 null인 채로 run()을 호출해서 NullPointerException → default 처리 필요

</details>

<details>
<summary>28. 추상 클래스, 인터페이스 (11.02)</summary>

#### 추상 클래스

공통점을 모아둔 미완성 클래스. 클래스마다 구현이 다른 메소드는 선언만 해두고 상속받은 클래스가 구현한다.

```java
abstract class 도형 {
    String color = "검정색";
    abstract void draw();               // 추상 메소드: 선언만 → 자식이 반드시 구현
    void tick() {                       // 일반 메소드: 그대로 쓰거나 오버라이딩 (선택)
        System.out.println("두께: 5mm");
    }
}

class 원 extends 도형 {
    @Override
    void draw() { System.out.println("원을 그린다"); }
    @Override
    void tick() { System.out.println("두께: 10mm"); }
}

도형 a = new 원();    // new 도형()은 불가
a.draw();
a = new 네모();       // 변수 하나로 여러 도형을 제어
a.draw();
```

- @Override: 오버라이딩한 메소드라는 표시. 이름이나 매개변수가 틀리면 컴파일 에러로 알려준다.
- 이클립스: 클래스 이름의 에러에서 Add unimplemented methods → 추상 메소드 자동 생성
- 활용: 26번 Music → GenieMusic, MelonMusic 구조, DB 연결(오라클, MySQL을 같은 코드로 사용)
- 단점: 단일 상속만 가능, 추상 메소드를 추가하면 모든 자식 클래스를 수정해야 한다

#### 인터페이스

추상 클래스를 보완한 것. implements로 여러 개를 동시에 구현할 수 있다.

```java
interface A {
    int MAX = 10;          // 자동으로 public static final (상수)
    void display();        // 자동으로 public abstract
}

class B implements A, C {  // 여러 개 구현 가능
    public void display() { ... }
}
```

| | 추상 클래스 | 인터페이스 |
|---|---|---|
| 키워드 | extends | implements |
| 상속 | 1개만 | 여러 개 |
| 변수 | 일반 변수 가능 | 상수만 |
| 메소드 | 추상 + 일반 | 추상 (Java 8부터 default 메소드 가능) |
| 접근지정어 | 자유 | public (생략해도 자동) |

공통점: new로 직접 객체를 만들 수 없고, 관련된 클래스를 하나의 타입으로 묶어서 관리한다.

#### 익명 클래스, 람다

```java
Runnable r = new Runnable() {     // 이름 없는 클래스로 바로 구현
    @Override
    public void run() {
        System.out.println("쓰레드 실행");
    }
};

Runnable rr = () -> System.out.println("쓰레드 실행");   // 람다: 메소드 1개짜리 인터페이스를 짧게
```

윈도우 이벤트, 쓰레드, 네트워크에서 자주 쓴다.

</details>
<details>
<summary>29. 인터페이스 (2) (11.03)</summary>

#### 여러 클래스를 한 이름으로 관리

```java
List list = new ArrayList();   // List는 인터페이스라 new List()는 불가
list = new LinkedList();       // 구현 클래스만 바꿔 끼우면 나머지 코드는 그대로
list = new Vector();
```

클래스끼리 직접 묶이지 않아서(결합성이 낮아서) 유지보수가 쉽다.

#### 구성요소

```java
interface A {
    int MAX = 100;               // 상수 (public static final 자동). 반드시 값을 넣어야 한다
    void display();              // 추상 메소드 (public abstract 자동)
    default void print() { }     // default 메소드: 구현된 메소드 (Java 8)
    static void info() { }       // static 메소드: A.info()로 호출 (Java 8)
    private void help() { }      // private 메소드: 인터페이스 안에서만 사용 (Java 9)
}
```

default 메소드가 생긴 이유: 인터페이스에 추상 메소드를 추가하면 구현한 클래스가 전부 에러가 난다. 구현된 메소드로 추가하면 기존 클래스는 고칠 필요가 없다.

#### 상속 관계

| 관계 | 키워드 |
|---|---|
| 인터페이스 → 인터페이스 | extends (여러 개 가능: `interface C extends A, B`) |
| 인터페이스 → 클래스 | implements (여러 개 가능) |
| 클래스 → 인터페이스 | 불가 |

```java
class D extends C implements A, B { }   // 상속과 구현을 같이 할 때는 extends가 먼저
```

#### 구현할 때 public 필수

```java
interface A {
    void display();              // 자동으로 public
}

class B implements A {
    public void display() { }    // O
    // void display() { }        // X 에러
}
```

오버라이딩은 접근지정어를 줄일 수 없는데, 인터페이스 메소드는 전부 public이라서 구현 클래스에서도 public을 붙여야 한다.

사용처: 윈도우 이벤트, 쓰레드, 데이터베이스 연결, 웹 / 앱 연동

</details>
<details>
<summary>30. 예외처리 (11.04)</summary>

#### 예외처리란

실행 중에 생길 수 있는 에러에 미리 대비하는 코드. 목적은 비정상 종료 방지

에러를 고치는 게 아니라 건너뛰어서 프로그램이 계속 돌게 하는 것이다.

| | 에러 (Error) | 예외 (Exception) |
|---|---|---|
| 정도 | 심각 (메모리 부족 등) | 가벼움 (파일 없음, 잘못된 입력 등) |
| 코드로 처리 | 불가 | 가능 |

#### Checked vs Unchecked

| | Checked | Unchecked (RuntimeException) |
|---|---|---|
| 검사 시점 | 컴파일할 때 (저장하면 빨간 줄) | 실행할 때 |
| 예외처리 | 필수 (try~catch 또는 throws) | 선택 |
| 원인 | 바깥 (파일, 네트워크, DB) | 코드 실수, 사용자 입력 |
| 예 | java.io, java.net, java.sql | 아래 5가지 |

```
Throwable
 ├ Error
 └ Exception
     ├ IOException, SQLException ...   ← Checked
     └ RuntimeException                 ← Unchecked
         ├ ArithmeticException
         ├ NullPointerException
         ├ NumberFormatException
         ├ ArrayIndexOutOfBoundsException
         └ ClassCastException
```

예외도 전부 클래스다. 에러가 나면 자바가 예외 객체를 만들어서 던지고(`throw new ArithmeticException(...)`), catch가 그 객체를 받는다.

#### 자주 보는 Unchecked 예외

| 예외 | 원인 | 예 |
|---|---|---|
| ArithmeticException | 0으로 나누기 | `10 / 0` |
| NullPointerException | null로 메소드 호출 | `String s = null; s.length();` |
| NumberFormatException | 숫자로 못 바꾸는 문자열 | `Integer.parseInt(" 20")` (공백도 안 됨) |
| ArrayIndexOutOfBoundsException | 배열 범위 초과 | 크기 2인데 `arr[2]` |
| ClassCastException | 잘못된 형변환 | `A a = new A(); B b = (B) a;` |

- Unchecked는 먼저 if로 막고(유효성 검사), 그래도 필요하면 try~catch
- 형변환은 실제 객체가 B일 때만 된다. `A a = new B(); B b = (B) a;`는 정상

#### try ~ catch ~ finally

```java
try {
    // 에러가 날 수도 있는 코드
} catch (ArithmeticException e) {
    // 이 예외가 나면 실행
} catch (Exception e) {
    // 나머지 예외 전부 (부모라서 맨 마지막에)
} finally {
    // 무조건 실행 (파일 닫기, 연결 끊기). 생략 가능
}
```

실행 흐름 (try 안에 A, B, C / catch에 D / finally에 E / 그다음 F)

- 에러 없음: A → B → C → E → F
- B에서 에러: A → B → D → E → F (C는 건너뜀)
- try 밖에서 에러: 그 자리에서 프로그램 종료

- catch는 위에서부터 맞는 것 하나만 실행된다. Exception을 먼저 쓰면 아래 catch에 갈 수 없어서 컴파일 에러
- `catch (Exception e)`는 문법이라 모양 그대로 쓴다. e는 예외 객체를 담는 변수 이름
- `e.getMessage()`: 에러 메시지만 (`/ by zero`) / `e.printStackTrace()`: 종류와 몇 번째 줄인지까지
- 감싸는 범위: for 안을 감싸면 에러 난 바퀴만 건너뛰고 계속, for 전체를 감싸면 반복이 끝난다

#### 파일 닫기: finally vs try-with-resources

```java
FileReader fr = null;
try {
    fr = new FileReader("movie.txt");
    // 읽기
} catch (Exception ex) {
    System.out.println(ex.getMessage());
} finally {
    try {
        if (fr != null) fr.close();   // 파일을 못 열었으면 null이라 확인 필요
    } catch (Exception ex) { }        // close()도 Checked 예외라 한 번 더 감싼다
}

// try-with-resources (Java 7): try ( ) 안에서 연 것은 자동으로 닫힌다
try (FileReader fr = new FileReader("movie.txt")) {
    // 읽기
} catch (Exception ex) {
    ex.printStackTrace();
}
```

#### 예외 처리 방법 4가지

| 방법 | 코드 | 뜻 |
|---|---|---|
| 복구 (직접 처리) | `try ~ catch` | 그 자리에서 처리 |
| 회피 (간접 처리) | `메소드() throws 예외` | 메소드를 부른 쪽에 처리를 넘긴다 |
| 발생 | `throw new 예외("메시지")` | 일부러 발생시킨다 (테스트, 규칙 위반) |
| 사용자 정의 | `class MyException extends Exception` | 직접 만든 예외 |

```java
static void fff() throws Exception { }          // Checked → 부른 쪽에서 반드시 처리
static void ggg() throws RuntimeException { }   // Unchecked → 처리 안 해도 됨

try {
    fff();                    // throws로 넘어온 예외는 부른 쪽에서 try~catch
} catch (Exception e) { }

// 사용자 정의 + throw
class MyException extends Exception {
    public MyException(String msg) { super(msg); }
}

void withdraw(int money) throws MyException {
    if (money > balance) {
        throw new MyException("잔액 부족");
    }
}
```

main까지 throws로 계속 넘기면 결국 JVM이 받아서 프로그램이 종료된다.

</details>
<details>
<summary>31. 중첩 클래스 (11.05)</summary>

클래스 안에 만든 클래스. 안쪽 클래스는 바깥 클래스의 변수와 메소드를 private까지 바로 쓸 수 있다. 주로 쓰레드, 윈도우, 서버 프로그램에서 쓰고 웹(스프링)에서는 거의 안 쓴다.

| 종류 | 위치 | 비중 |
|---|---|---|
| 멤버 클래스 | 클래스 안 | 중요 |
| 정적 멤버 클래스 | 클래스 안 + static | 가끔 |
| 지역 클래스 | 메소드 안 | 거의 안 씀 |
| 익명 클래스 | 객체를 만드는 자리 | 가장 많이 씀 |

#### 멤버 클래스

```java
class Outer {
    private String name = "홍길동";

    class Inner {
        void print() {
            System.out.println(name);    // 바깥의 private 변수도 바로 사용
        }
    }
}

Outer p = new Outer();             // 바깥 객체를 먼저 만들고
Outer.Inner c = p.new Inner();     // 그 객체로 안쪽 객체 생성
```

변수 이름이 겹칠 때

```java
class Outer5 {
    int value = 10;
    class Inner {
        int value = 20;
        void method() {
            int value = 30;
            System.out.println(value);               // 30 지역 변수
            System.out.println(this.value);          // 20 Inner
            System.out.println(Outer5.this.value);   // 10 Outer5
        }
    }
}
```

예: 프로그레스바. BarThread를 JFrame 클래스 안에 만들어서 바깥의 go()와 bar를 바로 쓴다.

```java
class 중첩클래스_2 extends JFrame {
    JProgressBar[] bar;
    void go() { ... }                   // 바 채우기

    class BarThread extends Thread {    // 멤버 클래스
        public void run() {
            go();                       // 바깥 메소드를 바로 호출
        }
    }
}
```

밖에 따로 만들면 바깥 객체를 넘겨받아야 해서 코드가 복잡해진다.

#### 정적 멤버 클래스, 지역 클래스

```java
class Outer2 {
    static class Inner { }    // 바깥 객체 없이 new Outer2.Inner()로 생성, 바깥의 static 멤버만 사용 가능

    void print() {
        class Local { }       // 메소드 안에서만 사용
    }
}
```

#### 익명 클래스

클래스를 따로 만들지 않고 그 자리에서 상속 + 오버라이딩 + 객체 생성을 한 번에 한다. 이름이 없어서 다시 쓸 수 없는 일회용

```java
// 원래 방식
class 개 extends 동물 {
    void sound() { System.out.println("멍멍"); }
}
동물 a = new 개();

// 익명 클래스
동물 a = new 동물() {
    void sound() { System.out.println("멍멍"); }
};                            // 끝에 세미콜론
```

예: 표(JTable) 셀 수정 막기

```java
model = new DefaultTableModel(row, col) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;         // 이 메소드 하나만 바꿔서 사용
    }
};
```

`new 클래스() { }` 모양이면 익명 클래스다. 람다식(`() -> { }`)은 이걸 더 짧게 쓴 것 (28번)

</details>
<details>
<summary>32. java.lang - Object, 객체 복사 (11.06)</summary>

#### java.lang

import 없이 쓰는 기본 클래스 묶음

| 클래스 | 역할 |
|---|---|
| Object | 모든 클래스의 최상위 클래스 |
| String | 문자열 저장, 제어 |
| StringBuffer / StringBuilder | 문자열을 빠르게 이어 붙이기 |
| Wrapper | 기본형을 클래스로 (int → Integer, double → Double, boolean → Boolean, char → Character ...) |
| Math | 수학 관련 기능 |
| System | 출력, 입력, 시간, gc |

- StringBuffer는 동기화(쓰레드 여러 개에서 안전), StringBuilder는 동기화 없음(대신 더 빠름)
- 다른 기본 라이브러리: java.util, java.text, java.io, java.net, java.sql

#### Object의 주요 메소드

모든 클래스가 Object를 상속받아서 아래 메소드를 바로 쓸 수 있다.

| 메소드 | 기능 |
|---|---|
| toString() | 객체를 문자열로. 기본은 `클래스명@해시코드`, `println(a)`하면 자동 호출 |
| equals() | 객체 비교. 기본은 주소 비교(==) |
| hashCode() | 객체 구분 번호 |
| getClass() | 객체의 클래스 정보 |
| clone() | 객체 복제 |
| finalize() | 객체가 메모리에서 해제될 때 호출 (Java 9부터 사용 비권장) |

```java
A a = new A("홍길동");
A b = new A("홍길동");
a.equals(b);          // false → 내용이 같아도 주소가 다른 객체

@Override
public String toString() {        // 보통 객체 정보를 출력하도록 오버라이딩
    return "이름: " + name;
}
System.out.println(a);            // 이름: 홍길동
```

내용으로 비교하려면 equals()를 오버라이딩한다. String은 이미 오버라이딩돼 있어서 내용 비교가 되고, lombok @Data도 자동으로 만들어 준다.

#### finalize()

```java
Main m = new Main(100);   // 생성
m.display();              // 활용
m = null;                 // 주소 삭제
System.gc();              // GC 요청 → 메모리가 해제될 때 finalize() 호출
```

- finalize()는 객체를 없애는 메소드가 아니라, 없어질 때 호출되는 메소드
- System.gc()는 요청일 뿐이라 바로 실행된다는 보장이 없다.

#### 객체 복사: 대입 vs clone()

```java
class Sawon implements Cloneable {    // Cloneable을 구현해야 clone() 사용 가능
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

Sawon shim = (Sawon) hong.clone();    // 새 객체 생성 (리턴형이 Object라 형변환 필요)
Sawon kim = shim;                     // 주소만 복사 → 같은 객체
kim.setName("김두한");                 // shim의 이름도 김두한으로 바뀐다
```

| | 대입 (`kim = shim`) | clone() |
|---|---|---|
| 새 객체 | X (같은 객체) | O |
| 한쪽을 수정하면 | 둘 다 바뀐다 | 서로 영향 없음 |

clone()은 필드 값을 그대로 복사한다(얕은 복사). 그래서 배열 같은 참조형 필드는 원본과 같은 배열을 가리킨다.

#### 메소드에 참조형 넘기기

```java
static void arrayUpdate(int[] arr) {    // arr = a (주소가 넘어온다)
    arr[0] = 100;
}

int[] a = new int[5];
arrayUpdate(a);
System.out.println(a[0]);               // 100 → 메소드 안에서 바꾼 값이 원본에 반영
```

- 배열, 객체는 주소가 넘어가서 메소드 안에서 바꾸면 원본도 바뀐다. (memberUpdate(mm)도 같다)
- String은 참조형이지만 값을 바꿀 수 없어서(불변) 메소드 안에서 바꿔도 원본은 그대로

</details>
<details>
<summary>33. Object (2) toString, equals, hashCode 오버라이딩 (11.09)</summary>

#### Object = 가장 큰 데이터형

```java
Object o = 10;
o = 0.5;
o = "Hello";
o = new A();     // 기본형, 참조형 전부 담을 수 있다
```

- java.lang에서 Object를 뺀 나머지(String, System, Math ...)는 final이라 상속해서 바꿀 수 없다.
- 라이브러리가 Object로 돌려주면(예: 콤보박스 `getSelectedItem()`) 형변환이나 toString()으로 바꿔서 쓴다. 이걸 없애 주는 게 제네릭 `< >`

#### toString()

```java
@Override
public String toString() {
    return "이름:" + name + ",성별:" + sex;
}

System.out.println(m1);          // 이름:홍길동,성별:남자 (toString() 자동 호출)
String s = "회원: " + m1;         // 문자열과 + 할 때도 자동 호출
```

- 오버라이딩 전에는 `Member@1b6d3586`처럼 `클래스명@해시코드`가 나온다.
- String, Integer, ArrayList는 이미 오버라이딩돼 있어서 출력하면 내용이 바로 보인다.

#### equals() + hashCode()

```java
@Override
public boolean equals(Object obj) {
    if (obj instanceof Sawon) {           // Sawon 객체인지 확인
        Sawon s = (Sawon) obj;            // Object → Sawon 형변환
        return sabun == s.sabun && name.equals(s.name);
    }
    return false;
}

@Override
public int hashCode() {
    return Objects.hash(sabun, name);     // 같은 값이면 같은 번호
}

Sawon s1 = new Sawon(1, "박문수");
Sawon s2 = new Sawon(1, "박문수");
s1.equals(s2);     // true  (내용 비교)
s1 == s2;          // false (주소는 다름)
```

- equals를 오버라이딩하면 hashCode도 같이 오버라이딩해야 한다.
- HashSet은 hashCode()로 먼저 비교하고, 같을 때만 equals()로 확인한다. hashCode를 안 바꾸면 s1, s2가 중복으로 걸러지지 않고 둘 다 들어간다.
- lombok `@Data`를 붙이면 toString, equals, hashCode가 자동으로 만들어진다.

</details>

<details>
<summary>34. System (11.09)</summary>

전부 static 메소드라 new 없이 `System.메소드()`로 쓴다.

| 기능 | 메소드 |
|---|---|
| 프로그램 종료 | `System.exit(0)` (0 = 정상 종료) |
| 출력 | `System.out.print()` / `println()` / `printf()` |
| 입력 | `System.in.read()` (보통은 Scanner 사용) |
| 메모리 회수 요청 | `System.gc()` |
| 시간 측정 | `System.currentTimeMillis()` (1/1000초) |
| 운영체제, 자바 정보 | `System.getProperty("os.name")` |

#### 종료 범위

| | 끝내는 범위 | 아래 코드 |
|---|---|---|
| break | 반복문만 | 실행됨 |
| return | 메소드만 | 메소드 밖은 계속 |
| System.exit(0) | 프로그램 전체 | 실행 안 됨 |

#### 걸린 시간 측정

```java
long start = System.currentTimeMillis();
// 작업
long end = System.currentTimeMillis();
System.out.println("걸린 시간:" + (end - start));    // 밀리초
```

#### System.in.read()

```java
int num = System.in.read();       // '1'을 입력하면 49 (문자 코드값)
System.out.println(num - '0');    // 49 - 48 = 1
```

- 글자 하나의 코드값을 읽고, 엔터도 따로 읽힌다. Checked 예외라 try~catch도 필요
- 불편해서 실제로는 Scanner를 쓴다.

getProperty 키: `os.name`(운영체제), `user.name`(사용자), `user.home`(홈 폴더), `java.version`(자바 버전)

</details>

<details>
<summary>35. String (3) 분리, 정규식, 활용 (11.09)</summary>

#### 문자열 관련 클래스

| 클래스 | 용도 | 패키지 |
|---|---|---|
| String | 문자열 저장, 제어 | java.lang |
| StringBuffer / StringBuilder | `append()`로 문자열 결합 | java.lang |
| StringTokenizer | 구분자로 문자열 나누기 | java.util |

#### split vs StringTokenizer

```java
String data = "계란,새송이버섯,대파,참기름";

String[] datas = data.split(",");                 // 배열로 받는다

StringTokenizer st = new StringTokenizer(data, ",");
System.out.println(st.countTokens());             // 나눠진 단어 개수
while (st.hasMoreTokens()) {                      // 남은 단어가 있는 동안
    System.out.println(st.nextToken());           // 하나씩 꺼낸다
}
```

| | split | StringTokenizer |
|---|---|---|
| 구분자 | 정규식 (특수문자 앞에 `\\`) | 문자 그대로 |
| 결과 | 배열 | 하나씩 꺼내기 |
| 빈 값 (`"a,,b"`) | a, 빈 문자열, b (빈 칸 유지) | a, b (빈 칸 건너뜀 → 칸이 밀릴 수 있다) |

```java
"red|green".split("|");                     // r, e, d, |, g ... 한 글자씩 다 쪼개진다
"red|green".split("\\|");                   // red, green
new StringTokenizer("red|green", "|");      // red, green (\\ 필요 없음)
```

#### 정규식 기호

| 기호 | 뜻 |
|---|---|
| `[^ ]` | 괄호 안의 것 제외 |
| `\|` | 또는 |
| `?` | 0개 또는 1개 |
| `+` | 1개 이상 |
| `*` | 0개 이상 |
| `.` | 아무 글자 하나 |

#### 메소드 쓰임새

```java
String url = "https://www.genie.co.kr/chart/genre";

url.substring(url.lastIndexOf("/") + 1);   // "genre"  마지막 / 다음부터
url.substring(0, url.indexOf(":"));        // "https"  처음부터 : 전까지
```

| 메소드 | 쓰임 |
|---|---|
| equals | 대소문자 구분 → 로그인 |
| equalsIgnoreCase | 대소문자 무시 → 검색 |
| contains | 검색 |
| startsWith | 자동 완성 |
| endsWith | 파일 확장자 확인 |

문자열 비교는 ==가 아니라 equals

#### 예제: 지니 장르별 차트

```java
public class GenieMusic {
    private static MusicVo[] musics = new MusicVo[50];
    private static String[] category = {
        "https://www.genie.co.kr/chart/top200",
        "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20261108&genrecode=M0100",   // 가요
        // POP, OST, 트롯, JAZZ, CLASSIC ...
    };

    public void getData(int cno) {         // 요청할 때마다 다시 호출할 수 있게 메소드로
        Document doc = Jsoup.connect(category[cno]).get();
        // 크롤링 → musics[i]에 저장 (26번과 같은 방식)
    }
}

// UserMain
int cno = scan.nextInt();
gm.getData(cno - 1);                       // 메뉴 번호 - 1 = 배열 index
```

생성자나 static 블록은 1번만 실행돼서, 카테고리를 바꿀 때마다 다시 불러오려면 일반 메소드로 만들어야 한다.

</details>
<details>
<summary>36. 포맷(java.text), Math (11.10)</summary>

#### 날짜 포맷 SimpleDateFormat

```java
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
System.out.println(sdf.format(date));     // 2026-11-10 17:05:09
```

| 기호 | 뜻 |
|---|---|
| yyyy / yy | 년 (2026 / 26) |
| MM / M | 월 (11, 05 / 5) |
| dd / d | 일 |
| HH / hh | 시 (24시간 / 12시간) |
| mm | 분 |
| ss | 초 |

월은 대문자 `MM`, 분은 소문자 `mm`. `yyyy-mm-dd`로 쓰면 월 자리에 분이 나온다.

#### 숫자 포맷

```java
new DecimalFormat("###,###,###").format(100000);          // 100,000

double[] limits = {0, 60, 70, 80, 90};
String[] grades = {"F", "D", "C", "B", "A"};
new ChoiceFormat(limits, grades).format(85);               // B (범위별로 값 고르기)

NumberFormat.getInstance().format(1234567.89);             // 1,234,567.89
NumberFormat.getCurrencyInstance().format(1234567.89);     // ₩1,234,568
NumberFormat.getPercentInstance().format(0.25);            // 25%
```

NumberFormat은 추상 클래스라 new 대신 `getInstance()`로 객체를 받는다.

#### Math

전부 static 메소드라 `Math.메소드()`로 쓴다.

| 메소드 | 기능 | 예 |
|---|---|---|
| `random()` | 0.0 이상 1.0 미만 난수 | `(int)(Math.random() * 100) + 1` → 1~100 |
| `ceil()` | 올림, double로 리턴 | `(int)Math.ceil(1938 / 10.0)` → 194 (총 페이지) |
| `round()` | 반올림, long으로 리턴 | `Math.round(10.5)` → 11 |
| `max()` / `min()` | 큰 값 / 작은 값 | `Math.max(10, 20)` → 20 |
| `abs()` | 절대값 | `Math.abs(-1)` → 1 |

오라클에도 CEIL, ROUND가 같은 기능으로 있다.

</details>

<details>
<summary>37. StringBuffer, StringBuilder (11.10)</summary>

#### String과 비교

| | String | StringBuffer | StringBuilder |
|---|---|---|---|
| 문자열 변경 | 불가능 (불변) | 가능 | 가능 |
| 문자열 추가 | 새 객체 생성 | 기존 객체 변경 | 기존 객체 변경 |
| 동기화 | 해당 없음 | 지원 | 미지원 |
| 속도 | 반복 변경 시 느림 | 비교적 느림 | 빠름 |
| 용도 | 일반 문자열 | 쓰레드끼리 공유 | 일반 문자열 조립 |

String에 `+=`를 반복하면 매번 새 문자열이 만들어진다. "a"를 5만 번 붙이면 String은 약 450ms, StringBuilder는 약 2ms 걸렸다.

#### 주요 메소드

```java
StringBuilder sb = new StringBuilder("Java");
sb.append(" Hello");          // Java Hello              끝에 추가
sb.insert(4, "Language");     // JavaLanguage Hello      특정 위치에 삽입
sb.delete(0, 4);              // Language Hello          0~3 삭제 (end는 포함 안 함)
sb.replace(0, 4, "Spring");   // Springuage Hello        0~3을 Spring으로
sb.deleteCharAt(0);           // pringuage Hello         한 글자 삭제
sb.reverse();                 // olleH egaugnirp         뒤집기
String s = sb.toString();     // String으로 변환
```

`length()`, `charAt()`도 String과 똑같이 쓸 수 있다. StringBuffer도 메소드는 전부 같다.

#### 예제: 웹 페이지 HTML 읽기

```java
URL url = URI.create("https://www.10000recipe.com/recipe/list.html").toURL();   // new URL()은 Java 20부터 비권장
HttpURLConnection conn = (HttpURLConnection) url.openConnection();

BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
StringBuilder sb = new StringBuilder();
while (true) {
    String line = br.readLine();     // 한 줄씩 읽기, 끝이면 null
    if (line == null) break;
    sb.append(line).append("\n");
}
System.out.println(sb.toString());
```

</details>

<details>
<summary>38. Wrapper 클래스 (11.10)</summary>

기본형을 객체로 쓸 수 있게 만든 클래스

| 기본형 | Wrapper | 문자열 → 기본형 |
|---|---|---|
| int | Integer | `Integer.parseInt("10")` |
| long | Long | `Long.parseLong("10")` |
| double | Double | `Double.parseDouble("10.5")` |
| boolean | Boolean | `Boolean.parseBoolean("true")` |
| char | Character | |
| byte, short, float | Byte, Short, Float | |

- 웹이나 윈도우에서 받은 값은 전부 String이라, parse로 필요한 형으로 바꿔서 쓴다.
- 제네릭에는 클래스만 들어간다. `<int>`는 안 되고 `<Integer>`

#### Boxing / Unboxing

```java
Integer i = 100;     // Boxing: 기본형 → Wrapper (자동)
int n = i;           // Unboxing: Wrapper → 기본형 (자동)
```

Wrapper끼리 비교도 equals를 쓴다. `Integer a = 128, b = 128;`이면 `a == b`는 false (주소 비교)

#### 그 밖의 기능

```java
Integer.MAX_VALUE              // 2147483647 (int 최대값)
Integer.MIN_VALUE              // -2147483648
Integer.toBinaryString(10)     // "1010" (2진수)
Integer.toHexString(10)        // "a"    (16진수)
Integer.toOctalString(10)      // "12"   (8진수)
```

parseInt(null)은 NumberFormatException이 나서, null일 수 있는 값은 먼저 확인한다.

```java
if (s != null) {
    int a = Integer.parseInt(s);
}
```

</details>
<details>
<summary>39. 리플렉션, 어노테이션 (11.11)</summary>

#### 리플렉션

실행 중에 클래스 정보(변수, 생성자, 메소드)를 읽어서 직접 조작하는 기술. new 없이 객체를 만들고, private 변수에도 접근할 수 있다.

스프링, MyBatis, JPA가 이걸로 객체 생성과 메소드 호출을 자동으로 처리한다. 직접 만들어 쓸 일은 거의 없고, 원리만 알면 된다.

| 클래스 구성 | 리플렉션 클래스 |
|---|---|
| 클래스 | Class |
| 변수 | Field |
| 생성자 | Constructor |
| 메소드 | Method |

#### Class 객체 얻기

```java
Class cls = String.class;
Class cls = str.getClass();
Class cls = Class.forName("com.sist.reflect.Member");   // 패키지명부터 전부
```

#### 조작하기

```java
Class cls = Class.forName("com.sist.reflect.Member");

// 객체 생성 (생성자 호출)
Object obj = cls.getDeclaredConstructor().newInstance();                    // new Member()
Object obj2 = cls.getDeclaredConstructor(int.class, String.class, String.class)
                 .newInstance(2, "박문수", "부산");                          // new Member(2, "박문수", "부산")

// 변수
Field f = cls.getDeclaredField("name");
f.setAccessible(true);           // private 변수에 접근 허용
f.set(obj, "심청이");             // 값 쓰기
f.get(obj);                      // 값 읽기

// 메소드
Method m = cls.getDeclaredMethod("insert");
m.invoke(obj);                   // obj.insert()

// 전체 목록
cls.getDeclaredFields();         // Field[]
cls.getDeclaredConstructors();   // Constructor[]
cls.getDeclaredMethods();        // Method[]
```

- `getDeclared~`: 그 클래스에 선언된 것 전부 (private 포함, 상속받은 것 제외)
- `getMethods()`, `getConstructor()`: public만 (상속받은 것 포함)
- 장점: 프레임워크 자동화, 재사용, 유지보수
- 단점: 직접 호출보다 느리다, private 접근이 가능해서 보안 문제, 코드가 읽기 어렵다

#### 어노테이션

클래스, 변수, 메소드에 표시를 붙여서 바로 찾을 수 있게 하는 것. 표시 자체에는 기능이 없고, 리플렉션으로 찾아서 처리한다.

- 스프링: `@Controller` `@Service` `@Autowired` `@GetMapping` `@RequestMapping`
- MyBatis: `@Select` `@Insert` `@Update` `@Delete`

```java
@Retention(RetentionPolicy.RUNTIME)   // 실행 중에도 읽을 수 있게 (없으면 리플렉션으로 못 찾는다)
@Target(ElementType.METHOD)           // 메소드 위에 붙이는 용도
public @interface RequestMapping {
    String value();
}

class Board {
    @RequestMapping("1")
    public void list() { System.out.println("list"); }

    @RequestMapping("2")
    public void insert() { System.out.println("insert"); }
}

// 메뉴 번호와 같은 어노테이션이 붙은 메소드를 찾아서 실행
Class cls = Class.forName("com.sist.reflect.Board");
Object obj = cls.getDeclaredConstructor().newInstance();
for (Method m : cls.getDeclaredMethods()) {
    RequestMapping rm = m.getAnnotation(RequestMapping.class);
    if (rm != null && Integer.parseInt(rm.value()) == menu) {
        m.invoke(obj);
    }
}
```

if~else로 메뉴마다 메소드를 연결하지 않아도, 메소드에 어노테이션만 붙이면 자동으로 찾아서 실행된다. 스프링이 URL 요청을 메소드에 연결하는 방식이 이것이다.

</details>

<details>
<summary>40. 정규식 Pattern, Matcher (11.11)</summary>

지정한 패턴으로 문자열을 검색하거나 검사(유효성 검사)한다. 자바, 자바스크립트, 오라클에서 같은 기호를 쓴다. 기본 기호는 35번 참고

#### 추가 기호

| 기호 | 뜻 | 예 |
|---|---|---|
| `\\d` | 숫자 (= `[0-9]`) | `\\d{3}` |
| `\\s` | 공백 | |
| `\\w` | 알파벳, 숫자, `_` 한 글자 | |
| `{n}` | n개 | `[가-힣]{5}` 한글 5글자 |
| `{n,m}` | n~m개 | `[0-9]{1,3}` → 1, 12, 123 |
| `^` (괄호 밖) | 시작 | `^홍` 홍으로 시작 |
| `$` | 끝 | `[A-Z]$` 대문자로 끝 |
| `( )` | 묶음 | `(abc)` → abc 그대로 |

- `[abc]`는 a, b, c 중 한 글자. `(abc)`는 abc라는 묶음
- 자바 문자열 안에서는 `\`를 두 번 쓴다. (`\d` → `"\\d"`)

```java
"010-1234-5678".matches("\\d{3}-\\d{4}-\\d{4}")                      // 전화번호 형식
"211.238.142.21".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")  // IP 형식
"홍길동".matches("^홍[가-힣]+")                                          // 홍으로 시작하는 한글
"colour".matches("colou?r")                                           // u가 있어도 없어도 true
```

#### matches vs find

- `matches()`: 문자열 전체가 패턴과 맞아야 true (`"abc123".matches("[a-z]+")` → false)
- `find()`: 문자열 안에서 패턴에 맞는 부분을 찾는다

```java
String res = "맛있,맛있고,맛있게,맛없다,맛있습니다";
Pattern p = Pattern.compile("맛있[가-힣]+");   // 맛있 뒤에 한글 1개 이상
Matcher m = p.matcher(res);                    // 검색 대상 지정
while (m.find()) {                             // 다음으로 맞는 부분이 있는 동안
    System.out.println(m.group());             // 맛있고, 맛있게, 맛있습니다
}
```

`맛있`만 있는 건 뒤에 한글이 없어서 `+`(1개 이상)에 걸리지 않는다.

#### 그룹

```java
Matcher m = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\.(\\d{1,3})").matcher("211.238.142.21");
m.find();
m.group();     // 211.238.142.21  전체
m.group(1);    // 211.238.142     첫 번째 ( )
m.group(2);    // 21              두 번째 ( )
```

그룹 번호는 여는 괄호 `(` 순서대로 매겨진다.

쓰임: 이메일, 전화번호, 비밀번호 검증 / 크롤링 데이터 정리 / 로그 분석 / 오라클 `REGEXP_LIKE`

</details>

<details>
<summary>41. 날짜, 시간 LocalDateTime (11.11)</summary>

java.time 패키지 (Java 8). 예전 Date, Calendar를 대신한다.

| 클래스 | 저장 |
|---|---|
| LocalDateTime | 날짜 + 시간 |
| LocalDate | 날짜 |
| LocalTime | 시간 |

```java
LocalDateTime now = LocalDateTime.now();                         // 현재
LocalDateTime dt = LocalDateTime.of(2026, 11, 11, 12, 30, 30);   // 특정 날짜, 시간 (월은 1~12 그대로)

now.plusDays(4).plusHours(3);    // 4일 3시간 뒤
now.minusMonths(1);              // 1달 전

now.getYear();                   // 년
now.getMonthValue();             // 월
now.getDayOfMonth();             // 일
now.getHour();                   // 시
```

plus, minus는 원본을 바꾸지 않고 새 객체를 돌려준다. (String처럼 불변)

#### 문자열 ↔ 날짜

```java
DateTimeFormatter ff = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

LocalDateTime t = LocalDateTime.parse("2026-03-31 15:47:40", ff);   // 문자열 → 날짜
String s = dt.format(ff);                                           // 날짜 → "2026-11-11 12:30:30"
```

패턴 기호는 SimpleDateFormat과 같다. (36번: MM 월 / mm 분, HH 24시간 / hh 12시간)

</details>
</details>
