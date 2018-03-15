import java.util.*;		//importing java library



public class TSP_GA {		//TSP_GA class for perform operation of tsp problem using GA

	//static variable and list declaration in the class
	static ArrayList<Integer> alist=new  ArrayList<Integer>();
	static ArrayList<Integer> inilist=new  ArrayList<Integer>();
	static ArrayList<Node> population =new ArrayList<Node>();
	static ArrayList<Node> newpopulation =new ArrayList<Node>();
	static int count=0;    //for initial population
	static int x_cord[]=new int[20];
	static int y_cord[]=new int[20];
	
	
	public static void ini_graph(){		//ini_graph method  for graph initialization
		 
		
		x_cord[0]=2;y_cord[0]=3; x_cord[1]=5;y_cord[1]=5;
		x_cord[2]=10;y_cord[2]=11;   x_cord[3]=10;y_cord[3]=2;
		x_cord[4]=21;y_cord[4]=22; x_cord[5]=3;y_cord[5]=6;
		x_cord[6]=63;y_cord[6]=10;  x_cord[7]=6;y_cord[7]=6;
		x_cord[8]=12;y_cord[8]=110; x_cord[9]=32;y_cord[9]=45;// declaring all x and y coardinate for city graph
		x_cord[10]=12;y_cord[10]=13; x_cord[11]=11;y_cord[11]=19;
		x_cord[12]=20;y_cord[12]=34;  x_cord[13]=34;y_cord[13]=45;
		x_cord[14]=111;y_cord[14]=120;  x_cord[15]=110;y_cord[15]=244;
		x_cord[16]=67;y_cord[16]=13;  x_cord[17]=99;y_cord[17]=77;
		x_cord[1]=123;y_cord[18]=145;  x_cord[19]=3;y_cord[19]=56;	
		
	}
	
	
	public static class Node{		// node class defined for containing city with fitness value
		ArrayList<Integer> city=new ArrayList<Integer>();
		int fit_value;
	}

	
	//define permutation function for generating permutation
	
	public  static void permute(int arr[], int l, int r)
    {
        if (l == r && count<50){		//storing all 50 permutation in population list
        	ArrayList<Integer> tlist=new ArrayList<Integer>();
        	int val=0;
        	for(int k=0;k<arr.length;k++){
        		val=arr[k];
        		tlist.add(val);
        	}
        	
        	int fit_val=find_fitness_value(arr); 		//calling fitness function
        	Node node=new Node();		//creating an instance of Node class
        	node.city=tlist;
        	node.fit_value=fit_val;
        	population.add(node);
        	
        }	
        
        else
        {
            for (int i = l; i <= r; i++)   //loop for iteration
            {
                arr = swap(arr,l,i);
                permute(arr, l+1, r);
                arr = swap(arr,l,i);
            }
        }
    }
	
	//define swap function
	
	public static int[] swap(int arr[],int l,int i){
		
		int temp[]=new int[20];
		for(int j=0;j<20;j++){
			temp[i]=arr[i];
		}
		int tval=0;
		tval=temp[l];
		temp[l]=temp[i];
		temp[i]=tval;
		
		return temp;
		
	}
	
	
	public static int find_fitness_value(int arr[]){		//define function for finding fitness values of array
		int total=0;
		
		for(int k=0;k<arr.length-1;k++){
			int i=arr[k];
			int j=arr[k+1];
			
			//calculating total fitness values using distance formula
			total=total+((x_cord[i]-x_cord[j])*(x_cord[i]-x_cord[j]))+(y_cord[i]-y_cord[j])*(y_cord[i]-y_cord[j]);
			
		}
	
		return total;
		
	}
	
	//defining method crossover 
	
	public static void cross_over(){
		int ar1[]=new int[20];
		int ar2[]=new int[20];
		int cp=0;

		for(int i=0;i<50;i++){
			int one =(int)Math.random()*50;
			int two =(int)Math.random()*50;
			//using pmx for performing crossover
			population.get(one);
			population.get(two);	//geting node object from population list for crossover
			
			
			
			for(int z=0;z<10;z++){			//first offering in pmx crossover
				
				int index =(int)Math.random()*20;
				int vc=population.get(one).city.get(index);
				for(int v=0;v<20;v++){
					if(vc==population.get(two).city.get(v));
					//perform swap operation
					int b=population.get(one).city.get(v);
					population.get(one).city.set(v, vc);
					population.get(one).city.set(index, b);
					
				}
			}
			
			for(int z=0;z<10;z++){   ///second offering for two list of geted geneation population
				
				int index =(int)Math.random()*20;
				int vc=population.get(two).city.get(index);
				for(int v=0;v<20;v++){
					if(vc==population.get(one).city.get(v));
					//perform swap operation
					int b=population.get(two).city.get(v);
					population.get(two).city.set(v, vc);
					population.get(two).city.set(index, b);
					
				}
			}
			
			
			mutation(population.get(one).city);		//calling ,mutation function for swapping values
			mutation(population.get(two).city);		//calling ,mutation function for swapping values
			
			
		}
	
	}
	
	//defining mutation function function here we swap a list of values in city list
	
	public static ArrayList<Integer>  mutation(ArrayList<Integer> al){
		
		int i =(int)Math.random()*20;
		int j =(int)Math.random()*20;
		//performing mutation in above population list
		int tval=al.get(i);
		int v= al.get(j);
		al.set(i, v);
		al.set(j, tval);
	
		
		return al;
	}
	
	//defining recursion function for calling many times same procedure
	
	public static void recursion(){
		int count=0;
		
		while(true){
			ini_graph();
			System.out.println("want to itearte press Y or N");
			{
				Scanner input=new Scanner(System.in);
			 String c=input.nextLine();
			 if(c=="y"){
				 continue;
			 }else{
				 break;
			 }
			 
			}
		}
		
	}
	
	
	public static void main(String arg[]){		//defining main function
			Scanner input =new Scanner(System.in);		//creating scanner class object for input
			int arr[]=new int[20];
			for(int i=0;i<20;i++){
				arr[i]=i+1;
			}
			
			//call permutation function 
			permute(arr,0,arr.length-1);
			
			for(int i=0;i<20;i++){		//printing new population
				System.out.println(population.get(i).city);
				System.out.println(population.get(i).fit_value);
			}
			
	}
}
