import java.util.function.Function;

public class ExtrapolacionRichardson3 {

    public static double calcularTablaRichardson(Function<Double, Double> f, double x, double hInicial, int niveles) {
        double[][] table = new double[niveles][niveles];

        // Rellenar la primera columna con diferencias centrales ordinarias
        for (int i = 0; i < niveles; i++) {
            double h = hInicial / Math.pow(2, i);
            table[i][0] = (f.apply(x + h) - f.apply(x - h)) / (2.0 * h);
        }

        // Columnas interiores calculando la matriz triangular de Richardson
        for (int j = 1; j < niveles; j++) {
            for (int i = j; i < niveles; i++) {
                double factor = Math.pow(4, j);
                table[i][j] = table[i][j - 1] + (table[i][j - 1] - table[i - 1][j - 1]) / (factor - 1);
            }
        }

        // Retornar el nodo del extremo inferior derecho
        return table[niveles - 1][niveles - 1];
    }

    public static void main(String[] args) {
        Function<Double, Double> f = (x) -> x * Math.exp(x); // f(x) = x * e^x
        double x = 1.5;
        double h = 0.5;
        
        // Derivada analítica exacta: e^x * (x + 1) -> e^1.5 * 2.5
        double valorReal = Math.exp(1.5) * 2.5;

        System.out.println("--- Tabla Multi-Nivel de Richardson ---");
        for (int n = 1; n <= 4; n++) {
            double aprox = calcularTablaRichardson(f, x, h, n);
            System.out.printf("Nivel %d - Aproximación: %.10f | Error: %.1e%n", n, aprox, Math.abs(valorReal - aprox));
        }
    }
}