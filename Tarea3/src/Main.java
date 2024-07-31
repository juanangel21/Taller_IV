public class Main {
    public static void main(String[] args) {

        // Leemos el archivo CSV
        AnalizadorPagosI analizadorCSV = new AnalizadorPagosCSV("/Users/juanangel/Documents/Facultad/Taller IV/Tarea 3/pago1.csv");
        System.out.println("Pagos en CSV:");

        // Mostramos la lista de pagos luego de leer el archivo CSV
        ((AnalizadorPagosCSV) analizadorCSV).imprimirPagos();

        // Consultar un pago específico
        analizadorCSV.consulta(2);

        // Marcar un pago como pagado
        analizadorCSV.pago(2);

        // Verificar el cambio de estado
        analizadorCSV.consulta(2);

        // Leemos el archivo TSV
        AnalizadorPagosI analizadorTSV = new AnalizadorPagosTSV("/Users/juanangel/Documents/Facultad/Taller IV/Tarea 3/pago2.tsv");
        System.out.println("\nPagos en TSV:");

        // Mostramos la lista de pagos luego de leer el archivo TSV
        ((AnalizadorPagosTSV) analizadorTSV).imprimirPagos();

        // Consultar un pago especifico
        analizadorTSV.consulta(8);

        // Marcar un pago como pagado
        analizadorTSV.pago(8);

        // Verificar el cambio de estado
        analizadorTSV.consulta(8);

        // Leemos el archivo TXT
        AnalizadorPagosI analizadorTXT = new AnalizadorPagosTXT("/Users/juanangel/Documents/Facultad/Taller IV/Tarea 3/pago3.txt");
        System.out.println("\nPagos en TXT:");

        // Mostramos la lista de pagos luego de leer el archivo TXT
        ((AnalizadorPagosTXT) analizadorTXT).imprimirPagos();

        // Consultar un pago específico
        analizadorTXT.consulta(14);

        // Marcar un pago como pagado
        analizadorTXT.pago(14);

        // Verificar el cambio de estado
        analizadorTXT.consulta(14);
    }
}
