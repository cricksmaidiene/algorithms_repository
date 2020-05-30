import java.io.*;
import java.util.*;
class RecursiveBinarySearch {

	Scanner sc = new Scanner(System.in);

	public int InputSizeOfArray() {
		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();
		return n;
	}

	public void InputArrayElements(int n, int arr[]) {
		 
		for(int i = 0; i < n; i++)
			arr[i] = (int)(100000 * Math.random());
		
		// System.out.println("Enter "+n+" elements into the array");
		// for(int i=0;i<n;i++)
		// 	arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
	}

	public void DisplayArrayElements(int n, int arr[]) {
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public int InputKey(){
		System.out.print("Enter the key to be searched in the array: ");
		int key = sc.nextInt();
		return key;
	}
		
	public boolean BinarySearch (int n, int arr[], int key) {
		int lo = 0;
		int hi = n - 1;
		int mid = (lo + hi) / 2;
		int slice = (int)(Math.ceil(n / 2));

		if (lo > hi)
			return false;
		else if (arr[mid] == key)
			return true;
		else if (key < arr[mid]) {
			int sliced_array[] = new int[slice];
			for(int i = 0; i < mid; i++)
				sliced_array[i] = arr[i];
			return BinarySearch(sliced_array.length, sliced_array, key);
		}
		else { //if (key > arr[mid])
			int k = 0;
			int sliced_array[] = new int[slice];
			for(int i = mid + 1; i < n; i++, k++)
				sliced_array[k]=arr[i];
			return BinarySearch(sliced_array.length, sliced_array, key);
		}
	}

	public static void main(String args[])throws IOException {
		long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		RecursiveBinarySearch rbs = new RecursiveBinarySearch();
		
		int n = rbs.InputSizeOfArray();
		int arr[] = null;
		try{
			arr = new int[n];
		}
		catch (OutOfMemoryError e) {
			System.out.println("Memory Limit of Current Process Exceeded");
			System.exit(0);
		}	
		long startTime = System.nanoTime();
		rbs.InputArrayElements(n,arr);
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time to Populate List: " + totalTime / 10000 + "us, " + totalTime / 100000000 + "s");
		//rbs.DisplayArrayElements(n,arr);
		int key = rbs.InputKey();
		
		startTime = System.nanoTime();
		boolean result = rbs.BinarySearch(n,arr,key);
		if (result) 
			System.out.println(key + " was found in the array"); 
		else	
			System.out.println(key + " was not found in the array");
		
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Time to Search: " + totalTime / 10000 + "us, " + totalTime / 100000000 + "s");
		
		long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long totalMemory = afterMemory - beforeMemory;
		System.out.println("Memory Used: " + totalMemory / 1000000 + " MB");
	}
}
