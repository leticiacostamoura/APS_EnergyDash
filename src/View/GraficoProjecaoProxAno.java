package View;

import CONTROLLER.CalculosConsumoEnergia;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import MODEL.ConsumoEnergia;
import java.awt.Color;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;

//Projeção de consumo para o próximo ano, com base na média do ano inputado
public class GraficoProjecaoProxAno extends JFrame{
    
    public void criarGraficoVisaoProxAno(ConsumoEnergia dados){
              
    DefaultCategoryDataset dadosBarra = new DefaultCategoryDataset(); 
    
    //Instancia o calculo da media da soma dos meses e cria o gráfico de consumo
    CalculosConsumoEnergia calc = new CalculosConsumoEnergia();
    calc.mediaGraficoProjProxAno(dados);
   
    double acumulador = 0;
    for (int i = 0; i < calc.somaMesesAtual.length; i++) {
        acumulador = acumulador + calc.media;
        dadosBarra.addValue(acumulador, "Consumo", "Mês " + (i + 1));
    }
          
    //Cria a janela do gráfico 
    JFreeChart grafico2 = ChartFactory.createBarChart("Gráfico 2 - Projeção de consumo para o próximo ano","Meses", "kWh consumido", dadosBarra);
    ChartPanel painel = new ChartPanel(grafico2);
    add(painel);
    
        CategoryPlot plot = grafico2.getCategoryPlot();

        //Obtém o renderizador de barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Define a cor da barra
        renderer.setSeriesPaint(0, Color.magenta); 
        

        setVisible(true);
        setSize(800,700);
        setLocationRelativeTo(null);
        setTitle("Dashboard - Visão de consumo para o próximo ano");

    }
    }
