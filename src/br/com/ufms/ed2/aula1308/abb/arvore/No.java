package br.com.ufms.ed2.aula1308.abb.arvore;

public class No <T> {
    private T valor;
    private No<T> esquerdo;
    private No<T> direito;


    public No() {
        this.valor = null;
        this.esquerdo = null;
        this.direito = null;
    }

    public No(T valor) {
        this.valor = valor;
        this.direito = new No<T>();
        this.esquerdo = new No<T>();
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No<T> esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No<T> getDireito() {
        return direito;
    }

    public void setDireito(No<T> direito) {
        this.direito = direito;
    }
}
