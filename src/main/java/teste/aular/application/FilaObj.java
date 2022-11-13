package teste.aular.application;

public class FilaObj<T> {

    // Atributos
    private int tamanho;
    private T[] fila;

    // Construtor
    public FilaObj(int capacidade) {
        this.fila = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    // Métodos
    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return fila.length == tamanho;
    }

    public void insert(T info) {
        if (isFull()){
            throw new IllegalStateException("Fila Cheia!");
        }
        fila [tamanho++]  = info;
    }

    public T peek() {
        return fila[0];
    }

    public T poll() {
        T primeiroObjeto;
        if (!isEmpty()){
            primeiroObjeto = peek();
            for (int i = 0; i < tamanho -1 ; i++) {
                fila[i] = fila[i+1];
            }
            fila[tamanho -1] = null;
            tamanho--;
            return primeiroObjeto;
        }
        return null;
    }

    public void exibe() {
        if (isEmpty()){
            System.out.println("Fila vazia");
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.println(fila[i]);
        }
    }

    public T[] getFila() {
        return fila;
    }

    public int getTamanho() {
        return tamanho;
    }
}