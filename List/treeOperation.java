// Binary search Tree of given Element to by using linked list
import java.util.*;

//Structure class
class Node{
	int data;
	Node left;
	Node right;
	
	public void Node(int dat){
		data=dat;
		
} }

//method invocation class
class binaryTreeFunction{
	Node root;
	public void TreeOperation(){
		root=null;
	}
	
	public Node insertNode(Node node,int value ){
		Node A=new Node();
		A.data=value;
		
		if(node==null){
			
			node=A;
			root=node;
			
		}
		
		else if((value<node.data)&&(node.left==null)){
	
			node.left=A;
		}
		else if((value>node.data)&&(node.right==null)){
			
		node.right=A;
	}else if(value<node.data){
		insertNode(node.left,value);
	}else{
		insertNode(node.right,value);
	}
		
		return root;
	}
	
	
	
	public void inOrder(Node node) {
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}
	
}
//Main class and main methods
class treeOperation{
	public static void display(){
		System.out.println("1 For Inserting Eelement in A tree");
		System.out.println("2 For Print Inorder Listof Tree");
		System.out.println("Enter your choice");
	}
	
	
	public static void main(String arg[]){
		binaryTreeFunction object=new binaryTreeFunction();
		Scanner input =new Scanner(System.in);
		Node root=null;
		
		display();
		int choice=input.nextInt();
		while(choice!=6){
			switch(choice){
				case 1:
				
				System.out.println("Enter your number too insert in tree");
				int argument=input.nextInt();
				object.insertNode( root,argument);
				
				break;
				
				case 2:
				System.out.println("This is YOUR INORDER Tree");
				object.inOrder(root);
				break;
				
				default:
				System.out.println("No matching case  found re enter your chice ");
			}
			display();
				 choice=input.nextInt();
		}
		
	
	}
		
}