public class CuadraturaGaussiana {

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;

        System.out.println("=== Cuadratura Gaussiana ===");
        System.out.printf("∫ sen(x) dx [0, π] = 2.0000000000 (exacto)%n%n");

        // Probar con diferentes números de puntos
        for (int n = 2; n <= 5; n++) {
            double resultado = cuadraturaGaussiana(a, b, n);
            System.out.printf("n = %d: %.10f (error: %.2e)%n", 
                n, resultado, Math.abs(2.0 - resultado));
        }
    }

    public static double funcion(double x) {
        return Math.sin(x);
    }

    public static double cuadraturaGaussiana(double a, double b, int n) {
        double[] x, w;
        
        // Seleccionar puntos y pesos según n
        switch (n) {
            case 2:
                x = new double[]{-0.5773502692, 0.5773502692};
                w = new double[]{1.0000000000, 1.0000000000};
                break;
            case 3:
                x = new double[]{-0.7745966692, 0.0000000000, 0.7745966692};
                w = new double[]{0.5555555556, 0.8888888889, 0.5555555556};
                break;
            case 4:
                x = new double[]{-0.8611363116, -0.3399810436, 0.3399810436, 0.8611363116};
                w = new double[]{0.3478548451, 0.6521451549, 0.6521451549, 0.3478548451};
                break;
            case 5:
                x = new double[]{-0.9061798459, -0.5384693101, 0.0000000000, 0.5384693101, 0.9061798459};
                w = new double[]{0.2369268851, 0.4786286705, 0.5688888889, 0.4786286705, 0.2369268851};
                break;
            default:
                throw new IllegalArgumentException("n debe ser 2, 3, 4 o 5");
        }

        double suma = 0;
        double factor = (b - a) / 2;
        double medio = (b + a) / 2;

        for (int i = 0; i < n; i++) {
            double t = factor * x[i] + medio;
            suma += w[i] * funcion(t);
        }

        return factor * suma;
    }
}