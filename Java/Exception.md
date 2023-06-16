### 1. 예외란? (Error vs Exception)

오류는 시스템에 비정상적인 상황이 생겼을 때 발생한다. 이는 시스템 레벨에서 발생하기 때문에 심각한 수준의 오류이다. 따라서 개발자가 미리 예측하여 처리할 수 없기 때문에, 애플리케이션에서 오류에 대한 처리를 신경 쓰지 않아도 된다.

오류가 시스템 레벨에서 발생한다면,예외는 개발자가 구현한 로직에서 발생한다. 즉,예외는 발생할 상황을 미리 예측하여 처리할 수 있다. 즉,예외는 개발자가 처리할 수 있기 때문에 예외를 구분하고 그에 따른 처리 방법을 명확히 알고 적용하는 것이 중요하다.

### 2. 예외클래스
![image](https://user-images.githubusercontent.com/128464859/228566241-2d434ab4-0852-4f52-bb94-d91e6feb8b24.png)

-예외클래스의 구조
모든 예외클래스는 Throwable 클래스를 상속받고 있으면, Throwable은 최상위 클래스 Object의 자식 클래스이다.

Trowable을 상속받는 클래쓰는 Error아 Exception이 있다. Error는 시스템 레벨의 심각한 수준의 에러이기 때문에 시스템에 변화를 주어 문제를 처리해야 하는 경우가 일반적이다. 반면에 Exception은 개발자가 로직을 추가하여 처리할 수 있다.

Exception은 수많은 자식클래스를 가지고있다. 그 중 RuntimeException을 주목해야 한다. RuntimeException은 CheckdException과 UnchekedException을 구분하는 기준이다. Exception의 자식 클래스 중 RuntimeException을 제외한 모든 클래스는 CheckedException이며, RuntimeException과 자식 클래스들을 Uncheked Exception 이라 부른다. 

<hr/>

​Error와 Exception의 차이는 개발자가 프로그램 내에서 처리할 수 있는지에 대한 여부이다. Exception은 Error와 다르게 프로그램 내에서 처리해 줄 수 있다.

​즉, 예외가 발생하더라도 프로그램을 비정상 종료시키지 않는다.

​

​Exception은 RuntimeException과 OtherException으로 나뉜다. 이들을 구분하는 차이는 컴파일러가 예외 처리를 하는지에 대한 여부이다.

​RuntimeException은 Error와 함께 컴파일러가 예외를 체크하지 않는다. 이들을 비체크 예외(UnChecked Exceptions)라고 부른다.

​반대로 OtherException은 Error와 RuntimeException을 제외한 모든 예외를 의미하며 컴파일러가 예외를 체크해 준다. 이는 체크 예외(Checked Exception)라고 부른다.

![image](https://user-images.githubusercontent.com/128464859/228690971-68071c07-dbb5-4666-aa2a-2c8867113636.png)

 

RuntimeException은 주로 프로그래밍 버그나 논리 오류에서 기인한다. 예를 들어 Null 상태인 객체에 접근할 때 발생하는 NullPointerException 같은 것을 말한다.
![image](https://user-images.githubusercontent.com/128464859/228804582-cbe8c6f8-293e-4200-9b9c-fc2d925fe249.png)

OtherException은 **무조건 예외 처리를 해줘야 한다.** 처리하지 않으면 컴파일 과정에서 컴파일 오류가 발생한다.

예외를 처리하는 방법은 크게 2가지가 있다.
![image](https://user-images.githubusercontent.com/128464859/228806114-3fe6e1c4-b522-4689-8a69-f7c7a53dff71.png)

첫번째 방법은 **try-catch-(finally), try-with-resources 등을 사용하여 예외가 발생 시 그 자리에서 처리해 주는 방법**이다.

```java
-----------  try-catch  ------------
try {
    //something
} catch (Exception 하위 클래스 e) { 
    //handle Exception
}

-----------  try-catch-finally  ------------
try {
    //something
} catch (Exception 하위 클래스 e) { 
    //handle Exception
} finally {
    //Exception 발생 유무에 상관 없이 무조건 동작
}

-----------  try-with-resources  ------------
try (Exception 처리가 필요한 객체 선언) {
	//something	
} catch (Exception 하위 클래스 e) {
    //handle Exception
}
```



두 번째 방법은 **자신이 처리하지 않고 throws를 통해 다른 메서드한테 예외 처리를 넘겨주는 방법**이다. 

예왹 발생할 수 있는 메서드 뒤에throw + 예외 종류를 붙여줌으로써 예외가 발생 시 자신을 호출한 상위 메서드로 예외를 넘겨준다. 

'''java
public void doSomething() throws Exception { 
	//something
}
```
이러한 예외 처리 동작은 **호출 스텍(Call Stack)**을 통해 수행된다. 기본적으로 메서드를 호출하면 메서드들은 호출 스택에 쌓이게 된다. 따라서 마지막으로 호출한 메서드에서부터 역순으로 올라가면서 예외 처리를 구현한 메서드를 찾아가는 것이다.


예를 들어 main() → sub1() → sub2() → doSomething() 순서로 메서드를 호출한다.

doSomething(), sub1() 메서드에서는 throws를 통해 예외 처리를 상위 메서드로 넘겨주고 sub1() 메서드에서 try-catch 블록을 통해 예외를 처리해 주도록 구현하였다.

'''java
public static void main(String[] args) {
	sub1();
}
	
public static void sub1() {
	try {
		sub2();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
public static void sub2() throws Exception {
	doSomething();
}

public static void doSomething() throws Exception {
	throw new Exception();
}
```
doSomething() 메서드에서 예외가 발생 시 다음과 같이 동작한다

![image](https://user-images.githubusercontent.com/128464859/228810153-0f4f426e-3ea9-4202-98e3-885ced8a37ef.png)

![image](https://user-images.githubusercontent.com/128464859/228810206-3b8b5e70-c935-4ff9-b839-46bcebdc4fff.png)

만약, 호출 스택을 계속해서 탐색하면서 예외 처리를 구현한 메서드를 찾는 과정에서 해당 예외 처리를 구현한 메서드가 존재하지 않는다면 런타임 시스템이 그냥 프로그램을 종료시킨다.

throws를 통해 상위 메서드에게 예외 처리를 넘겨주는 방식은 try-catch 블록 등을 통해 예외를 직접 처리하는 것보다 코드가 간결해질 수 있으며 더 효율적일 수도 있다.

하지만 자신에게 발생한 예외를 다른 곳에서 처리하도록 책임을 넘기는 방식이기 때문에 **반드시 상위 메서드에서 책임을 지도록 구현해 줘야 한다.**


마지막으로 예외를 생성하는 방법이다. 예외를 처리하는 방식을 알았다면 예외를 생성해서 던져줘야 한다. 이는 **throw** 키워드를 사용하여 예외를 생성한다. throws가 아님을 주의해야 한다.

throw 문장은 하나의 인수만을 요구하는데 바로 **Throwable** 객체이다. 따라서 적합한 예외 객체를 생성하여 던져주면 된다.
````
throw new IOException() //입출력에 관한 예외 발생시
throw new NullPointerException() //Null 객체에 참조시
````

예외를 처리해 줌으로써 어떤 부분에서 예외가 발생했는지 개발자가 쉽게 알 수 있는 장점이 있다. 또한, 예외 처리 코드와 정상적인 코드를 분리함으로써 가독성도 높일 수 있게 된다.

하지만 예외를 검사하고 처리하는 비용이 적은 편은 아니다. 따라서 충분히 해결할 수 있는 부분이라면 Exception 처리보다는 return -1, 0, 1 방식처럼 return type 등 다른 간단한 방법을 이용하는 것이 좋다.
