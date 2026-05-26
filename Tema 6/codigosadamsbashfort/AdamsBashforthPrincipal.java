public class AdamsBashforthPrincipal {

    // Ejemplo de EDO: y' = t - 2y
    public static double f(double t, double y) {
        return t - (2 * y); 
    }

    // Rutina auxiliar de RK4 para generar las 3 iteraciones de arranque inicial
    public static double rk4Paso(double t, double y, double h) {
        double k1 = h * f(t, y);
        double k2 = h * f(t + h / 2.0, y + k1 / 2.0);
        double k3 = h * f(t + h / 2.0, y + k2 / 2.0);
        double k4 = h * f(t + h, y + k3);
        return y + (k1 + 2.0 * k2 + 2.0 * k3 + k4) / 6.0;
    }

    public static void main(String[] args) {
        // Condiciones Iniciales del PVI
        double t0 = 0.0;
        double y0 = 1.0;
        double tf = 2.0;
        double h = 0.1; // Tamaño de paso

        System.out.println("=== Solución de EDO: Adams-Bashforth de 4 Pasos ===");

        int totalPasos = (int) Math.ceil((tf - t0) / h);
        double[] t = new double[totalPasos + 1];
        double[] y = new double[totalPasos + 1];

        // 1. Fase de Arranque Obligatoria con RK4
        t[0] = t0;
        y[0] = y0;
        System.out.printf("Arranque [P0] -> t: %.2f | y: %.6f%n", t[0], y[0]);
        
        for (int i = 0; i < 3; i++) {
            y[i + 1] = rk4Paso(t[i], y[i], h);
            t[i + 1] = t[i] + h;
            System.out.printf("Arranque [P%d] -> t: %.2f | y: %.6f (Calculado via RK4)%n", (i + 1), t[i + 1], y[i + 1]);
        }

        // 2. Fase Principal Multipaso (Adams-Bashforth)
        for (int n = 3; n < totalPasos; n++) {
            double fn   = f(t[n], y[n]);
            double fn_1 = f(t[n - 1], y[n - 1]);
            double fn_2 = f(t[n - 2], y[n - 2]);
            double fn_3 = f(t[n - 3], y[n - 3]);

            // Aplicación de la fórmula explícita
            y[n + 1] = y[n] + (h / 24.0) * (55.0 * fn - 59.0 * fn_1 + 37.0 * fn_2 - 9.0 * fn_3);
            t[n + 1] = t[n] + h;

            System.out.printf("Principal [P%d] -> t: %.2f | y: %.6f (Calculado via Multipaso)%n", (n + 1), t[n + 1], y[n + 1]);
        }
    }
}