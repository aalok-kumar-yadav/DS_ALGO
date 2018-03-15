class cell2	{	//declare cell class 
	int i;
	int j;
	int val;
	cell2(int x,int y,int v){		//define constructor
		i=x;j=y;val=v;
	}
}


public class Sudoku_Problem_Final {
	//static declarations 
	
	public static int board2[][]={ {9,2,0,0,0,0,0,0,0},{8,6,7,5,0,0,0,0,0},{3,0,0,0,4,0,0,8,0},
			{0,3,0,0,0,7,0,0,4},{0,7,0,9,5,3,0,1,0},{2,0,0,6,0,0,0,7,0},
			{0,8,0,0,9,0,0,0,3},{0,0,0,0,0,5,8,4,6},{0,0,0,0,0,0,0,9,5}
	};
	
	
	public static int board1[][]={ {0,7,0,0,0,2,0,0,0},{0,0,8,0,0,0,3,0,0},{0,4,1,0,0,8,0,5,2},
			{0,8,0,0,7,0,9,0,0},{0,5,0,0,0,0,0,3,0},{0,0,7,0,1,0,0,4,0},
			{9,3,0,4,0,0,6,8,0},{0,0,2,0,0,0,4,0,0},{0,0,0,9,0,0,0,2,0}
	};
	
	public static int board[][]={ {0,0,2,6,0,4,0,9,3},{0,6,0,0,2,0,4,0,0},{5,0,4,0,0,7,0,0,0},
			{2,0,3,0,0,0,0,0,0},{0,0,8,0,0,0,6,0,0},{0,0,0,0,0,0,1,0,8},
			{0,0,0,3,0,0,7,0,5},{0,0,7,0,4,0,0,2,0},{8,2,0,9,0,6,3,0,0}
	};
	
	public static int board3[][]={ {0,3,0,0,0,0,6,5,0},{0,5,6,0,4,0,7,0,0},{4,2,0,0,0,0,3,8,0},
			{0,6,0,0,0,4,8,0,0},{0,0,9,0,2,0,0,7,0},{1,0,0,8,0,0,2,0,6},
			{0,0,5,7,0,0,0,0,1},{0,9,0,2,0,0,0,3,0},{0,0,7,0,5,6,0,2,0}
	};
	

	static boolean goal=false;
	static int back_track_count=0;
	
	//define function for placing right digit in vacant place
	public static void place_digit_cell(){
	
		//print_board_final();
		//System.out.println("-------------------");
		
		if(is_goal_state()==true){		//calling goal_test method
			goal=true;
			return;
		}else{
				
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					boolean ret_flag=false;
					if(board[i][j]==0)
					{
						for(int k=1;k<=9;k++){		
							boolean bool=is_valid_cell(i,j,k);		//call is_valid_cell function
							if(bool==true){
								ret_flag=true;
							}
							
							if(bool==true&&goal!=true){
								board[i][j]=k;
								place_digit_cell();		//call place_digit function
								if(goal!=true){
									board[i][j]=0;
								}	
							}
							if(goal==true){
								return;
							}	
						
					
				}
						//backtracking condition
						if(ret_flag==false||(ret_flag==true&&board[i][j]==0)){
							back_track_count++;
							return;
						}
				}
					
					
				}
				
			}
		}

	}
	
	
	
	//define function for checking that that digit is in matrix as well as visited_list or not
	public static boolean is_contain(int row,int col,int dig){
		
		boolean flag=false;
		int blc=find_block(row,col);
		
		blc--;
		int p=3*(blc/3);
		int q=3*(blc%3);
	
		for(int i=p;i<p+3;i++){
			for(int j=q;j<q+3;j++){
				if(board[i][j]==dig){
					flag=true;
					break;
				}
			}
			if(flag==true){
				break;
			}
		}
	return flag;
		
	}
	
	
	//define function for finding block of Sudoku with given row & column
	
	public static int find_block(int rw,int cl){
	boolean flag=false;
	int i=0;
	for( i=0;i<9;i++){
		
		int tr=3*(i/3);		//generating index of row & column
		int tcl=3*(i%3);
		
		for(int k=tr;k<tr+3;k++)
		for(int j=tcl;j<tcl+3;j++){
			if(k==rw&&j==cl){
				flag=true;
				
			}
		}
	
		if(flag==true){
			break;
		}
	}
	return i+1;
	}

	//define is_valid_cell for checking that cell is valid or not
	public static boolean is_valid_cell(int row,int col,int dig){		
		boolean flag=true;
		
		for(int i=0;i<9;i++){
			if(board[row][i]==dig  ){
				flag=false;
			}
		}
		
		for(int j=0;j<9;j++){
			if(board[j][col]==dig  ){
				flag=false;
			}
			
		}
		if(is_contain(row,col,dig)==true){
			flag=false;
		}
		
		return flag;
	}
	
	
//define function for checking all elements are filled or not in matrix of 9 element
	public static boolean is_goal_state(){
		int count=0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]!=0  ){
					count++;
				}
			}
		}
		
		if(count==81){
			return true;
		}else{
			
			return false;
		}
	}
	
	
	//define method printing board of 9X9 digit
	public static void print_board_final(){
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(board[i][j]+" ");	
				if((j+1)%3==0){
					System.out.print(" ");
				}
			}
		
			if((i+1)%3==0){
				System.out.println();
			}
			System.out.println();
			
		}
	}
	
	
	//define main method
	public static void main(String arg[]){
		
		System.out.println("Initial State Of Sudoku Is:-- ");
		System.out.println();
		print_board_final();		//call print_board function	
	
		place_digit_cell();		//call place_digit function
		
	System.out.println("Final State Of Sudoku Is:-- ");
	System.out.println();
		print_board_final();		//call print_board function
		System.out.println("No. Of Backtracking is: "+back_track_count);
	}
}
