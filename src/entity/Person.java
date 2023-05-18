package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person extends BaseEntity{
	
	private String name;
	private int age;
	private String address;
	
	public Person() { }

	public Person (int id, String name, String address, int age) {

		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

		this.setId(id);
		this.name = name;
		this.address = address;
		this.age = age;
		this.setCreationDate(formattedDateTime);
	}

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getNome() {
		return name;
	}
	
	public void setNome(String name) {
		this.name = name;
	}
	public int getIdade() {
		return age;
	}
	
	public void setIdade(int age) {
		this.age = age;
	}
	
	public String getEndereco() {
		return address;
	}
	
	public void setEndereco(String address) {
		this.address = address;
	}
}
