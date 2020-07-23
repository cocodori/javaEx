# 객체지향

1. 코드 재사용
2. 유지보수 용이
3. 신뢰성 높은 프로그래밍

## 클래스와 객체

클래스란 객체를 정의해놓은 일종의 설계도다.

> 도대체 클래스를 왜 만드는데?

클래스는 일종의 부품이 아닐까? 이를테면 거대한 우주선을 만든다고 하자.

수만가지의 부품이 필요하다. 그러나 우리는 그 부품들을 모두 만들어서 쓸 필요가 없다.

이미 누군가 만들어놓은 부품을 그대로 가져와서 쓰는 것이 (합리적이랄 것도 없이) 상식적인 선택이다. 물론 필요한 부품은 직접 만들 수도 있다. 사용자 정의 타입처럼.

아무튼.

클래스로 객체를 만드는 과정을 클래스의 인스턴스화라고 한다.

만들어진 클래스를 우리는 객체(=인스턴스)라고 부른다.

### 객체의 구성요소

  속성property과 기능function이 있다.

property - member variable

function - method

### 참 쉽고 진부한 객체지향 예제

```java
package com.javaex.ch6;

public class TvProps {
    //객체 프로퍼티
    private boolean power;
    private int channel;

    public TvProps() {
        this.channel = 1;
        this.power = false;
    }

    void power() {
        this.power = !power;
    }

    void channelUp() {
        this.channel = ++channel;
    }

    void channelDown() {
        this.channel = --channel;
    }

    public int getChannel() {
        return channel;
    }

}

package com.javaex.ch6;

public class Tv {
    public static void main(String[] args) {
        TvProps tv = new TvProps();
        TvProps tv2 = new TvProps();

        tv.channelUp(); //2
        tv.channelUp(); //3
        tv.channelUp(); //4

        tv2.channelUp(); //2

        System.out.println("tv.channel : " + tv.getChannel());

        System.out.println("tv2.channel : " + tv2.getChannel());

        tv.channelDown();

        System.out.println("tv.channel : " + tv.getChannel());

        /* 참조하는 객체의 주소가 다르다. */
        System.out.println("==========before========");
        System.out.println("tv : " + tv);
        System.out.println("tv2: " + tv2);

        /*tv2에 tv를 주입한다.*/
        tv2 = tv;

        /* 참조하는 객체의 주소가 같다. */
        System.out.println("==========After========");
        System.out.println("tv : " + tv);
        System.out.println("tv2: " + tv2);
    }
}
```

참고:자바의 정석

### 클래스

**클래스는 데이터와 함수(java에서는 method)의 결합이다.**

프로그래밍 언어에서 데이터 처리 저장형태의 발전과정은 다음과 같다.

1. 변수

    태초에 하나의 데이터만을 저장해둘 수 있는 공간이 있었다.

2. 배열

    1에 만족하지 못하는 탐욕스런 인간이 같은 종류의 여러 데이터를

    하나의 집합처럼 다룰 수 있는 저장형태를 만들었다.

3. 구조체structure

    이건 나도 생소하다.  서로 관련된 여러 데이터를 종류에 관계없이 집합처럼 저장할 수 있는 공간이라고 한다.

4. 그리고 클래스가 있었다

    구조체에 함수를 저장할 수 있는 공간을 더한 것이 클래스다.

**사용자 정의 타입(user - defined type) 클래스**

위에서 말했듯이 필요한 부품이 마땅하지 않다면, 직접 만들어 쓰면 된다.

사용자 정의 타입을 조합(또는 이용)해서 또다른 사용자정의타입 클래스를 만들어낼 수도 있다.

쉽게 말하자면.

1. 아이언맨, 캡틴 아메리카, 블랙 펜서, 헐크, 토르 클래스를 정의한다.
2. 1에서 정의한 각각의 아이언맨, 캡틴, 블랙펜서, 헐크, 토르 인스턴스를 생성해서 어벤져스라는 새로운 클래스를 만들어낼 수 있다.

## 변수와 메서드

변수는 세 종류가 있다.

1. 클래스 변수Class Variable
2. Instance Variable(=멤버변수)
3. 지역변수Local Variable

지역 변수를 제외한 모든 변수는 인스턴스 변수다.

지역 변수는 해당 변수가 선언된 블럭 밖을 벗어날 수 없다.

인스턴스 변수 중에서 static이 붙은 변수가 클래스 변수다.

> **인스턴스 변수? 클래스 변수? 뭐가 다른데?**

- ***instance variable***

클래스 영역에 선언한다. 해당 클래스의 인스턴스를 생성할 때 메모리에 올라간다.

따라서 객체를 생성할 때마다 값이 초기화된다.

인스턴스를 생성하지 않고서는 iv를 다룰 수 없다.

- ***class variable***

인스턴스 변수 앞에 'static'이 붙었다면 클래스 변수다.

cv의 가장 큰 특징은 클래스가 메모리에 로딩될 때 생성된다는 것이다. 프로그램이 종료될 때까지 유지되고 public을 붙이면 전역 변수global variable의 성격을 가진다.

iv처럼 각각의 객체마다 저장공간이 따로 있지 않다. 메모리에 올라간 cv는 하나의 저장공간을 가진다. iv처럼 참조변수.변수명으로 쓰는 게 아니라 클래스이름.변수명으로 쓴다.

물론 iv와 같이 참조변수.변수명으로 쓸 수도 있지만 권장하지 않는다. 

여러 개의 객체를 생성해도 static변수의 값은 공유된다.

**그러므로 static변수의 값은 항상 공통된 값을 갖는다.**

보통 final static ~하면서 변하지 않고 어떤 객체에서도 같아야 할 때 사용했던 것 같다.

```java
class Ironman {
    static String tonyStark = "robertDowneyJr";
}

public class Avengers {
    public static void main(String[] args) {
        System.out.println("================BEFORE====================");
        System.out.println("Ironman.tonyStark : " + Ironman.tonyStark);

        Ironman.tonyStark = "James Gosling";

        System.out.println("================AFTER====================");
        System.out.println("Ironman.tonyStark : " + Ironman.tonyStark);

				System.out.println("------------------------------------------");

        System.out.println("iron1.tonyStark : " + iron1.tonyStark);
        System.out.println("iron2.tonyStark : " + iron2.tonyStark);

        iron1.tonyStark = "SAME";

        System.out.println("--------------------------------------------");
        System.out.println("iron1.tonyStark : " + iron1.tonyStark);
        System.out.println("iron2.tonyStark : " + iron2.tonyStark);
    }

}

/*
결과
================BEFORE====================
Ironman.tonyStark : robertDowneyJr
================AFTER====================
Ironman.tonyStark : James Gosling

------------------------------------------
iron1.tonyStark : James Gosling
iron2.tonyStark : James Gosling
--------------------------------------------
iron1.tonyStark : STATIC is shared.
iron2.tonyStark : STATIC is shared.

*/
```

### Method

...