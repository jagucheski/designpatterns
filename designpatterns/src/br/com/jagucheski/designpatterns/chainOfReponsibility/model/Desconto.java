package br.com.jagucheski.designpatterns.chainOfReponsibility.model;

public interface Desconto {

	 double desconta(Orcamento orcamento);
     void setProximo(Desconto proximo);
}
