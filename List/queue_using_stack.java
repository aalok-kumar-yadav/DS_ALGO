import java.util.*;

public class queue_using_stack {
	
	public static void fun(Stack s1,Stack s2)
	{
		while(s1.size()!=0){
			s2.push((Integer)(s1.pop()));
		}
	}
	
	public static void remove(Stack s1,Stack s2){
		int d=s1.size();
		for(int l=1;l<=d;l++)
		{
			if(s1.size()!=0){
				fun(s1,s2);
				int g=(int)s2.pop();
				System.out.println(g);
				
			}else if(s2.size()!=0){
			
				fun(s2,s1);
				break;
			}
		}	
	}
	
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
		Stack<Integer>  s1= new Stack();
		Stack<Integer>  s2= new Stack();
		boolean bool =true;
	    
		while(bool==true)
		{
			System.out.println("enter 1 for add element");
			System.out.println("enter 2 for remove element");
			System.out.println("enter 3 for retrive all element");
			System.out.println("enter 4 for exit");
			int in=input.nextInt();
			
			switch(in){
			case 1:
				System.out.println("enter element ");
				int el=input.nextInt();
			s1.push(el);
				break;
			case 2:
				System.out.println("output is ");
				remove(s1,s2);
				break;	
			case 3:
				System.out.println(s1);
				break;	
			case 4:
				System.out.println("you exit sucessfully");
				bool=false;
				break;	
			}
			}
		 }
}
