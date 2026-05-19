public class ExtrapolacionPolinomial2 {
    
    public static double extrapolarNewton(double[] x, double[] y, double targetX) {
        int n = x.length;
        double[][] f = new double[n][n];

        for (int i = 0; i < n; i++) {
            f[i][0] = y[i];
        }

        // Construcción de la tabla de diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                f[i][j] = (f[i + 1][j - 1] - f[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Evaluación del polinomio interpolador en el punto externo
        double resultado = f[0][0];
        double factorAcumulado = 1.0;
        for (int i = 1; i < n; i++) {
            factorAcumulado *= (targetX - x[i - 1]);
            resultado += f[0][i] * factorAcumulado;
        }

        return resultado;
    }

    public static void main(String[] args) {
        double[] xData = {10, 20, 30, 40};
        double[] yData = {100, 141.4, 173.2, 200.0}; // Datos basados en 10 * sqrt(x)
        
        double xObjetivo = 50.0; // Extrapolación hacia adelante
        double yProyectado = extrapolarNewton(xData, yData, xObjetivo);

        System.out.println("--- Extrapolación por Polinomial de Newton ---");
        System.out.printf("Valor extrapolado en x = %.1f: %.4f%n", xObjetivo, yProyectado);
    }
}