package Imobiliaria.model;

import java.math.BigDecimal;

public class Apartamento extends Imovel{
	private String tipoImovel;
	private int totalDeComodos;
	private String SalaoDeFestas;
	
	public Apartamento(BigDecimal areaDoImovel, BigDecimal valorDoImovel, int totalDeComodo, String salaoDeFestas) {
		super(areaDoImovel, valorDoImovel);
		this.SalaoDeFestas = salaoDeFestas;
		this.totalDeComodos = totalDeComodo;
		this.tipoImovel = "APARTAMENTO";
	}
	
	public int getTotalDeComodos() {
		return totalDeComodos;
	}
	
	public void setTotalDeComodos(int totalDeComodos) {
		this.totalDeComodos = totalDeComodos;
	}
	
	
	public String getSalaoDeFestas() {
		return SalaoDeFestas;
	}

	public void setSalaoDeFestas(String salaoDeFestas) {
		SalaoDeFestas = salaoDeFestas;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	@Override
	public String toString() {
		return "Apartamento [totalDeComodos=" + totalDeComodos + ", SalaoDeFestas=" + SalaoDeFestas + "]";
	}
}