public class NewtonRaphson {

    // 1. Definimos la función f(x)
    public static double f(double x) {
        return Math.pow(x, 2) - 2; // Ejemplo: x^2 - 2
    }

    // 2. Definimos la derivada f'(x)
    public static double df(double x) {
        return 2 * x; // Derivada de x^2 - 2 es 2x
    }

    // 3. El método de Newton que me pasaste (ya corregido)
    public static double newton(double x0, double tol, int Nmax) {
        double x = x0;

        for (int k = 0; k < Nmax; k++) {
            double fx = f(x);
            double dfx = df(x);

            if (dfx == 0.0) {
                throw new ArithmeticException("Derivada cero en x = " + x);
            }

            double xNew = x - fx / dfx;

            // Comprobar si la diferencia es menor a la tolerancia
            if (Math.abs(xNew - x) < tol) {
                System.out.println("Convergencia alcanzada en la iteración: " + (k + 1));
                return xNew;
            }

            x = xNew;
        }

        System.out.println("Se alcanzó el máximo de iteraciones sin convergencia total.");
        return x;
    }

    // 4. Método principal para probar el código
    public static void main(String[] args) {
        double estimacionInicial = 1.0;
        double tolerancia = 0.0001;
        int maxIteraciones = 100;

        try {
            double resultado = newton(estimacionInicial, tolerancia, maxIteraciones);
            System.out.println("La raíz aproximada es: " + resultado);
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}