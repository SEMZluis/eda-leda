import java.util.Scanner;

class SolutionI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaI pilha = new PilhaI(Integer.parseInt(sc.nextLine()));

        String[] entrada = sc.nextLine().split(" ");
        for (String s : entrada) {
            pilha.push(Integer.parseInt(s));
        }

        pilha.inverts();
        System.out.println(pilha.printOut());

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
        if (isEmpty()) this.head++;
        size++;
        this.tail = (tail+1) % this.array.length;
        this.array[tail] = v;
    }

    public int remove() {
        if (isEmpty()) throw new RuntimeException("Fila vazia!");
        size--;
        int value = this.array[head];
        this.head = (this.head+1) % this.array.length;
        return value;
    }
}

public class PilhaI {
    private int[] array;
    private int top;
    private int size;

    public PilhaI(int capacity) {
        this.array = new int[capacity];
        this.top = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.array.length;
    }

    public void push(int v) {
        if (isFull()) throw new RuntimeException("Pilha cheia!");
        size++;
        this.array[++top] = v;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia!");
        size--;
        return this.array[top--];
    }

    public void inverts() {
        if (!isEmpty()) {
            Fila fila = new Fila(this.size);

            while (!isEmpty()) {
                fila.add(pop());
            }

            while(!fila.isEmpty()) {
                push(fila.remove());
            }
        } 
    }

    public String printOut() {
        String out = "";

        if (!isEmpty()) {
            out = pop()+"";

            while (!isEmpty()) {
                out += "\n"+pop();
            }
        }

        return out;
    }
}
