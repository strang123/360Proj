
public class Appointment {

	//Doctor Search
	private String zipCode;
	private String category;
	private String insuranceType;
	
	//Doctor Information
	private String doctorName;
	private String location;
	private String doctorCategory;
	private String insurance;
	
	private int appID;
	private int ssn;
	private int date;
	private int counter;
	
	private int appHour;
	private int appMin;
	private int appDay;
	private int appMonth;
	private int appYear;
	private int conditionType;
	
	private String knownDoctor;
	private String gender;
	private String reason;
	
	
	public void setZipCode(String z)
	{
		zipCode = z;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	
	//Not sure about category
	
	public void setInsuranceType(String t)
	{
		insuranceType = t;
	}
	public String getInsuranceType()
	{
		return insuranceType;
	}
	
	public void setDoctorName(String n)
	{
		doctorName = n;
	}
	public String GetDoctorName()
	{
		return doctorName;
	}
	
	public void setLocation(String l)
	{
		location = l;
	}
	public String getLocation()
	{
		return location;
	}
	
	//doctor category needed
	
	public void setInsurance(String i)
	{
		insurance = i;
	}
	public String getInsurance()
	{
		return insurance;
	}
	
	public void setAppID(int s,int da, int c)
	{
		ssn = s;
		date = da;
		counter = c;
	}
	public int getappID()
	{

		return appID;
	}
	
	public void setAppHour(int h)
	{
		appHour = h;
	}
	public int appHour()
	{
		return appHour;
	}
	
	public void setAppMin(int min)
	{
		appMin = min;
	}
	public int appMin()
	{
		return appMin;
	}
	
	public void setAppDay(int d)
	{
		appDay = d;
	}
	public int appDay()
	{
		return appDay;
	}
	
	public void setAppMonth(int m)
	{
		appMonth = m;
	}
	public int appMonth()
	{
		return appMonth;
	}
	
	public void setAppYear(int y)
	{
		appYear = y;
	}
	public int appYear()
	{
		return appYear;
	}
	
	public void setConditionType(int c)
	{
		conditionType = c;
	}
	public int conditionType()
	{
		return conditionType;
	}
	
	public void setKnownDoctor(String k)
	{
		knownDoctor = k;
	}
	public String getKnownDoctor()
	{
		return knownDoctor;
	}
	
	public void setGender(String g)
	{
		gender = g;
	}
	public String getGender()
	{
		return gender;
	}
	
	public void setReason(String r)
	{
		reason = r;
	}
	public String getReason()
	{
		return reason;
	}
	
	
}
