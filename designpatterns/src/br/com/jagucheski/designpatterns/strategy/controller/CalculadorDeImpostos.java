package br.com.jagucheski.designpatterns.strategy.controller;

import br.com.jagucheski.designpatterns.strategy.model.Imposto;
import br.com.jagucheski.designpatterns.strategy.model.Orcamento;

public class CalculadorDeImpostos {

	/** 1ª versão
	 * Dado um Orcamento temos de calcular o imposto informado.
	 * Porem o calculo do orcamento acabará ficando gigante a medida
	 * que forem sendo acrescentados novos impostos, além de estar cheio de IF's.
	 *  
	public void realizaCalculo(Orcamento orcamento, String imposto) {

		if (imposto.equals("ICMS")) {
			double icms =  orcamento.getValor() * 0.05 + 50;
			System.out.println(icms); 
		}
		if (imposto.equals("ISS")) {
			double iss = orcamento.getValor() * 0.06;
			System.out.println(iss); 
		}
	}
	 * */
	
	
	/** 2ª versão
	 * Foi criado uma classe para cada Imposto com seu respectivo calculo. 
	 * Porem o calculo do orcamento continuará ficando extenso.
	 *  
	public void realizaCalculo(Orcamento orcamento, String imposto) {

		if (imposto.equals("ICMS")) {
			double icms = new ICMS().calculaICMS(orcamento);
			System.out.println(icms); 
		}
		if (imposto.equals("ISS")) {
			double iss = new ISS().calculaISS(orcamento);
			System.out.println(iss); 
		}
	}
	 * */
 

	/**
	 * 3ª versão
	 * Foi separado a realização do calculo em diversas funções de acordo com o imposto, mas continuará com
	 * código extenso a medida que foram sendo inclusos novos impostos. 
	 * 	
	public void realizaCalculoICMS(Orcamento orcamento) {
		double icms = new ICMS().calculaICMS(orcamento);
		System.out.println(icms);
	}

	public void realizaCalculoISS(Orcamento orcamento) {
		double iss = new ISS().calculaISS(orcamento);
		System.out.println(iss);
	}
	 * */

	
	/**
	 * 4ª versão
	 * 
	 * Foi criado a Interface Imposto que possui o metodo cacula(). As classes ICMS
	 * e ISS implementam esta interface, por isso quando o metodo realizaCalculo for
	 * chamado irá chamar o metodo calcula da classe correspondente. 
	 * Dessa forma não será necessário alterar o metodo realizaCalculo para acrescentar novos impostos,
	 * basta criar nova classe que implemente Imposto. 
 	 */
	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		double valor = imposto.calcula(orcamento);
		System.out.println("Orcamento R$: " + orcamento.getValor() + 
						   " [Imposto " + imposto.getClass().getSimpleName() + 
				           " - Valor R$: " + valor + "]");
	}

}
