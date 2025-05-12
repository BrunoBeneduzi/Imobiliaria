package Imobiliaria.service;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import Imobiliaria.model.Apartamento;
import Imobiliaria.model.Casa;
import Imobiliaria.model.Terreno;
import Imobiliaria.repository.ImobiliariaRepository;

public class Cadastro {
	private Scanner sc = new Scanner(System.in);
	private ImobiliariaRepository listaImoveis = new ImobiliariaRepository();
	private VerificaAreaEvalor verificador = new VerificaAreaEvalor();
	
	public void cadastro() {
		System.out.println("Digite o tipo de imovel que deseja cadastrar"+"\n1- Casa"+"\n2- Apartamento"+"\n3- Terreno");
		this.linha();
		switch(2) {
		case 1:
			this.cadastrarCasa();
			System.out.println("--------------------------------- Cadastro concluido ---------------------------------");
			break;
		case 2:
			this.cadastrarApartamento();
			System.out.println("--------------------------------- Cadastro concluido ---------------------------------");
			break;
		case 3:
			this.cadastrarTerreno();
			System.out.println("--------------------------------- Cadastro concluido ---------------------------------");
			break;
		default:
			System.out.println("Numero invalido");
		}
	}
	
	public void cadastroProntosDeImoveis() {//cadastra automaticamente os 3 tipos de imoveis na lista
		this.listaImoveis.setListaDeImoveis(new Casa(new BigDecimal(100000.50), new BigDecimal(1000000), 6, new BigDecimal(150000)));
		this.listaImoveis.setListaDeImoveis(new Apartamento(new BigDecimal(200000.70), new BigDecimal(1500000), 4, "SIM"));
		this.listaImoveis.setListaDeImoveis(new Terreno(new BigDecimal(400000), new BigDecimal(4500000)));
		this.listaImoveis.setListaDeImoveis(new Casa(new BigDecimal(300000.30), new BigDecimal(2000000), 4, new BigDecimal(250000)));
		this.listaImoveis.setListaDeImoveis(new Apartamento(new BigDecimal(300000.70), new BigDecimal(2500000), 6, "NÃO"));
		this.listaImoveis.setListaDeImoveis(new Terreno(new BigDecimal(600000), new BigDecimal(5500000)));
	}

	private void cadastrarCasa() {
		BigDecimal areaTotalImovel = this.cadastraAreaDoImovel();
		System.out.println("--------------------------------- Cadastro da area do imovel concluido---------------------------------");
		
		BigDecimal precoImovel = this.cadastraValorDoImovel();
		System.out.println("--------------------------------- Cadastro do preco do imovel concluido ---------------------------------");
		
		int totalComodos = this.cadastrarComodos();
		System.out.println("--------------------------------- Cadastro dos comodos concluido ---------------------------------");
		
		BigDecimal areaTotalTerreno = this.cadastraAreaDoTerreno();
		System.out.println("--------------------------------- Cadastro da area do terreno concluido ---------------------------------");
		
		this.listaImoveis.setListaDeImoveis(new Casa(areaTotalImovel, precoImovel, totalComodos, areaTotalTerreno));
	}
	
	private void cadastrarApartamento() {
		BigDecimal areaTotalImovel = this.cadastraAreaDoImovel();
		System.out.println("--------------------------------- Cadastro da area do imovel concluido---------------------------------");
		
		BigDecimal precoImovel = this.cadastraValorDoImovel();
		System.out.println("--------------------------------- Cadastro do preco do imovel concluido ---------------------------------");
		
		int totalComodos = this.cadastrarComodos();
		System.out.println("--------------------------------- Cadastro dos comodos concluido ---------------------------------");
		
		String salaoDeFestas = this.cadastraSalaoDeFestas();
		System.out.println("--------------------------------- Cadastro do salao de festas concluido ---------------------------------");
		
		this.listaImoveis.setListaDeImoveis(new Apartamento(areaTotalImovel, precoImovel, totalComodos, salaoDeFestas));
		
	}
	
	private void cadastrarTerreno() {
		BigDecimal areaTotalImovel = this.cadastraAreaDoImovel();
		System.out.println("--------------------------------- Cadastro da area do imovel concluido---------------------------------");
		
		BigDecimal precoImovel = this.cadastraValorDoImovel();
		System.out.println("--------------------------------- Cadastro do preco do imovel concluido ---------------------------------");
		
		this.listaImoveis.setListaDeImoveis(new Terreno(areaTotalImovel, precoImovel));
	}
	
	private BigDecimal cadastraAreaDoImovel() {
		System.out.print("Digite a area do imovel -> ");
		return this.verificador.verificaAreaImovelEterreno();
	}
	
	private BigDecimal cadastraValorDoImovel() {
		System.out.print("Digite o valor do imovel -> ");
		return this.verificador.verificaValorImovel();
	}
	
	private BigDecimal cadastraAreaDoTerreno() {
		System.out.print("Digite a area do terreno -> ");
		return this.verificador.verificaAreaImovelEterreno();
		
	}
	
	private int cadastrarComodos() {
		System.out.print("Digite a quantidade de comodos -> ");
		int totalComodos = 0;
		Boolean verificaComodos = false;
		
			do {
				try {
					totalComodos = sc.nextInt();
					sc.nextLine();
					
					if(totalComodos == 0) {
						System.out.print("Não é possivel cadastrar ZERO comodos, digite novamente -> ");
						verificaComodos = true;
					}else if(totalComodos < 0) {
						System.out.print("Não é possivel ter numeros negativos de comodos, digite novamente -> ");
						verificaComodos = true;
					}else if(totalComodos > 30){
						System.out.print("Não é possivel cadastrar mais que 30 comodos, digite novamente -> ");
						verificaComodos = true;
					}else {
						verificaComodos = false;
					}
				}catch(InputMismatchException e) {
					System.out.print("Invalido, Digite um numero de comodo novamente -> ");
					sc.nextLine();
					verificaComodos = true;
				}
					
			}while(verificaComodos);
			
		return totalComodos;
	}
	
	
	private String cadastraSalaoDeFestas() {
		Boolean verificaLetra = true;
		String salaoDeFestas = "N/A";
		
			do{
				System.out.print("o Apartamento tem salão de festas (S) ou (N) -> ");
				String simOuNao = sc.nextLine();
				
				if(simOuNao.equalsIgnoreCase("s")) {
					salaoDeFestas = "SIM";
					verificaLetra = false;
				}else if(simOuNao.equalsIgnoreCase("n")) {
					salaoDeFestas = "NÃO";
					verificaLetra = false;
				}else {
					System.out.println("Digito invalido, tente novamente");
				}
			}while(verificaLetra);
		
		return salaoDeFestas;
	}
	
	private void linha() {
		System.out.println("------------------------------------------------------------------");
	}
	
}