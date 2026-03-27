package locadora;

public class Automovel implements Alugavel {
	  public static final int BASICO = 0;   // Carros hatch
	  public static final int FAMILIA = 1;  // Carros Sedan ou SUV b�sico
	  public static final int LUXO = 2;     // Carros padr�o luxo

	  private String descricao;
	  private String placa;
	  private int ano; // Ano de fabricacao
	  private int codigoDoPreco;
	  
	  public Automovel(String descricao, int ano, String placa, int codigoDoPreco) {
	    this.descricao = descricao;
	    this.placa = placa;
	    this.ano = ano;
	    this.codigoDoPreco = codigoDoPreco;
	  }
	 
	  public String getDescricao() {
	    return descricao;
	  }
	  
	  public String getPlaca() {
	    return placa;
	  }
	  
	  public int getAno() {
	    return ano;
	  }
	 
	  public int getCodigoDoPreco() {
	    return codigoDoPreco;
	  }
	 
	  public void setCodigoDoPreco(int codigoDoPreco) {
	    this.codigoDoPreco = codigoDoPreco;
	  }

	 public double getValorDaLocacao(int dias) {
    double valor = 0.0;

    switch(codigoDoPreco) {
        case BASICO:
            valor += dias * 90.0;
            break;

        case FAMILIA:
            valor += dias * 130.0;
            break;

        case LUXO:
            valor += dias * 200.0;

            if(dias > 4) {
                valor *= 0.9;
            }
            break;
    }

    return valor;
}

public int getPontosDeAlugadorFrequente(int dias) {
    int pontos = 1;

    if(codigoDoPreco == LUXO && dias > 2) {
        pontos += 2;
    }

    return pontos;
}
}
