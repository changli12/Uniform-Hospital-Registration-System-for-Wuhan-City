package object;

public class User {
	private int user_id;
	private String user_name;
	private String password;
	private String sort;

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public User(){}
	 public User(int id, String name, String password, String sort) {
	        super();
	        this.user_id = id;
	         this.user_name = name;
	        this.password= password;
	         this.sort = sort;
	     }
	
}

