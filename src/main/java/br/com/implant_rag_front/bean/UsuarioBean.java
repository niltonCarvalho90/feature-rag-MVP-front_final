package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.UsuarioDTO;
import br.com.implant_rag_front.service.UsuarioService;

@ManagedBean(name="MBUsuario")
@ViewScoped
public class UsuarioBean {
	
	private UsuarioDTO usuario;
	
	private ArrayList<UsuarioDTO> itens;
	
	@ManagedProperty(value = "#usuarioService}")
	private UsuarioService usuarioService;
	
	public UsuarioBean() {
		this.usuario = new UsuarioDTO();
		
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public ArrayList<UsuarioDTO> getItens() {
		return itens;
	}

	public void setItens(ArrayList<UsuarioDTO> itens) {
		this.itens = itens;
	}
	
	public void validarUsuario() {
		
	}
	
	public void validarSenha() {
		
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}	

}
