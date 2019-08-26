package br.com.ufms.ed2.aula1308.abb.main;

import br.com.ufms.ed2.aula1308.abb.arvore.Abb;
import br.com.ufms.ed2.aula1308.abb.arvore.No;

import java.io.IOException;

public class Main<T extends Comparable<T>> {

    public static void main(String[] args) throws IOException {

//        Abb<Integer> arvore = new Abb<Integer>(new No<Integer>(47));
//
//        arvore.inserir(30);
//        arvore.inserir(20);
//        arvore.inserir(43);
//        arvore.inserir(100);
//        arvore.inserir(200);
//        arvore.inserir(45);
//        arvore.inserir(150);
//        arvore.inserir(130);
//        arvore.inserir(44);
//        arvore.inserir(46);
//        arvore.inserir(156);
//
//        arvore.imprimirArvore();
//
//        arvore.remover(20);
//        arvore.imprimirArvore();
//
//        arvore.remover(200);
//        arvore.imprimirArvore();

        Abb<Integer> arvore = new Abb<Integer>(new No<Integer>(34));

        arvore.inserir(3);
        arvore.inserir(50);
        arvore.inserir(23);
        arvore.inserir(1);
        arvore.imprimirArvore();

        arvore.remover(34);
        arvore.imprimirArvore();

        arvore.inserir(100);
        arvore.inserir(90);
        arvore.imprimirArvore();

        arvore.remover(100);
        arvore.imprimirArvore();

        arvore.inserir(100);
        arvore.imprimirArvore();

        arvore.remover(90);
        arvore.imprimirArvore();

        arvore.remover(23);
        arvore.imprimirArvore();

        arvore.inserir(30);
        arvore.imprimirArvore();

        arvore.remover(3);
        arvore.imprimirArvore();

        arvore.altura(30);
        arvore.altura(50);
        arvore.altura(100);

        arvore.nivel(100);
        arvore.nivel(50);
        arvore.nivel(1);
    }

    private static boolean isdoisValores(String[] linha) {
        return linha.length == 2;
    }
}
