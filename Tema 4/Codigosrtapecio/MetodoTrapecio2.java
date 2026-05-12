public class MetodoTrapecio2 {
    public static void main(String[] args) {
        double a = 0;
        double b = 2;
        int n = 100; // subintervalos

        double resultado = trapecio(a, b, n);
        System.out.printf("∫ x^2 dx [0,2] ≈ %.6f%n", resultado);
    }

    public static double funcion(double x) {
        return x * x;
    }

    public static double trapecio(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += 2 * funcion(x);
        }
        return (h / 2) * suma;
    }
}
