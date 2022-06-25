package graphtabelfile;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class MakeGraph extends JPanel {
    public MakeGraph(double xMin, double xMax, int n){

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String str = "Integrals of " + MyFunc.getMyFuncStr();
        String series1 = "точно";
        String series2 = "численно";
        double y = MyFunc.getMyIntegral(xMin, xMax);
        dataset.addValue(y, series1, "Integral");

        NumIntegral[] array = {new Integral_cr(), new Integral_lt(), new Integral_rt(),
                               new Integral_tr(), new Integral_simp(), new Integral_38(),
                               new Integral_gauss1(), new Integral_gauss2(), new Integral_gauss3()};
        for(int i = 0; i < array.length; i++){
            y = array[i].integral(xMin, xMax, n);
            String integer_str = array[i].getClass().getSimpleName().substring(9);
            dataset.addValue(y, series2, integer_str);
        }
        JFreeChart chart = ChartFactory.createBarChart(str, "method", "Integral",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        setLayout(new BorderLayout());
        add(new ChartPanel(chart));
    }
}
