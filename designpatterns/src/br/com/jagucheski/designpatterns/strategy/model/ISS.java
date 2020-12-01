package br.com.jagucheski.designpatterns.strategy.model;

public class ISS implements Imposto {
	
	public double calculaISS(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}
	
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}
}
