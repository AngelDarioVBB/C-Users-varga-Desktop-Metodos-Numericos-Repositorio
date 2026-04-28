import java.lang.Math;

public class Biseccion {

    // Función a evaluar
    public static double f(double x) {
        return Math.pow(x, 3) - (4 * x) - 9;
    }

    // Método de bisección
    public static double calcular(double a, double b, double tol, int Nmax) {
        double fa = f(a);
        double fb = f(b);

        if (fa * fb >= 0) {
            throw new IllegalArgumentException("f(a) y f(b) deben tener signos opuestos");
        }

        double c = a;
        for (int k = 0; k < Nmax; k++) {
            c = (a + b) / 2.0;
            double fc = f(c);

            if (Math.abs(fc) < tol || (b - a) / 2.0 < tol) {
                return c;
            }

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
            // Prueba con intervalo [2, 3]
            double resultado = calcular(2.0, 3.0, 0.0001, 100);
            System.out.println("La raiz es: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}