package br.com.jagucheski.designpatterns.strategy.model;

public class ICCC implements Imposto {
	
	@Override
	public double calcula(Orcamento orcamento) {
		double valor = 0;

		if (orcamento.getValor() < 1000)
			valor = orcamento.getValor() * 0.05;

		if (orcamento.getValor() >= 1000 && orcamento.getValor() <= 3000)
			valor = orcamento.getValor() * 0.07;

		if (orcamento.getValor() > 3000)
			valor = orcamento.getValor() * 0.08 + 30;

		return valor;
	}
	
}
