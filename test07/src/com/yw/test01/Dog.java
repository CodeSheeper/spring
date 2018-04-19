package com.yw.test01;

public class Dog {
	private Integer a;
	private boolean b;
	
	
	
	public void setA(Integer a) {
		this.a = a;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public Integer getA() {
		return a;
	}
	public boolean isB() {
		return b;
	}
	public Dog()
	{
		System.out.println("==public Dog()==");
	}
	public Dog(Integer a)
	{
		System.out.println("==public Dog(int a)==");
		this.a=a;
	}
	public Dog(boolean b)
	{
		System.out.println("==public Dog(boolean b)==");
		this.b=b;
	}

}
