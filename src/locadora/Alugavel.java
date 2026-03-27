package locadora;

public interface Alugavel {
    String getDescricao();
    int getAno();
    double getValorDaLocacao(int diasAlugado);
    int getPontosDeAlugadorFrequente(int diasAlugado);
}
