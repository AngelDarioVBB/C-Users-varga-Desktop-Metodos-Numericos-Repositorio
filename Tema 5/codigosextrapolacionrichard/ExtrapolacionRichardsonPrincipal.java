public class ExtrapolacionRichardsonPrincipal {

    // Definimos la función matemática de manera tradicional
    // f(x) = ln(x) -> En Java: Math.log(x)
    public static double f(double x) {
        return Math.log(x);
    }

    public static void main(String[] args) {
        double x = 2.0;          // Punto donde queremos evaluar la derivada
        double h = 0.4;          // Tamaño de paso inicial grande

        System.out.println("=== Extrapolacion de Richardson (Derivada Corregida) ===");
        
        // Paso 1: Aproximación base con paso completo h (0.4)
        double D_h = (f(x + h) - f(x - h)) / (2.0 * h);
        
        // Paso 2: Aproximación base con el paso a la mitad h/2 (0.2)
        double hMitad = h / 2.0;
        double D_h2 = (f(x + hMitad) - f(x - hMitad)) / (2.0 * hMitad);
        
        // Paso 3: Aplicación de la fórmula de Richardson para limpiar el error
        // A* = D(h/2) + [D(h/2) - D(h)] / 3
        double derivadaRichardson = D_h2 + (D_h2 - D_h) / 3.0;
        
        // Valor real teórico: f'(x) = 1/x -> f'(2) = 1/2 = 0.5
        double valorReal = 1.0 / x; 

        // Mostrar resultados y comparación de errores
        System.out.printf("Aproximacion con h=0.4: %.6f (Error: %.6f)%n", D_h, Math.abs(valorReal - D_h));
        System.out.printf("Aproximacion con h=0.2: %.6f (Error: %.6f)%n", D_h2, Math.abs(valorReal - D_h2));
        System.out.printf("Richardson optimizado : %.6f (Error: %.6f)%n", derivadaRichardson, Math.abs(valorReal - derivadaRichardson));
    }
}