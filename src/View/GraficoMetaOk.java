
package View;

import CONTROLLER.CalculosConsumoEnergia;
import MODEL.ConsumoEnergia;
import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoMetaOk extends JFrame {
        
    public void criarGraficoMetaOK(ConsumoEnergia dados){
    
    //Projeção que propõe uma nova meta de consumo, caso o usuário atinja a meta
    DefaultCategoryDataset dadosLinha1 = new DefaultCategoryDataset();
       
       //Pega os dados de consumo do ano inserido
       double acumulador = 0;
       for (int i = 0; i < 12; i ++){
           acumulador += dados.consumokWhMensal[i];
           dadosLinha1.addValue(acumulador, "Consumo kWh do ano atual com a meta de " + dados.metaMensalPerc + "% por mês", "Mês " + (i + 1));
       }
       
       //Adiciona 5% a meta proposta
       CalculosConsumoEnergia calc = new CalculosConsumoEnergia();
       calc.novaMetaGraficoMetaOk(dados);
       
       //Cria a linha que mostra como deve ser o consumo para atingir a nova meta
       double acumulador2 = 0;
       for (int i = 0; i < 12; i ++){
           acumulador2 += calc.consumoReducaoMetaOk;
           dadosLinha1.addValue(acumulador2, "Consumo kWh para atingir uma nova meta de " + calc.novaMeta + "%", "Mês " + (i + 1));
       }
    
    //Cria a janela do gráfico
    JFreeChart graficoMetaOK = ChartFactory.createLineChart ("Gráfico 3 - Proposta de nova meta","Meses", "kWh", dadosLinha1);
    ChartPanel painelMetaOk = new ChartPanel(graficoMetaOK);
    add(painelMetaOk);
    
    setVisible(true);
    setSize(800,700);
    setLocationRelativeTo(null);
    setTitle("Dashboard - Proposta de nova meta");
    
    CategoryPlot plot = graficoMetaOK.getCategoryPlot();

        //Obtém o renderizador de linhas
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

        //Define a cor das linhas
        renderer.setSeriesPaint(0, Color.blue); 
        renderer.setSeriesPaint(1, Color.magenta); 
     
}
}
