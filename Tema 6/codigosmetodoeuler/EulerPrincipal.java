public class EulerPrincipal {

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

        System.out.println("=== Solución de EDO: Método de Euler ===");
        System.out.printf("Punto Inicial: (t0=%.2f, y0=%.2f)%n", t0, y0);
        System.out.printf("Tamaño de paso h = %.4f%n%n", h);

        double t = t0;
        double y = y0;
        int pasos = (int) Math.ceil((tf - t0) / h);

        for (int i = 0; i < pasos; i++) {
            double pendiente = f(t, y);
            y = y + h * pendiente;
            t = t + h;

            System.out.printf("Paso %2d -> t: %.2f | y aproximada: %.6f%n", (i + 1), t, y);
        }
        
        System.out.printf("%nSolución final estimada en t = %.2f es y = %.6f%n", t, y);
    }
}