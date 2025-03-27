package AlogoUndData.Blatt4;

public class listeF<T extends Comparable<T>> {
    private T[] elements;
    private int size;

    // Konstruktor mit angepasstem Array-Typ (Comparable)
    public listeF(int initialCapacity) {
        elements = (T[]) new Comparable[initialCapacity];
        size = 0;
    }

    // Methode zum Löschen des kleinsten Elements
    public void loescheMin() {
        if (size == 0) {
            return; // Keine Aktion, wenn die Liste leer ist
        }

        // Finde den Index des kleinsten Elements
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (elements[i].compareTo(elements[minIndex]) < 0) {
                minIndex = i;
            }
        }

        // Verschiebe alle Elemente nach rechts vom Minimum um eine Position nach links
        for (int i = minIndex; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        // Reduziere die Größe und setze die letzte Position auf null (optional)
        elements[size - 1] = null;
        size--;
    }

    // Weitere notwendige Methoden (z. B. add, get, etc.)
    public void add(T element) {
        if (size == elements.length) {
            // Vergrößere das Array (hier vereinfacht dargestellt)
            T[] newArray = (T[]) new Comparable[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
        elements[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public int size() {
        return size;
    }
}