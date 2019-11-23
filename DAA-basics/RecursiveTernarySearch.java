import java.io.*;
import java.util.*;
class RecursiveTernarySearch{

	Scanner sc = new Scanner(System.in);

	public static void main(String args[])throws IOException{
		long bM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		RecursiveTernarySearch ob = new RecursiveTernarySearch();
		int n = ob.InputSizeOfArray();
		if(n==-1) return;
		int arr[] = new int[n];
		int flag = ob.InputArrayElements(n,arr);
		if(flag==-1) return;
		ob.DisplayArrayElements(n,arr);
		int key = ob.InputKey();
		if(key==-1) return;
		long sT = System.nanoTime();
		int result = ob.TernarySearch(n,arr,key);
		if(result==-1)
			System.out.println(key+" was not found in the array");
		else
			System.out.println(key+" was found in the array");
		long eT = System.nanoTime();
		System.out.println("Elapsed Time: "+(eT-sT)+"ns "+(eT-sT)/1000+"us "+(eT-sT)/100000+"ms "+(eT-sT)/100000000+"s");
		long aM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long memory = aM-bM;
		System.out.println("Memory Used: "+memory+" bytes");
	}

	public int InputSizeOfArray(){
		System.out.print("\nEnter the size of the array: ");
		int n = sc.nextInt();
		if(n<=0){
			System.out.println("No elements in array. Exiting...");
			return -1;
		}
		return n;
	}

	public int InputArrayElements(int n, int arr[]){
		 
		/*for(int i=0;i<n;i++)
			arr[i]=(int)(100000*Math.random());
		*/
		System.out.println("Enter "+n+" elements into the array");
		for(int i=0;i<n;i++){
			try{
				arr[i]=sc.nextInt();
			}	
			catch(InputMismatchException e)
			{
				System.out.println("Result not an integer, exiting...");
				return -1;
			}
		}
		Arrays.sort(arr);
		return 0;
	}

	public void DisplayArrayElements(int n, int arr[]){
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

	public int InputKey(){
		System.out.print("\nEnter the key to be searched in the array: ");
		int key;
		try{
			key = sc.nextInt();
			return key;
		}
		catch(InputMismatchException e){
			System.out.println("Result not an integer, exiting..");
			return -1;
		}	
	}
		
	public int TernarySearch(int n, int arr[], int key){
		int lo,hi,m1,m2;
		lo = 0;
		hi = n-1;
		if(lo!=hi){
			m1 = (int)(Math.ceil((n/3)-1));
			m2 = (int)(Math.ceil(((2*n)/3)-1));
		
			if(arr[m1]==key||arr[m2]==key)
				return 1;
			
			else if(key<arr[m1]){
				int firstSize = m1+1;
				int arr1[]=new int[firstSize];
				for(int i=0;i<firstSize;i++)
					arr1[i]=arr[i];
				return TernarySearch(firstSize,arr1,key);
			}
			else if(key>arr[m1]&&key<arr[m2]){ 
				int k=0;
				int midSize = m2-m1;
				int arr2[]=new int[midSize];
				for(int i=m1+1;i<m2;i++,k++)
					arr2[k]=arr[i];
				return TernarySearch(midSize,arr2,key);
			}
			else{
				int k=0;
				int endSize = hi-m2;
				int arr3[]=new int[endSize];
				for(int i=m2+1;i<=hi;i++,k++)
					arr3[k]=arr[i];
				return TernarySearch(endSize,arr3,key);
			}
		}
		else{
			m1=m2=0;
			if(arr[m1]!=key)
				return -1;
			else
				return 1;
		}	
	}
}