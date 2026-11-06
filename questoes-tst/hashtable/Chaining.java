import java.util.ArrayList;
import java.util.List;

class Par {
    private int chave;
    private int valor;

    public Par(int chave, int valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public int getChave() {
        return this.chave;
    }

    public int getValue() {
        return this.valor;
    }

    public void setValue(int valor) {
        this.valor = valor;
    }
}

class TabelaHash {
    private List<Par>[] tabela;
    
    @SuppressWarnings("unchecked")
    public TabelaHash(int tamanho) {
        this.tabela = new ArrayList[tamanho];
    }

    private int hash(int chave) {
        return chave % this.tabela.length;
    }

    public void put(int chave, int valor) {
        Par nPar = new Par(chave, valor);

        int hash = hash(chave);

        ArrayList<Par> pares = (ArrayList) this.tabela[hash];

        if (pares == null) {
            pares = new ArrayList<Par>();
        } else {
            for (int i = 0; i < pares.size(); i++) {
                if (pares.get(i).getChave() == chave) {
                    pares.set(i, nPar);
                    return;
                }
            }
        }

        pares.add(nPar);
        this.tabela[hash] = pares;
    }
}

public class Chaining {
    
}
