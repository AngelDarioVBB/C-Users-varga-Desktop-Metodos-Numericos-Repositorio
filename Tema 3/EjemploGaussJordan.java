public class GaussJordan {

    public static void main(String[] args) {
        double[][] A = {
            {2, -1, 3},
            {1, 1, 1},
            {3, -1, 2}
        };
        double[] b = {9, 6, 8};

        resolverGaussJordan(A, b);
    }

    public static void resolverGaussJordan(double[][] A, double[] b) {
        int n = b.length;

        for (int i = 0; i < n; i++) {
            // Normalizar la fila del pivote
            double pivote = A[i][i];
            for (int j = 0; j < n; j++) {
                A[i][j] /= pivote;
            }
            b[i] /= pivote;

            // Eliminar elementos en las otras filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = A[k][i];
                    for (int j = 0; j < n; j++) {
                        A[k][j] -= factor * A[i][j];
                    }
                    b[k] -= factor * b[i];
                }
            }
        }

        // Mostrar resultados
        System.out.println("Solución por Gauss-Jordan:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.2f%n", i, b[i]);
        }
    }
}