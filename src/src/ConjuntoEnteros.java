public class ConjuntoEnteros {
    private boolean[] conjunto;

    // Constructor sin argumentos que inicializa el conjunto vacío
    public ConjuntoEnteros() {
        conjunto = new boolean[101]; // rango de 0 a 100
    }

    // Método union
    public static ConjuntoEnteros union(ConjuntoEnteros conjunto1, ConjuntoEnteros conjunto2) {
        ConjuntoEnteros unionConjunto = new ConjuntoEnteros();
        for (int i = 0; i < unionConjunto.conjunto.length; i++) {
            unionConjunto.conjunto[i] = conjunto1.conjunto[i] || conjunto2.conjunto[i];
        }
        return unionConjunto;
    }

    // Método intersección
    public static ConjuntoEnteros interseccion(ConjuntoEnteros conjunto1, ConjuntoEnteros conjunto2) {
        ConjuntoEnteros interseccionConjunto = new ConjuntoEnteros();
        for (int i = 0; i < interseccionConjunto.conjunto.length; i++) {
            interseccionConjunto.conjunto[i] = conjunto1.conjunto[i] && conjunto2.conjunto[i];
        }
        return interseccionConjunto;
    }

    // Método para insertar un elemento
    public void insertarElemento(int k) {
        if (k >= 0 && k <= 100) {
            conjunto[k] = true;
        }
    }

    // Método para eliminar un elemento
    public void eliminarElemento(int m) {
        if (m >= 0 && m <= 100) {
            conjunto[m] = false;
        }
    }

    // Método para convertir el conjunto a cadena
    public String aStringConjunto() {
        StringBuilder sb = new StringBuilder();
        boolean esVacio = true;
        for (int i = 0; i < conjunto.length; i++) {
            if (conjunto[i]) {
                sb.append(i).append(" ");
                esVacio = false;
            }
        }
        return esVacio ? "---" : sb.toString().trim();
    }

    // Método para verificar si dos conjuntos son iguales
    public boolean esIgualA(ConjuntoEnteros otroConjunto) {
        for (int i = 0; i < conjunto.length; i++) {
            if (this.conjunto[i] != otroConjunto.conjunto[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ConjuntoEnteros conjunto1 = new ConjuntoEnteros();
        ConjuntoEnteros conjunto2 = new ConjuntoEnteros();

        // Insertando elementos en los conjuntos
        conjunto1.insertarElemento(30);
        conjunto1.insertarElemento(10);
        conjunto1.insertarElemento(20);

        conjunto2.insertarElemento(20);
        conjunto2.insertarElemento(40);
        conjunto2.insertarElemento(50);

        // Mostrando los conjuntos
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto());
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto());

        // Unión de los conjuntos
        ConjuntoEnteros unionConjunto = ConjuntoEnteros.union(conjunto1, conjunto2);
        System.out.println("Unión: " + unionConjunto.aStringConjunto());

        // Intersección de los conjuntos
        ConjuntoEnteros interseccionConjunto = ConjuntoEnteros.interseccion(conjunto1, conjunto2);
        System.out.println("Intersección: " + interseccionConjunto.aStringConjunto());

        // Eliminando un elemento
        conjunto1.eliminarElemento(20);
        System.out.println("Conjunto 1 después de eliminar 20: " + conjunto1.aStringConjunto());

        // Verificando igualdad de conjuntos
        ConjuntoEnteros conjunto3 = new ConjuntoEnteros();
        conjunto3.insertarElemento(10);
        conjunto3.insertarElemento(30);

        System.out.println("Conjunto 1 es igual a Conjunto 3: " + conjunto1.esIgualA(conjunto3));
    }
}
