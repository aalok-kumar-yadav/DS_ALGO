package graph_package;
import java.util.*;

public class driver_class {
	
	public static int cal_weight(String st){
		int s=st.length();
		double cn=s-4;
		double sum=0;
		for(int i=4;i<=s-1;i++)
		{
				double temp=(int)st.charAt(i)-48;	
				sum=sum+(temp*Math.pow(10, cn-1));
				cn--;
		}
		int al=(int)sum;
	return al;
	
	
	
	}
	
	//main method invoked
		public static void main(String arg[]){
			graph_class object=new graph_class();
			Scanner input=new Scanner(System.in);
			
	
			int count=1;
			//loop for adding vertex
			while(count!=0)
			{
			
				System.out.println("Enter 'Y' for add vertex or 'N' for paths");
				char ch=input.next().charAt(0);
				if(ch=='y'||ch=='Y')
				{	
					input.nextLine();
				System.out.println("Enter two nodes and weight of ");
				String st=input.nextLine();
				char s=st.charAt(0);
				char d=st.charAt(2);
				
				int w=cal_weight(st);
				int i=(int)s-65; //converting char input to integer input
				int j=(int)d-65;
				object.add_vertex(i,j,w); //calling add edge method
				count++;
				}
				else
				{
					count=0;
				}
				
			} //while loop end braces
			object.norm_traversal();//calling traversal method
			input.nextLine();
			System.out.println("Enter first and second node for printing path");
		      String str=input.nextLine();
			char g=str.charAt(0);
			char h=str.charAt(2);
			
			System.out.println("");
			int g1=(int)g-65;
			int h1=(int)h-65;
			object.all_possible_path(g1, h1); //method call of printing all path
			if(object.path_count==0){
				System.err.println("No path available");
				
			}else
			{
				
				object.print_sort_path();
			}
			
			 //calling method of shortest path bw point
			
		}//main method end here
} //driver class end here
