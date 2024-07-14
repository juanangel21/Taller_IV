public class PruebaEmpleadoPorHoras {
    public static void main(String[] args) {
        EmpleadoPorHoras empleado = new EmpleadoPorHoras(
                "John", "Doe",
                "444-44-4444", 15.50, 40);

        System.out.println("Información del empleado obtenida por los métodos get:");
        System.out.printf("%n%s %s%n", "Primer nombre es", empleado.obtenerPrimerNombre());
        System.out.printf("%s %s%n", "Apellido paterno es", empleado.obtenerApellidoPaterno());
        System.out.printf("%s %s%n", "Número de seguro social es", empleado.obtenerNumeroSeguroSocial());
        System.out.printf("%s %.2f%n", "Sueldo por hora es", empleado.obtenerSueldo());
        System.out.printf("%s %.2f%n", "Horas trabajadas es", empleado.obtenerHoras());
        System.out.printf("%s %.2f%n", "Sueldo a cobrar es", empleado.obtenerSueldoHoras());

//        empleado.establecerHoras(45);
//        empleado.establecerSueldo(20.00);

        System.out.printf("%n%s:%n%n%s%n",
                "Información actualizada del empleado obtenida por toString", empleado);
    }
}