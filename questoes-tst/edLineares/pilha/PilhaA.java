// código referente à questão Pilha com Array

import java.util.Scanner;

class SolutionA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaA pilha;

        int tam = Integer.parseInt(sc.nextLine());
        pilha = new PilhaA(tam);

        String entrada = sc.nextLine();
        while (!entrada.equals("end")) {
            switch (entrada) {
                case "print":
                    System.out.println(pilha.print());
                    break;
                case "pop":
                    if (pilha.isEmpty()) System.out.println("empty");
                    else pilha.pop();
                    break;
                case "peek":
                    System.out.println(pilha.peek());
                    break;
                default:
                    if (pilha.isFull()) System.out.println("full");
                    else pilha.push(entrada.split(" ")[1]);
                    break;
            }
            entrada = sc.nextLine();
        }

        sc.close();
    }
}

public class PilhaA {
    private String[] array;
    private int top;
    private int size;

    public PilhaA(int capacity) {
        this.array = new String[capacity];
        this.top = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return this.size == this.array.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(String v) {
        size++;
        this.array[++top] = v;
    }

    public String pop() {
        size--;
        return this.array[top--];
    }

    public String peek() {
        if (isEmpty()) return "empty";
        return this.array[top]+"";
    }

    public String print() {
        if (isEmpty()) return "empty";

        PilhaA aux = new PilhaA(size);
        
        while(!isEmpty()) {    
            aux.push(pop());
        }

        String out = aux.pop();
        push(out);
        
        while(!aux.isEmpty()) {
            String v = aux.pop();
            out += " "+v;
            push(v);
        }

        return out;
    }

}
