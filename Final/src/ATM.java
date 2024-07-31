public class ATM {
    private int billetesDe10;
    private int billetesDe20;
    private int billetesDe50;
    private int billetesDe100;

    public ATM() {
        this.billetesDe10 = 10;
        this.billetesDe20 = 10;
        this.billetesDe50 = 10;
        this.billetesDe100 = 10;
    }

    public void recargarDinero(int denominacion, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }

        switch (denominacion) {
            case 10:
                this.billetesDe10 += cantidad;
                break;
            case 20:
                this.billetesDe20 += cantidad;
                break;
            case 50:
                this.billetesDe50 += cantidad;
                break;
            case 100:
                this.billetesDe100 += cantidad;
                break;
            default:
                throw new IllegalArgumentException("Denominación no válida.");
        }
    }

    public void retirarDinero(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }

        int saldoDisponible = getSaldoDisponible();
        if (monto > saldoDisponible) {
            throw new IllegalArgumentException("Saldo insuficiente en el cajero.");
        }

        int montoRestante = monto;
        int billetes100 = Math.min(montoRestante / 100, this.billetesDe100);
        montoRestante -= billetes100 * 100;
        int billetes50 = Math.min(montoRestante / 50, this.billetesDe50);
        montoRestante -= billetes50 * 50;
        int billetes20 = Math.min(montoRestante / 20, this.billetesDe20);
        montoRestante -= billetes20 * 20;
        int billetes10 = Math.min(montoRestante / 10, this.billetesDe10);
        montoRestante -= billetes10 * 10;

        if (montoRestante > 0) {
            throw new IllegalArgumentException("No se puede dispensar el monto exacto con los billetes disponibles.");
        }

        this.billetesDe100 -= billetes100;
        this.billetesDe50 -= billetes50;
        this.billetesDe20 -= billetes20;
        this.billetesDe10 -= billetes10;

        System.out.println("Billetes dispensados: ");
        System.out.println("Billetes de 100: " + billetes100);
        System.out.println("Billetes de 50: " + billetes50);
        System.out.println("Billetes de 20: " + billetes20);
        System.out.println("Billetes de 10: " + billetes10);
    }

    public void consultarBilletesDisponibles() {
        System.out.println("Billetes disponibles:");
        System.out.println("Billetes de 10: " + this.billetesDe10);
        System.out.println("Billetes de 20: " + this.billetesDe20);
        System.out.println("Billetes de 50: " + this.billetesDe50);
        System.out.println("Billetes de 100: " + this.billetesDe100);
    }

    private int getSaldoDisponible() {
        return (this.billetesDe10 * 10) + (this.billetesDe20 * 20) + (this.billetesDe50 * 50) + (this.billetesDe100 * 100);
    }
}
