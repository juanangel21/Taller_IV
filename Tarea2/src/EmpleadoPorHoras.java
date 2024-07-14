public class EmpleadoPorHoras extends Empleado {
    private double horas;
    private double sueldo;
    private double horaSueldo;

    // Constructor
    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, String numeroSeguroSocial,
                            double sueldo, double horas) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        establecerSueldo(sueldo);
        establecerHoras(horas);
    }

    // Métodos establecer y obtener
    public void establecerSueldo(double sueldo) {
        if (sueldo < 0.0) {
            throw new IllegalArgumentException("El sueldo debe ser >= 0.0");
        }

        this.sueldo = sueldo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public void establecerHoras(double horas) {
        if (horas < 0.0 || horas > 168.0) {
            throw new IllegalArgumentException("Las horas deben estar entre 0 y 168");
        }

        this.horas = horas;
    }

    public double obtenerHoras() {
        return horas;
    }

    public double obtenerSueldoHoras() {
        horaSueldo = sueldo * horas;
        return horaSueldo;
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("%s\n%s: %.2f; %s: %.2f, %s: %.2f",
                super.toString(),
                "Horas trabajadas", obtenerHoras(),
                "Sueldo por hora", obtenerSueldo(),
                "Sueldo a cobrar es", + obtenerSueldoHoras());
    }
}