import java.io.*;
import java.util.*;
class RecursiveBinarySearch{

	Scanner sc = new Scanner(System.in);

	public static void main(String args[])throws IOException{
		long bM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		RecursiveBinarySearch ob = new RecursiveBinarySearch();
		int n = ob.InputSizeOfArray();
		int arr[] = new int[n];
		ob.InputArrayElements(n,arr);
		//ob.DisplayArrayElements(n,arr);
		int key = ob.InputKey();
		long sT = System.nanoTime();
		int result = ob.BinarySearch(n,arr,key);
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
		return n;
	}

	public void InputArrayElements(int n, int arr[]){
		 
		for(int i=0;i<n;i++)
			arr[i]=(int)(100000*Math.random());
		
		/*System.out.println("Enter "+n+" elements into the array");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		*/	
		Arrays.sort(arr);
	}

	public void DisplayArrayElements(int n, int arr[]){
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

	public int InputKey(){
		System.out.print("\nEnter the key to be searched in the array: ");
		int key = sc.nextInt();
		return key;
	}
		
	public int BinarySearch(int n, int arr[], int key){
		int lo = 0;
		int hi = n-1;
		int mid = (lo+hi)/2;
		int div2 = (int)(Math.ceil(n/2));

		if(lo>hi)
			return -1;
		else if(arr[mid]==key)
			return 1;
		else if(key<arr[mid]){
			int arr2[]=new int[div2];
			for(int i=0;i<mid;i++)
				arr2[i]=arr[i];
			return BinarySearch(div2,arr2,key);
		}
		else if(key>arr[mid]){
			int k=0;
			int arr2[]=new int[div2];
			for(int i=mid+1;i<n;i++,k++)
				arr2[k]=arr[i];
			return BinarySearch(div2,arr2,key);
		}
		else
			return -2;
	}
}