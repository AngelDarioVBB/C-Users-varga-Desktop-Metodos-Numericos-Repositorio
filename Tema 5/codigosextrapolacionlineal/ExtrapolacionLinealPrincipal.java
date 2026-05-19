public class ExtrapolacionLinealPrincipal {

    public static void main(String[] args) {
        // Datos históricos de población (Años y Millones de habitantes)
        double[] anios = {2018, 2019, 2020, 2021, 2022};
        double[] poblacion = {100.5, 102.1, 103.8, 105.4, 107.0}; 

        double anioProyeccion = 2025; // Fuera del rango

        System.out.println("=== Proyección por Extrapolación Lineal ===");
        try {
            double poblacionEstimada = extrapolar(anios, poblacion, anioProyeccion);
            System.out.printf("Población proyectada para el año %.0f: %.2f millones%n", 
                              anioProyeccion, poblacionEstimada);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double extrapolar(double[] x, double[] y, double xEval) {
        int n = x.length;
        if (n < 2) throw new IllegalArgumentException("Se requieren al menos 2 puntos.");

        // Solo usar los dos últimos puntos asumiendo tendencia reciente
        double x1 = x[n - 2], y1 = y[n - 2];
        double x2 = x[n - 1], y2 = y[n - 1];

        double pendiente = (y2 - y1) / (x2 - x1);
        return y2 + pendiente * (xEval - x2);
    }
}