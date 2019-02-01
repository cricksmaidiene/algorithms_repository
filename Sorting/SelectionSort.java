class SelectionSort{
	public void SelectionSortRoutine(int n, int arr[]){
		int i=0,j=0,min=0;
		for(i=0;i<n-1;i++){
			min = i;
			for(j=i+1;j<n;j++)
				if(arr[j]<arr[min])
					min = j;
			Swap(min,i,arr);	
		}
	}
	public void Swap(int min, int i, int arr[]){
		int temp = arr[min];
		arr[min]=arr[i];
		arr[i]=temp;
	}
}