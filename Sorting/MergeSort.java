class MergeSort{

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
}