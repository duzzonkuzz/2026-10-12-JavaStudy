

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
</details>
