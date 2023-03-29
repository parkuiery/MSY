### 1. 예외란? (Error vs Exception)

오류는 시스템에 비정상적인 상황이 생겼을 때 발생한다. 이는 시스템 레벨에서 발생하기 때문에 심각한 수준의 오류이다. 따라서 개발자가 미리 예측하여 처리할 수 없기 때문에, 애플리케이션에서 오류에 대한 처리를 신경 쓰지 않아도 된다.

오류가 시스템 레벨에서 발생한다면,예외는 개발자가 구현한 로직에서 발생한다. 즉,예외는 발생할 상황을 미리 예측하여 처리할 수 있다. 즉,예외는 개발자가 처리할 수 있기 때문에 예외를 구분하고 그에 따른 처리 방법을 명확히 알고 적용하는 것이 중요하다.

### 2. 예외클래스
![image](https://user-images.githubusercontent.com/128464859/228566241-2d434ab4-0852-4f52-bb94-d91e6feb8b24.png)

-예외클래스의 구조
모든 예외클래스는 Throwable 클래스를 상속받고 있으면, Throwable은 최상위 클래스 Object의 자식 클래스이다.

Trowable을 상속받는 클래쓰는 Error아 Exception이 있다. Error는 시스템 레벨의 심각한 수준의 에러이기 때문에 시스템에 변화를 주어 문제를 처리해야 하는 경우가 일반적이다. 반면에 Exception은 개발자가 로직을 추가하여 처리할 수 있다.

Exception은 수많은 자식클래스를 가지고있다. 그 중 RuntimeException을 주목해야 한다. RuntimeException은 CheckdException과 UnchekedException을 구분하는 기준이다. Exception의 자식 클래스 중 RuntimeException을 제외한 모든 클래스는 CheckedException이며, RuntimeException과 자식 클래스들을 Uncheked Exception 이라 부른다. 

### 3. 





​Error와 Exception의 차이는 개발자가 프로그램 내에서 처리할 수 있는지에 대한 여부이다. Exception은 Error와 다르게 프로그램 내에서 처리해 줄 수 있다.

​즉, 예외가 발생하더라도 프로그램을 비정상 종료시키지 않는다.

​

​Exception은 RuntimeException과 OtherException으로 나뉜다. 이들을 구분하는 차이는 컴파일러가 예외 처리를 하는지에 대한 여부이다.

​RuntimeException은 Error와 함께 컴파일러가 예외를 체크하지 않는다. 이들을 비체크 예외(UnChecked Exceptions)라고 부른다.

​반대로 OtherException은 Error와 RuntimeException을 제외한 모든 예외를 의미하며 컴파일러가 예외를 체크해 준다. 이는 체크 예외(Checked Exception)라고 부른다.

![image](https://user-images.githubusercontent.com/128464859/228690971-68071c07-dbb5-4666-aa2a-2c8867113636.png)

 

RuntimeException은 주로 프로그래밍 버그나 논리 오류에서 기인한다. 예를 들어 Null 상태인 객체에 접근할 때 발생하는 NullPointerException 같은 것을 말한다.
