package caixa_eletronico;

public class Caixa {

	private int valorEmCaixa;
	private int qtdNotaDez;
	private int qtdNotaVinte;
	private int qtdNotaCinquenta;
	private int qtdNotaCem;
	
	public Caixa(int qtdNotaDez, int qtdNotaVinte, int qtdNotaCinquenta, int qtdNotaCem) {
		super();
		this.valorEmCaixa = (qtdNotaDez * 10) + (qtdNotaVinte * 20) + (qtdNotaCinquenta * 50) + (qtdNotaCem * 100);
		this.qtdNotaDez = qtdNotaDez;
		this.qtdNotaVinte = qtdNotaVinte;
		this.qtdNotaCinquenta = qtdNotaCinquenta;
		this.qtdNotaCem = qtdNotaCem;
	}

	public int getValorEmCaixa() {
		return valorEmCaixa;
	}

	public void setValorEmCaixa(int valorEmCaixa) {
		this.valorEmCaixa = valorEmCaixa;
	}

	public int getQtdNotaDez() {
		return qtdNotaDez;
	}

	public void setQtdNotaDez(int qtdNotaDez) {
		this.qtdNotaDez = qtdNotaDez;
	}

	public int getQtdNotaVinte() {
		return qtdNotaVinte;
	}

	public void setQtdNotaVinte(int qtdNotaVinte) {
		this.qtdNotaVinte = qtdNotaVinte;
	}

	public int getQtdNotaCinquenta() {
		return qtdNotaCinquenta;
	}

	public void setQtdNotaCinquenta(int qtdNotaCinquenta) {
		this.qtdNotaCinquenta = qtdNotaCinquenta;
	}

	public int getQtdNotaCem() {
		return qtdNotaCem;
	}

	public void setQtdNotaCem(int qtdNotaCem) {
		this.qtdNotaCem = qtdNotaCem;
	}
	
	
}
