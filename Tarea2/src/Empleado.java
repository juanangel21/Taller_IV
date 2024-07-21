
public class Empleado {
    private String primerNombre;
    private String apellidoPaterno;
    private String numeroSeguroSocial;

    // Constructor
    public Empleado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    // Getters
    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    public String obtenerNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%s %s\nNúmero de seguro social: %s",
                obtenerPrimerNombre(), obtenerApellidoPaterno(), obtenerNumeroSeguroSocial());
    }
}
