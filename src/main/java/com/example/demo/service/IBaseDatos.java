package com.example.demo.service;

import java.util.ArrayList;
import com.example.demo.bean.Receta;

//En comentarios: la función equivalente en JPA
public interface IBaseDatos {
	public void inserta(Receta receta);		//SAVE
	public void borrar(int id);				//DELETE BY ID
	public void modifica(Receta receta);		//SAVE
	public Receta getReceta(int id);			//FIND BY ID
	public ArrayList<Receta> getRecetas();	//FIND ALL
	public boolean compruebaUsuario(String usuario, String password);

}