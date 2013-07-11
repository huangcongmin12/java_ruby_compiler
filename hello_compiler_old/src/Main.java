
public class Main {
	public static void main(String[] args) {
		String fullClassName = "MyObj";

		String code = "public class MyObj implements MyInterface{public void sayHello(){System.out.println(666);}}";
		String code_2 = "public class MyObj implements MyInterface{public void sayHello(){System.out.println(777);}}";
		String code_3 = "public class MyObj implements MyInterface{public void sayHello(){System.out.println(888);}}";
		load(code,fullClassName);
		load(code_2,fullClassName);
		load(code_3,fullClassName);
	}

	private static void load(String code, String fullClassName) {
		new MyClassCompiler(fullClassName, code).compile();

		try {
			MyInterface myObj = (MyInterface) new MyClassLoader().loadClass(
					fullClassName).newInstance();
			myObj.sayHello();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class MyObj implements MyInterface{public void sayHello(){System.out.println("Hello World 3333");}}
