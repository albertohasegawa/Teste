package br.com.cast.teste.interfac;

import java.util.List;

import br.com.cast.teste.dto.EnderecoDTO;

public interface InterfaceEnderecoServices {

	public List<EnderecoDTO> buscarTodos();
	public EnderecoDTO buscarPorCep(String cep);
	public void deletar(String cep);
	public void salvar(EnderecoDTO end);
}
