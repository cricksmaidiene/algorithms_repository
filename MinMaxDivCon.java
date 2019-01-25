import java.io.*;
import java.util.*;

class MinMaxDivCon{
	Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		
		MinMaxDivCon activate = new MinMaxDivCon();
		int n = activate.InputSizeOfArray();
		int arr[]=new int[n];
		activate.InputArrayElements(n,arr);
		System.out.println("\nThe Given Array is:");
		activate.DisplayArrayElements(n,arr);
		int minmax[]= new int[2];
		activate.DivideAndConquer(minmax,arr,n);
		System.out.print("\nMin: "+minmax[0]);
		System.out.println("\tMax: "+minmax[1]);

	}
	
	public int InputSizeOfArray(){
		
		System.out.print("\nEnter the size of the array: ");
		int n = sc.nextInt();
		return n;
	}

	public void InputArrayElements(int n, int arr[]){
		 
		/*for(int i=0;i<n;i++)
			arr[i]=(int)(100000*Math.random());
		*/
		
		System.out.println("Enter "+n+" elements into the array");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
	}

	public void DisplayArrayElements(int n, int arr[]){
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

	public void DivideAndConquer(int minmax[],int arr[], int n){
		if(n==2){
			if(arr[0]<arr[1]){
				minmax[0] = arr[0];
				minmax[1] = arr[1];
			}
			else{
				minmax[0] = arr[1];
				minmax[1] = arr[0];
			}	
		}
		else if(n==1){
			minmax[0]=minmax[1]=arr[0];
		}
		else{
			int leftSize = ((int)(Math.floor(n/2)));
			int rightSize = n - leftSize;
			int LArr[] = new int [leftSize];
			int RArr[] = new int [rightSize];
			
			for(int i=0; i<leftSize; i++)
				LArr[i]=arr[i];
		
			for(int j=leftSize; j<n; j++)
				RArr[j-leftSize]=arr[j];

			int minmaxl[] = new int[2];
			int minmaxr[] = new int[2];

			DivideAndConquer(minmaxl, LArr, leftSize);
			DivideAndConquer(minmaxr, RArr, rightSize);
			
			
			if(minmaxr[1]>minmaxl[1]){ //if rmax>lmax
				minmax[1]=minmaxr[1];
			}	
			else{ 
				minmax[1]=minmaxl[1];
			}	
			
			if(minmaxr[0]<minmaxl[0]){//if rmin < lmin
				minmax[0]=minmaxr[0];
			}	
			else{
				minmax[0]=minmaxl[0];
			}	
							
		}				

	}
}