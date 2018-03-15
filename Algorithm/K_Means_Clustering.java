import java.util.*;

//creating point class
class Point{
	double x;
	double y;
	
	Point(double a,double b){			//define point class constructor
		this.x=a;
		this.y=b;
	}
}

public class K_Means_Clustering {		
	//static variable and list declaration
	static ArrayList<Point> Vector_List =new ArrayList<Point>();
	static ArrayList<ArrayList<Point>> current_class_info=new ArrayList<ArrayList<Point>>();
	static ArrayList<ArrayList<Point>> previous_class_info=new ArrayList<ArrayList<Point>>();
	static ArrayList<Point> mean_list=new ArrayList<Point>();
	static int K=0;
	
	static double pi[]= {0.4, 0.3 ,0.2 ,0.1};
	static int mean[][]= {{0,0},{4,4},{0,3},{4,0}};
	static  ArrayList<double[][]>covariance=  new ArrayList<double[][]>();
	static double c1[][]={{1,0.7},{0.7,1}};
	static double c2[][]={{1,0.25},{0.25,0.5}};
	static double c3[][]={{0.5,0.1},{0.1,1}};
	static double c4[][]={{0.25,0},{0,0.35}};

	public static void ini() {			//define ini function for initialization
		covariance.add(c1);covariance.add(c2);
		covariance.add(c3);covariance.add(c4);
	}
	
	
	public static void generate_data_point() {		//function for generating 100 random vector
		Random obj_ran=new Random();
		
		for(int i=0;i<4;i++) {
			double sdev_x=Math.sqrt(covariance.get(i)[0][0]);
			double sdev_y=Math.sqrt(covariance.get(i)[1][1]);
			
			
		for(int j=0;j<25;j++) {
			double val_x=obj_ran.nextGaussian()*sdev_x+mean[i][0];
			double val_y=obj_ran.nextGaussian()*sdev_y+mean[i][1];
		    val_x = (double) Math.round(val_x * 100) / 100;
		    val_y = (double) Math.round(val_y * 100) / 100;
			Point obj=new Point(val_x,val_y);		
				
			Vector_List.add(obj);		//adding those points into Vector_List	
			}
		}
	}
	
	
	public static void print_point() {			//function for printing data points
		for(int i=0;i<Vector_List.size();i++) {
		
				System.out.print("("+Vector_List.get(i).x+" ");
				System.out.print(Vector_List.get(i).y+",)");
		}
	}
	
	
	public static void k_means_algorithm() {		//define k_means function 
		
		while(true) {
				calculate_mean();
				create_table();	
				boolean bool=class_match();
				
				if(bool==true) {		//checking goal state is found or not
					System.out.println("Goal State is Found: ");
					print_cluster();
					break;
				}else {
					copy_class();		//copy function called
					current_class_info.clear();
					mean_list.clear();
					for(int j=0;j<K;j++) {
						ArrayList<Point> temp=new ArrayList<Point> ();
						current_class_info.add(temp);		//add list into current_class_info
					}
					
				}
		
		}
		
	}
	
	
	public static void calculate_mean() {			//function for calculating mean 
		
		for(int i=0;i<previous_class_info.size();i++) {
			find_mean(previous_class_info.get(i));
		}
		
	}
	
	public static void find_mean(ArrayList<Point> input) {		//function for calculating individual mean
		
		double temp_x=0;double temp_y=0;
		for(int i=0;i<input.size();i++ ) {
			temp_x=temp_x+input.get(i).x;
			temp_y=temp_y+input.get(i).y;
			
			
		}	
		temp_x=temp_x/input.size();temp_y=temp_y/input.size();
		temp_x = (double) Math.round(temp_x * 100) / 100;		//rounding floating values to 2 decimal place
		temp_y = (double) Math.round(temp_y * 100) / 100;
	
		Point obj=new Point(temp_x,temp_y);
		mean_list.add(obj);
	}
	
	
	
	public static void create_table() {			//function for creating table and assiging distance
		double arr[][]=new double[100][K];
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<K;j++) {
				double dist=cal_dist(Vector_List.get(i),mean_list.get(j));
				arr[i][j]=dist;
			}
		}
		 derive_class_info(arr);
	}
		
	
	//function for deriving class information from newly created table
		static void derive_class_info(double arr[][])
		{	
			
			for(int i=0;i<100;i++) {
				double db=Double.MAX_VALUE;
				int index=0;
				for(int j=0;j<K;j++) {
					if(arr[i][j]<db) {
						db=arr[i][j];
						index=j;
					}
				}
				current_class_info.get(index).add(Vector_List.get(i));
			}
		}
	
		
		//function for copying one class to another class
	public static void copy_class() {
		previous_class_info.clear();
		for(int i=0;i<current_class_info.size();i++) {
			ArrayList<Point> tp=new ArrayList<Point>();
			for(int j=0;j<current_class_info.get(i).size();j++) {
				
				Point pt=new  Point(current_class_info.get(i).get(j).x,current_class_info.get(i).get(j).y);
				tp.add(pt);
			}
			previous_class_info.add(tp);
		}
	}


	//function for calculating distance between point and mean
	public static double cal_dist(Point p,Point m)
	{
		double ret_val;
		ret_val=Math.pow(p.x-m.x, 2)+Math.pow(p.y-m.y, 2);
		ret_val = (double) Math.round(ret_val * 100) / 100;
		return ret_val;
				
	}
	
	
	//function for checking previous class and current class is same or not
	public static boolean class_match() {
		boolean flag=true;
			for(int i=0;i<previous_class_info.size();i++) {
					for(int j=0;j<previous_class_info.get(i).size();j++) {
						if(current_class_info.get(i).get(j).x==previous_class_info.get(i).get(j).x&&
								current_class_info.get(i).get(j).y==previous_class_info.get(i).get(j).y	)
						{
							continue;
						}else {
							flag=false;
							break;
						}
					}
				}
		return flag;
	}
	
	
	//function for printing current cluster 
	public static void print_cluster() {
		
		for(int i=0;i<current_class_info.size();i++) {
			
			if(current_class_info.get(i).size()!=0) {
				
				System.out.print("[ ");
				for(int j=0;j<current_class_info.get(i).size();j++) {
					System.out.print("("+current_class_info.get(i).get(j).x+", "+current_class_info.get(i).get(j).y+")");
				}
				System.out.println(" ]");
			}
			
			}
		}
	
	
	//main function defined
	public static void main(String arg[]) {
	ini();
	generate_data_point();
	System.out.println("Generated Points Are: ");
	print_point();
	//print_point();
	System.out.println();
	Scanner input=new Scanner(System.in);
	System.out.println("Enter Value of K: ");
	K=input.nextInt();
	
	for(int j=0;j<K;j++) {			//object initialization
		ArrayList<Point> temp=new ArrayList<Point> ();
		current_class_info.add(temp);
		
	}
	
	for(int j=0;j<K;j++) {		//object initialization
		ArrayList<Point> obj=new ArrayList<Point> ();
		previous_class_info.add(obj);
	}
	
	int ind=100/K;
	for(int i=0;i<99;i++){
		previous_class_info.get(i/ind).add( Vector_List.get(i));
		
	}
	
	System.out.println("started: ");
	//k_means_algorithm();		//calling k_mean_algorithm function
	
	}
}
