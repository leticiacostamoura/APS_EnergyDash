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

//Projeção que propõe uma nova meta de redução de consumo, caso o usuário não atinja a meta
public class GraficoMetaNOk extends JFrame {
        
    public void criarGraficoMetaNOk(ConsumoEnergia dados){
    
    DefaultCategoryDataset dadosLinha2 = new DefaultCategoryDataset();
    
       //Puxa os dados de consumo do ano inserido
        double acumulador3 = 0;
    for (int i = 0; i < 12; i++){
            acumulador3 = acumulador3 + dados.consumokWhMensal[i];
            dadosLinha2.addValue(acumulador3, "Consumo kWh do ano atual com a meta de " + dados.metaMensalPerc + "% por mês", "Mês " + (i + 1));
        }
       
       //Subtrai 5% da meta proposta pelo usuario
       CalculosConsumoEnergia calc = new CalculosConsumoEnergia();
       calc.reducaoMetaGraficoMetaNOk(dados);
       
       //Cria a linha do gráfico para mostrar como deve ser o consumo para atingir a nova meta
       double acumulador4 = 0;
       for (int i = 0; i < 12; i ++){
           acumulador4 += calc.consumoReducaoMetaNOk;
           dadosLinha2.addValue(acumulador4, "Consumo kWh para atingir uma nova meta de " + calc.reducaoMeta + "%", "Mês " + (i + 1));
       }
   
    //Cria a janela do gráfico
    JFreeChart graficoMetaNOk = ChartFactory.createLineChart ("Gráfico 3 - Proposta de redução de consumo","Meses", "kWh", dadosLinha2);
    ChartPanel painelLinhas2 = new ChartPanel(graficoMetaNOk);
    add(painelLinhas2);
    
    setVisible(true);
    setSize(800,700);
    setLocationRelativeTo(null);
    setTitle("Dashboard - Proposta de redução de consumo");
    
    CategoryPlot plot = graficoMetaNOk.getCategoryPlot();

        // Obtém o renderizador de linhas
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

        // Define a cor das linhas
        renderer.setSeriesPaint(0, Color.blue); 
        renderer.setSeriesPaint(1, Color.magenta); 
        
    }
}
