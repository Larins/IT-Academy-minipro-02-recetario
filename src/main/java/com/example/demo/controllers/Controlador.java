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
import com.example.demo.bean.Usuario;
import com.example.demo.repository.BaseDatosService;

@Controller // Con la etiqueta, el controlador se convierte en un servlet que atiende peticiones HTTP
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
			ArrayList<Receta> Recetas = bd.getRecetas();
			model.addAttribute("usuario", usuario);
			this.usuario = usuario;
			model.addAttribute("Recetas", Recetas);
			model.addAttribute("Receta", new Receta(0,"",Posicion.JUNIOR));
			model.addAttribute("boton", "Insertar Receta");
			model.addAttribute("action", "/insertar");
			return "consulta";
		} else
			model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		return "login";
	}

	// Handler insertar (CREATE)
	@PostMapping("/insertar")
	public String insertar(Receta Receta, Model model) {
		Receta.setSalario(Receta.getPosicion().getSalario());
		bd.inserta(Receta);
		ArrayList<Receta> Recetas = bd.getRecetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("Recetas", Recetas);
		model.addAttribute("Receta", new Receta(0,"",Posicion.JUNIOR));
		model.addAttribute("boton", "Insertar Receta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

	// Handler borrar (DELETE)
	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Receta> Recetas = bd.getRecetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("Recetas", Recetas);
		model.addAttribute("Receta", new Receta(0,"",Posicion.JUNIOR));
		model.addAttribute("boton", "Insertar Receta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

	// Handler modificar GET (rellenar formulario) (READ)
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Receta Receta = bd.getReceta(id);
		ArrayList<Receta> Recetas = bd.getRecetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("Recetas", Recetas);
		model.addAttribute("Receta", Receta);
		model.addAttribute("boton", "Actualizar Receta");
		model.addAttribute("action", "/modificar");
		return "consulta";
	}

	// Handler modificar POST (enviar formulario) (UPDATE)
	@PostMapping("/modificar")
	public String modificar2(Receta Receta, Model model) {
		Receta.setSalario(Receta.getPosicion().getSalario());
		bd.modifica(Receta);
		ArrayList<Receta> Recetas = bd.getRecetas();
		model.addAttribute("usuario", this.usuario);
		// this.usuario = usuario;
		model.addAttribute("Recetas", Recetas);
		model.addAttribute("Receta", new Receta(0,"",Posicion.JUNIOR));
		model.addAttribute("boton", "Actualizar Receta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}
}