import java.util.*;
import java.util.stream.Collectors;
public class Alt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Student stud=new Student();
		List<Student> student = stud.reader("Test.csv");
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
}

