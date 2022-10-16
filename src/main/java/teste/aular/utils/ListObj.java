package teste.aular.utils;

public class ListObj<T> {
    private T[] vetor;

    private int numberOfElements;

    public ListObj(int capacity) {
        vetor = (T[]) new Object[capacity];
        numberOfElements = 0;
    }

    public void add(T element) {
        if (numberOfElements >= vetor.length) {
            System.out.println("Full list!");;
        }
        else {
            vetor[numberOfElements++] = element;
        }
    }

    public int search(T searchedElement) {
        for (int i = 0; i < numberOfElements; i++) {
            if (vetor[i].equals(searchedElement)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeByIndex(int index) {
        if (index < 0 || index >= numberOfElements) {
            System.out.println("\nInvalid index!");
            return false;
        }

        // Loop para "deslocar para a esquerda" os elementos do vetor
        // sobrescrevendo o elemento removido
        for (int i = index; i < numberOfElements -1; i++) {
            vetor[i] = vetor[i+1];
        }

        numberOfElements--;
        return true;
    }

    public boolean removeElement(T elementToRemove) {

        return removeByIndex(search(elementToRemove));
    }

    public int getSize() {

        return numberOfElements;
    }

    public T getElement(int index) {
        if (index < 0 || index >= numberOfElements) {
            return null;
        }
        else {
            return vetor[index];
        }
    }

    public void clean() {

        numberOfElements = 0;
    }

    public void show() {
        if (numberOfElements == 0) {
            System.out.println("\nEmpty list.");
        }
        else {
            System.out.println("\nList Elements:");
            for (int i = 0; i < numberOfElements; i++) {
                System.out.println(vetor[i]);
            }
        }
    }
}
