package locadora.model;

import locadora.item.Alugavel;

public class Locacao {
	   private Alugavel item;
	   private int diasAlugado;
	 
	   public Locacao(Alugavel item, int diasAlugado) {
	      this.item = item;
	      this.diasAlugado = diasAlugado;
	   }
	 
	   public Alugavel getItem() {
	      return item;
	   }
	 
	   public int getDiasAlugado() {
	      return diasAlugado;
	   }

	   public double valorDeUmaLocacao(){
		return item.getValorDaLocacao(diasAlugado);		
	}

	public int calcularPontos() {
    return item.getPontosDeAlugadorFrequente(diasAlugado);
	}
	
}
