# 부트캠프 


> IT 부트캠프에서 배운 내용을 주제별로 정리한 저장소입니다.  
> 항목을 클릭하면 내용이 펼쳐집니다.

<br>

<details>
<summary><b>☕ Java</b></summary>

<br>

<details>
<summary><b>01. 자바 실행 원리와 JVM</b> <sub>📅 2026.10.12</sub></summary>

#### 실행 과정

```text
소스 코드(.java) ──[javac 컴파일]──▶ 바이트코드(.class) ──[JVM 실행]──▶ 프로그램 실행
```

> 💡 바이트코드는 OS가 아니라 JVM이 실행하기 때문에, JVM만 있으면 Windows · Mac · Linux 어디서든 같은 `.class` 파일이 동작한다. (Write Once, Run Anywhere)

#### 소스 코드 vs 바이트코드

| | 소스 코드 (`.java`) | 바이트코드 (`.class`) |
|---|---|---|
| 만드는 주체 | 개발자가 직접 작성 | `javac`가 소스 코드를 변환해 생성 |
| 읽기 | 사람이 읽을 수 있음 | JVM 전용 중간 언어 |
| 수정 | 개발자가 수정 | 직접 작성 · 수정하지 않음 |

#### JDK / JRE / JVM

```text
JDK ⊃ JRE ⊃ JVM
```

| 구성 | 포함 내용 | 용도 |
|---|---|---|
| **JVM** | 바이트코드를 실행하는 가상 머신 | 실행 |
| **JRE** | JVM + 기본 라이브러리 | 실행 전용 |
| **JDK** | JRE + 개발 도구(`javac` 등) | 개발 → **개발자는 JDK를 설치** |

#### JVM 구조

**① 클래스 로더 (Class Loader)**  
`.class` 파일을 메모리로 불러온다. 실행 전 준비 단계.

**② 런타임 데이터 영역 (Runtime Data Area)**  
프로그램이 실행되는 동안 쓰는 메모리 공간. 변수 같은 데이터가 여기 저장된다.

| 영역 | 저장되는 것 |
|---|---|
| Method Area | 클래스 정보, 정적(static) 변수 |
| Heap | `new`로 생성한 객체, 인스턴스 변수 |
| Stack | 메소드 호출 정보, 지역 변수, 매개변수 |

**③ 실행 엔진 (Execution Engine)**

| 구성 | 역할 |
|---|---|
| 인터프리터 | 바이트코드를 한 줄씩 기계어로 바꿔 바로 실행한다. 시작은 빠르지만, 반복되는 코드도 매번 번역해서 느리다. |
| JIT 컴파일러 | 자주 실행되는 코드를 통째로 기계어로 바꿔 저장해두고 재사용한다. 인터프리터의 속도 문제를 보완한다. |
| 가비지 컬렉터 (GC) | 더 이상 쓰지 않는 메모리(Heap의 객체)를 자동으로 정리한다. |

</details>

<details>
<summary><b>02. 변수</b> <sub>📅 2026.10.13</sub></summary>

#### 변수란?

값을 저장하는 메모리 공간에 붙인 이름. 프로그램이 실행되는 동안 값을 기억해두고 계속 바꿔 쓰기 위해 사용한다.

```java
int hp;        // 선언: 변수(메모리 공간)를 만든다
hp = 100;      // 초기화: 처음으로 값을 넣는다
int mp = 50;   // 선언과 초기화를 한 번에
```

#### 변수의 종류와 저장 위치

| 종류 | 선언 위치 | 저장 영역 | 생성 → 소멸 |
|---|---|---|---|
| 인스턴스 변수 (멤버 변수) | 클래스 안, 메소드 밖 | Heap | 객체 생성(`new`) 시 → 쓰지 않게 되면 GC가 정리 |
| 정적 변수 (`static`) | 클래스 안, 메소드 밖 + `static` | Method Area | 클래스 로딩 시 → 프로그램 종료 시 |
| 지역 변수 · 매개변수 | 메소드 안 | Stack | 메소드 실행 시 → 메소드 종료 시 자동 삭제 |

#### 자바 클래스의 기본 구조

