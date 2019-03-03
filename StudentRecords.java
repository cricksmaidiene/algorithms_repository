import java.io.*;
import java.util.*;

class StudentRecords{
	
	public static void main(String args[])throws Exception{
		StudentRecords object = new StudentRecords();
		object.Driver();
	}

	public void Driver()throws IOException{

		String fileName = "Students.txt";
		String path = "./Students.txt";
		String newFile = "MergeSorted.txt";
		String yearFile = "InsertionSorted.txt";
		
		int n = getLineCount(fileName);
		Student arr[] = new Student[n];
		readAllLines(fileName,n,arr);

		String names[]=new String[n];
		CopyNames(arr,names,n);
		MergeSort(n,names);
		writeAllLies(newFile,n,names,arr);
/*
		int years[]=new int[n];
		CopyYears(arr,years,n);
		InsertionSort(n,years);
		writeAllLies(yearFile,n,years,arr);
*/		//Display(names,n);
	}

	public void writeAllLies(String fileName, int n, String[]names, Student[]arr)throws IOException{
		
		File file = new File("Users\\mansarovar\\Desktop\\Code\\MergeSorted.txt");
		if(!file.exists())
			file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fw);

		for(int i=0;i<n;i++){
			
			String name = names[i];
			for(int j=0;j<n;j++){
				
				String current = (arr[j].name).toString();
				
				if(current.equalsIgnoreCase(name)){
					
					String one = name;
					String two = (arr[j].ID).toString();
					int enY = Integer.valueOf(arr[j].enrollmentYear);
					float gpa = Float.valueOf(arr[j].gpa);
					String three = Integer.toString(enY);
					String four = Float.toString(gpa);
					
					String concat = one+" "+two+" "+three+" "+four;
					try{

						writer.write(concat,0,concat.length());
						writer.newLine();
						
					}
					catch(FileNotFoundException e){
						System.out.println("File not found, try again");
						break;
					}
					catch(IOException e){
						System.out.println("Issue found in Read/Write Operations, exiting");
						break;
					}	
				}
				else
					continue; 
			}
		}
		writer.close();
	}

	public void Display(String names[],int n){
		for(int i=0;i<n;i++)
			System.out.println(names[i]);
	}
	public void CopyNames(Student arr[], String names[],int n){
		for(int i=0;i<n;i++)
			names[i]=(arr[i].name).toString();
	}
	
	public int getLineCount(String fileName)throws IOException{

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		int lineCount = 0;
		while (br.readLine() != null) lineCount++;
		br.close();
		return lineCount;
	}	

	public void readAllLines(String fileName, int n, Student arr[])throws IOException{
		int i=0,c=0;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			for(i=0;i<n;i++){
				String in = reader.readLine();
				String [] words = in.split("\\s");
				Student ob = new Student(words[0],words[1],Integer.parseInt(words[2]),Float.parseFloat(words[3]));
				arr[c]=ob;
				c++;
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found, try again");
		}
		catch(IOException e){
			System.out.println("Issue found in Read/Write Operations, exiting");
		}
	}
	public void MergeSort(int n, String arr[]){
		int lo = 0;
		int hi = n-1;
		if(lo<hi){
			int mid = (int)(Math.floor((lo+hi)/2));
			String LArr[] = new String[mid+1];
			String RArr[] = new String[n-(mid+1)];
			PopulateArray(LArr,RArr,arr,mid+1);
			
			MergeSort(mid+1,LArr);
			MergeSort(n-(mid+1),RArr);
			
			Merge(LArr,RArr,arr);

		}
	}

	public void Merge(String LArr[], String RArr[], String newArr[]){
		int i=0,j=0,k=0;
		while(i < LArr.length && j < RArr.length){
			if(LArr[i].compareToIgnoreCase(RArr[j])<0) {
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

	public void PopulateArray(String LArr[], String RArr[], String arr[],int mid){
		for(int i=0;i<LArr.length;i++)
			LArr[i]=arr[i];
		for(int j=mid;j<arr.length;j++)
			RArr[j-mid]=arr[j];
	}
}

class Student{
	String name,ID;
	int enrollmentYear;
	float gpa;

	public Student(String name, String ID, int enrollmentYear, float gpa){
		this.name = name;
		this.ID = ID;
		this.enrollmentYear = enrollmentYear;
		this.gpa=gpa;
	}
}
