package com.example.demo.bean;

public enum Tipo { 
	
	OMNIVORA("OMNIVORA", 1), VEGETARIANA("VEGETARIANA", 2), VEGANA("VEGANA", 3);
	
	private String dieta;
	private int num;

	private Tipo(String dieta, int num) {
		this.dieta = dieta;
		this.num = num;
	}

	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
