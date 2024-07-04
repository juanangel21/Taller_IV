public class Racional {
    private int numerador;
    private int denominador;

    // Constructor sin argumentos que inicializa a 1/1
    public Racional() {
        this(1, 1);
    }

    // Constructor que inicializa con valores dados
    public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser 0");
        }
        int gcd = gcd(numerador, denominador);
        this.numerador = numerador / gcd;
        this.denominador = denominador / gcd;
        if (this.denominador < 0) {
            this.numerador = -this.numerador;
            this.denominador = -this.denominador;
        }
    }

    // Método para calcular el máximo común divisor (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Método para sumar dos números racionales
    public Racional sumar(Racional otro) {
        int nuevoNumerador = this.numerador * otro.denominador + otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Método para restar dos números racionales
    public Racional restar(Racional otro) {
        int nuevoNumerador = this.numerador * otro.denominador - otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Método para multiplicar dos números racionales
    public Racional multiplicar(Racional otro) {
        int nuevoNumerador = this.numerador * otro.numerador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Método para dividir dos números racionales
    public Racional dividir(Racional otro) {
        if (otro.numerador == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        int nuevoNumerador = this.numerador * otro.denominador;
        int nuevoDenominador = this.denominador * otro.numerador;
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Método para imprimir en formato a/b
    public String aString() {
        return numerador + "/" + denominador;
    }

    // Método para imprimir en formato de punto flotante
    public String aFloatString(int precision) {
        double valor = (double) numerador / denominador;
        return String.format("%." + precision + "f", valor);
    }

    public static void main(String[] args) {
        // Prueba de los constructores y métodos
        Racional r1 = new Racional(2, 4);
        Racional r2 = new Racional(3, 9);

        System.out.println("Racional 1: " + r1.aString());
        System.out.println("Racional 2: " + r2.aString());

        Racional suma = r1.sumar(r2);
        System.out.println("Suma: " + suma.aString());

        Racional resta = r1.restar(r2);
        System.out.println("Resta: " + resta.aString());

        Racional multiplicacion = r1.multiplicar(r2);
        System.out.println("Multiplicación: " + multiplicacion.aString());

        Racional division = r1.dividir(r2);
        System.out.println("División: " + division.aString());

        System.out.println("Racional 1 en formato flotante: " + r1.aFloatString(2));
        System.out.println("Racional 2 en formato flotante: " + r2.aFloatString(2));
    }
}
