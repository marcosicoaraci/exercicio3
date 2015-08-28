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
public class LivroDAO extends GenericDAO<Livro> {

    public List<Livro> listarDecrescente(){
        Query q = getEntityManager()
                .createNamedQuery("Livro.findAll");
        try {
            return q.getResultList();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Livro> listarporMinPrecoNamedQuery(Double preco){
        Query q = getEntityManager()
                .createNamedQuery("Livro.findAllPreco").setParameter("preco",preco);
        try {
            return q.getResultList();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public Double minLivro(){
        Query q = getEntityManager()
                .createQuery("SELECT MIN ( livro.preco ) FROM Livro livro");
        try {
            return (Double) q.getSingleResult();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public Double minLivroAutor(Autor autor){
        Query q = getEntityManager()
                .createQuery("SELECT MIN ( l.preco ) FROM Autor a JOIN a.livroList l WHERE a = :autor").setParameter("autor", autor);
        try {
            return (Double) q.getSingleResult();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public Double maxLivro(){
        Query q = getEntityManager()
                .createQuery("SELECT MAX ( livro.preco ) FROM Livro livro");
        try {
            return (Double) q.getSingleResult();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Livro> listarTodosNamedQuery(Integer minResult, Integer maxResult){
        TypedQuery<Livro> q = getEntityManager().createQuery("SELECT l FROM Livro l", Livro.class);
        if (minResult != null) {
            q.setFirstResult(minResult);
        }
        if (maxResult != null) {
            q.setMaxResults(maxResult);
        }
        try {
            List<Livro> resposta = q.getResultList();
            return resposta;
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public Double mediaLivros(){
        Query q = getEntityManager().createQuery("SELECT AVG ( livro.preco ) FROM Livro livro");
        try {
            return (Double) q.getSingleResult();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public Double mediaLivros(Autor autor){
        Query q = getEntityManager()
                .createQuery("SELECT AVG ( l.preco ) FROM Autor a JOIN a.livroList l where a = :autor").setParameter("autor", autor);
        try {
            Double resposta = (Double) q.getSingleResult();
            return Math.ceil(resposta);
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public Double maxLivros(Autor autor){
        Query q = getEntityManager()
                .createQuery("SELECT MAX ( l.preco ) FROM Autor a JOIN a.livroList l where a = :autor").setParameter("autor", autor);
        try {
            return (Double) q.getSingleResult();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Autor> listarAutorComMaisLivros(){
        Query q = getEntityManager()
                .createQuery("SELECT distinct a FROM Autor a JOIN " +
                        "a.livroList l where exists (SELECT MAX (livro) FROM Autor autor JOIN autor.livroList livro )");
        try {
            return q.getResultList();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }

    public Livro menorPrecoLivroAutor(Autor autor){
        Query q = getEntityManager()
                .createQuery("SELECT livro FROM Autor a JOIN a.livroList livro WHERE livro.preco = " +
                        " (SELECT MIN (livro.preco) " +
                        "FROM Autor autor JOIN autor.livroList livro WHERE autor = :autor) AND " +
                        "a = :autor")
                .setParameter("autor", autor);
        try {
            return (Livro) q.getSingleResult();
        } catch (NoResultException e ) {
            e.printStackTrace();
            return null;
        }

    }




}
