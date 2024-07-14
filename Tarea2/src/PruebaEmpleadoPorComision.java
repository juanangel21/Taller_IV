public class PruebaEmpleadoPorComision {
    public static void main(String[] args) {
        EmpleadoPorComision empleado = new EmpleadoPorComision(
                "Sue", "Jones", "222-22-2222", 10000, .06);

        System.out.println("Información del empleado obtenida por los métodos get:");
        System.out.printf("%n%s %s%n", "Primer nombre es", empleado.obtenerPrimerNombre());
        System.out.printf("%s %s%n", "Apellido paterno es", empleado.obtenerApellidoPaterno());
        System.out.printf("%s %s%n", "Número de seguro social es", empleado.obtenerNumeroSeguroSocial());
        System.out.printf("%s %.2f%n", "Ventas brutas es", empleado.obtenerVentasBrutas());
        System.out.printf("%s %.2f%n", "Tarifa de comisión es", empleado.obtenerTarifaComision());

        empleado.establecerVentasBrutas(5000);
        empleado.establecerTarifaComision(.1);

        System.out.printf("%n%s:%n%n%s%n",
                "Información actualizada del empleado obtenida por toString", empleado);
    }
}
