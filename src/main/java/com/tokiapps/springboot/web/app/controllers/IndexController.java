package com.tokiapps.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tokiapps.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		// devuelve el nombre de la vista. Si está en
		// algún directorio sería como "test/index"
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil (Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Alberto");
		usuario.setApellido("Gonzalez");
		usuario.setEmail("tokiapps@gmail.com");
		
		// Le pasamos el objeto usuario a la vista
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar (Model model) {
	
		model.addAttribute("titulo", textoListar);
		
		return "listar";
	}

//	De aquí va directamente a la vista. No tiene porqué pasar por listar() antes
	@ModelAttribute("usuarios")
	private List<Usuario> poblar_usuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Alberto", "Gonzalez", "tokiapps@gmail.com"),
				new Usuario("Pepe", "Gonzalez", "Pepe@gmail.com"),
				new Usuario("Jon", "Doe", "Jon@gmail.com"),
				new Usuario("Jane", "Doe", "Jane@gmail.com"),
				new Usuario("Tornado", "Roe", "roe@gmail.com")
				);
		return usuarios;
	}

}
