public class MetodoSimpson132 {
    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        int n = 10; // Debe ser par

        double resultado = simpson13(a, b, n);
        System.out.printf("∫ 1/(1+x^2) dx [0,1] ≈ %.10f%n", resultado);
        System.out.printf("Valor exacto (π/4)       = %.10f%n", Math.PI / 4);
    }

    public static double funcion(double x) {
        return 1.0 / (1.0 + x * x);
    }

    public static double simpson13(double a, double b, int n) {
        if (n % 2 != 0) n++;
        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += (i % 2 == 1) ? 4 * funcion(x) : 2 * funcion(x);
        }
        return (h / 3) * suma;
    }
}
