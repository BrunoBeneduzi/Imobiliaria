package Imobiliaria.menu;

import java.util.Scanner;

import Imobiliaria.service.Cadastro;
import Imobiliaria.service.Listar;

public class ImobiliariaMenu {
	private Cadastro cadastrarImoveis = new Cadastro();
	private Listar listarImoveis = new Listar();
	private Scanner sc = new Scanner(System.in);
	
	public void menu() {
		int escolha = 0;
		do {
			System.out.print("Digite o que deseja fazer"+"\n0- Para carregar imoveis prontos"+"\n1- Cadastrar imovel"+"\n2- Listar todos os imoveis"+"\n3- Exibir apenas as casas"+"\n4- Exibir apenas os apartamentos"
		+"\n5- Exibir apenas os terrenos"+"\n6- Encerrar programa"+"\n-> ");
			escolha = sc.nextInt();
			sc.nextLine();
			
			this.linha();
			
				switch(escolha) {
				case 0:
					this.cadastrarImoveis.cadastroProntosDeImoveis();
					break;
				case 1:
					this.cadastrarImoveis.cadastro();
					break;
				case 2:
					this.listarImoveis.exibirTodosOsImoveisMenu();
					break;
				case 3:
					this.listarImoveis.exibeApenasCasasMenu();
					break;
				case 4:
					this.listarImoveis.exibeApenasApartamentoMenu();
					break;
				case 5:
					this.listarImoveis.exibeApenasTerrenoMenu();
					break;
				case 6:
					break;
				default:
					System.out.println("Numero invalido");
				}
		}while(escolha != 6);
		System.out.println("Programa encerrado");
	}
	
	public void linha() {
		System.out.println("\n------------------------------------------------------------------------------------------------------");
	}
}