package locadora;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	private String nome;
	private List<Locacao> itensAlugados = new ArrayList<Locacao>();
	private static final String fimDeLinha = System.lineSeparator();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaLocacao(Locacao locacao) {
		itensAlugados.add(locacao);
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

	private String gerarCabecalhoExtrato() {
		String resultado = "Registro de Locações de " + getNome() + fimDeLinha;
		resultado += String.format("Seq Automovel             Ano  Diarias   Valor Pago"+fimDeLinha);
		resultado += String.format("=== ==================== ===== ========= ==========="+fimDeLinha);
		return resultado;
	}

	

	private String montarLinhaExtrato(int sequencia, Locacao locacao, double valor) {
    return String.format("%02d. %-20s  %4d    %2d     R$ %8.2f" + fimDeLinha,
            sequencia,
            locacao.getItem().getDescricao(),
            locacao.getItem().getAno(),
            locacao.getDiasAlugado(),
            valor);
	}

	private String gerarRodapeExtrato(double valorTotal, int pontos) {
    String resultado = "====================================================" + fimDeLinha;
    resultado += String.format("Valor Acumulado em diárias............:  R$ %8.2f" + fimDeLinha, valorTotal);
    resultado += "Voce acumulou " + pontos + " pontos de locador frequente";
    return resultado;
	}

	/*public String extrato() {

		int sequencia = 0;
	
		String resultado = gerarCabecalhoExtrato();
		
		Iterator<Locacao> locacoes = carrosAlugados.iterator();
    	while(locacoes.hasNext()) {
        Locacao cada = locacoes.next();
		sequencia++;
		
        
        resultado += montarLinhaExtrato(sequencia, cada, cada.valorDeUmaLocacao());
    }
	
	resultado += gerarRodapeExtrato(getValorTotal(), getPontosTotaisDeAlugadorFrequente());
	return resultado;
}
	**/
	public String extratoHTML() {

    int sequencia = 0;

    Iterator<Locacao> locacoes = itensAlugados.iterator();

    String resultado = "<html><body>" + fimDeLinha;

    resultado += String.format(
        "<H2>Registro de Locações de <EM>%s</EM></H2>" + fimDeLinha,
        getNome()
    );

    resultado += "<table border=\"1\">" + fimDeLinha;
    resultado += "<tr><th>Seq</th><th>Automóvel</th><th>Ano</th><th>Diárias</th><th>Valor</th></tr>" + fimDeLinha;

    while(locacoes.hasNext()) {
        Locacao cada = locacoes.next();

        sequencia++;

        resultado += String.format(
            "<tr><td>%02d.</td><td>%s</td><td>%4d</td><td>%2d</td><td>R$ %8.2f</td></tr>" + fimDeLinha,
            sequencia,
            cada.getItem().getDescricao(),
            cada.getItem().getAno(),
            cada.getDiasAlugado(),
            cada.valorDeUmaLocacao()
        );
    }

    resultado += String.format(
        "<tfoot><tr><td colspan=\"4\">Valor Acumulado em diárias:</td><td><EM>R$ %8.2f</EM></td></tr></tfoot>" + fimDeLinha,
        getValorTotal()
    );

    resultado += "<p>Você acumulou <EM>" +
            getPontosTotaisDeAlugadorFrequente() +
            " pontos</EM> de locador frequente</p>";

    resultado += "</table></body></html>";

    return resultado;
}
}
