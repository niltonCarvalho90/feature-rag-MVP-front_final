package br.com.implant_rag_front.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.implant_rag_front.dto.ClienteDTO;
import br.com.implant_rag_front.responseDTO.ClienteResponse;

@Service
public class ClienteClient {


    public List<ClienteDTO> listarUsuarios(){

        RestTemplate rest = new RestTemplate();
        ResponseEntity<ClienteResponse> response = rest.getForEntity("http://localhost:8000/implant_rag_back/clientes/listar"  , ClienteResponse.class);

        List<ClienteDTO> clientes = response.getBody().getClientes();
        return clientes;

    }

    public Integer cadastrarUsuarios(ClienteDTO cliente, String nome) {
        HttpEntity<ClienteDTO> clienteDTO = new HttpEntity<>(cliente);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Integer> response = rest.postForEntity("http://localhost:8000/implant_rag_back/clientes/salvar/" + nome , clienteDTO, Integer.class);



        if(response.getBody() == 0) {
                return 0;
        }else if(response.getBody() == 1) {
            return 1;

        }


        return 4;

    }
    public void deletarCliente(Integer codigo) {

        RestTemplate rest = new RestTemplate();
        rest.delete("http://localhost:8000/implant_rag_back/clientes/deletar/" + codigo);

    }
    
    public void editar(ClienteDTO cliente) {
    	HttpEntity<ClienteDTO> clienteDTO = new HttpEntity<>(cliente);
        RestTemplate rest = new RestTemplate();
        rest.put("http://localhost:8000/implant_rag_back/clientes/editar", clienteDTO);


       
      


}
}
