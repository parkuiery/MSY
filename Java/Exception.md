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
