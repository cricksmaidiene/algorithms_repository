#include<stdio.h>
void main()
{
	int i,j,no,c,temp;
	printf(" Enter The Size of 1D Array\n");
	scanf(" %d", &no);
	int arr[no];
	printf(" Enter The Elements into the Array: \n");
	for(i=0;i<no;i++)
	scanf("%d",&arr[i]);
	printf("\n\n The Given Array Is:\n \n");
	for(i=0;i<no;i++)
	printf("%d ",arr[i]);
	/*BUBBLE SORT*/
	printf("\n\n The Sorted Array Is: \n\n");
	for(j=0;j<no;j++)
	{
		for(i=(no-1);i>c;i--)
		{
			if(arr[i]<arr[i-1])
			{
				temp=arr[i-1];
				arr[i-1]=arr[i];
				arr[i]=temp;
			}
			else
			continue;
		}
		++c;
	}
	for(i=0;i<no;i++)
	printf("%d ", arr[i]);
	printf("\n");
}	
			
