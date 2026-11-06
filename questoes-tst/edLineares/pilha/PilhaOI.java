// código referente à questão Ordena Invertendo

import java.util.Scanner;

class SolutionOI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaOI pilha = new PilhaOI(Integer.parseInt(sc.nextLine()));

        String[] entrada = sc.nextLine().split(" ");
        for (String en : entrada) {
            pilha.push(Integer.parseInt(en));
        }

        int index = Integer.parseInt(sc.nextLine());
        pilha.invertsWithIndex(index);  
        String[] valores = pilha.toString().split(" ");

        System.out.println("-");
        for (String v : valores) {
            System.out.println(v);
        }

        sc.close();
    }
}

class Fila {
    private int[] array;
    private int head;
    private int tail;
    private int size;

    public Fila(int capacity) {
        this.array = new int[capacity];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return this.size == this.array.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(int v) {
        if (isFull()) throw new RuntimeException("Fila cheia!");
        if (isEmpty()) this.head = 0;
        size++;
        this.tail = (this.tail+1) % this.array.length;
        this.array[this.tail] = v;
    }

    public int remove() {
        if (isEmpty()) throw new RuntimeException("Fila vazia!");
        size--;
        int removed = this.array[this.head];
        this.head = (this.head+1) % this.array.length;
        return removed;
    }
}

public class PilhaOI {
    private int[] array;
    private int last;
    private int size;

    public PilhaOI(int capacidade) {
        this.array = new int[capacidade];
        this.last = -1;
        this.size = 0;
    }

    public void invertsWithIndex(int index) {
        if (!isEmpty()) {
            Fila aux = new Fila(index+1);

            int i = 0;
            while(!isEmpty() && i <= index) {
                aux.add(pop());
                i++;
            }

            while (!aux.isEmpty()) {
                push(aux.remove());
            }
        }
    }

    public String toString() {
        String out = "";

        if (!isEmpty()) {
            PilhaOI aux = new PilhaOI(this.size);

            int value = pop();
            aux.push(value);
            out = value+"";

            while(!isEmpty()) {
                value = pop();
                aux.push(value);
                out += " "+value;
            }

            while (!aux.isEmpty()) {
                push(aux.pop());
            }
        }

        return out;
    }
    
    public boolean isFull() {
        return this.size == this.array.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int elem) {
        if (isFull()) throw new RuntimeException("Pilha cheia!");
        size++;
        this.array[++last] = elem;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia!");
        last--;
        size--;
        return this.array[last+1];
    }
}