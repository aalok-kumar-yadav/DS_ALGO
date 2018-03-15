import java.util.*;
public class rat_in_maze {
		static int arr[][]={{1, 0, 1, 1},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}};
	static int fin[][]=new int[4][4];
static ArrayList<Integer> al=new ArrayList<Integer>();
	

	public static void dfs(boolean visited[][],int i1,int j1,int i2,int j2){
		visited[i1][j1]=true;
	    fin[i1][j1]=1;
		if(i1==i2&&j1==j2){
		return;
		}
		
		System.out.println(i1+" "+j1);
	if((i1>=0&&i1<4)&&(j1+1>=0&&j1+1<4)){
      if(arr[i1][j1+1]!=0&&!visited[i1][j1+1]){
    	 
    	  dfs(visited,i1,j1+1,i2,j2);
		}
	}
	
	if((i1+1>=0&&i1+1<4)&&(j1<4&&j1>=0)){
	      if(arr[i1+1][j1]!=0&&!visited[i1+1][j1]){
	   
	    	  dfs(visited,i1+1,j1,i2,j2);
			}
		}
		
		
		
	visited[i1][j1]=false;
	
		
	}
	
	public static void rat(){
		
		boolean visited[][]=new boolean[4][4];
		dfs(visited,0,0,3,3);
	}
	
	
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
	
    
		 rat();
		System.out.println("final matrix is");
		System.out.println("source index is (0,0)");
		System.out.println("dest index is (3,3)");
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print(fin[i][j]+" ");
			}
			System.out.println();
		}
	}
}
