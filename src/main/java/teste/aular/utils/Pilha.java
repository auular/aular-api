package teste.aular.utils;

public class Pilha {

    private int topo;
    private int[] pilha;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new int [capacidade];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == pilha.length -1;
    }

    public void push(int info) {
        if (!isFull()){
            pilha[++topo] = info;
        }
        else {
            System.out.println("Pilha cheia!");
        }
    }

    public int pop(){
        if (!isEmpty()){
            return pilha[topo--];
        }
        return -1;
    }

    public int peek(){
        if (!isEmpty()){
            return pilha[topo];
        }
        return -1;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.println(pilha[i]);
            }
        }
    }

    public void exibeEmLinha() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.print(pilha[i]);
            }
        }
    }

    public int getTopo() {
        return topo;
    }

    public int getTamanho() {
        return pilha.length;
    }
}
