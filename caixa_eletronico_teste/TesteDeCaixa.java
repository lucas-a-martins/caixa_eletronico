package caixa_eletronico_teste;

import org.junit.Test;
import org.junit.Assert;
import caixa_eletronico.Caixa;
import caixa_servico.ManipuladorDeCaixa;


public class TesteDeCaixa {
	
	@Test
	public void conseguiuAdicionarNotasDeDez() { //Registrar o abastecimento de notas de 10
		//cenário
		Caixa caixa = new Caixa(3,2,7,5); //920 reais em caixa, 3 notas de 10, 2 notas de 20, 7 nota de 50 e 4 nota de 100
		int qtdAdicionada = 5;
		int notasDeDezAnteriores = caixa.getQtdNotaDez();
		int valorEmCaixaAnterior = caixa.getValorEmCaixa();
		
		//ação
		ManipuladorDeCaixa manipulador = new ManipuladorDeCaixa();
		manipulador.addNotaDeDez(caixa, qtdAdicionada);
		
		//validação
		//valor esperado: true
		Assert.assertTrue(caixa.getQtdNotaDez() > notasDeDezAnteriores);
		Assert.assertTrue(caixa.getValorEmCaixa() > valorEmCaixaAnterior);
	}
	
	@Test
	public void conseguiuAdicionarNotasDeVinte() { //Registrar o abastecimento de notas de 20
		//cenário
		Caixa caixa = new Caixa(3,2,7,4); //820 reais em caixa, 3 notas de 10, 2 notas de 20, 7 nota de 50 e 4 nota de 100
		int qtdAdicionada = 0;
		int notasDeVinteAnteriores = caixa.getQtdNotaVinte();
		int valorEmCaixaAnterior = caixa.getValorEmCaixa();
		
		//ação
		ManipuladorDeCaixa manipulador = new ManipuladorDeCaixa();
		manipulador.addNotaDeVinte(caixa, qtdAdicionada);
		
		//validação
		//valor esperado: false
		Assert.assertFalse(caixa.getQtdNotaVinte() > notasDeVinteAnteriores);
		Assert.assertFalse(caixa.getValorEmCaixa() > valorEmCaixaAnterior);
	}
	
	@Test
	public void conseguiuAdicionarNotasDeCinquenta() { //Registrar o abastecimento de notas de 50
		//cenário
		Caixa caixa = new Caixa(3,2,7,4); //820 reais em caixa, 3 notas de 10, 2 notas de 20, 7 nota de 50 e 4 nota de 100
		int qtdAdicionada = 6;
		int notasDeCinquentaAnteriores = caixa.getQtdNotaCinquenta();
		int valorEmCaixaAnterior = caixa.getValorEmCaixa();
		
		//ação
		ManipuladorDeCaixa manipulador = new ManipuladorDeCaixa();
		manipulador.addNotaDeCinquenta(caixa, qtdAdicionada);
		
		//validação
		//valor esperado: true
		Assert.assertTrue(caixa.getQtdNotaCinquenta() > notasDeCinquentaAnteriores);
		Assert.assertTrue(caixa.getValorEmCaixa() > valorEmCaixaAnterior);	
	}
	
	@Test
	public void conseguiuAdicionarNotasDeCem() { //Registrar o abastecimento de notas de 100
		//cenário
		Caixa caixa = new Caixa(3,2,7,4); //820 reais em caixa, 3 notas de 10, 2 notas de 20, 7 nota de 50 e 4 nota de 100
		int qtdAdicionada = 7;
		int notasDeCemAnteriores = caixa.getQtdNotaCem();
		int valorEmCaixaAnterior = caixa.getValorEmCaixa();
		
		//ação
		ManipuladorDeCaixa manipulador = new ManipuladorDeCaixa();
		manipulador.addNotaDeCem(caixa, qtdAdicionada);
		
		//validação
		//valor esperado: true
		Assert.assertTrue(caixa.getQtdNotaCem() > notasDeCemAnteriores);
		Assert.assertTrue(caixa.getValorEmCaixa() > valorEmCaixaAnterior);
	}
	
	@Test
	public void PossuiNotasNecessarias() { //O saque deve ser rejeitado caso não existam notas que permitam completar a quantia solicitada
		//cenário
		Caixa caixa = new Caixa(3,0,8,4); //830 reais em caixa, 3 notas de 10, 0 notas de 20, 8 nota de 50 e 4 nota de 100
		int tentativaDeSaque = 790;
		
		//ação
		ManipuladorDeCaixa manipulador = new ManipuladorDeCaixa();
		
		//validação
		//valor esperado: false
		Assert.assertFalse(manipulador.selecionarNotas(caixa, tentativaDeSaque));
	}
	
	@Test
	public void PossuiValorEmCaixa() { //O saque deve ser rejeitado caso a quantia solicitada for maior que a quantia existente em caixa
		//cenário
		Caixa caixa = new Caixa(3,2,7,4); //820 reais em caixa, 3 notas de 10, 2 notas de 20, 7 nota de 50 e 4 nota de 100
		int tentativaDeSaque = 790;
		
		//ação
		ManipuladorDeCaixa manipulador = new ManipuladorDeCaixa();
		
		//validação
		//valor esperado: true
		Assert.assertTrue(manipulador.sacarValor(caixa, tentativaDeSaque));
	}
	
	
}