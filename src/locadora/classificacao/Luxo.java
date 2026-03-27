package locadora.classificacao;

import locadora.item.Automovel;

public class Luxo extends Classificacao {
     public int getCodigoDoPreco() {
        return Automovel.LUXO;
    }

    public double getValorDaLocacao(int dias) {
        double valor = dias * 200.0;

        if(dias > 4) {
            valor *= 0.9;
        }

        return valor;
    }

    @Override
    public int getPontosDeAlugadorFrequente(int dias) {
        if(dias > 2) return 3;
        return 1;
    }
}
