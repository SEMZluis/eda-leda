import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Chaining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TabelaHash tabela = new TabelaHash(Integer.parseInt(sc.nextLine()));
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

        } while (!entrada[0].equals("end"));
    }
}

class Par {
    private int chave;
    private String valor;

    public Par(int chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public int getKey() {
        return this.chave;
    }

    public String getValue() {
        return this.valor;
    }

    public void setValue(String valor) {
        this.valor = valor;
    }
}

class TabelaHash {
    private List<Par>[] tabela;
    private int size;
    
    public TabelaHash(int tamanho) {
        this.tabela = new ArrayList[tamanho];
    }

    private int hash(int chave) {
        return chave % this.tabela.length;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public String keys() {
        if (isEmpty()) return "[]";

        int[] keys = new int[this.size];
        int c = 0;

        for (int i = 0; i < this.tabela.length; i++) {
            ArrayList<Par> listaDePares = (ArrayList) this.tabela[i];
            if (listaDePares != null) {
                for (int j = 0; j < listaDePares.size(); j++) {
                    keys[c] = listaDePares.get(j).getKey();
                    c++;
                }
            }
        }

        Arrays.sort(keys);

        return Arrays.toString(keys);
    }

    public void put(int chave, String valor) {
        Par nPar = new Par(chave, valor);

        int hash = hash(chave);

        ArrayList<Par> pares = (ArrayList) this.tabela[hash];

        if (pares == null) {
            pares = new ArrayList<Par>();
        } else {
            for (int i = 0; i < pares.size(); i++) {
                if (pares.get(i).getKey() == chave) {
                    pares.set(i, nPar);
                    return;
                }
            }
        }

        pares.add(nPar);
        this.tabela[hash] = pares;
        this.size++;
    }

    public String toString() {
        String tabelaString = "[";
        
        for (int i = 0; i < this.tabela.length; i++) {
            ArrayList<Par> listaDePares = (ArrayList) this.tabela[i];
            String lista = "";

            if (listaDePares == null || listaDePares.size() == 0) {
                lista = "[]";
            } else {
                lista = "[";

                for (int j = 0; j < listaDePares.size(); j++) {
                    String par = "<";
                    
                    int k = listaDePares.get(j).getKey();
                    String v = listaDePares.get(j).getValue();
                    
                    par += k+", "+v;
                    par += ">";
                    lista += par+", ";
                }
                
                lista = lista.substring(0, lista.length()-2) + "]";
            }

            tabelaString += lista+", ";
        }

        return tabelaString.substring(0, tabelaString.length()-2) + "]";
    }

    public String values() {
        if (isEmpty()) return "[]";

        String[] values = new String[this.size];
        int c = 0;

        for (int i = 0; i < this.tabela.length; i++) {
            ArrayList<Par> lista = (ArrayList) this.tabela[i];

            if (lista != null) {
                for (int j = 0; j < lista.size(); j++) {
                    values[c] = lista.get(j).getValue();
                    c++;
                }
            }
        }

        Arrays.sort(values);

        return Arrays.toString(values);
    }

    public void remove(int key) {   
        if (this.size == 0) return;

        int hash = hash(key);

        ArrayList<Par> lista = (ArrayList) this.tabela[hash];
        if (lista != null && lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getKey() == key) {
                    lista.remove(i);
                    this.size--;
                    break;
                }
            }
        }
    }
}