```java
package com.example;              // 패키지: 클래스의 위치 지정
import java.util.Scanner;         // import: 다른 클래스를 가져올 때 사용

public class Player {
    String name;                  // 인스턴스 변수 (멤버 변수)
    static int count;             // 정적 변수 → Player.count 처럼 객체 없이 접근 가능

    public Player() { }           // 생성자

    void attack() { }             // 메소드

    public static void main(String[] args) {
        int hp = 100;             // 지역 변수 → 선언된 메소드(main) 안에서만 사용 가능
    }
}
```

#### 메모리 vs DB

| 구분 | 특징 |
|---|---|
| 메모리 (RAM) | 실행 중 사용하는 공간. 빠르지만 프로그램이 끝나면 사라진다. **변수가 저장되는 곳** |
| DB / 하드디스크 | 오래 보관하는 공간. 전원이 꺼져도 남는다. |

</details>

<details>
<summary><b>03. 자료형</b> <sub>📅 2026.10.13</sub></summary>

#### 기본형 (Primitive Type)

자료형에 따라 차지하는 메모리 크기가 다르다.

| 종류 | 자료형 | 크기 | 비고 |
|---|---|---|---|
| 정수 | `byte` | 1 byte (8 bit) | 네트워크 · 파일 데이터 처리 |
| | `short` | 2 byte | |
| | **`int`** | 4 byte | **정수 기본형** |
| | `long` | 8 byte | 큰 수 (금융, AI, 데이터 분석). 값 뒤에 `L` |
| 실수 | `float` | 4 byte | 값 뒤에 `f` |
| | **`double`** | 8 byte | **실수 기본형** |
| 문자 | `char` | 2 byte | 유니코드 문자 1개 |
| 논리 | `boolean` | 1 byte | `true` / `false` |

#### 리터럴 표기

```java
long money = 10000000000L;   // int 범위를 넘는 수 → L (소문자 l은 숫자 1과 헷갈려서 대문자 권장)
float pi = 3.14f;            // float는 f 필수 (없으면 double로 인식되어 에러)
double rate = 3.14;          // 실수는 기본이 double
char grade = 'A';            // 문자 1개 → 작은따옴표
String name = "Java";        // 문자열 → 큰따옴표, String 사용
```

#### 참조형 (Reference Type)

- 기본형을 제외한 나머지: 클래스(`String` 등), 배열, 인터페이스
- 값 자체가 아니라 객체가 있는 위치(주소)를 저장한다.
- 문자열은 기본형이 아니라 `String` 클래스를 사용한다.

</details>

<details>
<summary><b>04. 식별자와 명명 규칙</b> <sub>📅 2026.10.13</sub></summary>

#### 식별자란?

변수, 클래스, 메소드, 인터페이스, 배열 등에 붙이는 이름.

#### 문법 규칙 (어기면 에러)

- 숫자로 시작할 수 없다. (`1st` ❌ / `st1` ⭕)
- 대소문자를 구분한다. (`age` ≠ `Age`)
- 특수문자는 `_`와 `$`만 사용할 수 있다.
- 공백을 포함할 수 없다.
- 키워드(`int`, `class` 등)는 사용할 수 없다.

#### 관례 (개발자 약속)

| 대상 | 규칙 | 예시 |
|---|---|---|
| 변수 | 소문자로 시작, 두 번째 단어부터 첫 글자 대문자 (camelCase) | `myAge`, `maxHp` |
| 메소드 | 소문자로 시작 (camelCase) | `attack()`, `getName()` |
| 배열 | 소문자로 시작 | `scores` |
| 클래스 · 인터페이스 | 대문자로 시작 (PascalCase) | `Scanner`, `Player` |
| 상수 | 전부 대문자, 단어 사이는 `_` | `MAX_HP` |

</details>

<details>
<summary><b>05. 키보드 입력 (Scanner)</b> <sub>📅 2026.10.13</sub></summary>

```java
import java.util.Scanner;

Scanner scan = new Scanner(System.in);
int a = scan.nextInt();   // 입력한 정수를 a에 저장
```

