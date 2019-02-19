import java.io.*;
import java.util.*;
class QueueArray{

	Scanner sc = new Scanner(System.in);
	int queue[];
	int front=0,rear=0;
	int n=0;

	public static void main(String args[])throws IOException{
		
		QueueArray Queue = new QueueArray();
		Queue.Driver();
	}
	
	public void Driver(){	
		
		String in=""; 
		int elem=0;

		System.out.print("Enter the size of the Queue: ");
		if(ZeroQueue()) return;

		CreateQueue(n);
		boolean INTR=true;
		do{
			int choice = QueueMenu();
			switch (choice){
				case (1):
				{
					if(!QueueIsFull()){	
						System.out.print("ENQUEUE: ");
						in = SafeInput();
						if(in.equals("invalid")){
							sc.nextLine();
							break;
						}
						elem = Integer.parseInt(in);
						Enqueue(elem);
						System.out.println(elem+" has been added to the queue");
					}
					else
						System.out.println("Queue is full");
					break;		
				}
				case (2):
				{
					if(!QueueIsEmpty()){
						elem = Dequeue();
						System.out.println("Dequeued element: "+elem);
					}
					else
						System.out.println("Queue is empty");	
					break;
				}
				case (3):
				{
					if(!QueueIsEmpty())
						System.out.println("Front element is: "+queue[front]);
					else
						System.out.println("Queue is empty");	
					break;
				}
				case (4):
				{
					System.out.println("Size of Queue is "+ Size());
					break;
				}
				case (5):
				{
					if(!QueueIsEmpty()){
						System.out.print("QUEUE: ( ");
						Display();
						System.out.println(")");
					}
					else
						System.out.println("Queue is empty");	
					break;
				}
				case (0):
					INTR=false;

			}
			if(choice>5||choice<0)
				System.out.println("Not a valid menu option");

		}while(INTR);	
	}
	
	public boolean ZeroQueue(){
		String in="";
		in = SafeInput();
		if(in.equals("invalid"))
			return true;
		
		n = Integer.parseInt(in);
		if(n<=0){
			System.out.println("No worthwhile queue size. Exiting...");
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

	public void CreateQueue(int n){
		queue = new int[n];
	}

	public int QueueMenu(){
		System.out.println("QUEUE OPTIONS: ");
		System.out.println("1.ENQUEUE 2.DEQUEUE 3.FRONT 4.SIZE 5.DISPLAY 0.EXIT");
		String in = SafeInput();
		if(in=="invalid"){
			sc.nextLine();
			return -1;
		}
		else return Integer.parseInt(in);
	}

	public void Enqueue(int elem){
		queue[rear]=elem;
		if(rear==n-1)
			rear=0;
		else
			++rear;
	}
	public int Dequeue(){
		int elem = queue[front];
		if(front==n-1)
			front=0;
		else
			++front;
		return elem;
	}
	public void Display(){
		for(int i=front,j=0;j<Size();j++){
			System.out.print(queue[i] +" ");
			i=(i+1)%n;
		}
	}
	public boolean QueueIsFull(){
		boolean value;
		int size = Size();
		value = ((size==n-1) ? true : false);
		return value;
	}
	public boolean QueueIsEmpty(){
		boolean value;
		value = ((front==rear) ? true : false);
		return value;
	}
	public int Size(){
		return (n-front+rear)%n; 
	}

}