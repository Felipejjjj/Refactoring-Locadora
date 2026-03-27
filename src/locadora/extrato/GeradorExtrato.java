package locadora.extrato;

import locadora.model.Cliente;

public class GeradorExtrato {
    private Extrato extrato;

    public GeradorExtrato(Extrato extrato) {
        this.extrato = extrato;
    }

    public String gerar(Cliente cliente) {
        return extrato.gerar(cliente);
    }
}
