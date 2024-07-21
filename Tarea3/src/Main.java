public class Main {
    public static void main(String[] args) {
        AnalizadorPagosI analizadorCSV = new AnalizadorPagosCSV("/Users/juanangel/Documents/Facultad/Taller IV/Tarea 3/pago1.csv");
        System.out.println("Pagos en CSV:");
        analizadorCSV.imprimirPagos();

        AnalizadorPagosI analizadorTSV = new AnalizadorPagosTSV("/Users/juanangel/Documents/Facultad/Taller IV/Tarea 3/pago2.tsv");
        System.out.println("\nPagos en TSV:");
        analizadorTSV.imprimirPagos();

        AnalizadorPagosI analizadorTXT = new AnalizadorPagosTXT("/Users/juanangel/Documents/Facultad/Taller IV/Tarea 3/pago3.txt");
        System.out.println("\nPagos en TXT:");
        analizadorTXT.imprimirPagos();
    }
}
