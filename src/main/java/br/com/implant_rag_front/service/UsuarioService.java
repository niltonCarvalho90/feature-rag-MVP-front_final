package br.com.implant_rag_front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_front.client.UsuarioClient;
import br.com.implant_rag_front.dto.UsuarioDTO;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioClient usuarioClient;

	public void cadastrar(UsuarioDTO usuario) {
		this.usuarioClient.logar(usuario);
	}
}