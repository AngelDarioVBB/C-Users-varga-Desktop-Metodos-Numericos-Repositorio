public class Jacobi {

    public static void main(String[] args) {
        double[][] A = {
            {10, 2, 1},
            {1, 5, 1},
            {2, 3, 10}
        };
        double[] b = {7, -8, 6};
        double[] x0 = {0, 0, 0}; // Estimación inicial

        resolverJacobi(A, b, x0, 0.0001, 100);
    }

    public static void resolverJacobi(double[][] A, double[] b, double[] x, double tol, int maxIter) {
        int n = b.length;
        double[] xNuevo = new double[n];

        for (int k = 0; k < maxIter; k++) {
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * x[j];
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            // Calcular error (distancia simple)
            double error = 0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(xNuevo[i] - x[i]);
            }

            // Actualizar x para la siguiente iteración
            System.arraycopy(xNuevo, 0, x, 0, n);

            if (error < tol) {
                System.out.println("Convergencia alcanzada en la iteración " + (k + 1));
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.4f%n", i, x[i]);
        }
    }
}