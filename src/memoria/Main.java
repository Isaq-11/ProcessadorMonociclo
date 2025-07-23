package memoria;

import processador.*;

public class Main {
    public static void main(String[] args) {

        Memoria memory = new Memoria(1024);
        Bin bin = new Bin();
        Lib lib = new Lib(memory);

        String caminhoBinario = "C:/msys64/home/Aluno/arq-sim-assembler/asm-example/perfectSquares.bin";
        lib.load_binary(caminhoBinario);

        CPU cpu = new CPU(memory);

        Instrucoes inst = new Instrucoes(memory, cpu);
        cpu.setInstrucoes(inst);

        cpu.executarPrograma();

        //memory.imprimirMemoria(32);
        //System.out.println(memory.getTamanho());

    }
}

// /home/isaqu/arq-sim-assembler/asm-example
