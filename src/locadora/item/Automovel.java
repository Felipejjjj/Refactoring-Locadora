package locadora.item;


import locadora.classificacao.Basico;
import locadora.classificacao.Classificacao;
import locadora.classificacao.Familia;
import locadora.classificacao.Luxo;

public class Automovel implements Alugavel {
	  public static final int BASICO = 0;   // Carros hatch
	  public static final int FAMILIA = 1;  // Carros Sedan ou SUV b�sico
	  public static final int LUXO = 2;     // Carros padr�o luxo

	  private String descricao;
	  private String placa;
	  private int ano; // Ano de fabricacao
	  private Classificacao classificacao;
	  
	  public Automovel(String descricao, int ano, String placa, int codigoDoPreco) {
	    this.descricao = descricao;
	    this.placa = placa;
	    this.ano = ano;
	    setCodigoDoPreco(codigoDoPreco);
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
	    return classificacao.getCodigoDoPreco();
	  }
	 
	  public void setCodigoDoPreco(int codigoDoPreco) {
	    switch(codigoDoPreco) {
        case BASICO:
            classificacao = new Basico();
            break;
        case FAMILIA:
            classificacao = new Familia();
            break;
        case LUXO:
            classificacao = new Luxo();
            break;
    }
	  }

	 public double getValorDaLocacao(int dias) {
    return classificacao.getValorDaLocacao(dias);
	}

public int getPontosDeAlugadorFrequente(int dias) {
     return classificacao.getPontosDeAlugadorFrequente(dias);
}
}
