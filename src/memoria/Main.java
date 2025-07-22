package memoria;

public class Main {
    public static void main(String[] args) {

        Memoria memory = new Memoria(1024);

        Lib lib = new Lib(memory);

        Bin bin = new Bin();

        String caminhoBinario = bin.sleep;

        lib.load_binary(caminhoBinario);
        memory.imprimirMemoria(32);
    }
}

// /home/isaqu/arq-sim-assembler/asm-example
