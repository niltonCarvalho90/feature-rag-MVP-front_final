package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.ClienteDTO;
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
		this.usuario = this.usuarioService.listarUsuariosPorEmail(this.usuario.getEmail()).get(0);
		if(validadorLogin == true) {
			JsfUtil.adicionarMensagemDeSucesso("Login realizado com sucesso");
			return "cadastroFiliais?faces-redirect=true&idCliente="+usuario.getCliente().getCodigo();
		}else {
			JsfUtil.adicionarMensagemDeErro("Usurio ou senha invlido");		
			return null ;
		}
		
	}

	
	public void cadastrarUsuario() {
		
		 
		Boolean validadorNome = true;
		Boolean validadorEmail = false;
		
		String emailUsuario = this.usuario.getEmail();
        String nomeUsuario = this.usuario.getNome();
        String senhaUsuario = this.usuario.getSenha();
        
        int contNum = 0;
        
        for(int cont = 0; cont < nomeUsuario.length(); cont++) {
            
        		if(Character.isDigit(nomeUsuario.charAt(cont))
        				|| (!Character.isAlphabetic(nomeUsuario.charAt(cont)))) {
            	
	        			contNum++;
	        			validadorNome = false;
        		}else{
        			
        			validadorNome = true;
        		}
        }
        
        if(contNum>0) {
            validadorNome = false;

            JsfUtil.adicionarMensagemDeErro("Nome inválido", null);
            JsfUtil.adicionarMensagemDeAtencao("O nome não pode conter espaços, números ou caracteres especiais", null);

        }
        
       
        
        if(emailUsuario.contains("@")) {
            validadorEmail = true;
        }else {
            JsfUtil.adicionarMensagemDeErro("E-mail inválido", null);
            validadorEmail = false;
        }
        
        if(nomeUsuario.length() > 50 && validadorNome == false){
            JsfUtil.adicionarMensagemDeErro("O nome não pode conter mais de 50 caracteres", null);
        } 
        
        if(emailUsuario.length() > 100 && validadorNome == false) {
            JsfUtil.adicionarMensagemDeErro("O e-mail não pode conter mais de 100 caracteres", null);
        } 
        
        if(senhaUsuario.length() > 50  && validadorNome == false) {
            JsfUtil.adicionarMensagemDeErro("A senha não pode conter mais de 50 caracteres", null);
        }
        if( validadorNome == true && validadorEmail == true){
        	
            int conferir = this.usuarioService.cadastrar(usuario, this.usuario.getCliente().getCodigo(), this.usuario.getEmail());
            
            if(conferir == 0) {
            	
				JsfUtil.adicionarMensagemDeSucesso("Cadastro realizado com sucesso", null);

            	this.usuario = new UsuarioDTO();

                this.usuario.setCliente(new ClienteDTO());
                 
            }else if(conferir == 1) {
				JsfUtil.adicionarMensagemDeErro("Cliente não encontrado", null);

            }else if( conferir == 2) {
				JsfUtil.adicionarMensagemDeErro("E-mail já cadastrado", null);
            }
           
        }
		
		
	}


}
