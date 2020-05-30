class QuickSort{
	public void QuickSortRoutine(int arr[], int p,int r){
			if(p<r){
				int q = Partition(arr,p,r);
				QuickSortRoutine(arr,p,q-1);
				QuickSortRoutine(arr,q+1,r);
			}
		}

	public int Partition(int arr[], int p, int r){
		int x = arr[r];
		int i = p-1;
		for(int j=p;j<r;j++)
			if(arr[j]<x){
				i++;
				Swap(i,j,arr);
			}
		Swap(i+1,r,arr);
		return i+1;		
	}

	public void Swap(int a, int b, int arr[]){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}	