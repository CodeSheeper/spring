package test;

import java.lang.reflect.Constructor;

public class GetClassConstructorInfo {
             public void test1() throws Exception{
            	Class cls=Class.forName("entity.Person");
            	Object obj=cls.newInstance();
            	System.out.println(obj.toString());
             }
             public void test2()throws Exception{
            	Class cls=Class.forName("entity.Person");
            	//获取类的构造函数
            	Constructor[] consts=cls.getDeclaredConstructors();
            	System.out.println("============构造函数展示===========");
            	for (Constructor constructor : consts) {
					Class [] params=constructor.getParameterTypes();
					if (params.length==0) {
						System.out.println("此构造函数没有参数");
					}else {
						System.out.println("此构造函数的参数列表为:[");
						for (int i = 0; i < params.length; i++) {
							System.out.print(params[i].getName());
								System.out.print(",");
						}
						System.out.println("]");
					}
				}
            	//获取无参构造
            	Constructor c1=cls.getConstructor();
            	//通过无参构造获取Person类的对象实例
            	    Object obj=c1.newInstance();
            	    System.out.println(obj);
            	    //获取有参构造
            	    Constructor c2=cls.getDeclaredConstructor(String.class,String.class,String.class);
            	    //c2是私有的
            	    c2.setAccessible(true);
            	    obj=c2.newInstance("新手","北京","欢迎您");
            	    System.out.println(obj);
             }
        public static void main(String[] args) {
        	GetClassConstructorInfo cons=new GetClassConstructorInfo();
        	try {
				//cons.test1();
				cons.test2();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
