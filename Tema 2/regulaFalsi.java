public static double regulaFalsi(double a, double b, double tol, int Nmax) {
    double fa = f(a);
    double fb = f(b);

    if (fa * fb >= 0) {
        throw new IllegalArgumentException("f(a) y f(b) deben tener signos opuestos");
    }

    double c = a;
    for (int k = 0; k < Nmax; k++) {
        // punto de intersección de la secante con el eje x
        c = a - fa * (b - a) / (fb - fa);
        double fc = f(c);

        if (Math.abs(fc) < tol) {
            return c; // éxito
        }

        if (fa * fc < 0) {
            b = c;
            fb = fc;
        } else {
            a = c;
            fa = fc;
        }
    }

    return c; // última aproximación
}
