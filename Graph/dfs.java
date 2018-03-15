public class dfs{
	         
	public static  void DFSUtil(int v,boolean visited[])
    {
      
        visited[v] = true;
        System.out.print(v+" ");
 
        for(int i=0;i<4;i++){
        	if (!visited[i])
                DFSUtil(i, visited);
        }
        }
      
 
   public static  void DFS(int v)
    {
        boolean visited[] = new boolean[4];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

public static void main(String arg[]){
int arr[][]= {{0,10,6,5},
		  {10,0,0,15},
		  {6,0,0,4},
		  {5,15,4,0}};

   DFS(2);

}

}
