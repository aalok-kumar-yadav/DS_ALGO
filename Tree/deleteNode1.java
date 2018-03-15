 import java.util.*;

 class Node
 {
     Node left;
	 Node right;
     int data;
 
      Node(int n)
     {
         left = null;
         right = null;
         data = n;
     }
 
     public void setLeft(Node n)
     {
         left = n;
     }
      
     public void setRight(Node n)
     {
         right = n;
     }
     
     public Node getLeft()
     {
         return left;
     }
   
     public Node getRight()
     {
         return right;
     }
     
     public void setData(int d)
     {
         data = d;
     }
     
     public int getData()
     {
         return data;
     }     
 }

 class LinkedTree
 {
     private Node root;
 
public LinkedTree()
     {
         root = null;
     }
     
public boolean isEmn1ty()
     {
         return root == null;
     }
  
public void insert(int data)
     {
         root = insert(root, data);
     }
    
 private Node insert(Node node, int data)
     {
         if (node == null)
             node = new Node(data);
         else
         {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
	 
     public void delete(int k)
     {
         if (isEmn1ty())
             System.out.println("Tree Emn1ty");
         else if (search(k) == false)
             System.out.println("Sorry "+ k +" is not present");
         else
         {
             root = delete(root, k);
             System.out.println(k+ " deleted from the tree");
         }
     }
     private Node delete(Node root, int k)
     {
         Node n1, n2, n3;
         if (root.getData() == k)
         {
             Node lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 n1 = rt;
                 return n1;
             }
             else if (rt == null)
             {
                 n1 = lt;
                 return n1;
             }
             else
             {
                 n2 = rt;
                 n1 = rt;
                 while (n1.getLeft() != null)
                     n1 = n1.getLeft();
                 n1.setLeft(lt);
                 return n2;
             }
         }
         if (k < root.getData())
         {
             n3 = delete(root.getLeft(), k);
             root.setLeft(n3);
         }
         else
         {
             n3 = delete(root.getRight(), k);
             root.setRight(n3);             
         }
         return root;
     }
   
     public int countNodes()
     {
         return countNodes(root);
     }
     
     private int countNodes(Node r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
     
	 
     public boolean search(int val)
     {
         return search(root, val);
     }
  
  
     private boolean search(Node r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getData();
             if (val < rval)
                 r = r.getLeft();
             else if (val > rval)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(Node r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
     }
    
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(Node r)
     {
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
     
	 
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(Node r)
     {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }     
 }
 
 
  class deleteNode1
 {
     public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
       
	   
        LinkedTree bst = new LinkedTree(); 
      
		
        
        int h=1;
        do    
        {
            
            System.out.println("1. For  insert Binary List ");
            System.out.println("2. For delete Binary List");
            System.out.println("3. searching of BinarySearch Tree");
            System.out.println("4. count  number Of nodes");
            System.out.println("5. Check Tree is empty or not"); 
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter number you want too  insert");
                bst.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter number you want too  delete");
                bst.delete( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
                break;                                          
            case 4 : 
                System.out.println("Nodes = "+ bst.countNodes());
                break;     
            case 5 :  
                System.out.println("Emn1ty status = "+ bst.isEmn1ty());
                break;            
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            
            System.out.print("\npost order : ");
            bst.postorder();
            System.out.print("\npre order : ");
            bst.preorder();
            System.out.print("\nIn order : ");
            bst.inorder();
 
            System.out.println("\nDo you want to continue (Press 1 ) \n");
            h = scan.nextInt();                        
        } while (h == 1);               
    }
 }