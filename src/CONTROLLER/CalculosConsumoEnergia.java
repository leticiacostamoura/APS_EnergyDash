
package CONTROLLER;

import MODEL.ConsumoEnergia;

public class CalculosConsumoEnergia {
    public double media;
    public double[] somaMesesAtual;
    public double novaMeta;
    public double consumoReducaoMetaOk;
    public double consumoReducaoMetaNOk;
    public double reducaoMeta;
    
    //Cálculos para o grafico de projeção do próximo ano
    public void mediaGraficoProjProxAno(ConsumoEnergia dados){
        
    //soma os dados dos meses indicados no GraficoConsumoAtual
    somaMesesAtual = dados.consumokWhMensal;
    double soma = 0;
        for (int i = 0; i < somaMesesAtual.length; i++) {
        soma += somaMesesAtual[i];
    }
        
    // Calcula a média
    media = soma / somaMesesAtual.length;
    }

    //Cálculos para o gráfico de projeção de uma nova meta
    public void novaMetaGraficoMetaOk(ConsumoEnergia dados){
       //Adiciona mais 5% a meta proposta pelo usuario
       novaMeta = dados.metaMensalPerc + 5;
       consumoReducaoMetaOk = dados.consumoMensal - (dados.consumoMensal*(novaMeta/100));
    }
    
    //Cálculos para o gráfico de projeção de uma redução de meta
    public void reducaoMetaGraficoMetaNOk(ConsumoEnergia dados){
       reducaoMeta = dados.metaMensalPerc - 5;
       consumoReducaoMetaNOk = dados.consumoMensal - (dados.consumoMensal*(reducaoMeta/100));
    }
    
}
