package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Receta;
import com.example.demo.bean.Tipo;
import com.example.demo.bean.Usuario;
import com.example.demo.repository.BaseDatosService;

@Controller // Lo convertimos en un servlet que atiende peticiones HTTP
@RequestMapping("") // localhost:8080
public class Controlador {

	@GetMapping("/")
	public String iniciar(Model model) {
		model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		model.addAttribute("info1", "Introduce los datos de acceso:");
		return "login";
	}

	Usuario usuario;

	@Autowired
	BaseDatosService bd;

	// HANDLER LOGIN
	@PostMapping("/")
	public String login(Usuario usuario, Model model) {
		if (bd.compruebaUsuario(usuario.getNombre(), usuario.getPassword())) {
			ArrayList<Receta> recetas = bd.getRecetas();
			model.addAttribute("usuario", usuario);
			this.usuario = usuario;
			model.addAttribute("recetas", recetas);
			model.addAttribute("receta", new Receta(0,"","","","", Tipo.OMNIVORA));
			model.addAttribute("boton", "Insertar receta");
			model.addAttribute("action", "/insertar");
			return "consulta";
		} else
			model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		return "login";
	}

	// HANDLER INSERCION
	@PostMapping("/insertar")
	public String insertar(Receta receta, Model model) {
		receta.setNum(receta.getTipo().getNum());
		bd.inserta(receta);
		ArrayList<Receta> recetas = bd.getRecetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("recetas", recetas);
		model.addAttribute("receta", new Receta(0,"","","","", Tipo.OMNIVORA));
		model.addAttribute("boton", "Insertar receta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

	// Handler borrado
	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Receta> recetas = bd.getRecetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("recetas", recetas);
		model.addAttribute("receta", new Receta(0,"","","","", Tipo.OMNIVORA));
		model.addAttribute("boton", "Insertar receta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

	// Handler modificar GET (rellenar formulario)
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Receta receta = bd.getReceta(id);
		ArrayList<Receta> recetas = bd.getRecetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("recetas", recetas);
		model.addAttribute("receta", receta);
		model.addAttribute("boton", "Actualizar receta");
		model.addAttribute("action", "/modificar");
		return "consulta";
	}

	// Handler modificar POST (enviar formulario)
	@PostMapping("/modificar")
	public String modificar2(Receta receta, Model model) {
		receta.setNum(receta.getTipo().getNum());
		bd.modifica(receta);
		ArrayList<Receta> recetas = bd.getRecetas();
		model.addAttribute("usuario", this.usuario);
		// this.usuario = usuario;
		model.addAttribute("recetas", recetas);
		model.addAttribute("receta", new Receta(0,"","","","", Tipo.OMNIVORA));
		model.addAttribute("boton", "Actualizar receta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}
}