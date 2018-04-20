package com.yw.test05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) {
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		
		hm.put(1, "hello");
		hm.put(2, "world");
		
		Set<Entry<Integer,String>> entry=hm.entrySet();
		
		Iterator<Entry<Integer,String>> it= entry.iterator();
		while(it.hasNext())
		{
			Entry<Integer,String> e=it.next();
			int key=e.getKey();
			String value=e.getValue();
			System.out.println("key="+key+",value="+value);
		}
		
	}

}
