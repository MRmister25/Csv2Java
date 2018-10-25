import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
public class Alt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		List<Student> student = reader("Test.csv");
		//highest marks
		student.stream().map(x -> x.getSub1()+x.getSub2()+x.getSub3()).sorted(Comparator.reverseOrder()).limit(1).forEach(System.out::println);
		// lowest marks
		student.stream().map(x -> x.getSub1()+x.getSub2()+x.getSub3()).sorted(Comparator.naturalOrder()).limit(1).forEach(System.out::println);
		// average marks in the school
		student.stream().mapToInt(x -> x.getSub1()+x.getSub2()+x.getSub3()).average().ifPresent(System.out::println);
		//dept wise total marks
		Map<String,Integer> dept= 
				student.stream().collect(
						Collectors.groupingBy(Student::getDept,Collectors.summingInt(x -> x.getSub1()+x.getSub2()+x.getSub3()))
						
								);
						
						
		System.out.println(dept);

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
	
	 static Student createStudent(String[] data) {
		int id = Integer.parseInt(data[0]);
		String name = data[1];
		String dept = data[2];
		int sub1 = Integer.parseInt(data[3]);
		int sub2 = Integer.parseInt(data[4]);
		int sub3 = Integer.parseInt(data[5]);
		return new Student(id, name, dept,sub1,sub2,sub3);
								
	}

}

