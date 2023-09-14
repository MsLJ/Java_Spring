package com.ms.jun164sdi.human;


import com.ms.jun164sdi.main.Dog;

public class Human {
	private String name;
	private int age;
	private Dog pet;
	public Human() {
		// TODO Auto-generated constructor stub
	}
	
	
	


	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public Dog getPet() {
		return pet;
	}





	public void setPet(Dog pet) {
		this.pet = pet;
	}





	public Human(String name, int age, Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}




	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
		pet.printInfo();
		
	}

}
