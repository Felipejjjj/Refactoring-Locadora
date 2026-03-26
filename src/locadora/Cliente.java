package locadora;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	private String nome;
	private List<Locacao> carrosAlugados = new ArrayList<Locacao>();
	private static final String fimDeLinha = System.lineSeparator();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaLocacao(Locacao locacao) {
		carrosAlugados.add(locacao);
	}


	public double getValorTotal(){
		double total = 0.0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();

		while(locacoes.hasNext()) {
			 Locacao cada = locacoes.next();
			 total += cada.valorDeUmaLocacao();
	}
	return total;
}

	public int getPontosTotaisDeLocadorFrequente(){
		int pontos = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		while(locacoes.hasNext()) {
			 Locacao cada = locacoes.next();
			 pontos += cada.calcularPontos();

	}
	return pontos;
}

	private String gerarCabecalhoExtrato() {
		String resultado = "Registro de Locações de " + getNome() + fimDeLinha;
		resultado += String.format("Seq Automovel             Ano  Diarias   Valor Pago"+fimDeLinha);
		resultado += String.format("=== ==================== ===== ========= ==========="+fimDeLinha);
		return resultado;
	}

	

	private String montarLinhaExtrato(int sequencia, Locacao locacao, double valor) {
    return String.format("%02d. %-20s  %4d    %2d     R$ %8.2f" + fimDeLinha,
            sequencia,
            locacao.getCarro().getDescricao(),
            locacao.getCarro().getAno(),
            locacao.getDiasAlugado(),
            valor);
	}

	private String gerarRodapeExtrato(double valorTotal, int pontos) {
    String resultado = "====================================================" + fimDeLinha;
    resultado += String.format("Valor Acumulado em diárias............:  R$ %8.2f" + fimDeLinha, valorTotal);
    resultado += "Voce acumulou " + pontos + " pontos de locador frequente";
    return resultado;
	}

	public String extrato() {

	
		int sequencia = 0;
	
		String resultado = gerarCabecalhoExtrato();
		Iterator<Locacao> locacoes = carrosAlugados.iterator();

    	while(locacoes.hasNext()) {
        Locacao cada = locacoes.next();

        sequencia++;
		
        
        resultado += montarLinhaExtrato(sequencia, cada, cada.valorDeUmaLocacao());
    }
	
	resultado += gerarRodapeExtrato(getValorTotal(), getPontosTotaisDeLocadorFrequente());
	return resultado;
}
}
