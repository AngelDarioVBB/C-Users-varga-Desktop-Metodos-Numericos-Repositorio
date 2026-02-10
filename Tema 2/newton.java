public static double newton(double x0, double tol, int Nmax) {
    double x = x0;

    for (int k = 0; k < Nmax; k++) {
        double fx = f(x);
        double dfx = df(x);

        if (dfx == 0.0) {
            throw new ArithmeticException("Derivada cero, no se puede continuar");
        }

        double xNew = x - fx / dfx;

        if (Math.abs(xNew - x) < tol) {
            return xNew; // éxito
        }

        x = xNew;
    }

    return x; // última aproximación
}
