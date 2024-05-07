package clases;

public class Alumno {
	
	int id;
	String name;
	String last_name;
	int age;
	
	Alumno() {
		
	}
	public Alumno(int id, String name, String last_name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.age = age;
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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
