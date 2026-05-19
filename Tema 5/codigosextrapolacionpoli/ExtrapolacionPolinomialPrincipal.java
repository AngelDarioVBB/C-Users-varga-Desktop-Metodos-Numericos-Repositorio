public class ExtrapolacionPolinomialPrincipal {

    public static void main(String[] args) {
        // Datos de un objeto acelerando (Tiempo vs Distancia)
        double[] tiempo = {0.0, 1.0, 2.0, 3.0};
        double[] distancia = {0.0, 2.5, 10.0, 22.5}; // Sigue la curva 2.5 * t^2

        double tiempoProyeccion = 4.0; // Punto fuera del rango original

        System.out.println("=== Extrapolación Polinómica de Newton ===");
        double[][] tabla = calcularDiferenciasDivididas(tiempo, distancia);
        double resultado = evaluarNewton(tabla, tiempo, tiempoProyeccion);

        System.out.printf("Proyección para t = %.1f s -> Distancia estimada: %.2f m%n", 
                          tiempoProyeccion, resultado);
        System.out.printf("Valor real esperado: %.2f m%n", 2.5 * Math.pow(tiempoProyeccion, 2));
    }

    private static double[][] calcularDiferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] tabla = new double[n][n];
        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return tabla;
    }

    private static double evaluarNewton(double[][] tabla, double[] x, double xEval) {
        int n = x.length;
        double resultado = tabla[0][0];
        double producto = 1.0;

        for (int i = 1; i < n; i++) {
            producto *= (xEval - x[i - 1]);
            resultado += tabla[0][i] * producto;
        }
        return resultado;
    }
}