package br.com.implant_rag_front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_front.client.FilialClient;
import br.com.implant_rag_front.dto.ClienteDTO;
import br.com.implant_rag_front.dto.FilialDTO;


@Service
public class FilialService {
	@Autowired
	private FilialClient filialClient;

	public void cadastrar(FilialDTO filial) {
		this.filialClient.cadastrar(filial);
		System.out.println("Filial cadastrada");
	}
	public List<FilialDTO> listar() {
		List<FilialDTO> filiais = this.filialClient.listar();
		return filiais;
	}
	public void editar(FilialDTO filial) {
		this.filialClient.editar(filial);
		System.out.println("Filial editada!");
	}
	public Boolean verificarCadastro(FilialDTO filial) {
		List<FilialDTO> filiais = this.filialClient.listar();
		int contaIgualdades = 0;
		for (FilialDTO filialDTO : filiais) {
			if(filial.getCnpj() == filialDTO.getCnpj() ||
				filial.getApelidoLoja().trim().equals(filialDTO.getApelidoLoja().trim()) ||
				filial.getCodErp() == filialDTO.getCodErp() ||
				filial.getRazaoSocial().trim().equals(filialDTO.getApelidoLoja().trim())) {
				
					contaIgualdades++;
			}
		}
		if(contaIgualdades>0) {
			return false;
		} else {
			return true;
		}
	}
	public ClienteDTO buscarCliente(Integer codigo) {
		return this.filialClient.buscarCliente(codigo);
	}
	public List<FilialDTO> listarPorCliente(Integer codigo){
		return this.filialClient.listarPorCliente(codigo);
	}
}
