public class MetodoSimpson134 {
    public static void main(String[] args) {
        double a = 0;
        double b = 2;
        int n = 10;

        double resultado = simpson13(a, b, n);
        System.out.printf("∫ ln(x+1) dx [0,2] ≈ %.10f%n", resultado);
        System.out.printf("Valor exacto (3ln3-2) = %.10f%n", 3 * Math.log(3) - 2);
    }

    public static double funcion(double x) {
        return Math.log(x + 1);
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
