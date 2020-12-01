package br.com.jagucheski.designpatterns.builder.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CriadorDeNotaFiscal {

	private String razaoSocial;
	private String cnpj;
	private double valorTotal;
	private double impostos;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	private String observacoes;
	private LocalDate data;

	//retorna CriadorDeNotaFiscal para poder chamar os metodos de forma encadeada
	public CriadorDeNotaFiscal paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	//retorna CriadorDeNotaFiscal para poder chamar os metodos de forma encadeada
	public CriadorDeNotaFiscal comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	//retorna CriadorDeNotaFiscal para poder chamar os metodos de forma encadeada
	public CriadorDeNotaFiscal comItem(ItemDaNota item) {
		todosItens.add(item);
		valorTotal += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}

	//retorna CriadorDeNotaFiscal para poder chamar os metodos de forma encadeada
	public CriadorDeNotaFiscal comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}

	//retorna CriadorDeNotaFiscal para poder chamar os metodos de forma encadeada
	public CriadorDeNotaFiscal naDataAtual() {
		this.data = LocalDate.now();
		return this;
	}
	

    public NotaFiscal constroi() {
      return new NotaFiscal(razaoSocial, cnpj, data, valorTotal, impostos, todosItens, observacoes);
    }


}
