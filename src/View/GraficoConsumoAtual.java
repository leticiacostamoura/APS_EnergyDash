package View;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import MODEL.ConsumoEnergia;
import CONTROLLER.MetasConsumoEnergia;
import java.awt.Color;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;

//Gráfico do consumo atual - inputs do usuário
public class GraficoConsumoAtual extends JFrame{
    
    public void criarGraficoConsumoAtual(ConsumoEnergia dados){
       
       MetasConsumoEnergia metas = new MetasConsumoEnergia();
       double meta = metas.calcularMetaMensalkWh(dados);
       
       DefaultCategoryDataset dadosBarra = new DefaultCategoryDataset();
       
       //Acumula a cada mes os valores inputados pelo usuário
       double acumulador = 0;
       for (int i = 0; i < dados.consumokWhMensal.length; i++){
           acumulador = acumulador + dados.consumokWhMensal[i];
           dadosBarra.addValue(acumulador, "Consumo", "Mês " + (i + 1));

       }
       
       //Acumula a cada mes a meta inserida
        for (int i = 0; i < dados.consumokWhMensal.length; i++) {
            if (i == 0)
                dadosBarra.addValue(meta, "Meta", "Mês " + (i + 1));
            else 
                dadosBarra.addValue(meta * (i + 1), "Meta", "Mês " + (i + 1)); 
        }
       
    //Cria a janela do gráfico
    JFreeChart grafico = ChartFactory.createBarChart("Gráfico 1 - Consumo atual de energia","Meses", "kWh consumido", dadosBarra);
    ChartPanel painelConsumoInserido = new ChartPanel(grafico);
    add(painelConsumoInserido);
    
    CategoryPlot plot = grafico.getCategoryPlot();

        //Obtém o renderizador de barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Define a cor da barras
        renderer.setSeriesPaint(0, Color.cyan); 
        renderer.setSeriesPaint(1, Color.BLUE); 
        setVisible(true);
        setSize(800,700);
        setLocationRelativeTo(null);
        setTitle("Dashboard - Consumo de kWh Atual");
  
}
}