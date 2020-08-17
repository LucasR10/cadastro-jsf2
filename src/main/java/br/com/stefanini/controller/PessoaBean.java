package br.com.stefanini.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.stefanini.costante.Genero;
import br.com.stefanini.dto.EstadoDTO;
import br.com.stefanini.model.Pessoa;
import br.com.stefanini.service.PessoaService;
import br.com.stefanini.ws.EstadoClient;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Genero generoSelecionado;
	private Pessoa pessoa = new Pessoa();
	private EstadoDTO estadoSelecionado = new EstadoDTO();
	private PessoaService pessoaService = new PessoaService();
    private List<Pessoa> pessoas;
    
	private Genero[] generos;
	private List<EstadoDTO> estados;

	public PessoaBean() {
		generos = Genero.values();
		estados = EstadoClient.listarEstados();
	}

	public void salvar() {
		pessoa.setSexo( generoSelecionado );
		pessoa.setNaturalidade( estadoSelecionado.getSigla() );
		pessoaService.salvar(this.pessoa);
		this.pessoa = new Pessoa();
	}

	public void excluir(Long id) {
		pessoaService.excluir( new Pessoa(id) );
	}
	
	public void  editar(Pessoa p) {
		this.pessoa = p;
	}
	
	public void limpar() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Genero[] getGeneros() {
		return generos;
	}

	public Genero getGeneroSelecionado() {
		return generoSelecionado;
	}

	public void setGeneroSelecionado(Genero generoSelecionado) {
		this.generoSelecionado = generoSelecionado;
	}

	public List<EstadoDTO> getEstados() {
		return estados;
	}

	public EstadoDTO getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(EstadoDTO estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}
	
	public List<Pessoa> getPessoas() {
		if( pessoas == null ) {
			return pessoaService.listarTodos();
		}
		return pessoas;
	}
}
