package locadora.extrato;

import locadora.model.Cliente;
import locadora.model.Locacao;

public class ExtratoTexto extends Extrato {
    private int sequencia = 0;

    @Override
    protected String cabecalho(Cliente cliente) {
        sequencia = 0;
        String resultado = "Registro de Locações de " + cliente.getNome() + "\n";
        resultado += "Seq Automovel             Ano  Diarias   Valor Pago\n";
        resultado += "=== ==================== ===== ========= ===========\n";
        return resultado;
    }

    @Override
    protected String linha(Locacao locacao) {
        sequencia++;

        return String.format(
            "%02d. %-20s  %4d    %2d     R$ %8.2f\n",
            sequencia,
            locacao.getItem().getDescricao(),
            locacao.getItem().getAno(),
            locacao.getDiasAlugado(),
            locacao.valorDeUmaLocacao()
        );
    }

    @Override
    protected String rodape(Cliente cliente) {
        String resultado = "====================================================\n";
        resultado += String.format(
            "Valor Acumulado em diárias............:  R$ %8.2f\n",
            cliente.getValorTotal()
        );
        resultado += "Você acumulou " +
                cliente.getPontosTotaisDeAlugadorFrequente() +
                " pontos de locador frequente";

        return resultado;
    }
}
