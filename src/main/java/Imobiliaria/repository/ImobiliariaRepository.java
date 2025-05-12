package Imobiliaria.repository;

import java.util.ArrayList;
import java.util.List;
import Imobiliaria.model.Imovel;

public class ImobiliariaRepository {
	private static List<Imovel> listaDeImoveis = new ArrayList<>();

	public List<Imovel> getListaDeImoveis() {
		return listaDeImoveis;
	}

	public void setListaDeImoveis(Imovel listaDeImoveiss) {
		listaDeImoveis.add(listaDeImoveiss);
	}

	@Override
	public String toString() {
		return "ImobiliariaRepository [getListaDeImoveis()=" + getListaDeImoveis() + "]";
	}
}