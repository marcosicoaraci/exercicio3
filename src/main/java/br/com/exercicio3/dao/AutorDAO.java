package br.com.exercicio3.dao;

import br.com.exercicio3.entidades.Autor;
import br.com.exercicio3.entidades.Livro;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by marcos on 25/08/15.
 */
public class AutorDAO extends GenericDAO<Autor> {

    /**
     * lista todos os autores e seus respectivos livros
     */

    public List<Autor> listarTodos(){
        try {
            Query query = getEntityManager().createQuery("select distinct a from Autor a left join fetch a.livroList l order by l.preco desc ");
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public List<Autor> listarTodosNamedQuery(){
        TypedQuery<Autor> q = getEntityManager().createNamedQuery("Autor.findAll",Autor.class);
        try {
            return q.getResultList();
        } catch (NoResultException e ) {
            return null;
        }

    }





}
