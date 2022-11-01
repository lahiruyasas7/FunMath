/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE;
import io.QuickChart.QuickChart;


/**
 *
 * @author lahiru yasas
 */
public class QuickChart {
    
    public String chartData(String [][] data){
    
        String chartGen = null;
        System.out.println("score  ready to send!");
        
        chartGen = "{" + 
                    "type: 'bar'," +   
                        "data: {" +
                                "labels: ['"+data[0][0]+"', '"+data[1][0]+"', '"+data[2][0]+"', '"+data[3][0]+"', '"+data[4][0]+"']," +  //player names
                                        "datasets: [{" +
                                                  "label: 'SCORE BOARD'," +                         // Create the 'player' dataset
                                                        "data: ['"+Integer.parseInt(data[0][1])+"', '"+Integer.parseInt(data[1][1])+"', '"+Integer.parseInt(data[2][1])+"', '"+Integer.parseInt(data[3][1])+"', '"+Integer.parseInt(data[4][1])+"']" +   
                                                    "}]" +
                                "}" +
                    "}";
               
        System.out.println("Scores sent!");
        
        return chartGen;
    }
    
    
    public String chartScore(String score){
        
        String scoreGen = null;
        String label = "Your Score";
        
        scoreGen = "{\n" +
                "  type: 'doughnut',\n" +
                "  data: {\n" +
                "    datasets: [\n" +
                "      {\n" +
                "        data: ["+Integer.parseInt(score)+"],\n" +  //score
                "        backgroundColor: [ 'rgb(255, 99, 132)', 'rgb(255, 159, 64)', ],\n" +
                "      },\n" +
                "    ],\n" +
                "    labels: ['"+label+"'],\n" +
                "  },\n" +
                "  options: {\n" +
                "    plugins: {\n" +
                "      datalabels: {\n" +
                "        formatter: (value) => {\n" +
                "          return value + '%';\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        return scoreGen;
    }
 
    
    
    
    
    public String gameChart(String [][] data){
        
        System.out.println("Scores received to gamechart!");

        QuickChart chartgen = new QuickChart();
        
        chartgen.setWidth(500);
        chartgen.setHeight(300);
        chartgen.setConfig(chartData(data));
        System.out.println(chartgen.getShortUrl());
        
        String url = chartgen.getShortUrl();
        
        return url;
    }
  
    
    
    public String scoreChart(String sco) {
        
        QuickChart chart = new QuickChart();
        
        chart.setWidth(500);
        chart.setHeight(300);
        chart.setConfig(chartScore(sco));
        System.out.println(chart.getUrl());
        
        String url = chart.getShortUrl();

        return url;
    }
    
    
}
