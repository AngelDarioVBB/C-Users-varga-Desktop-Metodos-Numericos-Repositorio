public class MetodoSimpson385 {
    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        int n = 12; // Múltiplo de 3

        double resultado = simpson38(a, b, n);
        System.out.printf("∫ sen²(x) dx [0, π] ≈ %.10f%n", resultado);
        System.out.printf("Valor exacto (π/2)     = %.10f%n", Math.PI / 2);
    }

    public static double funcion(double x) {
        return Math.sin(x) * Math.sin(x);
    }

    public static double simpson38(double a, double b, int n) {
        while (n % 3 != 0) n++;
        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += (i % 3 == 0) ? 2 * funcion(x) : 3 * funcion(x);
        }
        return (3 * h / 8) * suma;
    }
}
