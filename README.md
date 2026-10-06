# Energy Dash

![Energy Dash](src/ImageLogo/Banner%20Energy%20Dash.png)

Aplicação Java para análise de consumo de energia e acompanhamento de metas de redução.

O sistema recebe dados mensais de consumo em kWh, compara os valores com uma meta definida pelo usuário e apresenta visualizações gráficas para facilitar a interpretação dos resultados.

## 🎯 Objetivo

O Energy Dash foi desenvolvido para transformar dados de consumo de energia em informações visuais de fácil compreensão, permitindo acompanhar o comportamento do consumo ao longo do ano e avaliar o cumprimento de metas de redução.

## ⚙️ Principais funcionalidades

- Registro do consumo de energia dos 12 meses do ano;
- Definição de uma meta percentual de redução de consumo;
- Cálculo do consumo esperado de acordo com a meta informada;
- Identificação do cumprimento ou não da meta;
- Visualização gráfica do consumo atual;
- Projeção de consumo para o próximo ano com base na média anual;
- Sugestão de nova meta quando a meta atual é atingida;
- Proposta de ajuste da meta quando o objetivo não é alcançado.

## 🛠️ Tecnologias utilizadas

- **Java 21**
- **Java Swing** para a interface gráfica
- **JFreeChart** para geração dos gráficos
- **Apache Ant**
- **NetBeans**

## 🧱 Estrutura do projeto

O código está organizado em uma estrutura semelhante ao padrão MVC:

```text
src/
├── CONTROLLER/
│   ├── CalculosConsumoEnergia.java
│   └── MetasConsumoEnergia.java
├── MODEL/
│   └── ConsumoEnergia.java
├── View/
│   ├── Principal.java
│   ├── GraficoConsumoAtual.java
│   ├── GraficoMetaOk.java
│   ├── GraficoMetaNOk.java
│   └── GraficoProjecaoProxAno.java
└── ImageLogo/
    └── Banner Energy Dash.png
```

## ▶️ Como executar

### Pré-requisitos

Para executar o projeto, é necessário ter:

- JDK 21 instalado;
- NetBeans ou outra IDE compatível com projetos Java/Ant;
- Biblioteca JFreeChart configurada no projeto.

A versão da biblioteca utilizada no desenvolvimento pode ser obtida pelo link abaixo:

[JFreeChart - arquivos utilizados no projeto](https://drive.google.com/file/d/1gFEiFBFze51FlzlqayTVn8KU3xES0Ezm/view?usp=sharing)

### Execução pelo NetBeans

1. Clone este repositório:

```bash
git clone https://github.com/leticiacostamoura/APS_EnergyDash.git
```

2. Abra o projeto no NetBeans.

3. Configure as dependências do JFreeChart caso a IDE indique referências ausentes.

4. Execute a classe principal:

```text
View.Principal
```

5. Informe o consumo mensal em kWh e a meta percentual desejada.

6. Clique em **Executar** para visualizar a análise e os gráficos gerados pelo sistema.

## 📚 Contexto acadêmico

Projeto desenvolvido como **Atividade Prática Supervisionada (APS)** do 3º semestre do curso de Ciência da Computação.

O trabalho permitiu aplicar conceitos de programação orientada a objetos, organização de código, construção de interfaces gráficas, cálculos sobre dados de consumo e visualização de informações por meio de gráficos.
