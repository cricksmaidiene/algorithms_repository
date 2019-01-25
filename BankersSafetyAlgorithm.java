import java.io.*;
import java.util.*;

class BankersAlgorithm
{

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[])throws IOException
	{
		BankersAlgorithm b = new BankersAlgorithm();
		
		int n=0, m=0;
		b.InputNumberOfResources(m);
		b.InputNumberOfProcesses(n);

		int available[] = new int[m];
		int max[][] = new int[n][m];
		int allocation[][] = new int[n][m];
		int need[][] = new int[n][m];
		b.InputAvailableMatrix(available,m);
		b.InputMaxMatrix(max,n,m);
		b.InputAllocationMatrix(allocation,n,m);
		b.DisplayAvailableMatrix(available,m);
		b.DisplayMaxMatrix(max,n,m);
		b.DisplayAllocationMatrix(allocation,n,m);
		b.CalculateNeedMatrix(need,max,allocation,n,m);
		b.DisplayNeedMatrix(need,n,m);

		int work[] = new int[m];
		boolean finish[] = new boolean[n];
		boolean round[] = new boolean[n];
		int safeSequence[] = new int[n];

		b.InitializeWorkMatrix(work,m);
		b.InitializeFinishMatrix(finish, round, n);
		
		int set_flag=0;
		boolean finflags=false;
		int c=0;

		
		for(int i=0; i<m; i++)
			work[i]=available[i];
		for(int i=0; i<n; i++){
			finish[i]=false;
			round[i]=finish[i];
		}	


		while(true)
		{
			for(int i=0; i<n; i++)
			{
				if(finish[i]==false)
				{	
					int j=0;
					for(j=0;j<m;++j)
					{	
						if(!(need[i][j]<=work[j]))
						{
							break;
						}
					}	
					if(j==m){
						for(int k=0;k<m;++k)
							work[k]+=allocation[i][k];
						
						finish[i]=true;
						safeSequence[c]=i;
						++c;	
					}
				}
			}					
					
			int count=0;
			//First check if all finish[i]==true
			for(count=0;count<n;++count)
				if(finish[count]!=true)
					break;
			if(count==n){
				finflags=true;
				break; // from while
			}		
			//if all finish[i]!=true, check for looping
			//round stores the value of finish before finish goes for the current run
			// if both are the same after a run, then no safe state
			for(count=0;count<n;++count)
				if(round[count]!=finish[count])
					break;
				//if any one element is unequal, we need to go back for a loop
			if(count==n){
				// if all elements have been compared and no element is unequal
				break;
			}	 // break out of loop
			else{// if it broke out before count could reach n for round
				for(int i=0;i<n;i++) 
					//copy the current state of finish into round and enter loop again
					round[i]=finish[i];
			}		

		}
		if(finflags==true){
			System.out.println("SAFE STATE OBTAINED");
			System.out.print("SAFE SEQUENCE IS: <");
			for(int i=0;i<c;i++)
				System.out.print(safeSequence[i]+" ");
			System.out.println(">");
		}	
		else
			System.out.println("UNSAFE STATE OBTAINED");

	}
	
	public void InputNumberOfResources(int m)
	{
		System.out.print("\nEnter the number of resources in the system: ");
		m = sc.nextInt();
	}	

	public void InputNumberOfProcesses(int n)
	{
		System.out.print("\nEnter the number of processes in the system: ");
		n = sc.nextInt();
	}

	public void InputAvailableMatrix(int available[], int m)
	{
		System.out.print("\nEnter contents of available matrix ");
		for(int i=0; i<m; i++)
			available[i]= sc.nextInt();
	}

	public void InputMaxMatrix(int max[][], int n, int m)
	{
		System.out.print("\nEnter contents of Max matrix ");
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				max[i][j]=sc.nextInt();
	}

	public void InputAllocationMatrix(int allocation[][], int n, int m)
	{
		System.out.print("\nEnter contents of Allocation matrix ");	
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				allocation[i][j]=sc.nextInt();
	}

	public void DisplayAvailableMatrix(int available[], int m)
	{

		System.out.println("\nAVAILABLE");
		for(int i=0; i<m; i++)
			System.out.print(available[i]+"  ");

	}

	public void DisplayMaxMatrix(int max[][], int n, int m)
	{

		System.out.println("\n\nMAX");
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++)
					System.out.print(max[i][j]+" ");
				System.out.println();
			}
	}

	public void DisplayAllocationMatrix(int allocation[][], int n, int m)
	{
			System.out.println("\nALLOCATION");
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++)
					System.out.print(allocation[i][j]+" ");
				System.out.println();
		}

	}

	public void CalculateNeedMatrix(int need[][], int max[][], int allocation[][], int n, int m)
	{
		for(int i=0; i<n;i++)
			for(int j=0; j<m;j++)
				need[i][j]=max[i][j]-allocation[i][j];
	}

	public void DisplayNeedMatrix(int need[][], int n, int m)
	{
		System.out.println("\nNEED");
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++)
					System.out.print(need[i][j]+" ");
				System.out.println();
			}	
	}
}
		
		
			