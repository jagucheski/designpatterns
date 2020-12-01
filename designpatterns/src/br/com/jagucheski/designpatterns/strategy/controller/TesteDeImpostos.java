package br.com.jagucheski.designpatterns.strategy.controller;

import br.com.jagucheski.designpatterns.strategy.model.ICCC;
import br.com.jagucheski.designpatterns.strategy.model.ICMS;
import br.com.jagucheski.designpatterns.strategy.model.ISS;
import br.com.jagucheski.designpatterns.strategy.model.Orcamento;

public class TesteDeImpostos {

	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(5000.0);
		ICMS icms = new ICMS();
		ISS iss = new ISS();
		ICCC iccc = new ICCC();
		
		
		CalculadorDeImpostos calculadora = new CalculadorDeImpostos();
		
		calculadora.realizaCalculo(orcamento, icms );
		calculadora.realizaCalculo(orcamento, iss );
		calculadora.realizaCalculo(orcamento, iccc );
	}
	
	
}
