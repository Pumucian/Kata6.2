package kata6.view;

import kata6.model.Histogram;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;



public class HistogramDisplay <T> extends ApplicationFrame {

    private final Histogram<T> histogram;
    private final String nameEjeX;
    private final String nameEjeY;
    
    public HistogramDisplay(Histogram<T> histogram, String nameEjeX, String nameEjeY) {
        super("Histograma");
        this.histogram = histogram;
        this.nameEjeX = nameEjeX;
        this.nameEjeY = nameEjeY;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    public JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", nameEjeX, 
                nameEjeY, dataSet, PlotOrientation.VERTICAL, false, 
                rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.getKey(key), "",(Comparable) key);
        }
        return dataSet;
    }
    
}
