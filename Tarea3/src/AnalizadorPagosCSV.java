import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorPagosCSV implements AnalizadorPagosI {
    private List<Pago> pagos;

    public AnalizadorPagosCSV(String filePath) {
        pagos = new ArrayList<>();
        leerArchivo(filePath);
    }

    private void leerArchivo(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0].trim());
                String fecha = datos[1].trim();
                double monto = Double.parseDouble(datos[2].trim());
                String nombreCliente = datos[3].trim();
                pagos.add(new Pago(id, fecha, monto, nombreCliente));
            }
        } catch (IOException e) {
            System.out.println("Archivo no existe o ruta invalida");
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
        System.out.println("\nPago con ID " + id + " no encontrado.\n");
    }

    @Override
    public void pago(int id) {
        for (Pago pago : pagos) {
            if (pago.getId() == id) {
                if (pago.getEstado().equals("Pendiente")) {
                    pago.setEstado("Pagado");
                    System.out.println("\nPago con ID " + id + " ha sido marcado como pagado.\n");
                } else {
                    System.out.println("\nPago con ID " + id + " ya está pagado.\n");
                }
                return;
            }
        }
        System.out.println("Pago con ID " + id + " no encontrado.");
    }

    public void imprimirPagos() {
        for (Pago pago : pagos) {
            System.out.println(pago);
        }
    }
}
