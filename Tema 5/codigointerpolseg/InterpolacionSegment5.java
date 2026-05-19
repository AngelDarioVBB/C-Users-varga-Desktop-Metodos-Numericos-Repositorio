public class InterpolacionSegment5 {
    private final double[] tData; // Parámetro artificial (tiempo)
    private final double[] xData;
    private final double[] yData;

    public InterpolacionSegment5(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los arreglos X e Y deben tener el mismo tamaño.");
        }
        
        this.xData = x;
        this.yData = y;
        this.tData = new double[x.length];
        
        // Creamos un parámetro 't' secuencial (0, 1, 2, 3...)
        for (int i = 0; i < tData.length; i++) {
            tData[i] = i; 
        }
    }

    // Método auxiliar privado para interpolar 1D
    private double interpolar1D(double[] arrT, double[] arrValores, double t) {
        for (int i = 0; i < arrT.length - 1; i++) {
            if (t >= arrT[i] && t <= arrT[i + 1]) {
                double pendiente = (arrValores[i + 1] - arrValores[i]) / (arrT[i + 1] - arrT[i]);
                return arrValores[i] + pendiente * (t - arrT[i]);
            }
        }
        return Double.NaN; // Si está fuera de rango
    }

    // Devuelve un arreglo [X, Y] para un instante t
    public double[] obtenerPunto(double t) {
        return new double[]{ 
            interpolar1D(tData, xData, t), 
            interpolar1D(tData, yData, t) 
        };
    }

    public static void main(String[] args) {
        // Trayectoria que forma una "C" (imposible de modelar con una sola función Y=f(X))
        double[] x = { 5.0, 2.0, 2.0, 5.0 };
        double[] y = { 0.0, 2.0, 8.0, 10.0 };
        
        InterpolacionSegment5 trayectoria = new InterpolacionSegment5(x, y);
        
        System.out.println("=== Interpolación Paramétrica 2D (Generación de Trayectoria) ===");
        
        // Evaluamos de t=0 a t=3 (tenemos 4 puntos en total)
        for (double t = 0; t <= 3.0; t += 0.5) {
            double[] pos = trayectoria.obtenerPunto(t);
            System.out.printf("Instante t=%.1f -> Coordenada (%.3f, %.3f)%n", t, pos[0], pos[1]);
        }
    }
}