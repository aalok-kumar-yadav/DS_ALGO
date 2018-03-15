//Linked list
import java.util.*;

class Node {
	int data;
	Node next;
	public Node(int value){
		next=null;
		data=value;
	}
}


class method{
	
	Node first;

	Node A;
	public method(){
		first=null;
		A=null;
	}
	
	
public void display(){
	System.out.println("1. for insert at first");
	System.out.println("2. for insert at last");
	System.out.println("3. for insert at any position");
	System.out.println("4. for delete first");
		System.out.println("5. for delete last");
		System.out.println("6. for delete at any position");
	    System.out.println("7. for traversing a list");
		System.out.println(" 8.printing reverse list");
		
		System.out.println(" 9.for removing dublicate element");
		System.out.println(" 10. for swap two Nodes");
}	
	
public void insertAtFirst(int d){
		 A=new Node(d);
		if(first==null){
			
		
		first=A;
		}
		else
			A.next=first;
		first=A;
		
	}
	
public void insertAtLast(int d){
	A=new Node(d);
		if(first==null){
			first=A;
			
		}else{
			Node r=first;
			while(r.next!=null){
				r=r.next;
			}
			r.next=A;
			r=r.next;
		}
		}
		
public void insertAtAnyPosition(int i,int value){
	int j=1;
	
	 A=new Node(value);
	 Node prv=null;
	if(first==null){
		System.out.println("list is empty");
	
	}
	else{
	
	Node r=first;
	while((r!=null)&&(j<i)){
		prv=r;
		r=r.next;
		prv.next=r;
		j++;
	}
	prv.next=A;
	A.next=r;
		}	
	
	
	}

public void deleteFirst(){
	Node temp=null;
	temp=first;
	first=first.next;
	temp=null;
}

public void deleteLast(){
	Node r=first;
	while(r.next.next!=null){
		r=r.next;
	}
	
	r.next=null;
}

public void deleteAtPosition(int p){
	Node r=first;
	int z=1;
	Node prv=null;
	while((r.next!=null)&&(z<p)){
		prv=r;
		r=r.next;
		prv.next=r;
		z++;
	}
	
prv.next=r.next;


	
}
public void print_reverse(){
	reverse(first);
}


public Node reverse(Node node){
       if(node==null){
		   
	   }
		   else{
	   
	   reverse(node.next);
	   
	   System.out.println(node.data);
		   }
		   
   return node;
}

//removing dublicate element in linked list
public void remove_dublicate(){
	
	
	while(first.next!=null){
		int temp=first.data;
		
		function(first,temp);
		first=first.next;
	}
}
	//function of dublicate removel defined
	
	public  Node function(Node r,int f){
		Node nd=r.next;
		Node prv1=null;
		while((nd.next!=null)&&(f!=nd.data)){
			prv1=nd;
			nd=nd.next;
			prv1.next=nd;
		}
		prv1.next=nd.next;
		
		return r;
		
	}
	
public void swap_element(int i1){
	Node prv=null;
	Node r=first;
	int count=1;
	Node l=null;
	while(i1<6){
	
	while((r.next!=null)&&(count<i1)){
		prv=r;
		r=r.next;
		count++;
	}
	Node prv2=r;
	Node temp=r.next;
	
	prv.next=temp;
	if(temp.next!=null){
	
	 l= temp.next;
	}else{
		break;
	}
	temp.next=r;
	
	r.next=l;
	
	i1+=2;
	}
}
		
		

	
public void traverse(){
	Node r=first;
	
	while(r!=null){
		
		System.out.println(r.data);
		
	
		r=r.next;
		
	}
}	
	
}




public class linkedLab{
	public static void main(String arg[]){
		method object=new method();
		
		
				Scanner input=new Scanner(System.in);
		
		object.display();
		
		int choice=input.nextInt();
		while(choice!=15){
			
		switch(choice){
		 case 1:
		 
		System.out.println("Enter your number too insert at first ");
		int a=input.nextInt();
		
		object.insertAtFirst(a);
		break;
		
		case 2:
		System.out.println("Enter your number too insert at last");
		int n=input.nextInt();
		object.insertAtLast(n);
		break;
		
		case 4: 
		
		object.deleteFirst();
		break;
		
		case 5:
		object.deleteLast();
		break;
		
		case 6:
		System.out.println("enter your position to delete element");
		int i=input.nextInt();
		object.deleteAtPosition(i);
		break;
		case 7:
		System.out.println("This is your Traverse list");
		
		object.traverse();
		
		break;
		
		case 8:
		System.out.println("This is your reverse linked list");
		object.print_reverse();
		break;
		
		case 9:
		object.remove_dublicate();
		break;
		
		case 10:
		System.out.println("enter  first position you want to swap there");
		int z=input.nextInt();
		
		object.swap_element(z);
		break;
		case 3:
		System.out.println("enter number you want to insert");
		int b=input.nextInt();
		System.out.println("enter position you want to insert there");
			int p=input.nextInt();
		object.insertAtAnyPosition(p,b);
		
		break;
		
		default:
		System.out.println("Choice does not match please re enter");
		
	}
	object.display();
	choice=input.nextInt();
		}
}
}
	
