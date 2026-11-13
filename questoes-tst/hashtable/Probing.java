import java.util.Arrays;
import java.util.Scanner;

public class Probing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable tabela = new HashTable(Integer.parseInt(sc.nextLine()));

        String[] entrada;

        do {
            entrada = sc.nextLine().split(" ");

            switch (entrada[0]) {
                case "keys":
                    System.out.println(tabela.keys());
                    break;
                case "values":
                    System.out.println(tabela.values());
                    break;
                case "put":
                    tabela.put(Integer.parseInt(entrada[1]), entrada[2]);
                    System.out.println(tabela.toString());
                    break;
                case "remove":
                    tabela.remove(Integer.parseInt(entrada[1]));
                    System.out.println(tabela.toString());
                    break;
                default:
                    break;
            }
        } while(!entrada[0].equals("end"));
    }
}

class Pair {
    private int key;
    private String value;

    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }
}

class HashTable {
    private Pair[] array;
    private int size;

    public HashTable(int capacity) {
        this.array = new Pair[capacity];
    }

    public int hash(int key) {
        return key % this.array.length;
    }

    public boolean isFull() {
        return this.size == this.array.length;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public void put(int key, String value) {
        if (isFull()) return;

        int probing = 0;
        int hash = hash(key+probing);

        while (probing < this.array.length) {
            hash = hash(key+probing);

            if (this.array[hash] == null) {
                Pair p = new Pair(key, value);
                this.array[hash] = p;
                this.size++;
                return;
            }

            if (this.array[hash].getKey() == key) {
                this.array[hash].setValue(value);
                return;
            }

            probing++;
        }
    }

    public void remove(int key) {
        int probing = 0;
        int hash;

        while (probing < this.array.length) {
            hash = hash(key+probing);

            if (this.array[hash] != null && this.array[hash].getKey() == key) {
                this.array[hash] = null;
                this.size--;
                return;
            }

            probing++;
        }
    }

    public String keys() {
        if (isEmpty()) return "[]";

        int[] keys = new int[this.size];
        int c = 0;

        for (int i = 0; i < this.array.length; i++) {
            if (array[i] != null) {
                keys[c] = array[i].getKey();
                c++;
            }
        }

        Arrays.sort(keys);

        return Arrays.toString(keys);
    }

    public String values() {
        if (isEmpty()) return "[]";

        String[] values = new String[this.size];
        int c = 0;

        for (int i = 0; i < this.array.length; i++) {
            if (array[i] != null) {
                values[c] = array[i].getValue();
                c++;
            }
        }

        Arrays.sort(values);

        return Arrays.toString(values);
    }

    public String toString() {
        String out = "[";

        for (int i = 0; i < this.array.length; i++) {
            Pair p = this.array[i];

            if (p == null) {
                out += "null, ";
            } else {
                out += "<"+p.getKey()+", "+p.getValue()+">, ";
            }
        }

        return out.substring(0, out.length()-2) + "]";
    }


}