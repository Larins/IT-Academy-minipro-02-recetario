package com.example.demo.bean;

import javax.persistence.*;


@Entity
@Table(name="recetas")

public class Receta { 

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;

	@Column(name="nombre", nullable=false, length=30)
	private String nombre;
	private String ingredientes;
	private String imagen;
	private String preparacion;
	private int num;

	//Para usar combobox usamos la siguiente declaracion:
	@Column(name="TIPO")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	public Receta(int id, String nombre, String ingredientes, String imagen, String preparacion, Tipo tipo) {
		this.id = id;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.imagen = imagen;
		this.preparacion = preparacion;
		this.tipo = tipo;	
	}
	
	public Receta() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}