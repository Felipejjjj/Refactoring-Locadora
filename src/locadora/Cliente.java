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

	private String gerarCabecalhoExtrato() {
		String resultado = "Registro de Locações de " + getNome() + fimDeLinha;
		resultado += String.format("Seq Automovel             Ano  Diarias   Valor Pago"+fimDeLinha);
		resultado += String.format("=== ==================== ===== ========= ==========="+fimDeLinha);
		return resultado;
	}

	private double valorDeUmaLocacao(Locacao locacao){
		double valor = 0.0;

			// determina valores para cada linha
			switch(locacao.getCarro().getCodigoDoPreco()) {
			case Automovel.BASICO: // R$ 90.00 por dia
				valor += locacao.getDiasAlugado() * 90.0;
				break;

			case Automovel.FAMILIA: // R$ 130.00 por dia
				valor += locacao.getDiasAlugado() * 130.0;
				break;

			case Automovel.LUXO: // R$ 200.00 por dia
				valor += locacao.getDiasAlugado() * 200.0;
				
				// Adiciona um desconto de 10% se alugar o carro por mais de 4 dias
				if(locacao.getDiasAlugado() > 4) {
					valor *= 0.9;
				}
				break;
			}
		return valor;
			
	}
	
	private int calcularPontos(Locacao locacao) {
    int pontos = 1;

    if(locacao.getCarro().getCodigoDoPreco() == Automovel.LUXO &&
       locacao.getDiasAlugado() > 2) {
        pontos += 2;
    }

    return pontos;
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

		double valorTotal = 0.0;
		int pontosDeLocadorFrequente = 0;
		int sequencia = 0;
	
		String resultado = gerarCabecalhoExtrato();


		Iterator<Locacao> locacoes = carrosAlugados.iterator();

		while(locacoes.hasNext()) {
			 Locacao cada = locacoes.next();

        double valorCorrente = valorDeUmaLocacao(cada);

        pontosDeLocadorFrequente += calcularPontos(cada);

        sequencia++;

        resultado += montarLinhaExtrato(sequencia, cada, valorCorrente);

        valorTotal += valorCorrente;
    }

    resultado += gerarRodapeExtrato(valorTotal, pontosDeLocadorFrequente);

    return resultado;
}
}