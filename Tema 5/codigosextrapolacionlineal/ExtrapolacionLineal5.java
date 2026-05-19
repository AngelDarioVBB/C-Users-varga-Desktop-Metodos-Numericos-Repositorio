public class ExtrapolacionLineal5 {
    
    public static double extrapolacionSegura(double[] x, double[] y, double targetX) {
        int n = x.length;
        double rangoDatos = x[n - 1] - x[0];
        
        // Regla de negocio: No permitir extrapolar más allá del 20% del ancho del dominio original
        double limiteAdelante = x[n - 1] + (rangoDatos * 0.20);
        double limiteAtras = x[0] - (rangoDatos * 0.20);
        
        if (targetX > limiteAdelante) {
            throw new ArithmeticException("Límite excedido. Proyección máxima permitida hasta x=" + limiteAdelante);
        }
        if (targetX < limiteAtras) {
            throw new ArithmeticException("Límite excedido. Retrospección máxima permitida hasta x=" + limiteAtras);
        }
        
        // Si está en zona segura, extrapolamos normalmente con los extremos
        double x1, y1, x2, y2;
        if (targetX > x[n - 1]) {
            x1 = x[n - 2]; y1 = y[n - 2];
            x2 = x[n - 1]; y2 = y[n - 1];
        } else {
            x1 = x[0]; y1 = y[0];
            x2 = x[1]; y2 = y[1];
        }
        
        return y2 + ((y2 - y1) / (x2 - x1)) * (targetX - x2);
    }

    public static void main(String[] args) {
        // Datos recolectados a lo largo de 100 metros
        double[] distancia = {0, 20, 40, 60, 80, 100};
        double[] desgaste = {0.5, 0.8, 1.2, 1.5, 1.9, 2.2};
        
        System.out.println("--- Extrapolación con Horizonte de Seguridad ---");
        try {
            // El rango total es 100. El 20% es 20. Límite máximo = 120.
            double res1 = extrapolacionSegura(distancia, desgaste, 110);
            System.out.println("Predicción en 110m (Segura): " + res1);
            
            // Intento de extrapolar en 150m (Debería fallar por estar muy lejos)
            System.out.println("Intentando proyectar en 150m...");
            double res2 = extrapolacionSegura(distancia, desgaste, 150);
            System.out.println(res2);
            
        } catch (ArithmeticException e) {
            System.err.println("OPERACIÓN ABORTADA: " + e.getMessage());
        }
    }
}