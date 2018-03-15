public class bfs{
	         static int arr[][]=new int[4][4];
	public static  void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
 
        // Recur for all the vertices adjacent to this vertex
        
        for(int i=0;i<4;i++){
        	if (!visited[i]){
        		visited[i] = true;
        		 System.out.print(i+" ");
        	}
        }
        for(int j=0;j<4;j++){
        if (arr[v][j]!=0){
        	 DFSUtil(arr[v][j], visited);
        }
        }
       
        
        }
      
    
    // The function to do DFS traversal. It uses recursive DFSUtil()
   public static  void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[4];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

public static void main(String arg[]){
int arr[][]= {{0,10,6,5},
		  {10,0,0,15},
		  {6,0,0,4},
		  {5,15,4,0}};

   DFS(0);

}

}
