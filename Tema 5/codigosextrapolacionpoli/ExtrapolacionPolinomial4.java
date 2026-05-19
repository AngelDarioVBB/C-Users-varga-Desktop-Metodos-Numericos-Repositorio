public class ExtrapolacionPolinomial4 {

    public static double evaluarLagrange(double[] x, double[] y, double xEval) {
        int n = x.length;
        double resultado = 0.0;

        for (int i = 0; i < n; i++) {
            double termino = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    termino *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            resultado += termino;
        }
        return resultado;
    }

    public static void main(String[] args) {
        double[] meses = {1, 2, 3};
        double[] rendimiento = {95.0, 92.0, 85.0}; // Simulación de desgaste de maquinaria

        double[] mesesFuturos = {4.0, 5.0, 6.0};

        System.out.println("--- Proyección por Lotes usando Lagrange ---");
        for (double m : mesesFuturos) {
            double res = evaluarLagrange(meses, rendimiento, m);
            System.out.printf("Mes Proyectado: %.1f -> Rendimiento Esperado: %.2f%%%n", m, res);
        }
    }
}