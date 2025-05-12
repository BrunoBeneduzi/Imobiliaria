package Imobiliaria.model;

import java.math.BigDecimal;

public class Terreno extends Imovel{
	private String tipoImovel;
	
	public Terreno(BigDecimal areaDoImovel, BigDecimal valorDoImovel) {
		super(areaDoImovel, valorDoImovel);
		this.tipoImovel = "TERRENO";
	}

	
	public String getTipoImovel() {
		return tipoImovel;
	}


	@Override
	public String toString() {
		return "Terreno [tipoImovel=" + tipoImovel + "]";
	}
}