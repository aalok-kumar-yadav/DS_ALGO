import java.util.*;
import java.io.*;

class node{
	static ArrayList<ArrayList<String>> al=new ArrayList<ArrayList<String>> ();
	
	public void set(int index,String val,String s){
		if(s.equals("first")==true)
		{
		ArrayList<String> temp=new ArrayList<String>();
		temp.add(val);
		al.set(index,temp);
		}else
		{
			al.get(index).add(val);
		}
		
	}
	
public ArrayList<String> get_list(int k){
	ArrayList<String> j =new ArrayList<String>();
	j=al.get(k);
	return j;
	}
}


public class hash_dictionary{
	
	static long arr_length=1200;
	static ArrayList<String> key_of =new ArrayList<String>();
	static ArrayList<String> aky =new ArrayList<String>();
	
	public static void fun(String key,String val){
		node type=new node();
		long hash_code=hashCode(key);
		double tp_link= hash_code%arr_length;
		int index=(int)tp_link;
		
        if(search(key,val,1)==false)
        {
		key_of.set(index,key);
		type.set(index, val,"first");
        }
        else{
        	type.set(index, val,"second");
        }
	}
	
	
public static void retrive(){
	
	for(int i=0;i<1200;i++){
		int sz=node.al.get(i).size();
		System.out.print(i+"  -->>>");
			for(int b=0;b<sz;b++){
				if(node.al.get(i).get(b).equals("null")==false){
					System.out.print(node.al.get(i).get(b)+"  ");
				}	
			}
			System.out.println();	
	}
	System.out.println();
	}

public static void  remove(String key,String val){
	
	long hash_code=hashCode(key);
	double db= hash_code%arr_length;
	int index=(int)db;
	int sz=node.al.get(index).size();
	if(sz==1)
	{
	key_of.set(index, "null");
	node.al.set(index, aky);

	}else{
		int bc=0;
		int dd=0;
		while(bc<arr_length){
			if(node.al.get(index).get(bc).equals(val)==true){
				dd=bc;
				break;
			}else{
				bc++;
			}
		}
	
			node.al.get(index).remove(dd);
			System.out.println("Remove sucessfully ");
	}	
}

public static boolean search(String key,String val,int type){
	
	long hash_code=hashCode(key);
	double db=hash_code%arr_length;
	int index=Math.abs((int)db);
	String temp_key=key_of.get(index);
	int sz=node.al.get(index).size();
	boolean bool=false;
	
	for(int i=0;i<sz;i++){
		if(val.equals(node.al.get(index).get(i))&&type==3){
			bool= true;
			break;
			}else if(temp_key.equals("null")==false&&type==1){
				bool= true;
		
			}
			else{
				bool= false;
			}
	}
	return bool;
}


public static long hashCode(String st){
	
	long hash=0;
	 for(int k=0;k<st.length();k++){
		 hash=hash+(int)st.charAt(k);
	 }
	 return hash;
}
	

	public static void main(String arg[])throws IOException{
		
		Scanner input=new Scanner(new File("C:/Users/Aalok Kumar/Desktop/words.dat"));
		Scanner in=new Scanner(System.in);
		boolean bool=true;
		aky.add("null");
		for(int i=0;i<1200;i++)
		{
			key_of.add("null");
			node.al.add(aky);
			
		}
		
		while(bool==true){
			System.out.println("Enter 1 for add value in table ");
			System.out.println("Enter 2 for retrive all values in table ");
			System.out.println("Enter 3 for remove value in table ");
			System.out.println("Enter 4 for search value in table ");
			
			int b=in.nextInt();
			String key=null;String val=null;
			if(b!=2&&b!=1){
			System.out.println("Enter key to operation ");
			in.nextLine();
			key=in.nextLine();
			System.out.println("Enter value for operation ");
			val=in.nextLine();
			}
			if(b==1){
            int cp=0;
            while(cp<1200){
            String temp= input.nextLine(); 
			fun(temp,temp);
		    cp++;
            }
            System.out.println("added sucessfully");
            continue;
			
			}else if(b==2)
			{
				retrive();
			}else if (b==3){
	
			remove(key ,val);
			}
			else{
			
				boolean hb=search(key,val,3);
				if(hb==true){
					System.out.println("value found");
				}else{
					System.out.println("value not found");
				}
			}	
		}
	}	
}
