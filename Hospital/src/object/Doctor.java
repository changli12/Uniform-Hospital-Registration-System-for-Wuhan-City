package object;

public class Doctor {
	private int doctor_id;
	private String doctor_name;
	private String doctor_post;//zhiwei
	private String doctor_specialty;//shanchangsha
	private String email;
	private String sex;
	private String tel;
	private int depart_id;
	
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getdepart_id() {
		return depart_id;
	}
	public void setdepart_id(int depart_id) {
		this.depart_id = depart_id;
	}
	
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_post() {
		return doctor_post;
	}
	public void setDoctor_post(String doctor_post) {
		this.doctor_post = doctor_post;
	}
	public String getDoctor_specialty() {
		return doctor_specialty;
	}
	public void setDoctor_specialty(String doctor_specialty) {
		this.doctor_specialty = doctor_specialty;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
   
	 public Doctor(int doctor_id,
		 String doctor_name,
		 String doctor_post,
		 String doctor_specialty,
		 String email,
		 String sex,
		 String tel,
		 int depart_id) {
	         super();
	         this.doctor_id =doctor_id;
	         this.doctor_name = doctor_name;
	         this.doctor_post= doctor_post;
	         this.doctor_specialty =doctor_specialty;
	         this.email =email;
	         this.tel =tel;
	         this.sex= sex;
	         this.depart_id=depart_id;
	     }
	public Doctor() {
		// TODO 自动生成的构造函数存根
	}
	 

}
