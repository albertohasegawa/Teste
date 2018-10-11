package br.com.cast.teste.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.teste.dto.EnderecoDTO;
import br.com.cast.teste.entidade.Endereco;
import br.com.cast.teste.interfac.InterfaceEnderecoServices;
import br.com.cast.teste.repository.EnderecoRepository;

@Service
public class EnderecoServices implements InterfaceEnderecoServices{

	@Autowired
	private EnderecoRepository eRepo;
	
	@Override
	public List<EnderecoDTO> buscarTodos() {
		List<Endereco> enderecos = (List<Endereco>) eRepo.findAll();
		List<EnderecoDTO> edtos = new ArrayList<>();
		for (Endereco endereco : enderecos) {
			EnderecoDTO edto = new EnderecoDTO();
			edto.setCep(endereco.getCep());
			edto.setBairro(endereco.getBairro());
			edto.setCidade(endereco.getCidade());
			edto.setComplemento(endereco.getComplemento());
			edto.setLogradouro(endereco.getLogradouro());
			edto.setUf(endereco.getUf());
			edto.setNumero(endereco.getNumero());
			edtos.add(edto);
		}
		return edtos;
		
	}
	@Override
	public EnderecoDTO buscarPorCep(String cep) {
		Endereco end = (Endereco) eRepo.findById(cep).get();
		EnderecoDTO edto = new EnderecoDTO();
		edto.setCep(end.getCep());
		edto.setBairro(end.getBairro());
		edto.setCidade(end.getCidade());
		edto.setComplemento(end.getComplemento());
		edto.setLogradouro(end.getLogradouro());
		edto.setUf(end.getUf());
		edto.setNumero(end.getNumero());
		return edto;
		
	}
	@Override
	public void deletar(String cep) {
		eRepo.deleteById(cep);
	}
	@Override
	public void salvar  (EnderecoDTO edto) {
		Endereco end = new Endereco();
		end.setBairro(edto.getBairro());
		end.setCep(edto.getCep());
		end.setCidade(edto.getCidade());
		end.setUf(edto.getUf());
		end.setNumero(edto.getNumero());
		end.setLogradouro(edto.getLogradouro());
		end.setComplemento(edto.getComplemento());
		eRepo.save(end);
	}
}
