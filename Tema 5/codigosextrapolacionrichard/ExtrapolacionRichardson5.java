import java.util.function.Function;

public class ExtrapolacionRichardson5 {

    public static double calcularRichardsonAdaptativo(Function<Double, Double> f, double x, double tol, int maxNiveles) {
        double[][] r = new double[maxNiveles][maxNiveles];
        double h = 0.5; // Paso inicial por defecto

        // Fila 0
        r[0][0] = (f.apply(x + h) - f.apply(x - h)) / (2.0 * h);

        for (int i = 1; i < maxNiveles; i++) {
            h /= 2.0;
            r[i][0] = (f.apply(x + h) - f.apply(x - h)) / (2.0 * h);

            // Calcular extrapolaciones de la fila actual
            for (int j = 1; j <= i; j++) {
                double factor = Math.pow(4, j);
                r[i][j] = r[i][j - 1] + (r[i][j - 1] - r[i - 1][j - 1]) / (factor - 1);
            }

            // Criterio de convergencia: comparar el valor actual con el anterior de la diagonal
            double cambioestabilidad = Math.abs(r[i][i] - r[i - 1][i - 1]);
            if (cambioestabilidad < tol) {
                System.out.printf("[INFO] Tolerancia alcanzada con éxito en el nivel %d.%n", i);
                return r[i][i];
            }
        }
        System.out.println("[WARN] Se alcanzó el número máximo de niveles sin convergencia completa.");
        return r[maxNiveles - 1][maxNiveles - 1];
    }

    public static void main(String[] args) {
        // Evaluar derivada de f(x) = 1/x -> f'(4) = -1/16 = -0.0625
        Function<Double, Double> f = (x) -> 1.0 / x;
        double xEval = 4.0;
        double tolerancia = 1e-9;

        System.out.println("--- Motor de Extrapolación de Richardson Adaptativo ---");
        double resultado = calcularRichardsonAdaptativo(f, xEval, tolerancia, 10);
        System.out.printf("Resultado final obtenido: %.10f (Real: -0.0625)%n", resultado);
    }
}