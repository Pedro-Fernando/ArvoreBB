package br.com.ufms.ed2.aula1308.abb.arvore;

public class Abb<T extends Comparable<T>> {

    private No<T> raiz;

    public Abb() {
        this.raiz = null;
    }

    public Abb(No<T> novoNo) {
        this.raiz = novoNo;
    }

    public void inserir(T valor) {
        if (isArvoreVazia()) {
            this.raiz = new No<T>(valor);
        } else {
            No<T> resultadoDaBusca = buscarNo(valor);

            if (resultadoDaBusca.getValor() == null) {
                resultadoDaBusca.setValor(valor);
                resultadoDaBusca.setEsquerdo(new No<T>());
                resultadoDaBusca.setDireito(new No<T>());
            }
        }
    }

    public void remover(T valor) {
        No<T> resultadoDaBusca = buscarNo(valor);

        if (resultadoDaBusca == null || resultadoDaBusca.getValor() == null) {
            return;
        }

        switch (numeroDeFilhos(resultadoDaBusca)) {
            case 0:
                mataNo(resultadoDaBusca);
                break;

            case -1:
                resultadoDaBusca.setValor(resultadoDaBusca.getEsquerdo().getValor());
                resultadoDaBusca.setDireito(resultadoDaBusca.getEsquerdo().getDireito());
                resultadoDaBusca.setEsquerdo(resultadoDaBusca.getEsquerdo().getEsquerdo());
                break;

            case 1:
                resultadoDaBusca.setValor(resultadoDaBusca.getDireito().getValor());
                resultadoDaBusca.setEsquerdo(resultadoDaBusca.getDireito().getEsquerdo());
                resultadoDaBusca.setDireito(resultadoDaBusca.getDireito().getDireito());
                break;

            case 2:
                No<T> subArvoreDaDireita = menorDireita(resultadoDaBusca);
                T removido = subArvoreDaDireita.getValor();
                remover(subArvoreDaDireita.getValor());
                resultadoDaBusca.setValor(removido);
                break;
        }
    }

    public void altura(T valor) {
        No<T> resultadoDaBusca = buscarNo(valor);

        if (resultadoDaBusca != null) {
            System.out.println(altura(resultadoDaBusca));
        } else {
            System.out.println("Erro!!!");
        }
    }

    private int altura(No<T> No) {
        if (No.getValor() == null || (No.getEsquerdo().getValor() == null && No.getDireito().getValor() == null))
            return 1;
        else {
            if (altura(No.getEsquerdo()) > altura(No.getDireito()))
                return (1 + altura(No.getEsquerdo()));
            else
                return (1 + altura(No.getDireito()));
        }
    }

    public void nivel(T valor) {
        No<T> resultadoDaBusca = buscarNo(valor);

        if (resultadoDaBusca != null) {
            No<T> ponteiro = this.raiz;
            System.out.println(nivel(ponteiro, resultadoDaBusca));
        } else {
            System.out.println("Erro!!!");
        }
    }

    private int nivel(No<T> ponteiro, No<T> noBuscado) {

        if (noBuscado.getValor() == ponteiro.getValor())
            return 0;
        else {
            if (valorBuscadoMenorQueValorDoPonteiro(ponteiro, noBuscado.getValor())) {
                return (1 + nivel(ponteiro.getEsquerdo(), noBuscado));
            } else {
                return (1 + nivel(ponteiro.getDireito(), noBuscado));
            }

        }
    }

    private No<T> menorDireita(No<T> ponteiro) {
        ponteiro = ponteiro.getDireito();

        while (ponteiro.getEsquerdo().getValor() != null) {
            ponteiro = ponteiro.getEsquerdo();
        }

        return ponteiro;
    }

    private void mataNo(No<T> ponteiro) {
        ponteiro.setValor(null);
        ponteiro.setDireito(null);
        ponteiro.setEsquerdo(null);
    }

    private int numeroDeFilhos(No<T> ponteiro) {
        int aux = 0;
        if (ponteiro.getEsquerdo().getValor() != null) {
            aux = -1;
        }
        if (ponteiro.getDireito().getValor() != null) {
            aux = aux * (-1) + 1;
        }
        return aux;
    }

    private No<T> buscarNo(T valor) {
        if (isArvoreVazia()) {
            return null;
        }

        No<T> ponteiro = this.raiz;

        while (valorNaoEncontrado(ponteiro, valor)) {
            if (valorBuscadoMaiorQueValorDoPonteiro(ponteiro, valor)) {
                ponteiro = ponteiro.getDireito();
            } else if (valorBuscadoMenorQueValorDoPonteiro(ponteiro, valor)) {
                ponteiro = ponteiro.getEsquerdo();
            }
        }

        return ponteiro;
    }

    private boolean isArvoreVazia() {
        return this.raiz == null;
    }


    private boolean valorBuscadoMenorQueValorDoPonteiro(No<T> ponteiro, T valor) {
        return valor.compareTo(ponteiro.getValor()) < 0;
    }

    private boolean valorBuscadoMaiorQueValorDoPonteiro(No<T> ponteiro, T valor) {
        return valor.compareTo(ponteiro.getValor()) > 0;
    }

    private boolean valorNaoEncontrado(No<T> ponteiro, T valor) {
        return ponteiro.getValor() != null && !ponteiro.getValor().equals(valor);
    }

    public void imprimirArvore() {
        imprimeEmOrdem(this.raiz);
        separadorDaImpressao();
    }

    private void separadorDaImpressao() {
        System.out.println();
    }

    private void imprimeEmOrdem(No<T> no) {

        if (no.getEsquerdo() == null) return;
        if (no.getDireito() == null) return;

        imprimeEmOrdem(no.getEsquerdo());
        System.out.print(no.getValor() + " ");
        imprimeEmOrdem(no.getDireito());
    }

}
