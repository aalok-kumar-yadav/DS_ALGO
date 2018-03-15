import java.util.*;

 class link{
	int data;
	public link next;
	public link(int d){
		data=d;
		
 }}

 class linkedlist77{
 link first=null;
 
	public void display(){
		System.out.println("This is your list");
		System.out.println("enter your choice");
		System.out.println("1: for push");
		System.out.println("2: for pop");
		System.out.println("3: for picking last element");
		System.out.println("4: for cheking list is empty or not");
		System.out.println("5: traverse ");
	}
		link prv=null;
	public void pushList(int p){
		
		link A=new link(p);
	
		prv=first;
		first=A;
		first.next=prv;
		
	}
	
		public void popList(){
			
			link temp;
			temp=first;
			first=first.next;
			
		}
		
	public void pick(){
		link temp;
			temp=first;
		
			System.out.println(temp.data);
	}	
		
		public void isEmpty(int s){
			if(s==0){
				System.out.println("Stack is empty");
			}else
				System.out.println(" given stack size is  "+s);
		}
		
		public void traverse(){
			link r=first;
			while(r!=null){
			System.out.println(r.data);
		    r=r.next;
			}
		}
		
}
		
			
public class stackOperation{
          public static void main(String arg[]){

		  int count=0;
		  
		  
	linkedlist77 object =new linkedlist77();
	int choice;
	object.display();
	
	Scanner input=new Scanner(System.in);
	choice=input.nextInt();
	System.out.println("you entered : "+choice);
	
	while(choice!=6){
		switch(choice){
case 1:
System.out.println("enter a number for push operation");
			int v=input.nextInt();
			
	object.pushList(v);
	count++;
	break;

	case 2:
	System.out.println("this is your list after poping");
	object.popList();
	break;

case 5:
System.out.println(" this is your stack list ");
object.traverse();
break;

case 3:
System.out.println("this is  your pick element");
object.pick();
break;

case 4:
object.isEmpty(count);
break;

default:
System.out.println("invalid chice");
object.display();
		
		}
		System.out.println("please re enter your choice");
	choice=input.nextInt();
	System.out.println("you entered : "+choice);	
	}
}}