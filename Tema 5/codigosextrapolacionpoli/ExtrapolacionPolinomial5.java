public class ExtrapolacionPolinomial5 {

    public static double evaluarLagrange(double[] x, double[] y, double xEval) {
        int n = x.length;
        double resultado = 0.0;
        for (int i = 0; i < n; i++) {
            double termino = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) termino *= (xEval - x[j]) / (x[i] - x[j]);
            }
            resultado += termino;
        }
        return resultado;
    }

    public static void analizarYExtrapolar(double[] x, double[] y, double targetX) {
        int n = x.length;
        
        // Ejecutar extrapolación
        double resultado = evaluarLagrange(x, y, targetX);
        
        // Analizar la última tendencia local conocida de los datos reales
        double ultimaPendienteReal = (y[n-1] - y[n-2]) / (x[n-1] - x[n-2]);
        // Analizar la pendiente proyectada hacia el nuevo punto
        double pendienteProyeccion = (resultado - y[n-1]) / (targetX - x[n-1]);
        
        System.out.println("--- Filtro de Seguridad de Tendencia Polinomial ---");
        System.out.printf("Resultado numérico obtenido: %.4f%n", resultado);
        
        // Si la dirección de la curva cambia drásticamente respecto al último tramo medido, 
        // podría ser un artefacto del polinomio (Divergencia)
        if (Math.signum(ultimaPendienteReal) != Math.signum(pendienteProyeccion) && Math.abs(pendienteProyeccion) > 10 * Math.abs(ultimaPendienteReal)) {
            System.err.println("ALERTA: Posible inestabilidad numérica detectada (Efecto Runge). El polinomio oscila bruscamente.");
        } else {
            System.out.println("Análisis de estabilidad: Proyección dentro de márgenes de variación geométricos aceptables.");
        }
    }

    public static void main(String[] args) {
        // Datos experimentales con un ligero ruido
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2.1, 3.9, 6.2, 8.0, 10.1}; // Tendencia casi lineal/suave
        
        // Un grado 4 (5 puntos) evaluado lejos del nodo final suele dispararse erráticamente
        double objetivoLejano = 7.5; 
        analizarYExtrapolar(x, y, objetivoLejano);
    }
}