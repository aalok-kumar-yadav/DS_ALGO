package graph_package;

public class vertex_class {
	static int no_of_ver[]=new int[100];
	static int  max_node=0;
	static int ver_count=0;
	 //method for adding  edge Bw nodes
	public  int[][]  add_ve(int arr[][],int i,int j,int w){ 
		
		if(j>i){
			if(j>max_node)
			{
				max_node=j;
			}
		}
		else{
			if(i>max_node){
				max_node=i;
			}
		}
		
		if(ver_count==0){
			arr[i][j]=w;
			arr[j][i]=w;
			
			return arr;
		}else{
		int l=max_node;
		
		int temp[][]=new int[max_node][max_node];	
		for(int p=0;p<=l;p++){
			for(int q=0;q<l;q++){
				temp[p][q]=arr[p][q];
			}
		}
		temp[i][j]=w;
		temp[j][i]=w;
		return temp;	
	}
	}
}
