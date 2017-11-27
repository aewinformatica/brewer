package com.aewinformatica.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aewinformatica.brewer.model.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@GetMapping("/novo")
	public String novo(Usuario usuario){
		
		return "usuario/CadastroUsuario";
	}


}
