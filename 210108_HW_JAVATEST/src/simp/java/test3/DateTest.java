package simp.java.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		Calendar birth = new GregorianCalendar(1987, 4, 27);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Date 형식을 집어 넣어야 한다 그냥 Calendar 넣으니 오류남
		System.out.println(sdf.format(birth.getTime()));
		
		long age = (now.getTimeInMillis() - birth.getTimeInMillis())/1000/60/60/24/365;
		
		System.out.println(age);

	}

}
