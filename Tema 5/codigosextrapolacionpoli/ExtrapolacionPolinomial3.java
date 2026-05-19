public class ExtrapolacionPolinomial3 {

    public static double extrapolarNeville(double[] x, double[] y, double xEval) {
        int n = x.length;
        double[][] q = new double[n][n];

        for (int i = 0; i < n; i++) {
            q[i][0] = y[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                double num = (xEval - x[j - i]) * q[j][i - 1] - (xEval - x[j]) * q[j - 1][i - 1];
                double den = x[j] - x[j - i];
                q[j][i] = num / den;
            }
        }
        return q[n - 1][n - 1];
    }

    public static void main(String[] args) {
        double[] semanas = {1, 2, 3, 4};
        double[] contagios = {5.0, 15.0, 45.0, 135.0}; // Tendencia puramente geométrica / curva
        
        double semanaSiguiente = 5.0;
        double estimacion = extrapolarNeville(semanas, contagios, semanaSiguiente);

        System.out.println("--- Extrapolación mediante Algoritmo de Neville ---");
        System.out.printf("Estimado para la semana %.0f: %.2f casos.%n", semanaSiguiente, estimacion);
    }
}