package br.com.jagucheski.designpatterns.chainOfReponsibility.model;

public class DescontoPorMaisDeQuinhentosReais implements Desconto {

//  1ª versao	
//	public double desconta(Orcamento orcamento) {
//		if (orcamento.getValor() > 500) {
//			return orcamento.getValor() * 0.07;
//		} else {
//			return 0;
//		}
//	}

	// usado para chamar o próximo desconto caso este não se enquadre
	private Desconto proximo;

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

	public double desconta(Orcamento orcamento) {
		if (orcamento.getValor() > 500) {
			return orcamento.getValor() * 0.07;
		} else {
			return proximo.desconta(orcamento);
		}
	}
}
