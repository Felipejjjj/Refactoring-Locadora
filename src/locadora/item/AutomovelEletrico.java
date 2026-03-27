package locadora.item;



public class AutomovelEletrico extends Automovel {
    private int autonomia;
    private int tempoRecarga;
     
    public AutomovelEletrico(String descricao, int ano, String placa, int codigoDoPreco, int autonomia, int tempoRecarga) {
        super(descricao, ano, placa, codigoDoPreco);
        this.autonomia = autonomia;
        this.tempoRecarga = tempoRecarga;
    }

     public int getAutonomia() {
        return autonomia;
    }

    public int getTempoRecarga() {
        return tempoRecarga;
    }
}
