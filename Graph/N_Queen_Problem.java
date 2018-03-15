import java.util.*;

class cell {		//declare cell class contains row & column
	int i;int j;
	cell(int x,int y){
		i=x;j=y;	
	}
}

public class N_Queen_Problem{	
	static int num_queen=0;static boolean goal=false;			//static declaration
	static ArrayList<cell> visited_list=new ArrayList<cell>();
	
	public static void place_queen(cell current_cell){			//define place queen method for placing queen
		visited_list.add(current_cell);
		
		if(visited_list.size()==num_queen){
			goal=true;
			System.out.println("Result Is Displayed: ");
			System.out.println();
		for(int i=0;i<num_queen;i++){
				for(int j=0;j<num_queen;j++){			//loop for printing board with Queen  
					if(visited_list.get(i).i==i&&visited_list.get(i).j==j){
						i++;
						System.out.print("Q"+i+"   ");
						i--;
					}else{
					System.out.print("--   ");
					}
				}
				System.out.println();System.out.println();	
		}

			return;
		}else{
			for(int i=0;i<num_queen;i++){		//loop for all next cell corresponding to current_cell
				cell cell_obj=new cell(current_cell.i+1,i);
				boolean bool=is_valid_cell(cell_obj);		//call is_valid_cell function
				if(bool==true&&goal!=true){
					place_queen(cell_obj);
				}
			}
		}
		unvisit_cell(current_cell);			//call unvisit_cell function
	}
	
	
	public static void unvisit_cell(cell cr_cell){			//method for  unvisiting curent_cell
		for(int i=0;i<visited_list.size();i++){
			if(visited_list.get(i).i==cr_cell.i&&visited_list.get(i).j==cr_cell.j){
				visited_list.remove(i);
			}
		}
	}
	
	
	public static boolean  is_valid_cell(cell cr_cell){			//method for checking current cell is valid or not
		boolean flag=true;
		for(int k=0;k<visited_list.size();k++){
			if(visited_list.get(k).j==cr_cell.j ||
					(Math.abs(visited_list.get(k).i-cr_cell.i)==Math.abs(visited_list.get(k).j-cr_cell.j))){
				flag=false;
			}	
		}
		return flag;
	}
	
	
	public static void main(String arg[]){			//define main method 
		Scanner input=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter number of Queen: ");
			num_queen=input.nextInt();
			if(num_queen<=3){
				System.out.println("Solution Doesn't Exist!!!!");
			}else{
				for(int i=0;i<num_queen;i++){
					cell obj= new cell(0,i);
					place_queen(obj);		//call place_queen function
				}	
			}
			visited_list.clear();
			goal=false;
		}
	}
}
