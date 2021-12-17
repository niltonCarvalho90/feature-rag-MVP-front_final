package br.com.implant_rag_front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_front.client.UsuarioClient;
import br.com.implant_rag_front.dto.UsuarioDTO;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioClient usuarioClient;

	public Boolean validar(String email, String senha) {
		return this.usuarioClient.logar( email, senha);
	}
	
	public int cadastrar(UsuarioDTO usuario, int codigo, String email) {
		return this.usuarioClient.cadastrar(usuario , codigo, email);
	}
	
	
	public UsuarioClient getUsuarioClient() {
		return usuarioClient;
	}
	
	public void setUsuarioClient(UsuarioClient usuarioClient) {
		this.usuarioClient = usuarioClient;
	}
	
	public List<UsuarioDTO> listarUsuariosPorEmail(String email){
		return this.usuarioClient.listarUsuariosPorEmail(email);
	}

	

}
