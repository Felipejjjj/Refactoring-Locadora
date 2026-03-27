package locadora.extrato;

import locadora.model.Cliente;
import locadora.model.Locacao;

public abstract class Extrato {
  public String gerar(Cliente cliente) {
        String resultado = cabecalho(cliente);

        for (Locacao locacao : cliente.getLocacoes()) {
            resultado += linha(locacao);
        }

        resultado += rodape(cliente);

        return resultado;
    }

    protected abstract String cabecalho(Cliente cliente);
    protected abstract String linha(Locacao locacao);
    protected abstract String rodape(Cliente cliente);  

}
