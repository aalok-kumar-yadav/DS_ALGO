import java.util.*;
public class karatsuba_algorithm {
	static int base=10;
	
	public static long find_m(long n1,long n2){
		int a=(int)n1;
		int b=(int)n2;
		String s1=Integer.toString(a, 10);
		String s2=Integer.toString(b, 10);
		if(s1.length()<=s2.length()){
			
			return (long)s1.length()-1;
		}else{
			return (long)s2.length()-1;
		}
	}
	
	public static long multiply(long num1,long num2){
		if((num1<10) ||(num2<10)){
			return num1*num2;
		}
		else{
			long m=find_m(num1,num2);
			long low1,low2,high1,high2;
			long temp=(int)Math.pow(base, m);
			low1=num1%temp;low2=num2%temp;
			high1=num1/temp;high2=num2/temp;
			long z2,z1,z0;
			z2=multiply(high1,high2);
			z0=multiply(low1,low2);
			z1=multiply((low1+high1),(low2+high2));
			
			return z2*(int)Math.pow(base,2*m)+(z1-z2-z0)*(int)Math.pow(10, m)+z0;
			
		}
		
	} 
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter first number to multiply");
		int num1=input.nextInt();
		System.out.println("Enter second number to multiply");
		int num2=input.nextInt();
		long a=10;
		long result=multiply((long)num1,(long)num2);
		System.out.println("result is= "+ result);
		
		
	}
}
