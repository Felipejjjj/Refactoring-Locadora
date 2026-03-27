package locadora.classificacao;

import locadora.item.Automovel;

public class Premium extends Classificacao{
     @Override
    public int getCodigoDoPreco() {
        return Automovel.PREMIUM;
    }

    @Override
    public double getValorDaLocacao(int diasAlugado) {
        return diasAlugado * 320.0;
    }

    @Override
    public int getPontosDeAlugadorFrequente(int diasAlugado) {
        return diasAlugado; // pontos = número de dias
    }
}
