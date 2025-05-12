package Imobiliaria.model;

import java.math.BigDecimal;

public class Casa extends Imovel{
	private String tipoImovel;
	private int totalDeComodos;
	private BigDecimal areaDoTerreno;
	
	
	public Casa(BigDecimal areaDoImovel, BigDecimal valorDoImovel, int totalDeComodos, BigDecimal areaDoTerreno) {
		super(areaDoImovel, valorDoImovel);
		this.totalDeComodos = totalDeComodos;
		this.areaDoTerreno = areaDoTerreno;
		this.tipoImovel = "CASA";
	}
	
	public int getTotalDeComodos() {
		return totalDeComodos;
	}
	public void setTotalDeComodos(int totalDeComodos) {
		this.totalDeComodos = totalDeComodos;
	}
	

	public BigDecimal getAreaDoTerreno() {
		return areaDoTerreno;
	}

	public void setAreaDoTerreno(BigDecimal areaDoTerreno) {
		this.areaDoTerreno = areaDoTerreno;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	@Override
	public String toString() {
		return "Casa [totalDeComodos=" + totalDeComodos + ", areaDoTerreno=" + areaDoTerreno + "]";
	}
}