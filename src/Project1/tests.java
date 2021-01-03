package Project1;

import java.util.Date;
import java.text.SimpleDateFormat;

public class tests{
	static void main(String args[])
	{
		String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		String date2 = new SimpleDateFormat("dd/MM/yyyy").format("15/12/2020");
		Food x = new Food("chile", date);
		Food y = new Food("pepper", date2);
		System.out.println(x.differ(date2));
	}
}