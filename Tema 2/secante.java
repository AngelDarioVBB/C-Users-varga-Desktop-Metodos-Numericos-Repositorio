import java.lang.Math;

public class Secante {

    // 1. Definimos la función f(x)
    // Ejemplo: x^2 - 4
    public static double f(double x) {
        return Math.pow(x, 2) - 4;
    }

    // 2. El método de la secante que nos pasaste
    public static double ejecutar(double x0, double x1, double tol, int Nmax) {
        double f0 = f(x0);
        double f1 = f(x1);

        for (int k = 0; k < Nmax; k++) {
            double denom = (f1 - f0);
            if (denom == 0.0) {
                throw new ArithmeticException("División por cero en secante (las f(x) son iguales)");
            }

            // Fórmula de la secante
            double x2 = x1 - f1 * (x1 - x0) / denom;
            double f2 = f(x2);

            // Verificación de éxito
            if (Math.abs(x2 - x1) < tol || Math.abs(f2) < tol) {
                System.out.println("Raíz encontrada en la iteración: " + (k + 1));
                return x2;
            }

            // Avanzar para la siguiente iteración
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f2;
        }

        return x1; 
    }

    public static void main(String[] args) {
        try {
            // Probamos con x0=1.0 y x1=3.0
            double resultado = ejecutar(1.0, 3.0, 0.0001, 100);
            System.out.println("La raíz aproximada es: " + resultado);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}