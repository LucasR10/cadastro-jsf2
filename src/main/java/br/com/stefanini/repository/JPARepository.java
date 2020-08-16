package br.com.stefanini.repository;

import java.util.List;

public interface JPARepository<T, K> {

	
	List<T> listarTodos()  throws Exception ;
	T buscarPorId( K id)  throws Exception ;
    void salvar( T entity)  throws Exception ;
    T  atualizar( T entity)  throws Exception ;
    void excluir( T entity)  throws Exception ;
}
