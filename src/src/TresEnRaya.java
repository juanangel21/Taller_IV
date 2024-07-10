import java.util.Scanner;
import java.util.Random;

public class TresEnRaya {
    private int[][] tablero;
    private int jugadorActual;
    private Scanner scanner;
    private Random random;

    public TresEnRaya() {
        tablero = new int[3][3];
        jugadorActual = 1;
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void imprimirTablero() {
        System.out.println("  0 1 2"); // Encabezado de columnas
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " "); // Identificador de fila
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print(" ");
                } else if (tablero[i][j] == 1) {
                    System.out.print("X");
                } else if (tablero[i][j] == 2) {
                    System.out.print("O");
                }
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public boolean realizarMovimiento(int fila, int columna) {
        if (tablero[fila][columna] == 0) {
            tablero[fila][columna] = jugadorActual;
            return true;
        }
        return false;
    }

    public void cambiarJugador() {
        jugadorActual = (jugadorActual == 1) ? 2 : 1;
    }

    public boolean verificarGanador() {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual)
                return true;
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)
                return true;
        }
        // Verificar diagonales
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual)
            return true;
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)
            return true;

        return false;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == 0) return false;
            }
        }
        return true;
    }

    public void movimientoComputadora() {
        int fila, columna;
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (!realizarMovimiento(fila, columna));
    }

    public void jugar() {
        System.out.println("Bienvenido a Tres en Raya");
        System.out.print("¿Deseas jugar contra la computadora? (s/n): ");
        boolean modoComputadora = scanner.next().trim().toLowerCase().equals("s");
        System.out.print("¿Quieres ser el primer jugador? (s/n): ");
        int jugadorHumano = scanner.next().trim().toLowerCase().equals("s") ? 1 : 2;

        while (true) {
            imprimirTablero();
            System.out.println("Turno del jugador " + (jugadorActual == 1 ? "X" : "O"));

            if (modoComputadora && jugadorActual != jugadorHumano) {
                movimientoComputadora();
            } else {
                int fila = -1, columna = -1;
                boolean movimientoValido = false;
                while (!movimientoValido) {
                    try {
                        System.out.print("Ingrese la fila (0, 1, 2): ");
                        fila = Integer.parseInt(scanner.next());
                        System.out.print("Ingrese la columna (0, 1, 2): ");
                        columna = Integer.parseInt(scanner.next());

                        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
                            System.out.println("Coordenadas fuera de rango. Intente nuevamente.");
                        } else if (!realizarMovimiento(fila, columna)) {
                            System.out.println("Movimiento inválido. La celda ya está ocupada. Intente nuevamente.");
                        } else {
                            movimientoValido = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, ingrese números válidos.");
                    }
                }
            }

            if (verificarGanador()) {
                imprimirTablero();
                System.out.println("¡El jugador " + (jugadorActual == 1 ? "X" : "O") + " ha ganado!");
                break;
            }

            if (tableroLleno()) {
                imprimirTablero();
                System.out.println("¡Es un empate!");
                break;
            }

            cambiarJugador();
        }
    }

    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        juego.jugar();
    }
}
