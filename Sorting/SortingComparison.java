import java.io.*;
import java.util.*;
class SortingComparison{
	Scanner sc = new Scanner(System.in);

	public static void main(String args[])throws IOException{
		SortingComparison driver = new SortingComparison();
		driver.Driver();
	}

	public void Driver(){
		System.out.print("Enter the size of the array: ");
		String in = SafeInput();
		if(in.equals("invalid")){
			sc.nextLine();
			return;
		}
		
		int n = Integer.parseInt(in);
		int arr[]=new int[n];
		int arrCopy[]=new int[n];
		long startTime,endTime,time;
		
		InputArrayElements(n, arr);
		Copy(arr,arrCopy,n);
		//DisplayArrayElements(n,arr); 
		
		QuickSort quicksort = new QuickSort();
		startTime = System.nanoTime();
		quicksort.QuickSortRoutine(arr,0,n-1);
		System.out.println("Quick sort complete. Statistics: ");
		endTime = System.nanoTime();
		time = endTime-startTime;
		System.out.println("Elapsed Time: "+time+"ns "+time/1000+"us "+time/100000+"ms "+time/1000000000+"s");
		Copy(arrCopy,arr,n);
		
		
		MergeSort mergesort = new MergeSort();
		startTime = System.nanoTime();
		mergesort.MergeSortRoutine(n,arr);
		System.out.println("Merge sort complete. Statistics: ");
		endTime = System.nanoTime();
		time = endTime-startTime;
		System.out.println("Elapsed Time: "+time+"ns "+time/1000+"us "+time/100000+"ms "+time/1000000000+"s");
		Copy(arrCopy,arr,n);

		startTime = System.nanoTime();
		InsertionSort insertionsort = new InsertionSort();
		insertionsort.InsertionSortRoutine(n,arr);
		System.out.println("Insertion sort complete. Statistics: ");
		endTime = System.nanoTime();
		time = endTime-startTime;
		System.out.println("Elapsed Time: "+time+"ns "+time/1000+"us "+time/100000+"ms "+time/1000000000+"s");
		Copy(arrCopy,arr,n);
		
		BubbleSort bubblesort = new BubbleSort();
		startTime = System.nanoTime();
		bubblesort.BubbleSortRoutine(n,arr);
		System.out.println("Bubble sort complete. Statistics: ");
		endTime = System.nanoTime();
		time = endTime-startTime;
		System.out.println("Elapsed Time: "+time+"ns "+time/1000+"us "+time/100000+"ms "+time/1000000000+"s");
		Copy(arrCopy,arr,n);

		SelectionSort selectionsort = new SelectionSort();
		startTime = System.nanoTime();
		selectionsort.SelectionSortRoutine(n,arr);
		System.out.println("Selection sort complete. Statistics: ");
		endTime = System.nanoTime();
		time = endTime-startTime;
		System.out.println("Elapsed Time: "+time+"ns "+time/1000+"us "+time/100000+"ms "+time/1000000000+"s");
		Copy(arrCopy,arr,n);
	}	

	public String SafeInput(){
		int a;
		try{
				a=sc.nextInt();
				return Integer.toString(a);
			}	
			catch(InputMismatchException e)
			{
				System.out.println("Result not an integer");
				return "invalid";
			}
	}
	public void InputArrayElements(int n, int arr[]){
		for(int i=0;i<n;i++)
			arr[i]=(int)(10000*Math.random());
	}
	public void DisplayArrayElements(int n, int arr[]){
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public void Copy(int arrFrom[], int arrTo[], int n){
		for(int i=0;i<n;i++)
			arrTo[i]=arrFrom[i];
	}	
}
