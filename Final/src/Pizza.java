public class Pizza {
    // Atributos privados
    private String size;
    private int cheeseToppings;
    private int pepperoniToppings;
    private int oliveToppings;

    // Constructor
    public Pizza(String size, int cheeseToppings, int pepperoniToppings, int oliveToppings) {
        if (!size.equals("pequeña") && !size.equals("mediana") && !size.equals("grande")) {
            throw new IllegalArgumentException("Tamaño de pizza inválido");
        }

        if (cheeseToppings > 3 || pepperoniToppings > 3 || oliveToppings > 3) {
            throw new IllegalArgumentException("No se pueden agregar más de 3 toppings de ningún tipo");
        }

        if (size.equals("pequeña") && (cheeseToppings + pepperoniToppings + oliveToppings) > 5) {
            throw new IllegalArgumentException("Las pizzas pequeñas no pueden tener más de 5 toppings en total");
        }

        this.size = size;
        this.cheeseToppings = cheeseToppings;
        this.pepperoniToppings = pepperoniToppings;
        this.oliveToppings = oliveToppings;
    }

    // Método para calcular el costo de la pizza
    public double calcularCosto() {
        int baseCost = 0;
        switch (size) {
            case "pequeña":
                baseCost = 10;
                break;
            case "mediana":
                baseCost = 12;
                break;
            case "grande":
                baseCost = 14;
                break;
        }
        int totalToppings = cheeseToppings + pepperoniToppings + oliveToppings;
        return baseCost + (2 * totalToppings);
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return "Pizza tamaño: " + size +
                ", Toppings de queso: " + cheeseToppings +
                ", Toppings de pepperoni: " + pepperoniToppings +
                ", Toppings de aceituna: " + oliveToppings;
    }
}
