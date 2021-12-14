package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.UsuarioDTO;
import br.com.implant_rag_front.service.UsuarioService;
import br.com.implant_rag_front.util.JsfUtil;

@ManagedBean(name = "MBUsuario")
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

	public String validaLogin() {

		Boolean validadorLogin = this.usuarioService.validar(this.usuario.getEmail(), this.usuario.getSenha());

		if (validadorLogin == true) {
			JsfUtil.adicionarMensagemDeSucesso("Login realizado com sucesso");
			return "index";
		} else if (validadorLogin == false) {
			JsfUtil.adicionarMensagemDeErro("Usurio ou senha invlido");
		}
		return null;
	}

}
