### null에  대해
* null이란 아무것도 없음을 의마합니다.(0또는 공백:"")
* 모드 참조유형에 대한 기본 값은 null입니다.
* null은 유효한 객체 인스턴스가 아니므로 할당 되는 메모리가 없습니다.

### 예외가 발생하는 경우
* null 객체에서 method를 호출하는 경우
* null 객체의 필드에 접근하거나 값을 변경하는 경우
* null의 길이를 배열처럼 취하는 경우
* null을 throw하는 경우
* null을 통해 동기화 할 경우

### 그럼에도 null값이 필요한 이유?
* null은 자바에서 사용되는 특수값. 주로 참조 변수의 값이 할당되지 않았음을 나타내는데 사용
* Null Obiect 패턴(로그 시스템)및 Singleton 패턴에 사용함
* 연결된 목록 및 트리와 같은 데이터 구조를 구현하는데 사용됨

### NullpointException을 피하는 방법
1. 문자열 비교: String 변수와 리티럴문자를 비교할 때 다음과 같은 오류가 발생할 수 있음
````
String ptr = null;

if (ptr.equal("abc") // NullPointerException 발생!

{

System.out.println("SAME!");

}

else

{

System.out.println("NOT SAME!");

}
````
다음과 같이 null객체 대신 리터럴문자에서 equal 메소드를 호출함으로써 해결할수 있다.
````
String ptr = null;

if ("abc".equals(ptr))

{

System.out.println("SAME!");

}

else

{

System.out.println("NOT SAME!"); // "NOT SAME" 출력

}
````
2.tty-catch문 사용: 다음과 같이 예외처리문을 사용가능합니다.
````
public static void main(String[] arg) {

String s = null; 

try

{ 

System.out.println(getLength(s)); 

} 

catch(IllegalArgumentException e) 

{ 

System.out.println("IllegalArgumentException caught"); // 예외처리 발생!!

} 

}

public static int getLength(String s) 

{ 

if (s == null) 

{

throw new IllegalArgumentException("The argument cannot be null");

}

return s.length(); 

} 

}
````
3.삼항 연산자 사용: null값은 ==또는 !=의 연산자가 적용한다.
````
public class Main {

	public static void main(String[] arg) {

		String s = null; 

		System.out.println(s.length()); // NullPointerException 발생!!

        } 

}
````
수정
````
public class Main {

	public static void main(String[] arg) {

		String s = null; 

		System.out.println((s == null) ? "0" : s.length()); // "0" 출력

        } 

}
````
