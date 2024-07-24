public class Pago {
    private int id;
    private String fecha;
    private double monto;
    private String nombreCliente;
    private String estado;

    public Pago(int id, String fecha, double monto, String nombreCliente) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.nombreCliente = nombreCliente;
        this.estado = "Pendiente";
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pago [ID=" + id + ", Fecha=" + fecha + ", Monto=" + monto + ", Cliente=" + nombreCliente + ", Estado=" + estado + "]";
    }

    public void setEstado(String pagado) {
        this.estado = pagado;
    }
}
