package object;

import java.util.Date;

public class reserveinfo {
	private int reserve_id;
	private int patient_id;
	private Date reserve_time;
	private int hospital_id ;
	private int depart_id;
	private String patient_name;
	private int doctor_id;
	private String textinfo;
	private int age;
	private String sex;

	public int  getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int id) {
		this.patient_id = id;
	}
	
	public int  getDoc_id() {
		return doctor_id;
	}
	public void setDoc_id(int d) {
		this.doctor_id = d;
	}
	
	public int  getDpa_id() {
		return depart_id;
	}
	public void setDpa_id(int d) {
		this.depart_id = d;
	}
	
	public int getHop_id() {
		return hospital_id;
	}
	public void setHop_id(int i) {
		this.hospital_id=i;
	}
	
	public int getReserve_id() {
		return reserve_id;
	}
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}
	
	
	public Date getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(Date datetime) {
		this.reserve_time = datetime;
	}
	
	public String getTextinfo() {
		return textinfo;
	}
	public void setTextinfo(String textinfo) {
		this.textinfo = textinfo;
	}
	
	 public reserveinfo( int reserve_id,
		 int patient_id,
		 Date reserve_time,
		 int hospital_id ,
		 int depart_id,
		 String patient_name,
	     int doctor_id,
		String textinfo) {
	        super();
	        this.reserve_id=reserve_id;
	         this.patient_id = patient_id;
	        this.reserve_time= reserve_time;
	         this.hospital_id  = hospital_id ;
	         this.depart_id=depart_id;
	         this.setPatient_name(patient_name) ;
	        this.doctor_id= doctor_id;
	         this.textinfo  = textinfo;
	     }
	 public reserveinfo(int reserve_id,String patient_name,int age,String sex,Date reserve_time,String textinfo)
		{
			super();
			this.reserve_id=reserve_id;
			this.patient_name=patient_name;
			this.setAge(age);
			this.setSex(sex);
			this.reserve_time=reserve_time;
			this.textinfo=textinfo;
			
		}
	public reserveinfo() {
		// TODO 自动生成的构造函数存根
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
