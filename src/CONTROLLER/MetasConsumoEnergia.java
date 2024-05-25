
package CONTROLLER;

import MODEL.ConsumoEnergia;
import View.GraficoMetaNOk;
import View.GraficoMetaOk;
import javax.swing.JOptionPane;

public class MetasConsumoEnergia {
    
    public double metaConsumo;
    
    //cálculo para definir qual o valor que o usuário deve gastar por mês, conforme sua meta
    public double calcularMetaMensalkWh(ConsumoEnergia dados) {
        this.metaConsumo = dados.consumoMensal - (dados.consumoMensal * (dados.metaMensalPerc / 100));
        return this.metaConsumo;
    }

    //Condição para definir se o usuário atingiu ou não a meta
    
    //Condição - Meta não atingida 
    public boolean condicaoMetaNOk(ConsumoEnergia dados) {
        boolean retorno = false;
        GraficoMetaNOk graficoMetNOk = new GraficoMetaNOk();
        CalculosConsumoEnergia calc = new CalculosConsumoEnergia();
        calc.reducaoMetaGraficoMetaNOk(dados);

        for (int i = 0; i < 12; i++) {
            if (dados.consumokWhMensal[i] > this.metaConsumo) {
                graficoMetNOk.criarGraficoMetaNOk(dados);
                JOptionPane.showMessageDialog(null, "Infelizmente você não conseguiu atingir sua meta de " + dados.metaMensalPerc + "% por mês! \n \n Veja a seguir as seguintes visões: \n \n Gráfico 1 - Consumo Atual de Energia: \n Apresenta uma visão crescente do seu consumo mensal x sua meta, indicando, no último mês, um comparativo do seu consumo anual x sua meta anual \n \n Grafico 2 - Visão de consumo para o próximo ano: \n Conforme a média de consumo de kWh do ano informado, esse gráfico realiza uma projeção do seu consumo para o ano subsequente \n \n Grafico 3 - Proposta de redução da meta \n Esse dashboard indica o seu consumo atual e, como a meta inserida não foi atingida, é proposta uma nova meta de " + calc.reducaoMeta + "% por mês, \n além de informar a quantidade de kWh que deve ser consumido no ano para que essa meta seja atingida");
                retorno = true;
                break;
            }

        }
        return retorno;
    }

    //Condição - Meta atingida 
    public void condicaoMetaOk(ConsumoEnergia dados) {
        GraficoMetaOk graficoMetaOK = new GraficoMetaOk();
        CalculosConsumoEnergia calc = new CalculosConsumoEnergia();
        calc.novaMetaGraficoMetaOk(dados);

        for (int i = 0; i < 12; i++) {
            if (dados.consumokWhMensal[i] <= this.metaConsumo) {
                graficoMetaOK.criarGraficoMetaOK(dados);
                JOptionPane.showMessageDialog(null, "Parabéns, você conseguiu atingir sua meta de " + dados.metaMensalPerc + "% por mês! \n \n Veja a seguir as seguintes visões: \n \n Gráfico 1 - Consumo Atual de Energia: \n Apresenta uma visão crescente do seu consumo mensal x sua meta, indicando, no último mês, um comparativo do seu consumo anual x sua meta anual \n \n Grafico 2 - Visão de consumo para o próximo ano: \n Conforme a média de consumo de kWh do ano informado, esse gráfico realiza uma projeção do seu consumo para o ano subsequente \n \n Grafico 3 - Proposta de nova meta \n Esse dashboard indica o seu consumo atual e apresenta qual seria o consumo de kWh ideal para que você atinja uma nova meta de " + calc.novaMeta + "% por mês");
                break;
            }
        }

    }
}
