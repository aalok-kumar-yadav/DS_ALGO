import java.util.*;

public class stack_using_queue {
	
	public static void fun(Queue q1,Queue q2,int f)
	{
		if(f==1){
			while(q1.size()!=1){
				q2.add((Integer)(q1.remove()));
			}	
		}
		else{
			while(q1.size()!=0){
				q2.add((Integer)(q1.remove()));
			}
		}
	}
	
	public static void remove(Queue q1,Queue q2){
		int d=q1.size();
		for(int l=1;l<=d;l++)
		{
			if(q1.size()!=0){
				fun(q1,q2,1);
				int g=(int)q1.remove();
				System.out.println(g);
				
			}else if(q2.size()!=0){
			
				fun(q2,q1,2);
				break;
			}
		}	
	}
	
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
		Queue<Integer> q1=new LinkedList();
		Queue<Integer> q2=new LinkedList();
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
			q1.add(el);
				break;
			case 2:
				System.out.println("output is ");
				remove(q1,q2);
				break;	
			case 3:
				System.out.println(q1);
				break;	
			case 4:
				System.out.println("you exit sucessfully");
				bool=false;
				break;	
			}
			}
		 }
}
