import java.util.*;
import java.util.stream.Collectors;
public class Alt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Student stud=new Student();
		List<Student> student = stud.reader("Test.csv");
		//highest marks
		student.parallelStream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotal))).ifPresent(System.out::println);
		// lowest marks
		student.parallelStream().collect(Collectors.minBy(Comparator.comparingInt(Student::getTotal))).ifPresent(System.out::println);
		// average marks in the school
		Double avg=student.parallelStream().collect(Collectors.averagingInt(Student::getTotal));
		System.out.println(avg);
		//dept wise highest marks
		Map<String, Optional<Student>> dept= 
				student.parallelStream().collect(Collectors.groupingBy(Student::getDept,
						Collectors.maxBy(Comparator.comparingInt(Student::getTotal))
						
						)
						);
						
						
		System.out.println(dept);

	}

}

