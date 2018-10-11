package br.com.cast.teste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cast.teste.entidade.Pessoa;
@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, String>{

}
