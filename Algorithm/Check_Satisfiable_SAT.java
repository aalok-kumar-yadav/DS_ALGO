import java.util.*;		//importing library

public class Check_Satisfiable_SAT {		
	
	//static variable declaration like list and some boolean variable
	static ArrayList<ArrayList<Integer>> comb=new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> visited=new ArrayList<ArrayList<Integer>>();
	static boolean goal=false;
	static int m=0;
	
	//defining method for generating combination
	static void combinationUtil(int arr[], int data[], int start,
			int end, int index, int r)
{
if (index == r)
{
ArrayList<Integer> temp=new ArrayList<Integer>();		//declare temporary list

for (int j=0; j<r; j++){   //loop for adding element in list
temp.add(data[j]);	
}
comb.add(temp);
return;
}

for (int i=start; i<=end && end-i+1 >= r-index; i++)		//loop for calling again combinationUtil
{
		data[index] = arr[i];
		combinationUtil(arr, data, i+1, end, index+1, r);
}
}

	
	//  defining a function for best first search and hill climbing algorithm 
	public static void hill_best_search(int inp[][],int arr[],int state[],int data[],String type){
	
		if(Goal_Test(inp,state)==true){		//calling goal_test function and checking state is goal_state or not
			
			if(type=="hill"){		//this internal loop only execute when algorithm is hill climbing
				System.out.println("hillclimbing satisfiable state is: ");
				for(int nb=0;nb<arr.length;nb++){		//loop for printing variable of target state
					System.out.printf("%c ",arr[nb]+96);
				}
				System.out.println();
			}
			
			for(int nb=0;nb<state.length;nb++){		//loop for printing  target state
				System.out.print(state[nb]+" ");
			}
			
				goal=true;
			System.out.println();
		}
		else{		//else condition when incoming state is not goal state
			combinationUtil(arr, data,0,  arr.length-1, 0, 3);
			
			ArrayList<Integer> temp=new ArrayList<Integer>();		//declaring a temporary list and flag variables
			int min_index=Integer.MAX_VALUE;
			int min_val=Integer.MAX_VALUE;
			
			for(int i=0;i<comb.size();i++){		//iterating all combination of given list in this loop
				int change_st[]=change_state(comb.get(i),state);
				int temp_val=heuristic_value(inp,change_st);
				if(temp_val<min_val){		//sorting current heuristic value to previous value
					min_val=temp_val;
					min_index=i;
				}
				
				int state_n[]=change_state(comb.get(min_index),state);   //declaring changed state in an array
				remove_combination();		//function call for removing current combination to fill new combination
				if(type=="hill")
				{
					if(goal==false){		//checking a goal flag that is true or not
						hill_best_search(inp,arr,state_n,data,type);
					}
				}
				else{
					if(goal==false){		//checking a goal flag that is true or not
						hill_best_search(inp,arr,state_n,data,type);
					}
				}	
			}	
		}	
	}
	
	public static void remove_combination(){		//defining remove_combination function for removing combination
		for(int i=0;i<comb.size();i++){
			comb.remove(i);
		}
	}
	
	//define function for checking a state is goal_state or not
	public static boolean Goal_Test(int inp[][],int stt[]){  
		
		int vb=heuristic_value(inp,stt);
		if(vb==0){
			return true;
		}else{
			return false;
		}
	}
	
	/*define function for finding heuristic value of given state condition
	 * in this function we find how many clauses are F or false
	 */
	public static int heuristic_value(int inp[][],int st[]){
		int truth_count=0;
		
		for(int i=0;i<m;i++){		//nested loop for getting all variables truth values
			for(int j=0;j<3;j++){
			int bool=inp[i][j];
				String vcs="";
				if(bool>0){		//condition statement for checking val is negative or not
			    vcs="not_neg";
				}else{
				 vcs="neg";
				}
				
				boolean bl=find_truth(bool,st,vcs);		//calling find_truth function for getting truth value of var
				if(bl==true){
					
					truth_count++;
					break;
				}		
			}	
		}
		return m-truth_count;  //return count of false clauses
	}
	
	// defining find_truth function for finding truth value of variable
	public static boolean find_truth(int v,int st[],String vcs){
		boolean flg=false;
		
		if(vcs=="not_neg"){
			for(int k=0;k<st.length;k++){
				if(v-1==k){
					if(st[k]==1){
						flg=true;
					}
				}
				
			}
			
		}else{
			v=Math.abs(v);	
			for(int k=0;k<st.length;k++){		//loop for iterating all list of current state 
				if(v-1==k){
					if(st[k]==0){
						flg=true;
					}
				}
				
			}
			
		}
		return flg;		//returning truth flag of variable 
	}
	
	
	//defining change state function for changing state of current state based on combination
	public static int[] change_state(ArrayList<Integer> tp,int state[]){
		int temp_state[]=new int[state.length];
		for(int k=0;k<temp_state.length;k++){		//creating a temporary list and copy values into that
			temp_state[k]=state[k];
		}
		
		for(int i=0;i<tp.size();i++){		//nested loop
			int ch_index=tp.get(i)-1;
			for(int j=0;j<temp_state.length;j++){
				
				if(j==ch_index){
					if(temp_state[j]==0){
						temp_state[j]=1;
					}else{
						temp_state[j]=0;
					}
				}
			}
			
		}
		
		return temp_state;  //returning changed state
		
	}
	
	//defining main function
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the value of m: ");		//enter value of m from user
		 m=input.nextInt();
		
		System.out.println("Enter the value of n: ");		//enter value of n from user
		int n=input.nextInt();
		System.out.println("Enter the valid expression: ");
		input.nextLine();
		String str=input.nextLine();
		
		int arr[]=new int[n];
		int inp[][]=new int[m][3];		//declaring expression list
		
		for(int i=0;i<arr.length;i++){
			arr[i]=i+1;
		}
		int cp=0;  //temporary counter
		
		for(int a=0;a<m;a++){		//getting variable from user given expression
			for(int b=0;b<3;b++){
				if(str.charAt(cp)=='(' || str.charAt(cp)=='|' || str.charAt(cp)=='&' || str.charAt(cp)==')'){
					b--;
					cp++;
				}else if(str.charAt(cp)=='~'){   //condition for negation of variable 
					int temp=(int)str.charAt(cp+1)-96;
					inp[a][b]=-temp;
					cp+=2;
				}
				else{
					inp[a][b]=(int)str.charAt(cp)-96;
					cp+=1;
				}
			}
		}
		
		int state[]=new int[n];		//initializing initial state
		for(int d=0;d<n;d++){
			state[d]=0;
		}
		
		int data[]=new int[3];
		System.out.println();
		
		hill_best_search(inp,arr,state,data,"hill");		//calling function for hill climbing with flag
		if(goal==false){   //condition for when not any goal is found
			
			System.out.println("Not Satisfiable in hillclibimbing");
		}
		System.out.println();
		System.out.println("best first satisfiable states are: ");
		for(int nb=0;nb<arr.length;nb++){		//loop for printing variable of state
			System.out.printf("%c ",arr[nb]+96);
		}
		System.out.println();
		goal=false;
		hill_best_search(inp,arr,state,data,"best");	//calling function for hill climbing with flag
		
	}

}
