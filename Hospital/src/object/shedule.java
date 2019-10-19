package object;

public class shedule {
	private int number;
	private String doc_name;
	private int doc_id;
	public int getDoc_id() {
		return doc_id;
	}
	public void  setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name){
		this.doc_name=doc_name;
	}
	public int getNum()
	{
		return number;
	}
	public void setNum(int n)
	{
		this.number=n;
	}
	 public shedule(int id, String name, int num) {
	        super();
	        this.doc_id = id;
	         this.doc_name = name;
	        this.number= num;
	         
	     }
}
