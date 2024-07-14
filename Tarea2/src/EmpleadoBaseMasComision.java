// Fig. 9.6: EmpleadoBaseMasComision.java
// La clase EmpleadoBaseMasComision representa a un empleado que recibe
// un salario base, además de la comisión.

public class EmpleadoBaseMasComision {
    private final String primerNombre;
    private final String apellidoPaterno;
    private final String numeroSeguroSocial;
    private double ventasBrutas; // ventas totales por semana
    private double tarifaComision; // porcentaje de comisión
    private double salarioBase; // salario base por semana

    // constructor con seis argumentos
    public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno,
                                   String numeroSeguroSocial, double ventasBrutas,
                                   double tarifaComision, double salarioBase) {
// la llamada implícita al constructor predeterminado de Object ocurre aquí 20
// si ventasBrutas son inválidas, lanza excepción
        if (ventasBrutas < 0.0)
            throw new IllegalArgumentException(
                    "Las ventas brutas deben ser >= 0.0");

// si tarifaComision es inválida, lanza excepción
        if (tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException(
                    "La tarifa de comisión debe ser > 0.0 y < 1.0");

// si salarioBase es inválido, lanza excepción
        if (salarioBase < 0.0)
            throw new IllegalArgumentException(
                    "El salario base debe ser >= 0.0");

        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
        this.salarioBase = salarioBase;
    } // fin del constructor

    // devuelve el primer nombre
    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    // devuelve el apellido paterno
    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    // devuelve el número de seguro social
    public String obtenerNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    // establece el monto de ventas brutas
    public void establecerVentasBrutas(double ventasBrutas) {
        if (ventasBrutas < 0.0)
            throw new IllegalArgumentException(
                    "Las ventas brutas deben ser >= 0.0");
        this.ventasBrutas = ventasBrutas;
    }

    // devuelve el monto de ventas brutas
    public double obtenerVentasBrutas() {
        return ventasBrutas;
    }

    // establece la tarifa de comisión
    public void establecerTarifaComision(double tarifaComision) {
        if (tarifaComision <= 0.0 || tarifaComision > 1.0) {
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
        }
        this.tarifaComision = tarifaComision;
    }

    // devuelve la tarifa de comisión
    public double obtenerTarifaComision() {
        return tarifaComision;
    }

    // establece el salario base
    public void establecerSalarioBase(double salarioBase) {
        if (salarioBase < 0.0){
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        }
        this.salarioBase = salarioBase;
    }

    // devuelve el salario base
    public double obtenerSalarioBase() {
        return salarioBase;
    }

    //calcula los ingresos
    public double ingresos(){
        return salarioBase + (tarifaComision * ventasBrutas);
    }

    // devuelve representacion String de EmpleadoBaseMasComision
    @Override
    public String toString() {
        return String.format(
                "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
                "empleado por comision con sueldo base", primerNombre, apellidoPaterno,
                "numero de seguro social", numeroSeguroSocial,
                "ventas brutas", ventasBrutas, "tarifa de comision", tarifaComision,
                "salario base", salarioBase);
    }
}