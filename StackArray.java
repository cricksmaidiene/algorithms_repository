import java.io.*;
import java.util.*;
class StackArray{

	Scanner sc = new Scanner(System.in);
	static int st[];
	static int top=-1;

	public static void main(String args[])throws IOException{
		
		StackArray stack = new StackArray();
		int n = stack.Input(1);
		if(n==-1) return;
		stack.CreateStack(n);
		boolean INTR=true;
		do{
			int choice = stack.StackMenu();
			switch (choice){
				case (1):
				{
					if(!stack.StackOverflow()){	
						System.out.print("PUSH: ");
						int element = stack.Input(0);
						stack.Push(element);
						System.out.println(element+" has been pushed into stack");
					}
					else
						System.out.println("Stack is full");
					break;		
				}
				case (2):
				{
					if(!stack.StackUnderflow()){
						int elem = stack.Pop();
						System.out.println("Popped element: "+elem);
					}
					else
						System.out.println("Stack is empty");	
					break;
				}
				case (3):
				{
					if(!stack.StackUnderflow())
						System.out.println("Top element is: "+st[top]);
					else
						System.out.println("Stack is empty");	
					break;
				}
				case (4):
				{
					System.out.println("Size of Stack is "+(top+1));
					break;
				}
				case (5):
				{
					if(!stack.StackUnderflow())
						stack.Display();
					else
						System.out.println("Stack is empty");	
					break;
				}
				case (0):
					INTR=false;

			}
			if(choice>5||choice<0)
				System.out.println("Not a valid menu option");

		}while(INTR);	
	}
	
	public int Input(int flag){
		if(flag==1){
			System.out.print("Enter the size of the stack: ");
			int n = sc.nextInt();
			if(n<=0){
				System.out.println("Zero stack size. Exiting...");
				return -1;
			}
			return n;
		}
		else 
			return sc.nextInt();
	}

	public void CreateStack(int n){
		st = new int[n];
	}

	public int StackMenu(){
		System.out.println("STACK OPTIONS: ");
		System.out.println("1.PUSH 2.POP 3.PEEK 4.SIZE 5.DISPLAY 0.EXIT");
		return sc.nextInt();
	}

	public void Push(int elem){
		top++;
		st[top]=elem;
	}
	public int Pop(){
		--top;
		return st[top+1];
	}
	public void Display(){
		for(int i=0;i<=top;i++)
			System.out.print(st[i]+" ");
		System.out.println();
	}
	public boolean StackOverflow(){
		if(top==(st.length-1))
			return true;
		else
			return false;
	}
	public boolean StackUnderflow(){
		if(top==-1)
			return true;
		else
			return false;
	}

}