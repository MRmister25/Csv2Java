import java.util.List;

public class Normal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		High h=new High();
		
		Thread mech=new Thread() {
			public void run() {
				h.DeptHigh("mech");
			}
		};
		Thread cse=new Thread() {
			public void run() {
				h.DeptHigh("cse");
			}
		};
		mech.start();
		cse.start();
		
		try {
			mech.join();
			cse.join();
		}catch(Exception e) {e.printStackTrace();}
		
	}
}

	class High{
		Student stud=new Student();
		List<Student> student = stud.reader("Test.csv");
			synchronized void DeptHigh(String s)
		{
			System.out.println(s);
			int csemax=Integer.MIN_VALUE;
			int mechmax=Integer.MIN_VALUE;
			Student csehigh=null;
			Student mechhigh=null;
			int m=0,t=0;
			for(int i=0;i<student.size();i++)
			{
				if(s.equals("cse") && student.get(i).getDept().equals("cse"))
				{
					 t=student.get(i).getTotal();
					if(t> csemax)
					{
						csehigh=student.get(i);
						csemax=t;
					}
				}
				else if(s.equals("mech")&& student.get(i).getDept().equals("mech"))
				{
					 m=student.get(i).getTotal();
					if(m> mechmax)
					{
						mechhigh=student.get(i);
						mechmax=m;
					}
				}
					
			}
			if(s.equals("cse"))
			System.out.println(csehigh);
			else
			System.out.println(mechhigh);
		}
	
		
	}

