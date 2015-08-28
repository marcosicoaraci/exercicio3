package br.com.exercicio3.service;

import br.com.exercicio3.dao.AutorDAO;
import br.com.exercicio3.dao.LivroDAO;
import br.com.exercicio3.entidades.Autor;
import br.com.exercicio3.entidades.Livro;

import java.util.List;

/**
 * Created by marcos on 25/08/15.
 */
public class AutorSrv {

    private AutorDAO autorDAO = new AutorDAO();

    public void saveOrUpdate(Autor autor){
        if (autor.getId() == null) {
            if (salvar(autor)) {
                System.out.println("Salvou Autor");
            }else{
                System.out.println("Deu erro ao salvar");
            }
        }else{
            if (editar(autor)) {
                System.out.println("Editou autor");
            }else{
                System.out.println("Deu erro ao editar");
            }
        }
    }

    public boolean salvar(Autor autor){
       return autorDAO.criar(autor);
    }

    public boolean editar(Autor autor){
        return autorDAO.alterar(autor);
    }

    public Autor obter(Integer id){
        return autorDAO.obter(Autor.class, id);
    }

    public List<Autor> listarTodos(){
        return autorDAO.listarTodos();
    }

    public List<Autor> listarTodosNamedQuery(){
        return autorDAO.listarTodosNamedQuery();
    }



}
