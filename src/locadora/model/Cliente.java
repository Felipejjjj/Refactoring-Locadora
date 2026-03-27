package locadora.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	private String nome;
	private List<Locacao> itensAlugados = new ArrayList<Locacao>();
	

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaLocacao(Locacao locacao) {
		itensAlugados.add(locacao);
	}

	public List<Locacao> getLocacoes() {
    	return itensAlugados;
	}


	public double getValorTotal(){
		double total = 0.0;

		Iterator<Locacao> locacoes = itensAlugados.iterator();

		while(locacoes.hasNext()) {
			 Locacao cada = locacoes.next();
			 total += cada.valorDeUmaLocacao();
	}
	return total;
}

	public int getPontosTotaisDeAlugadorFrequente(){
		int pontos = 0;

		Iterator<Locacao> locacoes = itensAlugados.iterator();
		while(locacoes.hasNext()) {
			 Locacao cada = locacoes.next();
			 pontos += cada.calcularPontos();

	}
	return pontos;
}

}
