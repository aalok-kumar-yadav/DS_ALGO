import java.util.*;		//include java library
    
public class Eight_Puzzle_Problem {
	
	//declaring static variable and static list
	static int start_state[][]=new int[3][3];
	static int goal_state[][]=new int[3][3];
	static ArrayList<int[][]> visited_state_list=new ArrayList<int[][]>();
	static int index[][]=new int[4][2];
	static boolean found=false;
	
	
	//define initialize function for setting initial values
	public static void  initialize(){
		//start state declaration
		start_state[0][0]=2;start_state[0][1]=8;start_state[0][2]=3;
		start_state[1][0]=1;start_state[1][1]=6;start_state[1][2]=4;
		start_state[2][0]=7;start_state[2][1]=0;start_state[2][2]=5;
		
		//goal state declaration 
		goal_state[0][0]=1;goal_state[0][1]=2;goal_state[0][2]=3;
		goal_state[1][0]=8;goal_state[1][1]=0;goal_state[1][2]=4;
		goal_state[2][0]=7;goal_state[2][1]=6;goal_state[2][2]=5;
		
	}
	
	//define function perform move for take a move toward goal state
	public static void perform_move(int current_state[][]){
		int temp[][]=new int[3][3];
		for(int q=0;q<3;q++){
			for(int w=0;w<3;w++){
				temp[q][w]=current_state[q][w];
			}
		}
		
		visited_state_list.add(temp);		//add current node to visited list
	
		if(is_goal_state(current_state)==true){
			found=true;
			visited_state_list.add(current_state);
			return ;
		
		}else{
			//generate all possible state according to logic
			int row=0;int col=0;
			int finalrow=0;int finalcol=0;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(current_state[i][j]==0){
						row=i;col=j;
						break;
					}
				}
			}
		
			generate_index(row,col);
			int placed=4;
			for(int z=0;z<4;z++){
				if((index[z][0]>=0&&index[z][0]<=2)&&(index[z][1]>=0&&index[z][1]<=2)){
					int u=index[z][0];int v=index[z][1];
					//swap operation 
					current_state=swap_digit(row,col,u,v,current_state);
					int val=heuristic_function(current_state); 		//call heuristic function
					
					if(val>=placed && is_visited_state(current_state,"loop")==false){
						placed=val;
						finalrow=u;finalcol=v;	
					}
				
					current_state=swap_digit(u,v,row,col,current_state);	
				}
			}	
			
			current_state=swap_digit(finalrow,finalcol,row,col,current_state);
			if((found==false )&&(is_visited_state(current_state,"con")==false)){
				perform_move(current_state);
			}	
		}
	}

	// define is_visited_state function for checking current state is visited or not
	public static boolean is_visited_state(int current_state[][],String ty){
		boolean flag=false;
		int count=0;
		
		for(int i=0;i<visited_state_list.size();i++){
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					if(current_state[j][k]==visited_state_list.get(i)[j][k]){
						count++;
						
					}	
				}	
			}
			if(count==9){		//checking that all element are same with visited list
				flag=true;
				break;
				
			}
			count=0;	
		}	
		
		return flag;
	}
	

	//define heuristic function for finding heuristic value
	public static int heuristic_function(int current_state[][]){
		int val=0;
	
		for(int row1=0;row1<3;row1++){
			for(int col1=0;col1<3;col1++){
				//find element in goal state list
				if(current_state[row1][col1]==0){
					continue;
				}else{
					if(current_state[row1][col1]==goal_state[row1][col1]){
						val++;
					}
				}
				
				}	
			}
		
		return val;
	}
	
	//define swap_digit function for swapping two digit in current state
	public static int[][] swap_digit(int row1,int col1,int row2,int col2,int current_state[][]){
	
		int temp=current_state[row1][col1];
		current_state[row1][col1]=current_state[row2][col2];
		current_state[row2][col2]=temp;
		
	    return current_state;	
	}
	
	
	//define method for generating 4 index i mean up,down,left and right
	public static void generate_index(int row,int col)
	{
		int trow=row;int tcol=col;
		index[0][0]=row;index[0][1]=tcol-1;
		index[1][0]=row;index[1][1]=tcol+1;
		index[2][0]=trow-1;index[2][1]=col;
		index[3][0]=trow+1;index[3][1]=col;
		
	}
		
	
	//define function for printing all state of visited list
	public static void print_path_state(){
		for(int i=0;i<visited_state_list.size();i++){
			
			for(int j=0;j<3;j++){
				System.out.print("   ");
				for(int k=0;k<3;k++){
					System.out.print(visited_state_list.get(i)[j][k] +"  ");
				}
				System.out.println();
			}
			if(i!=visited_state_list.size()-1){
				System.out.println("Next state is:--> ");
			}
		}			
	}
	
	
	//define is_goal_state function for checking goal state or not
	public static boolean is_goal_state(int current_state[][]){
		int count=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(current_state[i][j]==goal_state[i][j]){
					count++;
				}
				} }
			
		if(count==9){
			return true;
		}else{
			return false;
		}	
	}
	
	
	//define main method
	public static void main(String arg[]){
		initialize();		//calling initialize function
	
		perform_move(start_state);		//call perform move function for take a move toward goal state
		if(found==true){
			System.out.println("Goal state is found: ");
			System.out.println();
		}
		
		print_path_state();
		
	}
}
