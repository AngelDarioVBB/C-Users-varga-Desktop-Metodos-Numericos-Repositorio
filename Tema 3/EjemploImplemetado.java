public class EliminacionGaussiana {

    public static void main(String[] args) {
        // Matriz de coeficientes (A)
        double[][] A = {
            {3, 2, -1},
            {2, -2, 4},
            {-1, 0.5, -1}
        };
        // Vector de términos independientes (b)
        double[] b = {1, -2, 0};

        double[] solucion = resolver(A, b);

        // Imprimir resultados
        System.out.println("Solución del sistema:");
        for (int i = 0; i < solucion.length; i++) {
            System.out.printf("x[%d] = %.2f%n", i, solucion[i]);
        }
    }

    public static double[] resolver(double[][] A, double[] b) {
        int n = b.length;

        // 1. Fase de Eliminación hacia adelante
        for (int i = 0; i < n; i++) {
            // Pivoteo: Buscar el máximo en la columna para mayor precisión (opcional)
            for (int k = i + 1; k < n; k++) {
                double factor = A[k][i] / A[i][i];
                b[k] -= factor * b[i];
                for (int j = i; j < n; j++) {
                    A[k][j] -= factor * A[i][j];
                }
            }
        }

        // 2. Fase de Sustitución hacia atrás
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0.0;
            for (int j = i + 1; j < n; j++) {
                suma += A[i][j] * x[j];
            }
            x[i] = (b[i] - suma) / A[i][i];
        }
        return x;
    }
}