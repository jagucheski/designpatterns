package br.com.jagucheski.designpatterns.strategy.model;

public class ICMS implements Imposto{

	public double calculaICMS(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + 50;
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + 50;
	}
}
