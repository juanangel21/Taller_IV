import java.util.Arrays;

public class EnteroEnorme {
    private int[] digitos;

    public EnteroEnorme() {
        digitos = new int[40];
    }

    public EnteroEnorme(String numero) {
        this();
        int longitud = numero.length();
        for (int i = 0; i < longitud; i++) {
            digitos[39 - i] = Character.getNumericValue(numero.charAt(longitud - 1 - i));
        }
    }

    public void entrada(String numero) {
        Arrays.fill(digitos, 0);
        int longitud = numero.length();
        for (int i = 0; i < longitud; i++) {
            digitos[39 - i] = Character.getNumericValue(numero.charAt(longitud - 1 - i));
        }
    }

    public void salida(String descripcion) {
        boolean encabezado = false;
        System.out.print(descripcion + ": ");
        for (int i = 0; i < 40; i++) {
            if (digitos[i] != 0) {
                encabezado = true;
            }
            if (encabezado) {
                System.out.print(digitos[i]);
            }
        }
        if (!encabezado) {
            System.out.print(0);
        }
        System.out.println();
    }

    public EnteroEnorme sumar(EnteroEnorme otro) {
        EnteroEnorme resultado = new EnteroEnorme();
        int acarreo = 0;
        for (int i = 39; i >= 0; i--) {
            int suma = this.digitos[i] + otro.digitos[i] + acarreo;
            resultado.digitos[i] = suma % 10;
            acarreo = suma / 10;
        }
        return resultado;
    }

    public EnteroEnorme restar(EnteroEnorme otro) {
        EnteroEnorme resultado = new EnteroEnorme();
        int acarreo = 0;
        for (int i = 39; i >= 0; i--) {
            int resta = this.digitos[i] - otro.digitos[i] - acarreo;
            if (resta < 0) {
                resta += 10;
                acarreo = 1;
            } else {
                acarreo = 0;
            }
            resultado.digitos[i] = resta;
        }
        return resultado;
    }

    public boolean esIgualA(EnteroEnorme otro) {
        return Arrays.equals(this.digitos, otro.digitos);
    }

    public boolean noEsIgualA(EnteroEnorme otro) {
        return !this.esIgualA(otro);
    }

    public boolean esMayorQue(EnteroEnorme otro) {
        for (int i = 0; i < 40; i++) {
            if (this.digitos[i] > otro.digitos[i]) {
                return true;
            } else if (this.digitos[i] < otro.digitos[i]) {
                return false;
            }
        }
        return false;
    }

    public boolean esMenorQue(EnteroEnorme otro) {
        for (int i = 0; i < 40; i++) {
            if (this.digitos[i] < otro.digitos[i]) {
                return true;
            } else if (this.digitos[i] > otro.digitos[i]) {
                return false;
            }
        }
        return false;
    }

    public boolean esMayorOIgualA(EnteroEnorme otro) {
        return this.esMayorQue(otro) || this.esIgualA(otro);
    }

    public boolean esMenorOIgualA(EnteroEnorme otro) {
        return this.esMenorQue(otro) || this.esIgualA(otro);
    }

    public boolean esCero() {
        for (int digito : digitos) {
            if (digito != 0) {
                return false;
            }
        }
        return true;
    }

    // Métodos adicionales para multiplicar, dividir y residuo
    public EnteroEnorme multiplicar(EnteroEnorme otro) {
        EnteroEnorme resultado = new EnteroEnorme();
        for (int i = 39; i >= 0; i--) {
            int[] temp = new int[40];
            int acarreo = 0;
            for (int j = 39; j >= 0; j--) {
                if (j - (39 - i) >= 0) {
                    int producto = otro.digitos[i] * this.digitos[j] + acarreo;
                    temp[j - (39 - i)] = producto % 10;
                    acarreo = producto / 10;
                }
            }
            resultado = resultado.sumar(new EnteroEnorme(Arrays.toString(temp).replaceAll("\\[|\\]|,|\\s", "")));
        }
        return resultado;
    }

    public EnteroEnorme dividir(EnteroEnorme otro) {
        if (otro.esCero()) {
            throw new ArithmeticException("División por cero");
        }

        EnteroEnorme dividendo = new EnteroEnorme(Arrays.toString(this.digitos).replaceAll("\\[|\\]|,|\\s", ""));
        EnteroEnorme divisor = new EnteroEnorme(Arrays.toString(otro.digitos).replaceAll("\\[|\\]|,|\\s", ""));
        EnteroEnorme resultado = new EnteroEnorme();

        while (dividendo.esMayorOIgualA(divisor)) {
            dividendo = dividendo.restar(divisor);
            resultado = resultado.sumar(new EnteroEnorme("1"));
        }

        return resultado;
    }

    public EnteroEnorme residuo(EnteroEnorme otro) {
        EnteroEnorme cociente = this.dividir(otro);
        EnteroEnorme producto = cociente.multiplicar(otro);
        return this.restar(producto);
    }

    public static void main(String[] args) {
        EnteroEnorme num1 = new EnteroEnorme("1234567890123456789012345678901234567890");
        EnteroEnorme num2 = new EnteroEnorme("987654321098765432109876543210987654321");

        num1.salida("Número 1");
        num2.salida("Número 2");

        EnteroEnorme suma = num1.sumar(num2);
        suma.salida("Suma");

        EnteroEnorme resta = num1.restar(num2);
        resta.salida("Resta");

        System.out.println("¿Número 1 es igual a Número 2?: " + num1.esIgualA(num2));
        System.out.println("¿Número 1 no es igual a Número 2?: " + num1.noEsIgualA(num2));
        System.out.println("¿Número 1 es mayor que Número 2?: " + num1.esMayorQue(num2));
        System.out.println("¿Número 1 es menor que Número 2?: " + num1.esMenorQue(num2));
        System.out.println("¿Número 1 es mayor o igual a Número 2?: " + num1.esMayorOIgualA(num2));
        System.out.println("¿Número 1 es menor o igual a Número 2?: " + num1.esMenorOIgualA(num2));
        System.out.println("¿Número 1 es cero?: " + num1.esCero());

        EnteroEnorme multiplicacion = num1.multiplicar(num2);
        multiplicacion.salida("Multiplicación");

        EnteroEnorme division = num1.dividir(num2);
        division.salida("División");

        EnteroEnorme residuo = num1.residuo(num2);
        residuo.salida("Residuo");
    }
}
