public class MetodoSimpson135 {
    public static void main(String[] args) {
        double a = 0;
        double b = Math.sqrt(Math.PI); // aproximadamente 1.7724538509
        int n = 100; // Mayor n para mejor precisión

        double resultado = simpson13(a, b, n);
        System.out.printf("∫ cos(x²) dx [0, √π] ≈ %.10f%n", resultado);
        System.out.printf("Valor de referencia     = 0.8948314696%n");
    }

    public static double funcion(double x) {
        return Math.cos(x * x);
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
