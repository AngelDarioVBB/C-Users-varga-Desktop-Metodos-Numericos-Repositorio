import java.util.Arrays;

public class InterpolacionSegment2 {
    
    // Encuentra el índice izquierdo del intervalo usando Búsqueda Binaria
    public static int encontrarIntervaloOptimo(double[] x, double valorX) {
        int index = Arrays.binarySearch(x, valorX);
        
        // Si es coincidencia exacta, retorna ese índice (salvo que sea el último)
        if (index >= 0) {
            return (index == x.length - 1) ? index - 1 : index;
        }
        
        // Si no es exacto, binarySearch retorna -(punto de inserción) - 1
        int insertPoint = -index - 1;
        
        if (insertPoint == 0 || insertPoint == x.length + 1) {
            throw new IllegalArgumentException("Extrapolación no permitida: valor fuera de rango.");
        }
        return insertPoint - 1; // Retorna el límite inferior del intervalo
    }

    public static void main(String[] args) {
        // Simulamos 10,000 puntos de datos
        double[] xGrandes = new double[10000];
        for (int i = 0; i < xGrandes.length; i++) xGrandes[i] = i * 0.5;
        
        double xBuscado = 4500.75; // Estará cerca del índice 9000
        
        long inicio = System.nanoTime();
        int intervalo = encontrarIntervaloOptimo(xGrandes, xBuscado);
        long fin = System.nanoTime();
        
        System.out.printf("Valor %.2f encontrado en el intervalo [%.2f, %.2f]%n", 
            xBuscado, xGrandes[intervalo], xGrandes[intervalo+1]);
        System.out.println("Tiempo de búsqueda: " + (fin - inicio) + " nanosegundos.");
    }
}