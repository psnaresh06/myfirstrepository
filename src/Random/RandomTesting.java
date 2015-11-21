package Random;

public class RandomTesting {

	public static void main(String[] args) {
		int a=10;
		double b=20.2;
		System.out.println("the output of a is " +a);
		System.out.println("the output of b is " +b);
		double c=a;
		System.out.println("the output of c is " +c);
		int d=(int)b;
		System.out.println("the output of d is " +d);
		
		double x=Math.random()*100;
		System.out.println("the output of x is " +x);
		int y=(int)x;
		System.out.println("the output of y is " +y);
	}

}
