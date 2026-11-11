import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    
    @SuppressWarnings("unchecked")
    public TabelaHash(int tamanho) {
        this.tabela = new ArrayList[tamanho];
    }

    private int hash(int chave) {
        return chave % this.tabela.length;
    }

    @SuppressWarnings("unchecked")
    public String keys() {
        if (this.size == 0) return "[]";

        String keys = "[";
        
        for (int i = 0; i < this.tabela.length; i++) {
            ArrayList<Par> listaDePares = (ArrayList) this.tabela[i];
            if (listaDePares != null) {
                for (int j = 0; j < listaDePares.size(); j++) {
                    keys += listaDePares.get(j).getKey()+", ";
                }
            }
        }

        return keys.substring(0, keys.length()-2) + "]";
    }

    @SuppressWarnings("unchecked")
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
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        if (this.size == 0) return "[]";

        String tabela = "[";
        
        for (int i = 0; i < this.tabela.length; i++) {
            ArrayList<Par> listaDePares = (ArrayList) this.tabela[i];
            String lista = "";

            if (listaDePares == null) {
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

            tabela += lista+", ";
        }

        return tabela.substring(0, tabela.length()-2);
    }
}

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
                case "put":
                    tabela.put(Integer.parseInt(entrada[1]), entrada[2]);
                    System.out.println(tabela.toString());
                default:
                    break;
            }

        } while (!entrada[0].equals("end"));
    }
}
