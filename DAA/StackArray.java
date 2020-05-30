import java.io.*;
import java.util.*;
class StackArray{

	Scanner sc = new Scanner(System.in);
	int st[];
	int top=-1;
	int n=0;

	public static void main(String args[])throws IOException{
		
		StackArray stack = new StackArray();
		stack.Driver();
	}
	
	public void Driver(){	
		
		String in=""; 
		int elem=0;

		System.out.print("Enter the size of the stack: ");
		if(ZeroStack())
			return;

		CreateStack(n);
		boolean INTR=true;
		do{
			int choice = StackMenu();
			switch (choice){
				case (1):
				{
					if(!StackOverflow()){	
						System.out.print("PUSH: ");
						in = SafeInput();
						if(in.equals("invalid")){
							sc.nextLine();
							break;
						}
						elem = Integer.parseInt(in);
						Push(elem);
						System.out.println(elem+" has been pushed into stack");
					}
					else
						System.out.println("Stack is full");
					break;		
				}
				case (2):
				{
					if(!StackUnderflow()){
						elem = Pop();
						System.out.println("Popped element: "+elem);
					}
					else
						System.out.println("Stack is empty");	
					break;
				}
				case (3):
				{
					if(!StackUnderflow())
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
					if(!StackUnderflow()){
						System.out.print("STACK: ( ");
						Display();
						System.out.println(")");
					}
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
	
	public boolean ZeroStack(){
		String in="";
		in = SafeInput();
		if(in.equals("invalid"))
			return true;
		
		n = Integer.parseInt(in);
		if(n<=0){
			System.out.println("Zero stack size. Exiting...");
		 	return true;
		}
		return false; 	
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

	public void CreateStack(int n){
		st = new int[n];
	}

	public int StackMenu(){
		System.out.println("STACK OPTIONS: ");
		System.out.println("1.PUSH 2.POP 3.PEEK 4.SIZE 5.DISPLAY 0.EXIT");
		String in = SafeInput();
		if(in=="invalid"){
			return -1;
		}	
		else return Integer.parseInt(in);
	}

	public void Push(int elem){
		st[++top]=elem;
	}
	public int Pop(){
		return st[(--top)+1];
	}
	public void Display(){
		for(int i=0;i<=top;i++)
			System.out.print(st[i]+" ");
	}
	public boolean StackOverflow(){
		boolean value;
		value = (top==(st.length-1)) ? true : false;
		return value;
	}
	public boolean StackUnderflow(){
		boolean value;
		value = (top==-1) ? true : false;
		return value;
	}

}
