import java.util.*;

//structure class
 class Node{
	Node left,right;
	int data;
	public  Node(int value){
		left=null;
		right=null;
		data=value;
		
	}
}
//Methods class
  class methods{
	Node root;
	Node parent;
	public methods(){
		root=null;
		parent=null;
	}
	//display contains of menu
	public void display(){
		System.out.println();
		System.out.println("1. for insertion");
		System.out.println("2. traverse");
		System.out.println("3. deletation");
		System.out.println("Enter your Choice");
		
	}
	
	//Inserting an element in binary search tree
	public void insert(int value){
		
		root=insertation(root,value);
	}
	
	
	public Node insertation(Node node,int d){
		if(node==null){
			 node=new Node(d);
			
			
		}
		else if(d<node.data){
			parent=node;
			node.left=insertation(node.left,d);;
		}
		else if(d>node.data){
			parent=node;
			node.right=insertation(node.right,d);
		}
		return node;
		
	}
	
//Searching of element in binary tree	
	int count=0;
public Node searchNode(Node k, int v){
	count++;
	if(k.data==v){
		System.out.println("value  found");
			 System.out.println("count data is "+count);
			 	 System.out.println("root data is "+parent.data);
		
	}
	else if(v<k.data){
		searchNode(k.left,v);
	}
	else if(v>k.data){
		searchNode(k.right,v);
	}
	return k;
}	
	
	//method for in orderSuccesor
	public Node inorderSuccesser(Node l,int w){
		
		while(l!=null)
		{
			
	
			l.left=inorderSuccesser(l.left,w);
		
		}
		return l;
	}
	
	
	
	
	
	
	
	
	
	//Deleting an element in a binary search tree
	
public void  deleteNode(int value){
	
	 deletation(root,value);
	 System.out.println("root data is "+root.data);
	
}

public Node deletation(Node r,int d){
	Node temp1=r;
	r=searchNode(r,d);
	//case first i mean this is leaf node
	if((r.left==null)&&(r.right==null)){
		if(d<parent.data){
			parent.left=null;
		}
		else{
			parent.right=null;
		}
	}
	//case second  first part i.e this is one child parent
	else if((r.left==null)&&(r.right!=null)){
		if(d<parent.data){
			parent.left=r.right;
		}
		else{
			parent.right=r.right;
		}
	}
	//case second`s second part i.e this is one child parent
	else if((r.left!=null)&&(r.right==null)){
		if(d<parent.data){
			parent.left=r.left;
		}
		else{
			parent.right=r.left;
		}
	}
	//case third a node have two children
	else if((r.left!=null)&&(r.right!=null)){
		
		Node n=inorderSuccesser(r.right,d);
		Node temp=r;
		r=n;
		n=r;
		n=null;
		
	}
	
		return temp1;
	
}
		
		
	//Printing tree element in three various order
		public void traverse(){
			System.out.println();
			System.out.print("  Inorder list---->");
			inOrder(root);
			System.out.println();
			System.out.print("  preorder list---->");
			preOrder(root);
			System.out.println();
			System.out.print("  Postorder list---->");
			postOrder(root);
			
			
		}
		
		
		
		
		
		//Inorder format printing of binary search tree
public void inOrder(Node r){
		 
		if(r!=null){
			inOrder(r.left);
			System.out.print(r.data+" ");
			
			inOrder(r.right);
			
			
		
		}
		
}
//pre order format of printing of binary search tree
public void preOrder(Node r){
		 
		if(r!=null){
			
			System.out.print(r.data+" ");
			preOrder(r.left);
			preOrder(r.right);
			
	
		
		}
				
}
//post order format of printing of binary search tree
public void postOrder(Node r){
		
		if(r!=null){
			postOrder(r.left);
			
			postOrder(r.right);
			System.out.print(r.data+" ");
			
			
		
		}
		
}
		
		
		
	}
	
	

//Main class and main methods to drive those all
public class binaryTree{
	public  static void main(String arg[]){
		methods object=new methods();
				Scanner input=new Scanner(System.in);
		
		object.display();
		
		int choice=input.nextInt();
		while(choice!=6){
			
		switch(choice){
		 case 1:
		 
		System.out.println("Enter your number too insert");
		int a=input.nextInt();
		
		object.insert(a);
		break;
		
		case 2:
		System.out.println("This is your Traverse list");
		
		object.traverse();
		
		break;
		
		case 3:
		System.out.println("Enter number you want too delete ");
		int b=input.nextInt();
		object.deleteNode(b);
		
		break;
		
		default:
		System.out.println("Choice does not match please re enter");
		
	}
	object.display();
	choice=input.nextInt();
		}
}}