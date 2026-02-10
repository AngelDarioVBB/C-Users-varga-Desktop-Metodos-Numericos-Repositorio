public static double secante(double x0, double x1, double tol, int Nmax) {
    double f0 = f(x0);
    double f1 = f(x1);

    for (int k = 0; k < Nmax; k++) {
        double denom = (f1 - f0);
        if (denom == 0.0) {
            throw new ArithmeticException("División por cero en secante");
        }

        double x2 = x1 - f1 * (x1 - x0) / denom;
        double f2 = f(x2);

        if (Math.abs(x2 - x1) < tol || Math.abs(f2) < tol) {
            return x2; // éxito
        }

        // avanzar
        x0 = x1;
        f0 = f1;
        x1 = x2;
        f1 = f2;
    }

    return x1; // última aproximación
}
