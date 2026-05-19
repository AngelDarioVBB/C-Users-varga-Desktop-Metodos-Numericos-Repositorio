public class ExtrapolacionLineal3 {
    private double pendiente;
    private double interseccion; // Corte con el eje Y

    // Constructor que ajusta la recta por Mínimos Cuadrados
    public ExtrapolacionLineal3(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        this.pendiente = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        this.interseccion = (sumY - pendiente * sumX) / n;
    }

    public double extrapolarTendenciaGlobal(double targetX) {
        return (pendiente * targetX) + interseccion;
    }

    public static void main(String[] args) {
        // Datos ruidosos
        double[] dias = {1, 2, 3, 4, 5};
        double[] usuarios = {100, 110, 105, 125, 120}; // Tendencia al alza, pero con caídas
        
        ExtrapolacionLineal3 modelo = new ExtrapolacionLineal3(dias, usuarios);
        
        System.out.println("--- Extrapolación por Tendencia Global (Mínimos Cuadrados) ---");
        System.out.printf("Predicción para el Día 6: %.0f usuarios%n", modelo.extrapolarTendenciaGlobal(6));
        System.out.printf("Predicción para el Día 10: %.0f usuarios%n", modelo.extrapolarTendenciaGlobal(10));
    }
}