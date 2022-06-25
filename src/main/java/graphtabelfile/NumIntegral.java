package graphtabelfile;

interface NumIntegral{
    double integral(double xMin, double xMax, int n);
}

class Integral_cr implements NumIntegral {

    public double integral(double xMin, double xMax, int n){
        double dx = (xMax - xMin) / (n - 1);
        double x, y, integral;
        integral = 0;
        for (int i = 1; i < n; i++){
            x = xMin + dx * (i - 0.5);
            y = MyFunc.getMyFunc(x);
            integral += y * dx;
        }
        return integral;
    }
}

class Integral_lt implements NumIntegral{

    public double integral(double xMin, double xMax, int n) {
        double dx = (xMax - xMin) / (n - 1);
        double x, y, integral;
        integral = 0;
        for (int i = 1; i < n; i++){
            x = xMin + dx * (i - 1);
            y = MyFunc.getMyFunc(x);
            integral += y * dx;
        }
        return integral;
    }
}

class Integral_rt implements NumIntegral{

    public double integral(double xMin, double xMax, int n) {
        double dx = (xMax - xMin) / (n - 1);
        double x, y, integral;
        integral = 0.0;
        for(int i = 1; i < n; i++){
            x = xMin + dx * i;
            y = MyFunc.getMyFunc(x);
            integral += y * dx;
        }
        return  integral;
    }
}

class Integral_tr implements NumIntegral{

    public double integral(double xMin, double xMax, int n) {
        double dx = (xMax - xMin) / (n - 1);
        double x, y, integral;
        integral = 0.0;
        for (int i = 1; i < n; i++){
            x = xMin + dx * (i - 1);
            y = 0.5*(MyFunc.getMyFunc(x) + MyFunc.getMyFunc(x + dx));
            integral += y * dx;
        }
        return  integral;
    }
}

class Integral_simp implements NumIntegral{

    public double integral(double xMin, double xMax, int n) {
        double dx =(xMax - xMin) / (n - 1);
        double x, y, integral;
        integral = 0.0;
        for (int i = 1; i < n; i++){
            x = xMin + dx * (i - 1);
            y = (MyFunc.getMyFunc(x) + 4.0 * MyFunc.getMyFunc(x + 0.5 * dx) + MyFunc.getMyFunc(x + dx)) / 6.0;
            integral += y * dx;
        }
        return  integral;
    }
}

class Integral_38 implements NumIntegral{

    public double integral(double xMin, double xMax, int n) {
        double dx = (xMax - xMin) / (n - 1);
        double x, y, integral;
        integral = 0.0;
        for (int i = 1; i < n; i++){
            x = xMin + dx*(i-1);
            y = (MyFunc.getMyFunc(x) + 3.0 * MyFunc.getMyFunc(x + dx / 3.0) + 3.0 * MyFunc.getMyFunc(x + 2.0 * dx / 3.0)
                    + MyFunc.getMyFunc(x + dx)) / 8.0;
            integral  += y * dx;
        }
        return  integral;
    }
}

class Integral_gauss1 implements NumIntegral{

    public double integral(double xMin, double xMax, int n) {
        double dx = (xMax - xMin) / (n - 1);
        double x, y, integral, w1, e1;
        w1 = 1.0;
        e1 = 0.0;
        integral = 0.0;
        for (int i = 1; i < n; i++){
            x = xMin + dx * (i - 0.5) + e1 * 0.5 * dx;
            y = w1 * MyFunc.getMyFunc(x);
            integral += y * dx;
        }
        return  integral;
    }
}

class Integral_gauss2 implements NumIntegral{

    public double integral(double xMin, double xMax, int n) {
        double dx = (xMax - xMin) / (n - 1);
        double x1, x2, y, integral, w1, e1;
        e1 = 1.0 / Math.sqrt(3.0);
        w1 = 0.5;
        integral = 0.0;
        for (int i = 1; i < n; i++){
            x1 = xMin + dx * (i - 0.5) + e1 * 0.5 * dx;
            x2 = xMin + dx * (i - 0.5) - e1 * 0.5 * dx;
            y = w1 * (MyFunc.getMyFunc(x1) + MyFunc.getMyFunc(x2));
            integral += y * dx;
        }
        return  integral;
    }
}

class Integral_gauss3 implements NumIntegral{

    public double integral(double xMin, double xMax, int n) {
        double dx = (xMax - xMin) / (n - 1);
        double x1, x2, x0, y, integral, w1, w0, e1, e0;
        e0 = 0.0;
        e1 = Math.sqrt(15.0) / 5.0;
        w0 = 4.0 / 9.0;
        w1 = 5.0 / 18.0;
        integral = 0.0;
        for (int i = 1; i < n; i++){
            x0 = xMin + dx * (i - 0.5) + e0 * 0.5 * dx;
            x1 = xMin + dx * (i - 0.5) + e1 * 0.5 * dx;
            x2 = xMin + dx * (i - 0.5) - e1 * 0.5 * dx;
            y = w0 * MyFunc.getMyFunc(x0) + w1 * (MyFunc.getMyFunc(x1) + MyFunc.getMyFunc(x2));
            integral += y * dx;
        }
        return  integral;
    }
}