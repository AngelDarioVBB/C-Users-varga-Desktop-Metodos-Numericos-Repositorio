import java.util.function.Function;

public class ExtrapolacionRichardson2 {
    
    private static double reglaTrapecio(Function<Double, Double> f, double a, double b, int intervalos) {
        double h = (b - a) / intervalos;
        double suma = 0.5 * (f.apply(a) + f.apply(b));
        for (int i = 1; i < intervalos; i++) {
            suma += f.apply(a + i * h);
        }
        return suma * h;
    }

    public static void main(String[] args) {
        Function<Double, Double> f = Math::sin;
        double a = 0;
        double b = Math.PI;

        // Evaluamos con 2 y 4 intervalos (reducción del paso a la mitad)
        double trapecio2 = reglaTrapecio(f, a, b, 2);
        double trapecio4 = reglaTrapecio(f, a, b, 4);

        // Extrapolación de Richardson para el error O(h^2) del trapecio
        double integralOptimizada = trapecio4 + (trapecio4 - trapecio2) / 3.0;
        double valorReal = 2.0; // Integral exacta de sin(x) de 0 a pi

        System.out.println("--- Aceleración de Richardson en Integración ---");
        System.out.printf("Error Trapecio (n=2): %.6f%n", Math.abs(valorReal - trapecio2));
        System.out.printf("Error Trapecio (n=4): %.6f%n", Math.abs(valorReal - trapecio4));
        System.out.printf("Error con Richardson: %.6f%n", Math.abs(valorReal - integralOptimizada));
    }
}