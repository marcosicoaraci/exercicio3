package br.com.exercicio3.main;


import br.com.exercicio3.entidades.Autor;
import br.com.exercicio3.entidades.Livro;
import br.com.exercicio3.service.AutorSrv;
import br.com.exercicio3.service.LivroSrv;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by marcos on 25/08/15.
 */
public class TesteLivro {


    public static void main (String[] args){


        LivroSrv livroSrv = new LivroSrv();
        AutorSrv autorSrv = new AutorSrv();

        /**
         * lista todos os autores e seus respectivos livros
         * Também atende ao item "Crie uma única consulta para obter todos os autores e seus
         respectivos livros "
         */
        List<Autor> listaTodosAutoresElivros = autorSrv.listarTodos();
        for (Autor autor1 : listaTodosAutoresElivros) {
            for (Livro livro1 : autor1.getLivroList()) {
                System.out.println("Autor: "+ autor1.getNome()+
                        "\nLivro: "+livro1.getNome()+" " +
                        "\nPreço R$: "+livro1.getPreco() +
                        "\n---------------------");
            }
        }

        /**
         * lista todos os autores e seus respectivos livros
         * usando uma NamedQuery
         * Também atende ao item "Teste o recurso da Typed Querie utilizando a Named
         *  Querie de Autor"
         */
        List<Autor> listaTodosNamedQUery = autorSrv.listarTodosNamedQuery();
        for (Autor autor1 : listaTodosNamedQUery) {
            System.out.println("Autor: "+ autor1.getNome()+
                    "\n---------------------");

        }

        /**
         * lista todos os Livros a partir de um preco mínimo
         * usando uma NamedQuery
         */
        List<Livro> todosMinNamedQuery = livroSrv.obterTodosMinNamedQuery(70.0);
        for (Livro livro1 : todosMinNamedQuery) {
            System.out.println("Livro: "+livro1.getNome()+
                    "\nPreço R$: "+livro1.getPreco() +
                    "\n---------------------");
        }

        /**
         * lista o nome de todos os Livros
         * usando TypedQuery, o metodo tbm está paginado
         */
        List<Livro> todosTypedQuery = livroSrv.obterTodosTypedQuery(1,8);
        for (Livro livro1 : todosTypedQuery) {
            System.out.println("Livro: "+livro1.getNome()+
                    "\n---------------------");
        }

        /**
         * Retorna a média de preço dos livros cadastrados
         */
        Double mediaLivro = livroSrv.mediaLivros();
        System.out.println(new DecimalFormat("0.00").format(mediaLivro));


        /**
         * Lista todos os livros com os precos na ordem decrescente
         */
        List<Livro> listaOrdemPreco = livroSrv.listaDecrescente();
        for (Livro livro1 : listaOrdemPreco) {
            System.out.println(
                    "Livro: "+livro1.getNome()+" " +
                    "\nPreço R$: "+livro1.getPreco() +
                    "\n---------------------");
        }


        /**
         * Retorna o Livro mais barato de um autor
         */
        Autor umAutor = autorSrv.obter(1);
        Livro maisBarato = livroSrv.obterLivroMinPreco(umAutor);
        System.out.println(maisBarato.getNome()+ "\n"+maisBarato.getPreco());


        /**
         * Lista todos os autores e os livros mais barato de cada um
         */
        List<Autor> listaMaisBarato = autorSrv.listarTodos();
        for (Autor autor1 : listaMaisBarato) {
            Livro livroTemp = livroSrv.obterLivroMinPreco(autor1);
                System.out.println("Autor: "+ autor1.getNome()+
                        "\nLivro: "+livroTemp.getNome()+" " +
                        "\nPreço R$: "+livroTemp.getPreco() +
                        "\n---------------------");

        }

        /**
         * Lista os autores com mais livros
         */
        List<Autor> listaAutorMaisLivros = livroSrv.autorComMaisLivros();
        for (Autor autor1 : listaAutorMaisLivros) {
            for (Livro livro1 : autor1.getLivroList()) {
                System.out.println("Autor: "+ autor1.getNome()+
                        "\nLivro: "+livro1.getNome()+" " +
                        "\nPreço R$: "+livro1.getPreco() +
                        "\n---------------------");
            }
        }


    }
}
