package locadora;

public class Locacao {
	   private Automovel carro;
	   private int diasAlugado;
	 
	   public Locacao(Automovel carro, int diasAlugado) {
	      this.carro = carro;
	      this.diasAlugado = diasAlugado;
	   }
	 
	   public Automovel getCarro() {
	      return carro;
	   }
	 
	   public int getDiasAlugado() {
	      return diasAlugado;
	   }

	   public double valorDeUmaLocacao(){
		double valor = 0.0;

			// determina valores para cada linha
			switch(this.getCarro().getCodigoDoPreco()) {
			case Automovel.BASICO: // R$ 90.00 por dia
				valor += this.getDiasAlugado() * 90.0;
				break;

			case Automovel.FAMILIA: // R$ 130.00 por dia
				valor += this.getDiasAlugado() * 130.0;
				break;

			case Automovel.LUXO: // R$ 200.00 por dia
				valor += this.getDiasAlugado() * 200.0;
				
				// Adiciona um desconto de 10% se alugar o carro por mais de 4 dias
				if(this.getDiasAlugado() > 4) {
					valor *= 0.9;
				}
				break;
			}
		return valor;
			
	}

	public int calcularPontos() {
    int pontos = 1;

    if(getCarro().getCodigoDoPreco() == Automovel.LUXO &&
       getDiasAlugado() > 2) {
        pontos += 2;
    }

    return pontos;
	}
	
}
