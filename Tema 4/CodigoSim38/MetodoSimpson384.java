public class MetodoSimpson384 {
     public static void main(String[] args) {
        double a = 0;
        double b = 3;
        int n = 9; // Múltiplo de 3

        double resultado = simpson38(a, b, n);
        System.out.printf("∫ ln(x+1) dx [0,3] ≈ %.10f%n", resultado);
        System.out.printf("Valor exacto (4ln4-3) = %.10f%n", 4 * Math.log(4) - 3);
    }

    public static double funcion(double x) {
        return Math.log(x + 1);
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
