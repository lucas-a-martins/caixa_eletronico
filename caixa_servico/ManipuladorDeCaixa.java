package caixa_servico;

import caixa_eletronico.Caixa;

public class ManipuladorDeCaixa {
	
	public void addNotaDeCem(Caixa caixa, int qtd) {
		int qtdFinal = caixa.getQtdNotaCem() + qtd;
		caixa.setQtdNotaCem(qtdFinal);
		
		int valorAddCaixa = caixa.getValorEmCaixa() + (qtd * 100);
		caixa.setValorEmCaixa(valorAddCaixa);
		
		System.out.printf("%d notas de 100 adicionadas ao caixa!\n", qtd);
		System.out.printf("Quantidade de notas de 100 disponíveis: %d\n", caixa.getQtdNotaCem());
		System.out.printf("Valor atual em caixa: %d\n\n", caixa.getValorEmCaixa());
	}
	
	public void addNotaDeCinquenta(Caixa caixa, int qtd) {
		int qtdFinal = caixa.getQtdNotaCinquenta() + qtd;
		caixa.setQtdNotaCinquenta(qtdFinal);
		
		int valorAddCaixa = caixa.getValorEmCaixa() + (qtd * 50);
		caixa.setValorEmCaixa(valorAddCaixa);
		
		System.out.printf("%d notas de 50 adicionadas ao caixa!\n", qtd);
		System.out.printf("Quantidade de notas de 50 disponíveis: %d\n", caixa.getQtdNotaCinquenta());
		System.out.printf("Valor atual em caixa: %d\n\n", caixa.getValorEmCaixa());
	}
	
	public void addNotaDeVinte(Caixa caixa, int qtd) {
		int qtdFinal = caixa.getQtdNotaVinte() + qtd;
		caixa.setQtdNotaVinte(qtdFinal);
		
		int valorAddCaixa = caixa.getValorEmCaixa() + (qtd * 20);
		caixa.setValorEmCaixa(valorAddCaixa);
		
		System.out.printf("%d notas de 20 adicionadas ao caixa!\n", qtd);
		System.out.printf("Quantidade de notas de 20 disponíveis: %d\n", caixa.getQtdNotaVinte());
		System.out.printf("Valor atual em caixa: %d\n\n", caixa.getValorEmCaixa());
	}
	
	public void addNotaDeDez(Caixa caixa, int qtd) {
		int qtdFinal = caixa.getQtdNotaDez() + qtd;
		caixa.setQtdNotaDez(qtdFinal);
		
		int valorAddCaixa = caixa.getValorEmCaixa() + (qtd * 10);
		caixa.setValorEmCaixa(valorAddCaixa);

		System.out.printf("%d notas de 10 adicionadas ao caixa!\n", qtd);
		System.out.printf("Quantidade de notas de 10 disponíveis: %d\n", caixa.getQtdNotaDez());
		System.out.printf("Valor atual em caixa: %d\n\n", caixa.getValorEmCaixa());
	}
	
	public boolean sacarValor(Caixa caixa, int valorDeSaque) { //Aprovar ou rejeitar o saque de uma determinada quantia
		if (valorDeSaque > caixa.getValorEmCaixa()) {
			System.out.println("Valor indisponível em caixa!");
			System.out.printf("Valor atual em caixa: %d\n\n", caixa.getValorEmCaixa());
		}
		else {
			if (this.selecionarNotas(caixa, valorDeSaque)) {
				int valorEmCaixaAtual = caixa.getValorEmCaixa() - valorDeSaque;
				caixa.setValorEmCaixa(valorEmCaixaAtual);
				System.out.println("Valor sacado com sucesso!");
				System.out.printf("Valor atual em caixa: %d\n\n", caixa.getValorEmCaixa());
			}
		}
		return true;
	}
	
	public boolean selecionarNotas(Caixa caixa, int valorDeSaque) { //Informar quais notas devem ser liberadas para um saque aprovado
		if (valorDeSaque % 10 != 0) {
			System.out.println("Notas indisponíveis, selecione um valor múltiplo de 10!\n");
			return false;
		} else {
			int valor = valorDeSaque;
			int comparador = 0;
			
			while (valor >= 100 && caixa.getQtdNotaCem() > 0) {
				valor = valor - 100;
				comparador += 100;
				int valorAtual = caixa.getQtdNotaCem() - 1;
				caixa.setQtdNotaCem(valorAtual);
			}
			
			while (valor >= 50 && caixa.getQtdNotaCinquenta() > 0) {
				valor = valor - 50;
				comparador += 50;
				int valorAtual = caixa.getQtdNotaCinquenta() -1;
				caixa.setQtdNotaCinquenta(valorAtual);
			}
			
			while (valor >= 20 && caixa.getQtdNotaVinte() > 0) {
				valor = valor - 20;
				comparador += 20;
				int valorAtual = caixa.getQtdNotaVinte() -1;
				caixa.setQtdNotaVinte(valorAtual);
			}
			
			while (valor >= 10 && caixa.getQtdNotaDez() > 0) {
				valor = valor - 10;
				comparador += 10;
				int valorAtual = caixa.getQtdNotaDez() -1;
				caixa.setQtdNotaDez(valorAtual);
			}
			
			if (comparador != valorDeSaque) {
				System.out.println("Notas necessárias para o saque estão indisponíveis!\n");
				return false;
			}
		}
		return true;
	}
}
