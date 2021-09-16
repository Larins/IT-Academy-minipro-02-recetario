package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.bean.Receta;

public interface BaseDatos extends JpaRepository<Receta, Integer> {
	/*
	public void inserta(Receta receta);		//SAVE
	public void borrar(int id);				//DELETE BY ID
	public void modifica(Receta receta);		//SAVE
	public Receta getReceta(int id);			//FIND BY ID
	public ArrayList<Receta> getRecetas();	//FIND ALL
	public boolean compruebaUsuario(String usuario, String password);
	*/

}
