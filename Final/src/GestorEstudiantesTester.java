import java.util.List;

public class GestorEstudiantesTester {
    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        String rutaArchivo = "/Users/juanangel/Documents/Facultad/Taller IV/Final/tema2.csv";

        gestor.leerDatosDesdeCSV(rutaArchivo);

        System.out.println("Buscar estudiantes por nombre 'Juan':");
        List<Estudiante> estudiantesPorNombre = gestor.buscarEstudiantesPorNombre("Juan");
        for (Estudiante estudiante : estudiantesPorNombre) {
            System.out.println(estudiante);
        }

        System.out.println("\nBuscar estudiantes por apellido 'Perez':");
        List<Estudiante> estudiantesPorApellido = gestor.buscarEstudiantesPorApellido("Perez");
        for (Estudiante estudiante : estudiantesPorApellido) {
            System.out.println(estudiante);
        }

        System.out.println("\nMostrar información de estudiante con matrícula '12345':");
        gestor.mostrarInformacionEstudiante("12345");

        System.out.println("\nGenerar informe de estudiantes:");
        gestor.generarInforme("/Users/juanangel/Documents/Facultad/Taller IV/Final/informe_estudiantes.txt");
    }
}
