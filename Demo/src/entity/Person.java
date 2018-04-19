package entity;

import java.io.Serializable;

public class Person extends FatherTest implements Serializable {
    public Person() {
		super();
		System.out.println("通过无参构造实例化Person类对象实例");
	}
	private Person(String name, String address, String message) {
		super();
		this.name = name;
		this.address = address;
		this.message = message;
		System.out.println("通过有参构造实例化Person类对象实例");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString(){
		return"{name="+name+"adress="+address+"message="+message+"}";
	}
	private int id;
    private String name;
    private String address;
    private String message;
}
