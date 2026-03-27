package locadora.extrato;

import locadora.model.Cliente;
import locadora.model.Locacao;

public class ExtratoHTML extends Extrato{
    private int sequencia = 0;

    @Override
    protected String cabecalho(Cliente cliente) {
        sequencia = 0;

        String resultado = "<html><body>\n";
        resultado += String.format(
            "<H2>Registro de Locações de <EM>%s</EM></H2>\n",
            cliente.getNome()
        );

        resultado += "<table border=\"1\">\n";
        resultado += "<tr><th>Seq</th><th>Automóvel</th><th>Ano</th><th>Diárias</th><th>Valor</th></tr>\n";

        return resultado;
    }

    @Override
    protected String linha(Locacao locacao) {
        sequencia++;

        return String.format(
            "<tr><td>%02d.</td><td>%s</td><td>%4d</td><td>%2d</td><td>R$ %8.2f</td></tr>\n",
            sequencia,
            locacao.getItem().getDescricao(),
            locacao.getItem().getAno(),
            locacao.getDiasAlugado(),
            locacao.valorDeUmaLocacao()
        );
    }

    @Override
    protected String rodape(Cliente cliente) {
        String resultado = String.format(
            "<tfoot><tr><td colspan=\"4\">Valor Acumulado em diárias:</td><td><EM>R$ %8.2f</EM></td></tr></tfoot>\n",
            cliente.getValorTotal()
        );

        resultado += "</table>\n";

        resultado += "<p>Você acumulou <EM>" +
                cliente.getPontosTotaisDeAlugadorFrequente() +
                " pontos</EM> de locador frequente</p>";

        resultado += "</body></html>";

        return resultado;
    }
}
