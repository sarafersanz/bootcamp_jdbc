package com.ecodeup.model;

public class Cliente {
	private int id;
	private String name;
	private String firstname;
	private String secondname;
	private String dni;
	
	public Cliente(int id, String name, String firstname, String secondname, String dni) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.secondname = secondname;
		this.dni = dni;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


}
