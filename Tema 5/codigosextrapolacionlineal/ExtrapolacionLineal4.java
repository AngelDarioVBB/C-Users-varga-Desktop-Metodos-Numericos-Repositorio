public class ExtrapolacionLineal4 {
    
    // Extrapola usando el promedio de las pendientes de los últimos 'k' segmentos
    public static double extrapolacionSuavizada(double[] x, double[] y, double targetX, int segmentos) {
        int n = x.length;
        if (segmentos >= n) segmentos = n - 1;

        double sumaPendientes = 0;
        for (int i = n - 1; i >= n - segmentos; i--) {
            sumaPendientes += (y[i] - y[i - 1]) / (x[i] - x[i - 1]);
        }
        
        double pendientePromedio = sumaPendientes / segmentos;
        
        // Usamos el último punto conocido y la pendiente suavizada
        return y[n - 1] + pendientePromedio * (targetX - x[n - 1]);
    }

    public static void main(String[] args) {
        double[] tiempo = {1, 2, 3, 4, 5, 6};
        // Crecimiento constante, pero el último mes tuvo un salto anómalo (de 15 a 22)
        double[] ingresos = {10.0, 11.0, 12.0, 13.0, 15.0, 22.0}; 
        
        System.out.println("--- Extrapolación Suavizada para Mitigar Anomalías ---");
        
        // Extrapolación normal (usaría solo el salto de 15 a 22, pendiente = 7)
        double pNormal = ExtrapolacionLineal4.extrapolacionSuavizada(tiempo, ingresos, 7.0, 1);
        System.out.printf("Extrapolación usando 1 segmento (muy afectada por ruido): %.1f%n", pNormal);
        
        // Extrapolación suavizada (promedia los últimos 3 segmentos)
        double pSuavizada = ExtrapolacionLineal4.extrapolacionSuavizada(tiempo, ingresos, 7.0, 3);
        System.out.printf("Extrapolación suavizada de 3 segmentos (más conservadora): %.1f%n", pSuavizada);
    }
}