import java.io.*;
import java.util.*;

class LinearSearch{
	
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
		LinearSearch search = new LinearSearch();
		int searchResult = search.Search(arr,key,n);
		
		if(searchResult==0)
			System.out.println("\nNumber was not found");
		else
			System.out.println("\nNumber was found");
		long eT = System.nanoTime();
		long time=(eT-sT);
		System.out.println("Elapsed Time: "+time+"ns "+time/1000+"us "+time/100000+"ms "+time/100000000+"s");
	}

	public int Search(int arr[], int key, int n){
		for(int i=0;i<n;i++)
			if(arr[i]==key)
				return 1;
		return 0;	
	}
}
