public class MetodoSimpson382 {
    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        int n = 9; // Múltiplo de 3

        double resultado = simpson38(a, b, n);
        System.out.printf("∫ 1/(1+x^2) dx [0,1] ≈ %.10f%n", resultado);
        System.out.printf("Valor exacto (π/4)       = %.10f%n", Math.PI / 4);
    }

    public static double funcion(double x) {
        return 1.0 / (1.0 + x * x);
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
