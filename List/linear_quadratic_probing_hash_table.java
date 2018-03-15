import java.util.*;
import java.io.*;

class node_class{ //creating a class for use to list of list
	static ArrayList<ArrayList<String>> al=new ArrayList<ArrayList<String>> ();
	static int cv=0;
	
	public static void set(int index,String val,String s){ // performing actual add operation in this class
		if(s.equals("first")==true)
		{
		ArrayList<String> temp=new ArrayList<String>(); //temporary list
		temp.add(val);
		
		al.set(index,temp); //set this value to a static list of list
		}else
		{
			int ind=find_index(index,val);
			if(ind==index){
				al.get(ind).add(val);
				cv=0;
			}
		   else{
			set(ind,val,"first");
			}
		}
		
	}
	
	public static  int find_index(double index,String val){
		//quadratic probing
		double i=1;
		double tp=index;
		int ret=0;
		boolean bool=true;
		
		while(cv<1200){
			  index=(tp+i*i)%1200;
			
				int in=Math.abs((int)index);
			
			if(al.get(in).size()==1&&al.get(in).get(0).equals("null")==true){
				
				ret=in;
			
				break;
			}else{
				i++;
				cv++;
			}
			
		}
		if(cv==1200){
			return (int)tp;
		}else{
			return ret;
		}
	
		
			
	}
	
public ArrayList<String> get_list(int k){ //method for getting list from anther class
	ArrayList<String> j =new ArrayList<String>();
	j=al.get(k);
	return j;
	}
}


public class linear_quadratic_probing_hash_table{ //class declaration
	
	static long arr_length=1200;
	static ArrayList<String> key_of =new ArrayList<String>(); //we storing key 
	static ArrayList<String> aky =new ArrayList<String>(); //temporary list for use
	static node_class type=new node_class();
	public static void fun(String key,String val){ // add method for adding element in table
		
		int index=hashCode(key);
		
        if(node_class.al.get(index).get(0).equals("null")==true) //calling search function return
        {
		key_of.set(index,key); //setting key in list
		type.set(index, val,"first"); //setting value in list of list first time
        }
        else{
        	type.set(index, val,"second"); //setting value in list of list second time
        }
	}
	
	
public static void retrive(){ //method for printing table
	
	for(int i=0;i<1200;i++){ //simple for loop
		int sz=node_class.al.get(i).size(); // size of list
		System.out.print(i+"  -->>>");
			for(int b=0;b<sz;b++){ //running a for loop 
				if(node_class.al.get(i).get(b).equals("null")==false){ //comparison of gated element with initially assign value
					System.out.print(node_class.al.get(i).get(b)+"  ");
				}	
			}
			System.out.println();	
	}
	System.out.println();
	}

public static void  remove(String key,String val){ //remove function to delete element from table
	
	
	int index=hashCode(key); //calling hashCode method for index
	int tm=index;
	int sz=node_class.al.get(index).size(); //calculating size of list
	if(sz>1){//for second time add in any index of table
		int bc=0;
		int dd=0;
		while(bc<sz){ //traversing  list to remove specific element  
			if(node_class.al.get(index).get(bc).equals(val)==true){ //comparing one string to another string
				dd=bc;
				break;
			}else{
				bc++;
			}
		}
	
			node_class.al.get(index).remove(dd);
			System.out.println("Remove sucessfully ");
	}	else{
		for(int i=1;i<1200;i++){		
			if(node_class.al.get(index).get(0).equals(val)==true){
			node_class.al.set(index, aky);
			key_of.set(index, "null");
			break;
			}else{
			index=(tm+i*i)%1200;
			}
		}
		
	}
}

public static boolean search(String key,String val){ //function for search operation in table

	int index=hashCode(key); //calling hashCode method for index
	int tm=index;
	int sz=node_class.al.get(index).size(); //calculating size of list
	boolean b=false;
	if(sz>1){//for second time add in any index of table
		int bc=0;
		int dd=-1;
		while(bc<sz){ //traversing  list to remove specific element  
			if(node_class.al.get(index).get(bc).equals(val)==true){ //comparing one string to another string
				dd=bc;
				break;
			}else{
				bc++;
			}
		}
			if(dd!=-1){
				b=true;
			}
			
	}	else{
		for(int i=1;i<1200;i++){		
			if(node_class.al.get(index).get(0).equals(val)==true){
			node_class.al.set(index, aky);
			key_of.set(index, "null");
			b=true;
			break;
			
			}else{
			index=(tm+i*i)%1200;
			}
		}
		
	}
	return b;

}


public static int hashCode(String st){ // hashCode method 
	
	long hash=0;
	 for(int k=0;k<st.length();k++){ 
		 hash=hash*31+(int)st.charAt(k); //logic for finding hash value
	 }
	 double db=hash%arr_length; //taking modulo with respect of a fixed number
		int index=Math.abs((int)db);
	 return index; //returning final index for a given key
}
	

	public static void main(String arg[])throws IOException{ //main method defined
		
		Scanner input=new Scanner(new File("C:/Users/Aalok Kumar/Desktop/words.dat"));//scanning value from from file
		Scanner in=new Scanner(System.in);
		boolean bool=true;
		aky.add("null");
		for(int i=0;i<1200;i++) //initializing arraylist with some string
		{
			key_of.add("null");
			node_class.al.add(aky);
			
		}
		
		while(bool==true){//while loop
			System.out.println("Enter 1 for add value in table ");
			System.out.println("Enter 2 for retrive all values in table ");
			System.out.println("Enter 3 for remove value in table ");
			System.out.println("Enter 4 for search value in table ");
			
			int b=in.nextInt();
			String key=null;String val=null;
			if(b!=2&&b!=1){ //for performing 3 and 4 operation only
			System.out.println("Enter key to operation ");
			in.nextLine();
			key=in.nextLine();
			System.out.println("Enter value for operation ");
			val=in.nextLine();
			}
			if(b==1){//
            int cp=0;
            while(cp<1200){//loop for adding all file string in table
            String temp= input.nextLine(); 
           
			fun(temp,temp);
		    cp++;
            }
            System.out.println("added sucessfully"); //confirmation of add operation
            continue;
			
			}else if(b==2)
			{
				retrive(); //calling this method for print table
			}else if (b==3){
	
			remove(key ,val);  //calling this method for remove table
			}
			else{
			
				boolean hb=search(key,val); //calling search method that return boolean type
				if(hb==true){
					System.out.println("value found");
				}else{
					System.out.println("value not found");
				}
			}	
		}
	}	
}
