public class InterpolacionSegment3 {
    // Almacenará los coeficientes de cada polinomio cúbico
    static class Coeficientes {
        double a, b, c, d, x;
    }

    public static Coeficientes[] calcularSplineCubico(double[] x, double[] a) {
        int n = x.length - 1;
        double[] h = new double[n];
        for (int i = 0; i < n; i++) h[i] = x[i + 1] - x[i];

        double[] alpha = new double[n];
        for (int i = 1; i < n; i++) {
            alpha[i] = (3.0 / h[i]) * (a[i + 1] - a[i]) - (3.0 / h[i - 1]) * (a[i] - a[i - 1]);
        }

        double[] l = new double[n + 1];
        double[] mu = new double[n];
        double[] z = new double[n + 1];
        
        l[0] = 1.0; mu[0] = 0.0; z[0] = 0.0; // Frontera natural

        for (int i = 1; i < n; i++) {
            l[i] = 2.0 * (x[i + 1] - x[i - 1]) - h[i - 1] * mu[i - 1];
            mu[i] = h[i] / l[i];
            z[i] = (alpha[i] - h[i - 1] * z[i - 1]) / l[i];
        }

        l[n] = 1.0; z[n] = 0.0;
        
        double[] c = new double[n + 1];
        double[] b = new double[n];
        double[] d = new double[n];

        c[n] = 0.0; // Frontera natural
        Coeficientes[] splines = new Coeficientes[n];

        for (int j = n - 1; j >= 0; j--) {
            c[j] = z[j] - mu[j] * c[j + 1];
            b[j] = (a[j + 1] - a[j]) / h[j] - h[j] * (c[j + 1] + 2.0 * c[j]) / 3.0;
            d[j] = (c[j + 1] - c[j]) / (3.0 * h[j]);

            splines[j] = new Coeficientes();
            splines[j].a = a[j];
            splines[j].b = b[j];
            splines[j].c = c[j];
            splines[j].d = d[j];
            splines[j].x = x[j];
        }
        return splines;
    }

    public static void main(String[] args) {
        double[] x = {0, 1, 2, 3};
        double[] f = {1, 2.718, 7.389, 20.085}; // e^x aproximado

        Coeficientes[] tramos = calcularSplineCubico(x, f);
        
        System.out.println("Coeficientes del Spline Cúbico por tramo:");
        for (int i = 0; i < tramos.length; i++) {
            System.out.printf("Tramo %d [%.0f, %.0f]: S(x) = %.3f + %.3f(x-%.0f) + %.3f(x-%.0f)^2 + %.3f(x-%.0f)^3%n",
                i, x[i], x[i+1], tramos[i].a, tramos[i].b, tramos[i].x, tramos[i].c, tramos[i].x, tramos[i].d, tramos[i].x);
        }
    }
}