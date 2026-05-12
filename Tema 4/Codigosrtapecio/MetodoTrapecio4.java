public class MetodoTrapecio4 {
    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        int n = 100;

        double resultado = trapecio(a, b, n);
        System.out.printf("∫ 1/(1+x^2) dx [0,1] ≈ %.6f%n", resultado);
        System.out.printf("Valor exacto (π/4)   = %.6f%n", Math.PI / 4);
    }

    public static double funcion(double x) {
        return 1.0 / (1.0 + x * x);
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
