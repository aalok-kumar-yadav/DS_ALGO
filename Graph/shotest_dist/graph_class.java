package graph_package;
import java.util.*;
public class graph_class {
	
	//initialization  of static array and data
			static int s_arr[][]=new int[100][100];
			static int sort_path[]=new int[100];
			static int so_len=0;
			static int count=1;
			static int sum_so_path ;
			static int path_count=0;
			static int vertex_n=0;
			
	
			edge_class ec=new edge_class();
			//method for add vertex
			public void add_vertex(int i,int j,int w)
			{
				vertex_class obj=new vertex_class();
				s_arr=obj.add_ve(s_arr, i, j, w);
			vertex_n=obj.max_node;
				
			}
			
			
			//method for comparison of shortest path
			public  int com_sort_path(int[] arr,int len)
			{ 
				//calculate sum of current sort_path array
				int sum_arr=0;
				int cou=0;
				int temp1=0;
				
				while(cou<len-1){ //summing of arr array edges
					int j=arr[temp1];
					int k=arr[temp1+1];
					sum_arr=sum_arr+s_arr[j][k];
					temp1++;
					cou++;
					
				}
			
				if(count==1){ //for first time initializing
					
					for(int h=0;h<len;h++)
					{
						sort_path[h]=arr[h];
						
					}
					
					sum_so_path=sum_arr;
					so_len=len;
					count++;
					
				}else{
		
				//comparing  shortest path sum and current path sum
				if(sum_so_path<sum_arr){
					
					
				}
				else{
			
					for(int h=0;h<len;h++)
					{
						sort_path[h]=arr[h];
						
					}
					
					
					sum_so_path=sum_arr;
					so_len=len;
				}
				
				}	
			return sum_arr;		
			}
			
			//method defined for printing shortest path
			public void print_sort_path()
			{
				System.out.println("Shortest path is -->>");
				for(int i=0;i<so_len;i++)
				{
					System.out.printf("%c",sort_path[i]+65);
					if(i!=so_len-1)
					    {
						int i1=sort_path[i];
						int i2=sort_path[i+1];
						System.out.printf("-"+s_arr[i1][i2]+"-");
						}
					
				}
				System.out.println("|"+sum_so_path);
				
				
			}
			
			//method for normal graph printing by 2-d matrix
			public   void norm_traversal()
			{
				//for loop for label
				System.out.print(" ");
				for(int f=0;f<=vertex_n;f++)
				{
					System.out.printf(" %c",f+65);
				}
				System.out.println("");
				
				for(int i=0;i<=vertex_n;i++)
				{
					System.out.printf("%c ",i+65);
					
					for(int j=0;j<=vertex_n;j++)
					{ 
					   System.out.print(s_arr[i][j]+" ");
					}
					System.out.println();
				}
			}
			
			//method for all possible path using recurson
			public    void all_possible_path_foo(int a,int b,int ver, boolean
					vis_arr[],int path[],int path_i )
			{
				
				vis_arr[a]=true; //make node as visited
				path[path_i]=a; //store that node in path array
				path_i++; //increment path index
		
				if(a==b){ //comparing current incoming source is equal to destination or not
					path_count++;
					if(path_count==1){
						System.out.println("all possible path are-->>");
					}
					path_count++;
					int sum=com_sort_path(path,path_i);
					for(int j=0;j<path_i;j++)
					{ //for loop for printing current path
			   
							System.out.printf("%c",path[j]+65);
							
							if(j!=path_i-1)
							{
							   int i1=path[j];
							   int i2=path[j+1];
							   System.out.printf("-"+s_arr[i1][i2]+"-");
							}
				    }
					System.out.println("|"+sum); //print sum of edges
					
					}
				else{
					//for loop for all possible edge connected
					for(int i=0;i<=vertex_n;i++)
					{
						if(ec.pos_edge(s_arr, a, i)&&(vis_arr[i]!=true))// edges is possible or not and not visited condition
						{ 
							all_possible_path_foo(i,b,ver,vis_arr,path,path_i); //recursive call for  next unvisited node
								
						}
					}	
				   }
				vis_arr[a]=false;
				path_i--;
				
			}
			
			public   void all_possible_path(int s,int d){
			
				
				boolean vis_arr[]=new boolean[vertex_n+1]; //initialization of visited array
				int path[]=new int[vertex_n+1];  //initialization of  path array
				
				for(int i=0;i<=vertex_n;i++)
				{
					vis_arr[i]=false; //assigning of  false and null initially
					path[i]=0;
				}
				
				all_possible_path_foo(s,d,vertex_n,vis_arr,path,0);//function call for printing all path
				System.out.println();
			}
			
		
}
