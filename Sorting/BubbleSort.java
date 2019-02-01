class BubbleSort{
	public void BubbleSortRoutine(int n, int arr[]){
		int i=0,j=0;
		for(i=1;i<n-1;i++)
			for(j=0;j<n-1-1;j++)
				if(arr[j+1]<arr[j])
					Swap(i,j,arr);
	}
	public void Swap(int i, int j, int arr[]){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}		
	