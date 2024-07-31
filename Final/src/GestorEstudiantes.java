import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorEstudiantes {
    private List<Estudiante> estudiantes;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void leerDatosDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String numeroMatricula = datos[2];
                    double nota1 = Double.parseDouble(datos[3]);
                    double nota2 = Double.parseDouble(datos[4]);
                    double nota3 = Double.parseDouble(datos[5]);
                    Estudiante estudiante = new Estudiante(nombre, apellido, numeroMatricula, nota1, nota2, nota3);
                    estudiantes.add(estudiante);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public List<Estudiante> buscarEstudiantesPorNombre(String nombre) {
        return estudiantes.stream()
                .filter(est -> est.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    public List<Estudiante> buscarEstudiantesPorApellido(String apellido) {
        return estudiantes.stream()
                .filter(est -> est.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
    }

    public Estudiante buscarEstudiantePorNumeroMatricula(String numeroMatricula) {
        return estudiantes.stream()
                .filter(est -> est.getNumeroMatricula().equals(numeroMatricula))
                .findFirst()
                .orElse(null);
    }

    public void mostrarInformacionEstudiante(String numeroMatricula) {
        Estudiante estudiante = buscarEstudiantePorNumeroMatricula(numeroMatricula);
        if (estudiante != null) {
            System.out.println(estudiante);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public void generarInforme(String rutaArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Estudiante estudiante : estudiantes) {
                writer.println(estudiante.getNombre() + " " + estudiante.getApellido() + " - Promedio: " + estudiante.calcularPromedio());
            }
            System.out.println("Archivo generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el informe: " + e.getMessage());
        }
    }
}