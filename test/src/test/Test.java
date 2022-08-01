package test;

import java.util.HashSet;
import java.util.Set;

class Student {

	Integer id;
	String name;

	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		System.out.println("idh " + id.hashCode());
		System.out.println("nmh " + name.hashCode());
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		System.out.println("fin " + name.hashCode());
		return 1;
	}
//
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("equ");
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

}

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student(2, "a");
		Student s2 = new Student(2, "a");
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		Set<Student> set = new HashSet<>();
		set.add(s1);
		set.add(s2);
		System.out.println(set);
		String s11;
	}

}
