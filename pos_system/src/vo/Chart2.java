package vo;

import java.sql.Date;

public class Chart2 {
	private int sum;
	private String month;
	private String name;
	
	
	public Chart2() {
		
	}


	public Chart2(int sum, String month, String name) {
		super();
		this.sum = sum;
		this.month = month;
		this.name = name;
	}


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Chart2 [sum=" + sum + ", month=" + month + ", name=" + name + "]";
	}

  
   
   
   

}