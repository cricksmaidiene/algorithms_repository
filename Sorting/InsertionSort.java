class InsertionSort{
	public void InsertionSortRoutine(int n, int arr[]){
		for(int i=1;i<n;i++){
			int currentElement = arr[i];
			int j=i-1;
			while(j>=0 && currentElement<arr[j]){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1] = currentElement;
		}
	}
}