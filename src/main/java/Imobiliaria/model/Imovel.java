package Imobiliaria.model;

import java.math.BigDecimal;

public class Imovel {
	private BigDecimal valorDoImovel,areaDoImovel;
	
	
	public Imovel(BigDecimal areaDoImovel, BigDecimal valorDoImovel) {
		this.areaDoImovel = areaDoImovel;
		this.valorDoImovel = valorDoImovel;
	}
	
	public BigDecimal getAreaDoImovel() {
		return areaDoImovel;
	}

	public void setAreaDoImovel(BigDecimal areaDoImovel) {
		this.areaDoImovel = areaDoImovel;
	}

	public BigDecimal getValorDoImovel() {
		return valorDoImovel;
	}
	public void setValorDoImovel(BigDecimal valorDoImovel) {
		this.valorDoImovel = valorDoImovel;
	}

	@Override
	public String toString() {
		return "Imovel [areaDoImovel=" + areaDoImovel + ", valorDoImovel=" + valorDoImovel + "]";
	}
}