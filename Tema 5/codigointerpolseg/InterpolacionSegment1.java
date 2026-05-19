import java.util.Arrays;

public class InterpolacionSegment1 {
    private final double[] x;
    private final double[] y;

    public InterpolacionSegment1(double[] x, double[] y) {
        if (x.length != y.length || x.length < 2) {
            throw new IllegalArgumentException("Los arreglos deben tener el mismo tamaño y al menos 2 puntos.");
        }
        // Verificar que X esté estrictamente ordenado (condición para funciones)
        for (int i = 1; i < x.length; i++) {
            if (x[i] <= x[i - 1]) throw new IllegalArgumentException("Los valores de X deben estar ordenados de forma ascendente.");
        }
        this.x = Arrays.copyOf(x, x.length);
        this.y = Arrays.copyOf(y, y.length);
    }

    public double evaluar(double valorX) {
        if (valorX < x[0] || valorX > x[x.length - 1]) {
            throw new IllegalArgumentException("Valor fuera del dominio de interpolación.");
        }
        for (int i = 0; i < x.length - 1; i++) {
            if (valorX >= x[i] && valorX <= x[i + 1]) {
                double dx = x[i + 1] - x[i];
                double dy = y[i + 1] - y[i];
                return y[i] + (dy / dx) * (valorX - x[i]);
            }
        }
        return Double.NaN;
    }

    public static void main(String[] args) {
        double[] x = {1.0, 3.0, 5.0, 7.0};
        double[] y = {2.5, 7.1, 8.8, 15.2};
        
        InterpolacionSegment1 spline = new InterpolacionSegment1(x, y);
        System.out.println("Evaluación en x=4.0: " + spline.evaluar(4.0));
    }
}