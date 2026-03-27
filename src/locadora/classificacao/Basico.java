package locadora.classificacao;

import locadora.item.Automovel;

public class Basico extends Classificacao {
     public int getCodigoDoPreco() {
        return Automovel.BASICO;
    }

    public double getValorDaLocacao(int dias) {
        return dias * 90.0;
    }
}
