public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    private static final String[] nombresMeses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    private static final int[] diasPorMes = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    // Constructor para el formato MM/DD/AAAA
    public Fecha(int mes, int dia, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Constructor para el formato "Junio 15, 1992"
    public Fecha(String nombreMes, int dia, int anio) {
        this.dia = dia;
        this.anio = anio;
        this.mes = convertirMesANumero(nombreMes);
    }

    // Constructor para el formato DDD AAAA
    public Fecha(int diaDelAnio, int anio) {
        this.anio = anio;
        this.mes = 1;
        this.dia = diaDelAnio;

        for (int i = 0; i < nombresMeses.length; i++) {
            int diasEnMes = diasPorMes[i];
            if (esBisiesto(anio) && i == 1) {
                diasEnMes++; // Febrero tiene 29 días en un año bisiesto
            }
            if (this.dia <= diasEnMes) {
                break;
            }
            this.dia -= diasEnMes;
            this.mes++;
        }
    }

    // Método para imprimir la fecha en formato MM/DD/AAAA
    public String formato1() {
        return String.format("%02d/%02d/%04d", mes, dia, anio);
    }

    // Método para imprimir la fecha en formato "Junio 15, 1992"
    public String formato2() {
        return String.format("%s %d, %d", nombresMeses[mes - 1], dia, anio);
    }

    // Método para imprimir la fecha en formato DDD AAAA
    public String formato3() {
        int diaDelAnio = dia;
        for (int i = 0; i < mes - 1; i++) {
            diaDelAnio += diasPorMes[i];
            if (esBisiesto(anio) && i == 1) {
                diaDelAnio++; // Febrero tiene 29 días en un año bisiesto
            }
        }
        return String.format("%03d %04d", diaDelAnio, anio);
    }

    // Método para convertir el nombre del mes a un número
    private int convertirMesANumero(String nombreMes) {
        for (int i = 0; i < nombresMeses.length; i++) {
            if (nombresMeses[i].equalsIgnoreCase(nombreMes)) {
                return i + 1;
            }
        }
        return -1; // valor inválido si no se encuentra el mes
    }

    // Método para verificar si un año es bisiesto
    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    public static void main(String[] args) {
        // Prueba de los constructores y métodos de impresión
        Fecha fecha1 = new Fecha(6, 15, 1992);
        System.out.println("Formato 1: " + fecha1.formato1());
        System.out.println("Formato 2: " + fecha1.formato2());
        System.out.println("Formato 3: " + fecha1.formato3());

        Fecha fecha2 = new Fecha("Junio", 15, 1992);
        System.out.println("Formato 1: " + fecha2.formato1());
        System.out.println("Formato 2: " + fecha2.formato2());
        System.out.println("Formato 3: " + fecha2.formato3());

        Fecha fecha3 = new Fecha(167, 1992);
        System.out.println("Formato 1: " + fecha3.formato1());
        System.out.println("Formato 2: " + fecha3.formato2());
        System.out.println("Formato 3: " + fecha3.formato3());
    }
}
