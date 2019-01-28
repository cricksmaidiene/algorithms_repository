import java.io.*;
import java.util.*;
class MergeSort{

	Scanner sc = new Scanner(System.in);

	public static void main(String args[])throws IOException{
		MergeSort ob = new MergeSort();
		int n = ob.InputSizeOfArray();
		if(n==-1) return;
		int arr[] = new int[n];
		int flag = ob.InputArrayElements(n,arr);
		if(flag==-1) return;
		long sT = System.nanoTime();
		//ob.DisplayArrayElements(n,arr);
		ob.MergeSortRoutine(n,arr);
		//System.out.println("The Sorted Array is:");
		//ob.DisplayArrayElements(n,arr);
		long eT = System.nanoTime();
		float time = eT-sT;
		System.out.println("Elapsed Time: "+(eT-sT)+"ns "+(eT-sT)/1000+"us "+(eT-sT)/100000+"ms "+(time)/1000000000+"s");
	}

	public void MergeSortRoutine(int n, int arr[]){
		int lo = 0;
		int hi = n-1;
		if(lo<hi){
			int mid = (int)(Math.floor((lo+hi)/2));
			int LArr[] = new int[mid+1];
			int RArr[] = new int[n-(mid+1)];
			PopulateArray(LArr,RArr,arr,mid+1);
			
			MergeSortRoutine(mid+1,LArr);
			MergeSortRoutine(n-(mid+1),RArr);
			
			Merge(LArr,RArr,arr);

		}
	}

	public void Merge(int LArr[], int RArr[], int newArr[]){
		int i=0,j=0,k=0;
		while(i < LArr.length && j < RArr.length){
			if(LArr[i]<RArr[j]){
				newArr[k]=LArr[i];
				i++;
			}
			else{
				newArr[k]=RArr[j];
				j++;
			}
			k++;
		}
		while(i<LArr.length){
			newArr[k]=LArr[i];
			i++;
			k++;
		}
		while(j<RArr.length){
			newArr[k]=RArr[j];
			j++;
			k++;
		}
	}

	public void PopulateArray(int LArr[], int RArr[], int arr[],int mid){
		for(int i=0;i<LArr.length;i++)
			LArr[i]=arr[i];
		for(int j=mid;j<arr.length;j++)
			RArr[j-mid]=arr[j];
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
		 
		
		for(int i=0;i<n;i++)
			arr[i]=(int)(100000*Math.random());
		return 0;
		
		/*
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
		return 0;
		*/
	}

	public void DisplayArrayElements(int n, int arr[]){
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}


}