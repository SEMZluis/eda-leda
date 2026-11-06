// código referente à questão Max Pilha Index

import java.util.Scanner;

class SolutionGMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] entrada = sc.nextLine().split(" ");
        PilhaGMI pilha = new PilhaGMI(entrada.length);

        for (String en : entrada) {
            pilha.push(Integer.parseInt(en));
        }

        int index = Integer.parseInt(sc.nextLine());

        System.out.println(pilha.getMax(index));
        sc.close();
    }
}

public class PilhaGMI {
    private int[] array;
    private int top;
    private int size;

    public PilhaGMI(int capacidade) {
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

    public void push(int elem) {
        if (isFull()) throw new RuntimeException("Pilha cheia!");
        this.size++;
        this.array[++top] = elem;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia!");
        this.size--;
        return this.array[top--];
    }

    public int getMax(int index) {
        PilhaGMI aux = new PilhaGMI(index+1);
        
        int max = pop();
        aux.push(max);
        int i = 1;
        while (i <= index && !isEmpty()) {
            int value = pop();
            if (value > max) max = value;
            aux.push(value);
            i++;
        }

        while(!aux.isEmpty()) {
            push(aux.pop());
        }

        return max;
    }
}