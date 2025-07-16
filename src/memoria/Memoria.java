package memoria;

public class Memoria {
    private short[] memoria;

    public Memoria(int tamanho){
        memoria = new short[tamanho];
    }

    public void escreverNaMemoria(short enderecoDaMemoria, short valor){
        memoria[enderecoDaMemoria & 0xFFFF] = valor;
    }

    public short lerMemoria(short enderecoDaMemoria){
        return memoria[enderecoDaMemoria & 0xFFFF];
    }
}
