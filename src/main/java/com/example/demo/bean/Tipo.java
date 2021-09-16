package com.example.demo.bean;

public enum Tipo {
	
	OMNIVORA("OMNIVORA"), VEGETARIANA("VEGETARIANA"), VEGANA("VEGANA");

	private String nombre;

	private Tipo(String dieta) {
		this.nombre = dieta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
