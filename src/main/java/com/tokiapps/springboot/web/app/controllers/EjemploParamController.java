package com.tokiapps.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("resultado", "El texto enviado es ");
		return "/params/index";
	}
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", defaultValue = "Texto por defecto") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es " + texto);
		return "/params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es " + saludo + " y el número: " + numero);
		return "/params/ver";
	}
}
