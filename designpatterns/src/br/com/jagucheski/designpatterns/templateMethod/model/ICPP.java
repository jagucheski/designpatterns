package br.com.jagucheski.designpatterns.templateMethod.model;

public class ICPP extends TemplateDeImpostoCondicional {

	/**
	 * 1ª versão
	 * 
	 * Todas as classes de imposto possuem uma estrutura em comum. 
	 * Ambas checam o orçamento para ver se devem cobrar a taxação máxima e, a partir daí, cobram a máxima ou a mínima.
	 *  
	 * Assim, podemos criar uma classe abstrata contendo o algoritmo, como um "molde":
	 * Ver a Classe TemplateDeImpostoCondicional
	
	public double calcula(Orcamento orcamento) {
		if (orcamento.getValor() > 500) {
			return orcamento.getValor() * 0.07;
		} else {
			return orcamento.getValor() * 0.05;
		}
	}
	* */
	
	
	/**
	 * 2ª versão
	 * 
	 * Extendemos a classe TemplateDeImpostoCondicional, 
	 * agora basta escrever apenas os métodos abstratos; 
	 * afinal, o método público que contém o algoritmo já está escrito na classe pai!
	 *  
	 */
	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}	
	
}
