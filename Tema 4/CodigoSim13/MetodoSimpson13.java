public class MetodoSimpson13 {
     public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        int n = 100; // Debe ser par

        double resultado = simpson13(a, b, n);
        System.out.printf("Aproximación de ∫ sen(x) dx [0, π] = %.8f%n", resultado);
        System.out.printf("Valor exacto (2)                 = %.8f%n", 2.0);
    }

    public static double funcion(double x) {
        return Math.sin(x);
    }

    public static double simpson13(double a, double b, int n) {
        // Asegurar que n sea par
        if (n % 2 != 0) {
            n++;
        }

        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 == 1) {
                suma += 4 * funcion(x);
            } else {
                suma += 2 * funcion(x);
            }
        }

        return (h / 3) * suma;
    }
}
