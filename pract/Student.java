package in.cdac.pract;

public class Student {
	public int age;
	public String name;

	public Student() {

	}

	public void display() {
		System.out.println("My name is " + name + ".I am " + age + " years old");
	}

	public void sayHello(String mesg) {
		System.out.println(name + " says hello to " + mesg);
	}

}
