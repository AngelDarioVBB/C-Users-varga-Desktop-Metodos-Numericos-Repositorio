public static double biseccion(double a, double b, double tol, int Nmax) {
    double fa = f(a);
    double fb = f(b);

    if (fa * fb >= 0) {
        throw new IllegalArgumentException("f(a) y f(b) deben tener signos opuestos");
    }

    double c = a;
    for (int k = 0; k < Nmax; k++) {
        c = (a + b) / 2.0;
        double fc = f(c);

        if (Math.abs(fc) < tol || (b - a) / 2.0 < tol) {
            // éxito
            return c;
        }

        if (fa * fc < 0) {
            b = c;
            fb = fc;
        } else {
            a = c;
            fa = fc;
        }
    }

    // no alcanzó tolerancia en Nmax iteraciones
    return c;
}
