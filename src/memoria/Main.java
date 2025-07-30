package memoria;

import processador.*;

public class Main {
    public static void main(String[] args) {

        Memoria memory = new Memoria(1024);
        Bin bin = new Bin();
        Lib lib = new Lib(memory);
        Registradores regist = new Registradores();

        String caminhoBinario = "C:\\Users\\Aluno\\Downloads\\home\\Aluno\\arq-sim-assembler\\asm-example\\dynamicMemory.bin";
        lib.load_binary(caminhoBinario);

        CPU cpu = new CPU(memory);

        Instrucoes inst = new Instrucoes(memory, cpu);
        cpu.setInstrucoes(inst);

        cpu.executarPrograma();

        memory.imprimirMemoria(90);
        regist.imprimirBancoRegistradores();
        //System.out.println(memory.getTamanho());

    }
}

// /home/isaqu/arq-sim-assembler/asm-example
// "C:\Users\Aluno\Downloads\home\Aluno\arq-sim-assembler\asm-example\count.bin"