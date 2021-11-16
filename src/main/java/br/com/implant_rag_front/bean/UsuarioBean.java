package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.UsuarioDTO;
import br.com.implant_rag_front.service.UsuarioService;
import br.com.implant_rag_front.util.JsfUtil;

@ManagedBean(name="MBUsuario")
@ViewScoped
public class UsuarioBean {
	
	private UsuarioDTO usuario;
	
	private ArrayList<UsuarioDTO> itens;
	
	@ManagedProperty(value = "#{usuarioService}")
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
	
	public String validaLogin( String email, String senha) {
		
		if(this.usuarioService.validar( usuario.getEmail(), usuario.getSenha()) == true) {
			return "cadastroOperadoras.xhtml";
		}else if( this.usuarioService.validar( usuario.getEmail(), usuario.getSenha()) == false) {
			JsfUtil.adicionarMensagemDeErro("Email ou senha inválidos");
		}
		return null;
	}
	public void teste() {
		System.out.println("KAUA GAY");
	}

}
