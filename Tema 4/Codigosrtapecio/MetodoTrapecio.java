public class MetodoTrapecio {

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        int n = 100; // número de subintervalos

        double resultado = trapecio(a, b, n);
        System.out.printf("Aproximación de ∫ sen(x) dx [0, π] = %.6f%n", resultado);
    }

    public static double funcion(double x) {
        return Math.sin(x);
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