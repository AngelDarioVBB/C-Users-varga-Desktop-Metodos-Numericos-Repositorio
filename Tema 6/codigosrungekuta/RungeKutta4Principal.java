public class RungeKutta4Principal {

    // Ejemplo de EDO: y' = t - 2y
    public static double f(double t, double y) {
        return t - (2 * y);
    }

    public static void main(String[] args) {
        // Condiciones Iniciales del PVI
        double t0 = 0.0;
        double y0 = 1.0;
        double tf = 2.0;
        double h = 0.1; // Tamaño de paso

        System.out.println("=== Solución de EDO: Método Runge-Kutta 4 (RK4) ===");
        System.out.printf("Punto Inicial: (t0=%.2f, y0=%.2f)%n", t0, y0);
        System.out.printf("Tamaño de paso h = %.4f%n%n", h);
        
        double t = t0;
        double y = y0;
        int pasos = (int) Math.ceil((tf - t0) / h);

        for (int i = 0; i < pasos; i++) {
            double k1 = h * f(t, y);
            double k2 = h * f(t + h / 2.0, y + k1 / 2.0);
            double k3 = h * f(t + h / 2.0, y + k2 / 2.0);
            double k4 = h * f(t + h, y + k3);

            // Avance síncrono aplicando la ponderación clásica
            y = y + (k1 + 2.0 * k2 + 2.0 * k3 + k4) / 6.0;
            t = t + h;

            System.out.printf("Paso %2d -> t: %.2f | y aproximada: %.6f%n", (i + 1), t, y);
        }
        
        System.out.printf("%nSolución final estimada en t = %.2f es y = %.6f%n", t, y);
    }
}