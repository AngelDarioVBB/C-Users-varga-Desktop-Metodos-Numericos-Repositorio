public class MetodoSimpson38 {

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        int n = 9; // Debe ser múltiplo de 3

        double resultado = simpson38(a, b, n);
        System.out.printf("Aproximación de ∫ sen(x) dx [0, π] = %.8f%n", resultado);
        System.out.printf("Valor exacto (2)                     = %.8f%n", 2.0);
    }

    public static double funcion(double x) {
        return Math.sin(x);
    }

    public static double simpson38(double a, double b, int n) {
        // Asegurar que n sea múltiplo de 3
        while (n % 3 != 0) {
            n++;
        }

        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                suma += 2 * funcion(x);
            } else {
                suma += 3 * funcion(x);
            }
        }

        return (3 * h / 8) * suma;
    }
}
