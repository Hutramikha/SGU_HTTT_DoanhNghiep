package GUI;
import org.knowm.xchart.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class n10_ChartCreator {

    // Tạo biểu đồ đường với các tham số đầu vào
    public static XYChart createLineChart(List<Integer> xData, List<Integer> yData,List<String> seriesNames, 
                                          String title, String xAxisTitle, String yAxisTitle) {
        XYChart lineChart = new XYChartBuilder()
                .width(800)
                .height(500)
                .title(title)
                .xAxisTitle(xAxisTitle)
                .yAxisTitle(yAxisTitle)
                .build();

                lineChart.getStyler().setDecimalPattern("###############");                        
        
        for (int i = 0; i < seriesNames.size(); i++) {
            String seriesName = seriesNames.get(i);
            lineChart.addSeries(seriesName, xData, yData);
        }
                                            
        return lineChart;
    }

    // Tạo biểu đồ nhiều cột có thể tùy chỉnh số lượng series
    public static CategoryChart createBarChart(List<String> xData, List<List<Integer>> yDataList, 
                                               List<String> seriesNames, String title, 
                                               String xAxisTitle, String yAxisTitle) {
        CategoryChart barChart = new CategoryChartBuilder()
                .width(800)
                .height(500)
                .title(title)
                .xAxisTitle(xAxisTitle)
                .yAxisTitle(yAxisTitle)
                .build();
                barChart.getStyler().setDecimalPattern("###############");                        

        // Thêm từng series vào biểu đồ
        for (int i = 0; i < seriesNames.size(); i++) {
            String seriesName = seriesNames.get(i);
            List<Integer> yData = yDataList.get(i);
            barChart.addSeries(seriesName, xData, yData);
        }

        return barChart;
    }
    public static PieChart createPieChart(List<String> labels, List<Double> values, String title) {
        PieChart pieChart = new PieChartBuilder()
                .width(800)
                .height(500)
                .title(title)
                .build();

        // Thêm các giá trị và nhãn vào biểu đồ tròn
        for (int i = 0; i < labels.size(); i++) {
            pieChart.addSeries(labels.get(i), values.get(i));
        }

        return pieChart;
    }
}
