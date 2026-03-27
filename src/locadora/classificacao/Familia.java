package locadora.classificacao;

import locadora.item.Automovel;

public class Familia extends Classificacao {
     public int getCodigoDoPreco() {
        return Automovel.FAMILIA;
    }

    public double getValorDaLocacao(int dias) {
        return dias * 130.0;
    }
}
