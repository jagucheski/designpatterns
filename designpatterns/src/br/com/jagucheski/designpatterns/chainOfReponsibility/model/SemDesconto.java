package br.com.jagucheski.designpatterns.chainOfReponsibility.model;

public class SemDesconto implements Desconto {

    public double desconta(Orcamento orcamento) {
        return 0;
    }

    public void setProximo(Desconto desconto) {
        // nao tem!
    }

}
