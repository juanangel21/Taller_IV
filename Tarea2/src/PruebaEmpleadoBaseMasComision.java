public class PruebaEmpleadoBaseMasComision {
    public static void main(String[] args) {
        EmpleadoBaseMasComision empleado = new EmpleadoBaseMasComision(
                "Bob", "Lewis", "333-33-3333", 5000, .04, 300);

        System.out.println("Información del empleado obtenida por los métodos get:");
        System.out.printf("%n%s %s%n", "Primer nombre es", empleado.obtenerPrimerNombre());
        System.out.printf("%s %s%n", "Apellido paterno es", empleado.obtenerApellidoPaterno());
        System.out.printf("%s %s%n", "Número de seguro social es", empleado.obtenerNumeroSeguroSocial());
        System.out.printf("%s %.2f%n", "Ventas brutas es", empleado.obtenerVentasBrutas());
        System.out.printf("%s %.2f%n", "Tarifa de comisión es", empleado.obtenerTarifaComision());
        System.out.printf("%s %.2f%n", "Sueldo base es", empleado.obtenerSalarioBase());

        empleado.establecerSalarioBase(1000);

        System.out.printf("%n%s:%n%n%s%n",
                "Información actualizada del empleado obtenida por toString", empleado);
    }
}
