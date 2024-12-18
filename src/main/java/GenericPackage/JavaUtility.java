package GenericPackage;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int toFetchRandomNumber(int value1) {
		Random r=new Random();
		int value = r.nextInt(1000);
		return value;
	}
	public String toFetchDateAndTime() {
		Date d=new Date();
		String date []=d.toString().split(" ");
		String month = date[0];
		String date1 = date[1];
		String time = date[2].replace(":", "-");
		String year = date[3];
		String finalData = month+" "+date1+" "+time+" "+year;
		//String finalData = month+date1+time+year;
		return finalData;		
	}
}
