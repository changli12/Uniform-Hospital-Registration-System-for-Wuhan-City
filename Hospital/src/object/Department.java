package object;

public class Department {
	private int depart_id;
	private String depart_name;
	private int hos_id;
	private String sub_depart;//zikeshi
	
	public int getDepart_id() {
		return depart_id;
	}
	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}

	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	public String getSub_depart() {
		return sub_depart;
	}
	public void setSub_depart(String sub_depart) {
		this.sub_depart = sub_depart;
	}
	public int getHos_id() {
		return hos_id;
	}
	public void setHos_id(int hos_id) {
		this.hos_id = hos_id;
	}
}
