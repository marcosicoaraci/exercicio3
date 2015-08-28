package br.com.exercicio3.util;

import br.com.exercicio3.entidades.Autor;
import br.com.exercicio3.entidades.Livro;
import br.com.exercicio3.service.AutorSrv;
import br.com.exercicio3.service.LivroSrv;

import java.util.ArrayList;

/**
 * Created by marcos on 27/08/15.
 */
public class LivroAutorUtil {

    /**
     * Método responsável por inserir vários Livros e autores
     */

    public void inserirLivros(){
        LivroSrv livroSrv = new LivroSrv();
        AutorSrv autorSrv = new AutorSrv();


        Livro livro1 = new Livro();
        livro1.setNome("Use a Cabeça Java");
        livro1.setPreco(79);
        livroSrv.saveOrUpdate(livro1);

        Livro livro2 = new Livro();
        livro2.setNome("Hary Potter");
        livro2.setPreco(70);
        livroSrv.saveOrUpdate(livro2);

        Livro livro3 = new Livro();
        livro3.setNome("O Guarani");
        livro3.setPreco(88);
        livroSrv.saveOrUpdate(livro3);

        Livro livro4 = new Livro();
        livro4.setNome("Tim Maia Biografia");
        livro4.setPreco(50);
        livroSrv.saveOrUpdate(livro4);

        Livro livro5 = new Livro();
        livro5.setNome("ABussola de Ouro");
        livro5.setPreco(44);
        livroSrv.saveOrUpdate(livro5);

        Livro livro6 = new Livro();
        livro6.setNome("Oragon");
        livro6.setPreco(78);
        livroSrv.saveOrUpdate(livro6);

        Livro livro7 = new Livro();
        livro7.setNome("Dungeons And Dragons");
        livro7.setPreco(33);
        livroSrv.saveOrUpdate(livro7);

        Livro livro8 = new Livro();
        livro8.setNome("Sítio do Pica Pau Amarelo");
        livro8.setPreco(30);
        livroSrv.saveOrUpdate(livro8);

        Livro livro9 = new Livro();
        livro9.setNome("O Doce Veneno do Escorpião");
        livro9.setPreco(100);
        livroSrv.saveOrUpdate(livro9);

        Livro livro10 = new Livro();
        livro10.setNome("Java Como Programar");
        livro10.setPreco(230);
        livroSrv.saveOrUpdate(livro10);

        Autor autor1 = new Autor();
        autor1.setNome("Marcos Roberto ");
        if (autor1.getLivroList() == null) {
            autor1.setLivroList(new ArrayList<Livro>());
        }

        Autor autor2 = new Autor();
        autor2.setNome("Stélio Corrêa ");
        if (autor2.getLivroList() == null) {
            autor2.setLivroList(new ArrayList<Livro>());
        }

        Autor autor3 = new Autor();
        autor3.setNome("Domingos Santos ");
        if (autor3.getLivroList() == null) {
            autor3.setLivroList(new ArrayList<Livro>());
        }

        Autor autor4 = new Autor();
        autor4.setNome("Harvey Deitel ");
        if (autor4.getLivroList() == null) {
            autor4.setLivroList(new ArrayList<Livro>());
        }

        Autor autor5 = new Autor();
        autor5.setNome("Maria da Graça ");
        if (autor5.getLivroList() == null) {
            autor5.setLivroList(new ArrayList<Livro>());
        }

        autor1.getLivroList().add(livro1);
        autor1.getLivroList().add(livro2);

        autor2.getLivroList().add(livro3);
        autor2.getLivroList().add(livro4);

        autor3.getLivroList().add(livro5);
        autor3.getLivroList().add(livro6);

        autor4.getLivroList().add(livro7);
        autor4.getLivroList().add(livro8);

        autor5.getLivroList().add(livro9);
        autor5.getLivroList().add(livro10);

        autorSrv.saveOrUpdate(autor1);
        autorSrv.saveOrUpdate(autor2);
        autorSrv.saveOrUpdate(autor3);
        autorSrv.saveOrUpdate(autor4);
        autorSrv.saveOrUpdate(autor5);

    }

}
