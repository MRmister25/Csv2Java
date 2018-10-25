import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Csv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> student = reader("Test.csv");
			 Iterator itr=student.iterator();  
			 //list of all students
			 while(itr.hasNext()){  
				    Student st=(Student)itr.next();  
				    System.out.println(st.getId()+" "+st.getName()+" "+st.getDept()+" "+st.getSub1()+" "+st.getSub2()+" "+st.getSub3());  
				  }  
			 
			 
			 Student topper=null;
			 Student lowest=null;
			 Student mech=null;
			 Student cse=null;
			 int max=Integer.MIN_VALUE;
			 int mechtopper=Integer.MIN_VALUE;
			 int csetopper=Integer.MIN_VALUE;
			 int min=Integer.MAX_VALUE;
			 int avg=0, total=0;
			 for(int i=0;i<student.size();i++)
			 {
				// student with maximum marks
				 int temp=student.get(i).getSub1() + student.get(i).getSub2() + student.get(i).getSub3();
				 if(temp > max)
				 {
					 topper=student.get(i);
					 max=temp;
				 }
				 //student with minimum marks
				 if(temp < min)
				 {
					 lowest=student.get(i);
					 min=temp;
				 }
				 //average
				 total+=temp;
				 //dept toppers
				 if(student.get(i).getDept().equalsIgnoreCase("mech"))
				 {
					 if(temp > mechtopper)
					 {
						 mech=student.get(i);
						 mechtopper=temp;
					 }
				 }
				 if(student.get(i).getDept().equalsIgnoreCase("cse"))
				 {
					 if(temp > csetopper)
					 {
						 cse=student.get(i);
						 csetopper=temp;
					 }
				 }
			 }
			 
			 System.out.println("average of the class="+total/student.size()); //average of the class
			 System.out.println("department toppers: mech"+mech+  " cse"+cse);
			 System.out.println("lowest scorer:"+lowest+"  total:"+min);
			 System.out.println("highest scorer:"+topper+"  total:"+max);
		}

	



	static List<Student> reader(String filename)
	{
		List<Student> students=new ArrayList<>();
		Path pathToFile = Paths.get(filename); 

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
				Student stud = createStudent(attributes);
				students.add(stud);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		
		
			return students;
	}
	
	private static Student createStudent(String[] data) {
		int id = Integer.parseInt(data[0]);
		String name = data[1];
		String dept = data[2];
		int sub1 = Integer.parseInt(data[3]);
		int sub2 = Integer.parseInt(data[4]);
		int sub3 = Integer.parseInt(data[5]);
		return new Student(id, name, dept,sub1,sub2,sub3);
									}

	
}
class Student {
	private String name;
	private int id;
	private String dept;
	private int sub1;
	private int sub2;
	private int sub3;

	public Student(int id, String name,String dept,int sub1,int sub2,int sub3) {
		this.name = name;
		this.id = id;
		this.dept = dept;
		this.sub1=sub1;
		this.sub2=sub2;
		this.sub3=sub3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSub1() {
		return sub1;
	}

	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}

	public int getSub2() {
		return sub2;
	}

	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}

	public int getSub3() {
		return sub3;
	}

	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dept=" + dept + ", sub1="+sub1+", sub2="+sub2+", sub3="+sub3+"]";
	}
}



