public class SistemaEDOPrincipal {

    // Sistema del Péndulo Simple: Y[0] = theta (posición), Y[1] = omega (velocidad)
    public static double[] F(double t, double[] Y) {
        double g = 9.81;
        double L = 1.0;
        
        double[] dY = new double[2];
        dY[0] = Y[1];                         // y1' = y2
        dY[1] = -(g / L) * Math.sin(Y[0]);    // y2' = -(g/L)*sin(y1)
        return dY;
    }

    public static void main(String[] args) {
        double t0 = 0.0;
        double tf = 1.0;
        double h = 0.1;

        // Condiciones iniciales: theta = 45 grados (en radianes), velocidad = 0
        double[] Y = { Math.toRadians(45.0), 0.0 };

        System.out.println("=== Solución de Sistemas EDO: RK4 Vectorial ===");
        System.out.printf("Estado Inicial -> t: %.1f | Posicion: %.4f rad | Velocidad: %.4f rad/s%n%n", t0, Y[0], Y[1]);

        double t = t0;
        int pasos = (int) Math.ceil((tf - t0) / h);

        for (int i = 0; i < pasos; i++) {
            int m = Y.length;
            
            double[] k1 = F(t, Y);
            
            // Vectores auxiliares para las evaluaciones intermedias vectoriales
            double[] aux2 = new double[m];
            for(int j=0; j<m; j++) aux2[j] = Y[j] + k1[j] * h / 2.0;
            double[] k2 = F(t + h / 2.0, aux2);
            
            double[] aux3 = new double[m];
            for(int j=0; j<m; j++) aux3[j] = Y[j] + k2[j] * h / 2.0;
            double[] k3 = F(t + h / 2.0, aux3);
            
            double[] aux4 = new double[m];
            for(int j=0; j<m; j++) aux4[j] = Y[j] + k3[j] * h;
            double[] k4 = F(t + h, aux4);

            // Actualización simultánea del vector de estado
            for (int j = 0; j < m; j++) {
                Y[j] = Y[j] + (h / 6.0) * (k1[j] + 2.0 * k2[j] + 2.0 * k3[j] + k4[j]);
            }
            t = t + h;

            System.out.printf("Paso %2d -> t: %.1f | Posicion: %.5f | Velocidad: %.5f%n", (i + 1), t, Y[0], Y[1]);
        }
    }
}