import java.lang.Math;

public class RegulaFalsi {

    // 1. Definimos la función f(x)
    // Ejemplo: x^3 - 4x - 9
    public static double f(double x) {
        return Math.pow(x, 3) - (4 * x) - 9;
    }

    // 2. El método que me pasaste estructurado correctamente
    public static double ejecutar(double a, double b, double tol, int Nmax) {
        double fa = f(a);
        double fb = f(b);

        if (fa * fb >= 0) {
            throw new IllegalArgumentException("f(a) y f(b) deben tener signos opuestos");
        }

        double c = a;
        for (int k = 0; k < Nmax; k++) {
            // Fórmula de la Falsa Posición
            c = a - fa * (b - a) / (fb - fa);
            double fc = f(c);

            // Verificamos si ya llegamos a la tolerancia
            if (Math.abs(fc) < tol) {
                System.out.println("Raíz encontrada por Regula Falsi en la iteración: " + (k + 1));
                return c;
            }

            // Actualizamos el intervalo
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        try {
            // Probamos en el intervalo [2, 3]
            double resultado = ejecutar(2.0, 3.0, 0.0001, 100);
            System.out.println("La raíz aproximada es: " + resultado);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}