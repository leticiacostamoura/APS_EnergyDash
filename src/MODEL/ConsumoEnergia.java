package MODEL;

//Definindo a classe de domínio da aplicação 
public class ConsumoEnergia {

    public double consumoMensal;
    public double metaMensalPerc;
    public double[] consumokWhMensal;

    public double getConsumo() {
        return consumoMensal;
    }

    public void setConsumo(double consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public double getMeta() {
        return metaMensalPerc;
    }

    public void setMeta(double metaMensal) {
        this.metaMensalPerc = metaMensal;
    }

    //Construtor
        public ConsumoEnergia() {
        consumokWhMensal = new double[12];
    }

}
