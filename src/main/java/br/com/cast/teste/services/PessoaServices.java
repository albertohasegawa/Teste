package br.com.cast.teste.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.teste.dto.EnderecoDTO;
import br.com.cast.teste.dto.PessoaDTO;
import br.com.cast.teste.entidade.Endereco;
import br.com.cast.teste.entidade.Pessoa;
import br.com.cast.teste.interfac.InterfacePessoaServices;
import br.com.cast.teste.repository.PessoaRepository;

@Service
public class PessoaServices implements InterfacePessoaServices {

	@Autowired
	private PessoaRepository pRepo;
	
	@Override
	public List<PessoaDTO> buscarTodos() {
		
		List<Pessoa> pessoas = (List<Pessoa>) pRepo.findAll();
		List<PessoaDTO> pdtos = new ArrayList<>();
		for (Pessoa pessoa : pessoas) {
			PessoaDTO pdto = new PessoaDTO();
			pdto.setNome(pessoa.getNome());
			pdto.setCpf(pessoa.getCpf());
			pdto.setEmail(pessoa.getEmail());
			EnderecoDTO edto = new EnderecoDTO();
			Endereco end = pessoa.getEndereco();
			edto.setCep(end.getCep());
			edto.setBairro(end.getBairro());
			edto.setCidade(end.getCidade());
			edto.setComplemento(end.getComplemento());
			edto.setLogradouro(end.getLogradouro());
			edto.setUf(end.getUf());
			edto.setNumero(end.getNumero());
			pdto.setEnderecodto(edto);
			pdtos.add(pdto);
		}
		return pdtos;
	}
	@Override
	public PessoaDTO buscarPorCpf(String cpf) {
		Pessoa pessoa = pRepo.findById(cpf).get();
		PessoaDTO pdto = new PessoaDTO();
		pdto.setNome(pessoa.getNome());
		pdto.setCpf(pessoa.getCpf());
		pdto.setEmail(pessoa.getEmail());
		EnderecoDTO edto = new EnderecoDTO();
		Endereco end = pessoa.getEndereco();
		edto.setCep(end.getCep());
		edto.setBairro(end.getBairro());
		edto.setCidade(end.getCidade());
		edto.setComplemento(end.getComplemento());
		edto.setLogradouro(end.getLogradouro());
		edto.setUf(end.getUf());
		edto.setNumero(end.getNumero());
		pdto.setEnderecodto(edto);
		return pdto;
	}
	@Override
	public void deletar(String cpf) {
		pRepo.deleteById(cpf);
	}
	@Override
	@Transactional
	public void salvar(PessoaDTO pdto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(pdto.getCpf());
		pessoa.setEmail(pdto.getEmail());
		pessoa.setNome(pdto.getNome());
		Endereco end = new Endereco();
		EnderecoDTO edto = pdto.getEnderecodto();
		end.setNumero(edto.getNumero());
		end.setLogradouro(edto.getLogradouro());
		end.setUf(edto.getUf());
		end.setCidade(edto.getCidade());
		end.setLogradouro(edto.getLogradouro());
		end.setBairro(edto.getBairro());
		end.setComplemento(edto.getComplemento());
		end.setCep(edto.getCep());
		pessoa.setEndereco(end);
		pRepo.save(pessoa);
		
	}
}
