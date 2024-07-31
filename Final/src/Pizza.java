public class Pizza {
    // Atributos privados
    private String size;
    private int quesoToppings;
    private int pepperoniToppings;
    private int aceitunasToppings;

    // Constructor
    public Pizza(String size, int quesoToppings, int pepperoniToppings, int aceitunasToppings) {
        if (!size.equals("pequeña") && !size.equals("mediana") && !size.equals("grande")) {
            throw new IllegalArgumentException("Tamaño de pizza inválido");
        }

        if (quesoToppings > 3 || pepperoniToppings > 3 || aceitunasToppings > 3) {
            throw new IllegalArgumentException("No se pueden agregar más de 3 toppings de ningún tipo");
        }

        if (size.equals("pequeña") && (quesoToppings + pepperoniToppings + aceitunasToppings) > 5) {
            throw new IllegalArgumentException("Las pizzas pequeñas no pueden tener más de 5 toppings en total");
        }

        this.size = size;
        this.quesoToppings = quesoToppings;
        this.pepperoniToppings = pepperoniToppings;
        this.aceitunasToppings = aceitunasToppings;
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
        int totalToppings = quesoToppings + pepperoniToppings + aceitunasToppings;
        return baseCost + (2 * totalToppings);
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return "Pizza tamaño: " + size +
                ", Toppings de queso: " + quesoToppings +
                ", Toppings de pepperoni: " + pepperoniToppings +
                ", Toppings de aceituna: " + aceitunasToppings;
    }
}
