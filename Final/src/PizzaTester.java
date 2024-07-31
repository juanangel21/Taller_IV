public class PizzaTester {
    public static void main(String[] args) {
        try {
            // Creación de pizzas válidas
            Pizza pizza1 = new Pizza("grande", 1, 1, 2);
            System.out.println(pizza1);
            System.out.println("Costo: $" + pizza1.calcularCosto());

            Pizza pizza2 = new Pizza("mediana", 2, 2, 2);
            System.out.println(pizza2);
            System.out.println("Costo: $" + pizza2.calcularCosto());

            Pizza pizza3 = new Pizza("pequeña", 1, 2, 1);
            System.out.println(pizza3);
            System.out.println("Costo: $" + pizza3.calcularCosto());

            // Creación de una pizza con demasiados toppings (debería lanzar una excepción)
            try {
                Pizza pizza4 = new Pizza("pequeña", 2, 2, 2); // 6 toppings en total para pizza pequeña
                System.out.println(pizza4);
                System.out.println("Costo: $" + pizza4.calcularCosto());
            } catch (IllegalArgumentException e) {
                System.out.println("Error al crear pizza4: " + e.getMessage());
            }

            // Creación de una pizza con toppings inválidos (debería lanzar una excepción)
            try {
                Pizza pizza5 = new Pizza("mediana", 4, 1, 1); // 4 cheese toppings
                System.out.println(pizza5);
                System.out.println("Costo: $" + pizza5.calcularCosto());
            } catch (IllegalArgumentException e) {
                System.out.println("Error al crear pizza5: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Se produjo un error inesperado: " + e.getMessage());
        }
    }
}
