#include<stdio.h>
void main()
{
	int mid,lb,ub,i,n,key;
	printf(" Enter The Size of 1D Array\n");
	scanf(" %d", &n);
	int arr[n];
	printf(" Enter The Elements into the Array: \n");
	for(i=0;i<n;i++)
	scanf("%d",&arr[i]);
	printf("\n\n The Given Array Is:\n \n");
	for(i=0;i<n;i++)
	printf("%d ",arr[i]);
	printf("\n Enter the number to be searched:");
	scanf("%d", &key);
	lb=0;
	ub=n-1;
	mid=(lb+ub)/2;
	while(lb<=ub)
	{
		if(key==arr[mid])
		{
			printf("\n %d found at %d",key,(mid+1));
			break;
		}
		else if(key<arr[mid])
		ub=mid-1;
		else if(key>arr[mid])
		lb=mid+1;
		else
		{
			printf("\n %d not found in the array", key);
			break;
		}
		mid=(lb+ub)/2;
	}
}	
	
