import java.util.Arrays;

public class ExtrapolacionLineal2 {
    private final double[] x;
    private final double[] y;

    public ExtrapolacionLineal2(double[] x, double[] y) {
        if (x.length != y.length || x.length < 2) {
            throw new IllegalArgumentException("Datos inválidos. Se necesitan al menos 2 puntos.");
        }
        this.x = Arrays.copyOf(x, x.length);
        this.y = Arrays.copyOf(y, y.length);
    }

    public double proyectar(double targetX) {
        int n = x.length;
        double x1, y1, x2, y2;

        if (targetX < x[0]) {
            // Extrapolación hacia atrás (Retrospectiva)
            x1 = x[0]; y1 = y[0];
            x2 = x[1]; y2 = y[1];
        } else if (targetX > x[n - 1]) {
            // Extrapolación hacia adelante (Proyección)
            x1 = x[n - 2]; y1 = y[n - 2];
            x2 = x[n - 1]; y2 = y[n - 1];
        } else {
            throw new IllegalArgumentException("El punto está dentro del dominio. Usa interpolación en su lugar.");
        }

        double m = (y2 - y1) / (x2 - x1);
        return y2 + m * (targetX - x2);
    }

    public static void main(String[] args) {
        double[] horas = {8, 9, 10, 11}; // 8:00 AM a 11:00 AM
        double[] temperatura = {15.0, 16.5, 18.0, 19.5}; // Sube 1.5°C por hora
        
        ExtrapolacionLineal2 clima = new ExtrapolacionLineal2(horas, temperatura);
        
        System.out.println("--- Extrapolación Bidireccional ---");
        System.out.println("Temperatura estimada a las 7:00 AM: " + clima.proyectar(7.0) + " °C");
        System.out.println("Temperatura estimada a las 1:00 PM (13:00): " + clima.proyectar(13.0) + " °C");
    }
}