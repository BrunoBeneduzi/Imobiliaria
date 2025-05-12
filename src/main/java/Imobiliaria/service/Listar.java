package Imobiliaria.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import Imobiliaria.model.Apartamento;
import Imobiliaria.model.Casa;
import Imobiliaria.model.Imovel;
import Imobiliaria.model.Terreno;
import Imobiliaria.repository.ImobiliariaRepository;

public class Listar {
	private ImobiliariaRepository listaImoveis = new ImobiliariaRepository();
	
	public void exibirTodosOsImoveisMenu() {
		for(Imovel imoveis : listaImoveis.getListaDeImoveis()) {
			
			if(imoveis instanceof Casa) {
				Casa casa = (Casa) imoveis;
				this.exibeApenasCasas(casa);
				
			}else if(imoveis instanceof Apartamento) {
				Apartamento apartamento = (Apartamento) imoveis;
				this.exibeApenasApartamento(apartamento);
				
			}else if(imoveis instanceof Terreno) {
				Terreno terreno = (Terreno) imoveis;
				this.exibeApenasTerreno(terreno);
			}
		}
	}
	
	public void exibeApenasCasasMenu() {
		for(Imovel imoveis : listaImoveis.getListaDeImoveis()) {
			if(imoveis instanceof Casa) {
				Casa casa = (Casa) imoveis;
				this.exibeApenasCasas(casa);
			}
		}
	}
	
	public void exibeApenasApartamentoMenu() {
		for(Imovel imoveis : listaImoveis.getListaDeImoveis()) {
			if(imoveis instanceof Apartamento) {
				Apartamento apartamento = (Apartamento) imoveis;
				this.exibeApenasApartamento(apartamento);
			}
		}
	}
	
	public void exibeApenasTerrenoMenu() {
		for(Imovel imoveis : listaImoveis.getListaDeImoveis()) {
			if(imoveis instanceof Terreno) {
				Terreno terreno = (Terreno) imoveis;
				this.exibeApenasTerreno(terreno);
			}
		}
	}
	
	private void exibeApenasCasas(Casa casa) {
		System.out.println(casa.getTipoImovel()+": Área do imovel: "+this.formataAreaImovelEterreno(casa.getAreaDoImovel())+" - Valor do imovel: "+this.formataParaDinheiroReal(casa.getValorDoImovel())
		+" - Cômodos: "+casa.getTotalDeComodos()+" - Área do Terreno: "+this.formataAreaImovelEterreno(casa.getAreaDoTerreno()));
		this.linha();
	}
	
	private void exibeApenasApartamento(Apartamento apartamento) {
		System.out.println(apartamento.getTipoImovel()+": Área do imovel: "+this.formataAreaImovelEterreno(apartamento.getAreaDoImovel())+" - Valor do imovel: "+this.formataParaDinheiroReal(apartamento.getValorDoImovel())
		+" - Cômodos: "+apartamento.getTotalDeComodos()+" - Salão de festas: "+apartamento.getSalaoDeFestas());
		this.linha();
	}
	
	private void exibeApenasTerreno(Terreno terreno) {
		System.out.println(terreno.getTipoImovel()+": Área do imovel: "+this.formataAreaImovelEterreno(terreno.getAreaDoImovel())+" - Valor do imovel: "+this.formataParaDinheiroReal(terreno.getValorDoImovel()));
		this.linha();
	}
	
	private String formataParaDinheiroReal(BigDecimal valor) {
		NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return formato.format(valor);
	}
	
	private String formataAreaImovelEterreno(BigDecimal areaEterreno) {
		 DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
	     simbolos.setDecimalSeparator(',');
	     simbolos.setGroupingSeparator('.');
	     
	     DecimalFormat formato = new DecimalFormat("###,##0.0", simbolos);
		return formato.format(areaEterreno) + " m²";
	}
	
	private void linha() {
		System.out.println("_______________________________________________________________________________________________________________________________________");
	}
}
