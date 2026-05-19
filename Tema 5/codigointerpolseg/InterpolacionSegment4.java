import java.util.Arrays;

public class InterpolacionSegment4 {
    private final double[] x;
    private final double[] a, b, c, d;

    // Constructor que calcula los coeficientes internamente
    public InterpolacionSegment4(double[] x, double[] y) {
        this.x = Arrays.copyOf(x, x.length);
        int n = x.length - 1;
        
        a = Arrays.copyOf(y, y.length);
        b = new double[n];
        c = new double[n + 1];
        d = new double[n];

        double[] h = new double[n];
        for (int i = 0; i < n; i++) h[i] = x[i + 1] - x[i];

        double[] alpha = new double[n];
        for (int i = 1; i < n; i++) {
            alpha[i] = (3.0 / h[i]) * (a[i + 1] - a[i]) - (3.0 / h[i - 1]) * (a[i] - a[i - 1]);
        }

        double[] l = new double[n + 1];
        double[] mu = new double[n];
        double[] z = new double[n + 1];
        
        l[0] = 1.0; mu[0] = 0.0; z[0] = 0.0; // Fronteras naturales

        for (int i = 1; i < n; i++) {
            l[i] = 2.0 * (x[i + 1] - x[i - 1]) - h[i - 1] * mu[i - 1];
            mu[i] = h[i] / l[i];
            z[i] = (alpha[i] - h[i - 1] * z[i - 1]) / l[i];
        }

        l[n] = 1.0; z[n] = 0.0; c[n] = 0.0;

        for (int j = n - 1; j >= 0; j--) {
            c[j] = z[j] - mu[j] * c[j + 1];
            b[j] = (a[j + 1] - a[j]) / h[j] - h[j] * (c[j + 1] + 2.0 * c[j]) / 3.0;
            d[j] = (c[j + 1] - c[j]) / (3.0 * h[j]);
        }
    }

    public double interpolar(double valorX) {
        int i = Arrays.binarySearch(x, valorX);
        if (i >= 0) {
            i = (i == x.length - 1) ? i - 1 : i; 
        } else {
            i = -i - 2;
        }

        if (i < 0 || i >= x.length - 1) {
            throw new IllegalArgumentException("Valor x = " + valorX + " fuera de rango");
        }

        double dx = valorX - x[i];
        return a[i] + b[i] * dx + c[i] * dx * dx + d[i] * dx * dx * dx;
    }

    public static void main(String[] args) {
        double[] x = {0.0, 1.0, 2.0, 3.0};
        double[] y = {0.0, 0.5, 2.0, 1.5};
        
        InterpolacionSegment4 spline = new InterpolacionSegment4(x, y);
        
        System.out.println("=== Generando puntos suavizados (Paso de 0.5) ===");
        for (double t = 0; t <= 3.0; t += 0.5) {
            System.out.printf("x = %.1f -> S(x) = %.4f%n", t, spline.interpolar(t));
        }
    }
}