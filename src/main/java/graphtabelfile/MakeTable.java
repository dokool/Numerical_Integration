package graphtabelfile;

import javax.swing.JTable;

public class MakeTable {
    public MyJTable getTable(double xMin, double xMax, int n){
        Double[][] cells;
        String[] colNames = {" X ", "Точно", "Средн.т", "Гаусса 3"};
        int k = 4;
        double x, dx = (xMax - xMin) / (n - 1);
        cells = new Double[n][k];
        double integral = MyFunc.getMyIntegral(xMin, xMax);
        double integral_cr = new Integral_cr().integral(xMin, xMax, n);
        double integral_gauss3 = new Integral_gauss3().integral(xMin, xMax, n);
        for (int i = 0; i < n; i++){
            x = xMin + dx * i;
            cells[i][0] = x;
            cells[i][1] = integral;
            cells[i][2] = integral_cr;
            cells[i][3] = integral_gauss3;
        }
        return new MyJTable(cells, colNames);
    }
    class MyJTable extends JTable{

        public MyJTable(final Object[][] rowData, final Object[] columnNames) {
            super(rowData, columnNames);
        }
        @Override
        public boolean isCellEditable(int i, int i1){
            return false;
        }
    }
}
