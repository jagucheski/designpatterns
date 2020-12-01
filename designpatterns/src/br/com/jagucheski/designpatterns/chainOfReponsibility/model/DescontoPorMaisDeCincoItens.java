package br.com.jagucheski.designpatterns.chainOfReponsibility.model;

public class DescontoPorMaisDeCincoItens implements Desconto {

//  1ª versao
//	public double desconta(Orcamento orcamento) {
//		if (orcamento.getItens().size() > 5) {
//			return orcamento.getValor() * 0.1;
//		} else {
//			return 0;
//		}
//	}

	//usado para chamar o próximo desconto caso este não se enquadre
	private Desconto proximo;

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

	public double desconta(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		} else {
			return proximo.desconta(orcamento);
		}
	}

}
