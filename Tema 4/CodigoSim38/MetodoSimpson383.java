public class MetodoSimpson383 {
    public static void main(String[] args) {
        double a = 0;
        double b = 9;
        int n = 9; // Múltiplo de 3

        double resultado = simpson38(a, b, n);
        System.out.printf("∫ √x dx [0,9] ≈ %.10f%n", resultado);
        System.out.printf("Valor exacto (18)    = %.10f%n", 18.0);
    }

    public static double funcion(double x) {
        return Math.sqrt(x);
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
