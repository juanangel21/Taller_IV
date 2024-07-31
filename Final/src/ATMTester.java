public class ATMTester {
    public static void main(String[] args) {
        ATM atm = new ATM();

        // Consultar billetes disponibles al inicio
        atm.consultarBilletesDisponibles();

        // Recargar dinero en el cajero
        try {
            atm.recargarDinero(50, 5);
            atm.recargarDinero(20, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al recargar dinero: " + e.getMessage());
        }

        // Consultar billetes disponibles después de recargar
        atm.consultarBilletesDisponibles();

        // Retirar dinero
        try {
            atm.retirarDinero(380);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al retirar dinero: " + e.getMessage());
        }

        // Consultar billetes disponibles después de retirar
        atm.consultarBilletesDisponibles();

        // Intentar retirar una cantidad que no se puede dispensar exactamente
        try {
            atm.retirarDinero(35);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al retirar dinero: " + e.getMessage());
        }

        // Intentar retirar una cantidad mayor que el saldo disponible
        try {
            atm.retirarDinero(2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al retirar dinero: " + e.getMessage());
        }

        // Consultar billetes disponibles al final
        atm.consultarBilletesDisponibles();
    }
}
