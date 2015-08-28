package br.com.exercicio3.service;

import br.com.exercicio3.dao.LivroDAO;
import br.com.exercicio3.entidades.Autor;
import br.com.exercicio3.entidades.Livro;

import java.util.List;

/**
 * Created by marcos on 25/08/15.
 */
public class LivroSrv {

    private LivroDAO livroDAO = new LivroDAO();

    public void saveOrUpdate(Livro livro){
        if (livro.getId() == null) {
            if (salvar(livro)) {
                System.out.println("Salvou Livro");
            }else{
                System.out.println("Erro ao salvar livro");
            }
        }else{
            if (editar(livro)) {
                System.out.println("Editou livro");
            }else{
                System.out.println("Erro ao editar livro");
            }
        }
    }


    public boolean salvar(Livro livro){
        return livroDAO.criar(livro);
    }

    public boolean editar(Livro livro){
        return livroDAO.alterar(livro);
    }

    public Livro obter(Integer id){
        return livroDAO.obter(Livro.class, id);
    }

    public List<Livro> obterTodos(){
        return livroDAO.obterTodos(Livro.class);
    }

    public List<Livro> obterTodosMinNamedQuery(Double preco){
        return livroDAO.listarporMinPrecoNamedQuery(preco);
    }
    public List<Livro> listaDecrescente(){
        return livroDAO.listarDecrescente();
    }

    public List<Livro> obterTodosTypedQuery(Integer minResult, Integer maxResult){
        return livroDAO.listarTodosNamedQuery(minResult, maxResult);
    }

    public Double obterMinLivro(){
        return livroDAO.minLivro();
    }

    public Double obterMaxLivro(){
        return livroDAO.maxLivro();
    }

    public Double mediaLivros(){
        return livroDAO.mediaLivros();
    }

    public Double minLivroAutor(Autor autor){
        return livroDAO.minLivroAutor(autor);
    }

    public List<Autor> autorComMaisLivros(){
        return livroDAO.listarAutorComMaisLivros();
    }

    public Livro obterLivroMinPreco(Autor autor){
        return livroDAO.menorPrecoLivroAutor(autor);
    }



}
