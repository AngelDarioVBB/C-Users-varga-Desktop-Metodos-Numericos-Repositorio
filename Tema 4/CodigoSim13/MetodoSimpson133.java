public class MetodoSimpson133 {
    public static void main(String[] args) {
        double a = 0;
        double b = 4;
        int n = 10;

        double resultado = simpson13(a, b, n);
        System.out.printf("∫ √x dx [0,4] ≈ %.10f%n", resultado);
        System.out.printf("Valor exacto (16/3)   = %.10f%n", 16.0 / 3.0);
    }

    public static double funcion(double x) {
        return Math.sqrt(x);
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
