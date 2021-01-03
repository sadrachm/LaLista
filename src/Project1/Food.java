package Project1;

import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date; 

public class Food{
	
	private String name;
	private String date;
	
	public Food(String name, String date)
	{
		this.name = name;
		this.date = date;
	}
	public int differ(String today)
	{	    
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        if (date.isBlank()) {return -1;}
        
        try { 
            Date d1 = sdf.parse(date); 
            Date d2 = sdf.parse(today); 
  
            // Calucalte time difference 
            // in milliseconds 
            long difference_In_Time 
                = d2.getTime() - d1.getTime(); 
  
            long ans = (difference_In_Time/ (1000 * 60 * 60 * 24))% 365; 
            return (int) ans;
        } 
  
        // Catch the Exception 
        catch (ParseException e) { 
            e.printStackTrace(); 
            return -1;
        } 
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDate()
	{
		return date;
	}
	public void updateDate(String x)
	{
		date = x;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public boolean equals(Object x)
	{
		if (x instanceof Food){
            Food ptr = (Food) x;
            return ptr.getName().equals(name);
        }
		return false;
	}
}

    