package Imobiliaria.service;

import java.math.BigDecimal;
import java.util.Scanner;

public class VerificaAreaEvalor {
	private Scanner sc = new Scanner(System.in);

	protected BigDecimal verificaAreaImovelEterreno() {
		return this.verificaSeEmenorQueDez(this.verificaSeFoiDigitadoNumero());
	}
	
	protected BigDecimal verificaValorImovel() {
		return this.verificaPrecoCorreto(this.verificaSeFoiDigitadoNumero());
	}
	
	
	private BigDecimal verificaSeFoiDigitadoNumero() {
		BigDecimal numeroBigDecimal= BigDecimal.ZERO;
		String numeroString;
		Boolean verifica = true;
		
			do {
				try {
					numeroString = sc.nextLine();
					
					numeroBigDecimal = new BigDecimal(numeroString.replace(",", "."));//caso o usuario digite uma virgula, ela vai ser substituida por um PONTO, para não lançar uma exceção
					
					verifica = false;
				}catch(NumberFormatException e) {
					System.out.print("Digito invalido, digite novamente -> ");
					
					verifica = true;
				}
			}while(verifica);
		return numeroBigDecimal;
	}
	
	private BigDecimal verificaSeEmenorQueDez(BigDecimal areaImovelTotal) {
		BigDecimal areaImovel = areaImovelTotal;
		
			do {
				if(areaImovel.compareTo(BigDecimal.valueOf(10.0)) < 0) {
					System.out.print("Tamanho do imovel invalido, Muito pequeno, Digite novamente -> ");
					areaImovel = this.verificaSeFoiDigitadoNumero();
				}
				
			}while(areaImovel.compareTo(BigDecimal.valueOf(10.0)) < 0);
		
		return areaImovel;
	}
	
	private BigDecimal verificaPrecoCorreto(BigDecimal valorImovel) {
		
		do {
			if(valorImovel.compareTo(BigDecimal.valueOf(1000)) < 0) {
				System.out.print("Valor abaixo dos 1000 R$, digite Novamente -> ");	
				valorImovel = this.verificaSeFoiDigitadoNumero();
			}
		}while(valorImovel.compareTo(BigDecimal.valueOf(1000)) < 0);
			
		return valorImovel;
	}
	
}