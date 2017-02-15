// Used to find order constructors are invoked
public class Test333 
{
	public static void main(String[] args){
		A a = new A(3);
	}
}

class A extends B 
{
	public int num = 0;
	public A(int t){
		System.out.println("A constructor");
		this.num = 1;
		super.num = 2;
		super.num1 = 3;

	}
}

class B extends C
{
	public int num = 0;
	public B(){
		System.out.println("B constructor");
	}
}

class C
{
	public int num1 = 0;
	public C(){
		System.out.println("C constructor");
	}
}