- `Scanner`는 `java.util` 패키지에 있어서 `import`가 필요하다.
- 이클립스 단축키 `Ctrl + Shift + O` → import 자동 추가

</details>

<details>
<summary><b>06. 연산자</b> <sub>📅 2026.10.14</sub></summary>

#### 연산자 우선순위

| 순위 | 연산자 | 설명 |
|---|---|---|
| 1 | `( )` | 괄호 |
| 2 | `++` `--` `!` | 단항 연산자 |
| 3 | `*` `/` `%` | 곱셈, 나눗셈, 나머지 |
| 4 | `+` `-` | 덧셈, 뺄셈 |
| 5 | `<` `>` `<=` `>=` | 대소 비교 |
| 6 | `==` `!=` | 같다, 다르다 |
| 7 | `&&` | 논리 AND |
| 8 | `\|\|` | 논리 OR |
| 9 | `=` `+=` `-=` | 대입 (가장 마지막) |

- 우선순위가 같으면 왼쪽부터 계산한다. (단, 대입 연산자는 오른쪽부터)
- 헷갈릴 때는 괄호로 순서를 명확하게 하는 게 좋다.

```java
int a = 5 + 3 * 2;     // 11
int b = (5 + 3) * 2;   // 16
```

#### 증감 연산자 (전위 / 후위)

`++`는 1 증가, `--`는 1 감소.

| 형태 | 동작 |
|---|---|
| 전위 `++a` | 먼저 증가시키고 그 값을 사용 |
| 후위 `a++` | 현재 값을 먼저 사용하고 나중에 증가 |

```java
int a = 5;
int b = ++a;   // a=6, b=6

int c = 5;
int d = c++;   // c=6, d=5
```

> 단독으로 쓰면(`a++;` / `++a;`) 결과가 같지만, 다른 연산과 함께 쓰면 결과가 달라진다.

#### 문자열 결합 연산자 (`+`)

한쪽이라도 문자열이면 더하기가 아니라 이어 붙이기가 되고, 결과는 문자열이 된다.

```java
"점수: " + 100     // "점수: 100"
1 + 2 + "3"        // "33"  (1+2=3 먼저 계산 후 결합)
"1" + 2 + 3        // "123" (처음부터 문자열이라 계속 결합)
```

- 왼쪽부터 순서대로 계산되는 점에 주의
- 문자열에는 `-`, `*`, `/` 사용 불가 (`"10" - 5`는 컴파일 에러)

#### 논리 연산자

여러 조건을 묶어서 판단할 때 사용한다. 결과는 항상 `true` 또는 `false`.

| 연산자 | 의미 | 설명 |
|---|---|---|
| `&&` | AND (그리고) | 둘 다 true일 때만 true |
| `\|\|` | OR (또는) | 하나라도 true면 true |
| `!` | NOT (아니다) | true와 false를 뒤집음 |

```java
int hp = 30;
int level = 6;

System.out.println(hp > 0 && level >= 6);   // true  (둘 다 참)
System.out.println(hp > 50 || level >= 6);  // true  (하나만 참이어도 됨)
System.out.println(!(hp > 0));              // false (true를 뒤집음)
```

#### 단축 평가 (Short Circuit)

결과가 이미 정해지면 뒤쪽 조건은 계산하지 않는다.

- `A && B` : A가 false면 B는 확인하지 않는다. (어차피 false)
- `A || B` : A가 true면 B는 확인하지 않는다. (어차피 true)

```java
int a = 5;
boolean r = (a > 10) && (++a > 0);   // 앞이 false라 ++a는 실행 안 됨
System.out.println(a);               // 5
```

</details>

<!--
✏️ 새 주제 추가할 때: 아래 블록을 복사해서 바로 위(06번 </details> 다음)에 붙여넣기

<details>
<summary><b>07. 제어문</b> <sub>📅 2026.10.15</sub></summary>

#### 소제목

내용

</details>
-->

</details>

<!--
✏️ 새 과목 추가할 때 (예: Oracle): 아래 블록을 복사해서 바로 위(Java </details> 다음)에 붙여넣기

<details>
<summary><b>🗄️ Oracle</b></summary>

<br>

(여기에 주제별 details 블록)

</details>
-->

