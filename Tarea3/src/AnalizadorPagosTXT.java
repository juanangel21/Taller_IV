import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorPagosTXT implements AnalizadorPagosI {
    private List<Pago> pagos;

    public AnalizadorPagosTXT(String filePath) {
        pagos = new ArrayList<>();
        leerArchivo(filePath);
    }

    private void leerArchivo(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            Pago pagoActual = null;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.startsWith("ID:")) {
                    if (pagoActual != null) {
                        pagos.add(pagoActual);
                    }
                    int id = Integer.parseInt(linea.substring(3).trim());
                    pagoActual = new Pago(id, "", 0.0, "");
                } else if (linea.startsWith("Fecha:")) {
                    if (pagoActual != null) {
                        String fecha = linea.substring(6).trim();
                        pagoActual = new Pago(pagoActual.getId(), fecha, pagoActual.getMonto(), pagoActual.getNombreCliente());
                    }
                } else if (linea.startsWith("Monto:")) {
                    if (pagoActual != null) {
                        double monto = Double.parseDouble(linea.substring(6).trim());
                        pagoActual = new Pago(pagoActual.getId(), pagoActual.getFecha(), monto, pagoActual.getNombreCliente());
                    }
                } else if (linea.startsWith("Cliente:")) {
                    if (pagoActual != null) {
                        String cliente = linea.substring(8).trim();
                        pagoActual = new Pago(pagoActual.getId(), pagoActual.getFecha(), pagoActual.getMonto(), cliente);
                    }
                }
            }

            if (pagoActual != null) {
                pagos.add(pagoActual);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consulta(int id) {
        for (Pago pago : pagos) {
            if (pago.getId() == id) {
                System.out.println(pago);
                return;
            }
        }
        System.out.println("Pago con ID " + id + " no encontrado.");
    }

    @Override
    public void pago(int id) {
        System.out.println("Pago con ID " + id + " procesado.");
    }

    public void imprimirPagos() {
        for (Pago pago : pagos) {
            System.out.println(pago);
        }
    }
}
