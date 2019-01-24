import java.io.*;
import java.util.*;

class IterativeBinarySearch{
	
	public static void main(String args[])throws IOException{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int n = sc.nextInt();
		int arr[]= new int[n];
		for(int i=0;i<n;i++)
			arr[i]=(int)(1000*Math.random());
		
		System.out.print("\nEnter the key to be searched: ");
		int key = sc.nextInt();
		long sT = System.nanoTime();
		IterativeBinarySearch search = new IterativeBinarySearch();
		int searchResult = search.BinarySearch(arr,key,n);
		
		if(searchResult==0)
			System.out.println("\nNumber was not found");
		else
			System.out.println("\nNumber was found");
		
		long eT = System.nanoTime();
		long time=(eT-sT);
		System.out.println("Elapsed Time: "+time+"ns "+time/1000+"us "+time/100000+"ms "+time/100000000+"s");
	}
	
	public int BinarySearch(int arr[], int key, int n){
		
		int lo = 0;
		int hi = n-1;
		while(lo<=hi){
			int mid = (int)(Math.ceil((lo+hi)/2));
			if(arr[mid]==key)
				return 1;
			else if(key<arr[mid])
				hi = mid-1;
			else
				lo = mid+1;
		}
		return 0;	

	}
}		
