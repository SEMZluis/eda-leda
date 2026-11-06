// código referente à questão Max Pilha


import java.util.Scanner;

class SolutionGM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaGM pilha;

        String[] entrada = sc.nextLine().split(" ");
        pilha = new PilhaGM(entrada.length);

        for (String e : entrada) {
            pilha.push(Integer.parseInt(e));
        }

        System.out.println(pilha.getMax());

        sc.close();
    }
}

public class PilhaGM {
    private int[] array;
    private int top;
    private int size;

    public PilhaGM(int capacidade) {
        this.array = new int[capacidade];
        this.top = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return this.size == this.array.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int v) {
        if (isFull()) throw new RuntimeException("Pilha Cheia!");
        this.size++;
        this.array[++top] = v;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pilha Vazia!");
        size--;
        return this.array[top--];
    }

    public int getMax() {
        PilhaGM aux = new PilhaGM(size);

        int max = pop();
        aux.push(max);

        // Desempilhar
        while(!isEmpty()) {
            int value = pop();
            aux.push(value);
            if (value > max) max = value;
        }

        // Empilhar
        while(!aux.isEmpty()) {
            push(aux.pop());
        }

        return max;
    }
}
