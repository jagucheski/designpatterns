package br.com.jagucheski.designpatterns.chainOfReponsibility.controller;

import br.com.jagucheski.designpatterns.chainOfReponsibility.model.Desconto;
import br.com.jagucheski.designpatterns.chainOfReponsibility.model.DescontoPorMaisDeCincoItens;
import br.com.jagucheski.designpatterns.chainOfReponsibility.model.DescontoPorMaisDeQuinhentosReais;
import br.com.jagucheski.designpatterns.chainOfReponsibility.model.Orcamento;
import br.com.jagucheski.designpatterns.chainOfReponsibility.model.SemDesconto;

public class CalculadorDeDescontos {

	/** 1ª versão
	 * Dado um Orcamento é calcular o valor do desconto conforme regras de negócio.
	 * Uma solução tipicamente procedural é fazer o algoritimo com ifs em sequencia.
	 *  
	public double calcula(Orcamento orcamento) {
		// verifica primeira regra de possível desconto
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		}

		// verifica segunda regra de possível desconto
		else if (orcamento.getValor() > 500.0) {
			return orcamento.getValor() * 0.07;
		}
	
		return orcamento.getValor();
	}
	 * */

	/** 2ª versão
	 * Foram criadas classes para cada tipo de calculo de desconto. 
	 * Cada regra de negócio está em sua respectiva classe. 
	 * O problema é como fazer essa sequência de descontos seja aplicada na ordem, 
	 * pois teremos de colocar mais um if sempre que um novo desconto aparecer.
	 * 
	 *
	public double calcula(Orcamento orcamento) {
        // vai chamando os descontos na ordem até que algum deles dê diferente de zero...
        double desconto = new DescontoPorMaisDeCincoItens().desconta(orcamento);
        if(desconto == 0) 
          desconto = new DescontoPorMaisDeQuinhentosReais().desconta(orcamento);
        if(desconto == 0)
       //Seria interessante fazer com que um desconto qualquer, caso não deva ser executado, automaticamente chame o próximo, até encontrar um desconto que se enquadre 
          desconto = new ProximoDesconto().desconta(orcamento);
        // ...

        return desconto;
      }
	 * */
	
	
	/**
	 * 3ª versão
	 * Foi criado a interface Desconto que possui o atributo proximo e a função calcula;
	 * As classes DescontoPorMaisDeCincoItens e DescontoPorMaisDeQuinhentosReais implementam esta interface,
	 * assim no calculo do desconto, caso não atenda irá chamar a proxima classe.
	 * 
	 * Além disso, temos de ter uma classe que crie este corrente especificando quais os elos da corrente devem ser chamados.
	 * 
	 * Para finalizar é criado uma classe que implementa a interface, porém não chama nenhuma outra classe da corrente,
	 * classe SemDesconto, assim encerrando a corrente.
	 * 
	 */ 
	public double calculaDesconto(Orcamento orcamento) {
		 Desconto d1 = new DescontoPorMaisDeCincoItens();
         Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
         Desconto d3 = new SemDesconto();

         d1.setProximo(d2);
         d2.setProximo(d3);

         return d1.desconta(orcamento);
	}
}
