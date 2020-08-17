package br.com.stefanini.jpa;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.stefanini.costante.Genero;
import br.com.stefanini.model.Pessoa;
import br.com.stefanini.repository.PessoaRepository;

public class TestaCadastroRepository {

	
	private static final String _123456789 = "123456789";
	private Pessoa pessoa =  new Pessoa(null,"Lucas", Genero.F, "email", new Date(), Calendar.getInstance(), Calendar.getInstance(), "naturalidade", "nacionalidade", _123456789);
	private PessoaRepository  pessoaRepository = new PessoaRepository();

	@Test
	public void salvar() throws Exception {
	    try {
	    	pessoaRepository.salvar(pessoa);
	    	assertTrue(true );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( e.getMessage() );
		}
	    
	}
	
	@Test
	public void atualizar() throws Exception {
	    try {
	    	pessoa = pessoaRepository.buscarPorCPF(_123456789);
	    	pessoa.setNome("Novo Nome");
	    	pessoaRepository.atualizar(pessoa);	    	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( e.getMessage() );
		}
	    
	}
	
	@Test
	public void excluir() throws Exception {
	    try {
	    	pessoa = pessoaRepository.buscarPorCPF(_123456789);
	    	pessoaRepository.excluir(pessoa);
	    	Pessoa pessoa2 = pessoaRepository.buscarPorCPF(_123456789);
	    	System.out.println(pessoa2);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( e.getMessage() );
		}
	    
	}
	
}
