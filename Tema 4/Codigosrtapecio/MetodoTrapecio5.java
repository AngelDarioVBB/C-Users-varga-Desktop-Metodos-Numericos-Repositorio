public class  MetodoTrapecio5 {
    public static void main(String[] args) {
        double a = 0;
        double b = 4;
        int n = 100;

        double resultado = trapecio(a, b, n);
        System.out.printf("∫ √x dx [0,4] ≈ %.6f%n", resultado);
    }

    public static double funcion(double x) {
        return Math.sqrt(x);
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
