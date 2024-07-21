import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorPagosTSV implements AnalizadorPagosI {
    private List<Pago> pagos;

    public AnalizadorPagosTSV(String filePath) {
        pagos = new ArrayList<>();
        leerArchivo(filePath);
    }

    private void leerArchivo(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\\\t"); // Uso "\\\\t" para separar por el carácter literal '\t' ya que el caracter no me reconoce como tabulacion
                int id = Integer.parseInt(datos[0].trim());
                String fecha = datos[1].trim();
                double monto = Double.parseDouble(datos[2].trim());
                String nombreCliente = datos[3].trim();
                pagos.add(new Pago(id, fecha, monto, nombreCliente));
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
