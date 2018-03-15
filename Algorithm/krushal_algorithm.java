import java.util.*;
public class krushal_algorithm {
	static int mst[][]=new int[4][4];	static int src=0;static int dt=0;static boolean  flag=false;
		static int cc=0;static int ct=0;
		 static  boolean visited[] = new boolean[4];
	        
	         public static void set(int v,int i){
	        	 
	       if (cc==0&& v==src&&dt==i){
	    	   flag=true;
      		 cc++;
      	         }
            }	
	        	
	   static void isCyclicUtil(int v, boolean visited[])
	    {
	        for(int i=0;i<4;i++ ){
	        	 if (mst[v][i]!=0)
		            {
         
		 if ((visited[v] == true)&&(visited[i] == true)){
			
			 if(ct!=0)
			 {
				 set(v,i);
			 }
		        return;
		        }
	        	
		    isCyclicUtil(i, visited);
		                 
		    } 
	        }
	    }
	 
	    // Returns true if the graph contains a cycle, else false.
	 public static  void isCyclic()
	    {
	        for (int u = 0; u < 4; u++);           
	    }
		
public static void main(String arg[]){
	
int weight[]=new int[16];	int source[]=new int[16];int dest[]=new int[16];boolean vis[][]=new boolean[4][4];
int arr[][]= {{0,10,6,5},
		  {10,0,0,15},
		  {6,0,0,4},
		  {5,15,4,0}};

int count=0;int e_c=0;
for(int i=0;i<4;i++){
	for(int j=0;j<4;j++){
		if((arr[i][j]!=0)&&vis[j][i]==false){
			weight[count]=arr[i][j];
			source[count]=i;
			dest[count]=j;
			vis[i][j]=true;
			count++;
			e_c++;
		}	
	}
}

for(int k=0;k<e_c-1;k++)
{
	for(int h=0;h<e_c-k-1;h++){
		if(weight[h]>weight[h+1]){
			int temp=weight[h];
			weight[h]=weight[h+1];
			weight[h+1]=temp;
			
			temp=source[h];
			source[h]=source[h+1];;
			source[h+1]=temp;
			
			temp=dest[h];
			dest[h]=dest[h+1];
			dest[h+1]=temp;
		}
	}
}
	System.out.println("W    s   d");
	for(int i=0;i<e_c;i++){
	System.out.println(weight[i]+"    "+source[i]+"   "+dest[i]);
	}
	for(int i=0;i<4;i++){
	visited[i]=false;
	}

	for(int v=0;v<5;v++)
	{
		mst[source[v]][dest[v]]=weight[v];
		src=source[v];
		dt=dest[v];
		 System.out.println(src+" "+dt);
		isCyclic();
		ct++;
	 
		if(flag==true){
			System.out.println("discard"+" ");
			mst[source[v]][dest[v]]=0;	
	}else
	{
		System.out.println("inserted"+" ");
		}
		visited[source[v]]=true;
		visited[dest[v]]=true;
		System.out.println();
		cc=0;
		
		flag=false;
	}
	System.out.println();
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
		      if(mst[i][j]!=0){
		    	  mst[j][i]=mst[i][j];
		      }
			System.out.print(mst[i][j]+" ");
	
		}
		System.out.println();
	}
	
	}}

