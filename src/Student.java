import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

 public class Student {
	private String name;
	private int id;
	private String dept;
	private int sub1;
	private int sub2;
	private int sub3;
	private int total;

	public Student(){
		
	}

	public Student(int id, String name,String dept,int sub1,int sub2,int sub3, int total) {
		this.name = name;
		this.id = id;
		this.dept = dept;
		this.sub1=sub1;
		this.sub2=sub2;
		this.sub3=sub3;
		this.total=total;
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
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dept=" + dept + ", sub1="+sub1+", sub2="+sub2+", sub3="+sub3+", total="+total+"]";
	}
	
	private static Student createStudent(String[] data) {
		int id = Integer.parseInt(data[0]);
		String name = data[1];
		String dept = data[2];
		int sub1 = Integer.parseInt(data[3]);
		int sub2 = Integer.parseInt(data[4]);
		int sub3 = Integer.parseInt(data[5]);
		int total=Integer.parseInt(data[6]);
		return new Student(id, name, dept,sub1,sub2,sub3,total);
									}
	
	List<Student> reader(String filename)
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

}



