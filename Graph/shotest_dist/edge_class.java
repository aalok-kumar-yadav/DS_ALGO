package graph_package;

public class edge_class {
	//method for possible edge b/w node or not
	
	public boolean pos_edge(int arr[][],int a,int b)
	{
		if(arr[a][b]!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}
