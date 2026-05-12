public class CuadraturaGaussiana3 {
    public static void main(String[] args) {
        double a = 0;
        double b = 4;

        System.out.println("=== Cuadratura Gaussiana: ∫ √x dx [0,4] ===");
        System.out.printf("Valor exacto (16/3) = %.15f%n%n", 16.0 / 3.0);

        for (int n = 2; n <= 5; n++) {
            double resultado = cuadraturaGaussiana(a, b, n);
            System.out.printf("n = %d: %.15f (error: %.2e)%n",
                n, resultado, Math.abs(16.0 / 3.0 - resultado));
        }
    }

    public static double funcion(double x) {
        return Math.sqrt(x);
    }

    public static double cuadraturaGaussiana(double a, double b, int n) {
        double[] x, w;
        
        switch (n) {
            case 2:
                x = new double[]{-0.5773502691896257, 0.5773502691896257};
                w = new double[]{1.0, 1.0};
                break;
            case 3:
                x = new double[]{-0.7745966692414834, 0.0, 0.7745966692414834};
                w = new double[]{0.5555555555555556, 0.8888888888888888, 0.5555555555555556};
                break;
            case 4:
                x = new double[]{-0.8611363115940526, -0.3399810435848563, 0.3399810435848563, 0.8611363115940526};
                w = new double[]{0.3478548451374538, 0.6521451548625461, 0.6521451548625461, 0.3478548451374538};
                break;
            case 5:
                x = new double[]{-0.9061798459386640, -0.5384693101056831, 0.0, 0.5384693101056831, 0.9061798459386640};
                w = new double[]{0.2369268850561891, 0.4786286704993665, 0.5688888888888889, 0.4786286704993665, 0.2369268850561891};
                break;
            default:
                throw new IllegalArgumentException("n debe ser 2, 3, 4 o 5");
        }

        double factor = (b - a) / 2;
        double medio = (b + a) / 2;
        double suma = 0;

        for (int i = 0; i < n; i++) {
            double t = factor * x[i] + medio;
            suma += w[i] * funcion(t);
        }

        return factor * suma;
    }
}
