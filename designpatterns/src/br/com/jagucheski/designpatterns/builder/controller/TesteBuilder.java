package br.com.jagucheski.designpatterns.builder.controller;

public class TesteBuilder {

	public static void main(String[] args) {
		
		/**
		 * 1ª versão
		 * Criando o objeto NotaFiscal a partir do Construtor da classe  
		 * 
		 * 
			List<ItemDaNota> itens = Arrays.asList(new ItemDaNota("item 1", 250.2), new ItemDaNota("item 2", 350.2));
	
			double valorTotal = 0;
			for (ItemDaNota item : itens) {
				valorTotal += item.getValor();
			}
			double impostos = valorTotal * 0.05;
	
			//Veja que esse construtor é extenso e difícil de entender. Além do mais, a regra de criação do objeto acabou ficando espalhado pelo código do método
			NotaFiscal nf = new NotaFiscal("razao social qualquer", "um cnpj", LocalDate.now() , valorTotal, impostos, itens, "observacoes quaisquer aqui");
			
		 * */
		
		/**
		 * 2ª versão
		 * Para resolver o problema, é separado a lógica da criação do objeto NotaFiscal. 
		 * Essa nova classe será responsável por pedir todos os parâmetros necessários, montar o que precisa, e enfim produzir uma Nota Fiscal, 
		 * de forma com que o cliente dessa classe consiga entender o que está acontecendo.
		 *
		
		CriadorDeNotaFiscal criador = new CriadorDeNotaFiscal();
		criador.paraEmpresa("razao social qualquer");
		criador.comCnpj("123.456.789/0001-10");
		criador.comItem(new ItemDaNota("item 1", 100.0));
		criador.comItem(new ItemDaNota("item 2", 200.0));
		criador.comItem(new ItemDaNota("item 3", 300.0));
		criador.comObservacoes("entregar nf pessoalmente");
		criador.naDataAtual();

		NotaFiscal nf = criador.constroi();
		
		* */
		
		
		/**
		 * 3ª versão
		 * Para podermos invocar um método atrás do outro basta trocar o retorno de todos os métodos do builder: de void para NotaFiscalBuilder. 
		 * Assim, poderemos chamar o próximo método logo em seguida:
		 *
		 * */
		
		NotaFiscal nf = new CriadorDeNotaFiscal().paraEmpresa("Caelum")
                .comCnpj("123.456.789/0001-10")
                .comItem(new ItemDaNota("item 1", 100.0))
                .comItem(new ItemDaNota("item 2", 200.0))
                .comItem(new ItemDaNota("item 3", 300.0))
                .comObservacoes("entregar nf pessoalmente")
                .naDataAtual()
                .constroi();
		
	}

}
