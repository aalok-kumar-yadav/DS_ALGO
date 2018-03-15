import java.util.*;

class Node{
	int data;
	Node  next;
	
	public void Node(int d){
		data=d;
	}
}

class Function{
	
	Node front;
	Node rear;
	public void Function(){
		front=null;
	    rear=null;
	}
	public void display(){
		System.out.println(" 1.insert  Opperation By LinkedList in 	Q");
		System.out.println(" 2. remove Opration By LinkedList IN Q");
		System.out.println(" 3. Getting Front Element Of Q");
		System.out.println(" 4. Getting Rear Elememnt Of Q");
		System.out.println(" 5. Traverse Of Q List");
		
		System.out.println(" Enter Your Choice");
	}
	
	
	
	public void putElement(int value){
		
		Node A=new Node();
		A.data=value;
		if(front==null){
			front=A;
		}
		else{
			
			Node r =front;
			while(r.next!=null){
				r=r.next;
			}
	       r.next=A;
		   	rear=A;
		}
		
	}
	
	public void removeElement(){
		
		Node Temp=front;
		front=front.next;
	}
	
	public void getFront(){
		System.out.println(front.data);
	}
	
	public void getRear(){
		System.out.println(rear.data);
	}
	
	public void Display(){
		Node r=front;
		if(r==null){
			System.out.println("List is Empty");
		}else{
			System.out.println("This is your List");
		while(r!=null){
			
			System.out.println(r.data);
			r=r.next;
		}
	}}
}

 public class queueOperation{
	public static void main(String args[]){
		Function object=new Function();
		Scanner input =new Scanner(System.in);
		object.display();
		
		int choice=input.nextInt();
		while(choice!=15){
	
		switch(choice){
			case 1:
			System.out.println("Enter number you want to insert in Queue Operation");
			int argument=input.nextInt();
			object.putElement(argument);
			break;
			
			case 2:
			object.removeElement();
			break;
			
			case 3:
			object.getFront();
			break;
			
			case 4:
			object.getRear();
			break;
			
			case 5:
			object.Display();
			break;
			
			default:
			System.out.println(" choice not found");
			System.out.println("Enter choice again");
			
		}
		object.display();

	choice=input.nextInt();
		}
	}}