package memoria;

public class Memoria {
    private short[] memoriaPrimaria;

    public Memoria(int tamanho){
        memoriaPrimaria = new short[tamanho];
    }

    public void escreverNaMemoria(short enderecoDaMemoria, short valor){
        memoriaPrimaria[enderecoDaMemoria & 0xFFFF] = valor;
    }

    public short lerMemoria(short enderecoDaMemoria){
        int indice = enderecoDaMemoria & 0xFFFF;  // índice entre 0 e 65535
        return memoriaPrimaria[indice];
    }

    public int getTamanho() {
        return memoriaPrimaria.length;
    }

    public void imprimirMemoria(int limite) {
    for (int i = 0; i < limite; i++) {
        short valor = lerMemoria((short)i);
        System.out.printf("Endereço %d: %04x\n", i, valor);
    }
}
}
