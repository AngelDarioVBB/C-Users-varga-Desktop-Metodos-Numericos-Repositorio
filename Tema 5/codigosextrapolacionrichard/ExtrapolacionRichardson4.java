import java.util.function.Function;

public class ExtrapolacionRichardson4 {
    
    private static double segundaDerivadaCentral(Function<Double, Double> f, double x, double h) {
        return (f.apply(x + h) - 2 * f.apply(x) + f.apply(x - h)) / (h * h);
    }

    public static void main(String[] args) {
        Function<Double, Double> f = Math::cos;
        double x = Math.PI / 4; // 45 grados
        double h = 0.2;

        double d2H = segundaDerivadaCentral(f, x, h);
        double d2H2 = segundaDerivadaCentral(f, x, h / 2.0);

        // Operación de Richardson
        double richardson = d2H2 + (d2H2 - d2H) / 3.0;
        double valorReal = -Math.cos(Math.PI / 4); // f''(x) = -cos(x)

        System.out.println("--- Richardson para Segunda Derivada ---");
        System.out.printf("Error Base (h=0.2) : %.10f%n", Math.abs(valorReal - d2H));
        System.out.printf("Error Base (h=0.1) : %.10f%n", Math.abs(valorReal - d2H2));
        System.out.printf("Error Richardson   : %.10f%n", Math.abs(valorReal - richardson));
    }
}