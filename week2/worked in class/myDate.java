public  class myDate
  {
    
    private int month, day, year;
	private final String[] month_names ={ "", "Jan", "Feb", "Mar", 
		"Apr", "May", "Jun",
		"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	
	public myDate(int month, int day, int year) {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		
		this.year = year;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		if (month <1 || month >12)
			month =1;
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		if (day <1 || day > 31)
			day =1;
		this.day = day;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	
	public String getMonthName() {
		return month_names[month];
	}
	
	public String tostring() {
		return (getMonthName() + " " + day +", " + year);
	}
	
	
	
	
	
  	  
    // Add constructor and methods

	
	 
	
  }
