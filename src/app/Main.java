package app;

import memoria.Lib;
import memoria.Memoria;
import processador.*;

public class Main {
    public static void main(String[] args) {

        Memoria memory = new Memoria(1024);
        Lib lib = new Lib(memory);
        Registradores regist = new Registradores();

        // colocar em caminhoBinario o endereço do arquivo binário
        String caminhoBinario = "bin/count.bin";
        lib.load_binary(caminhoBinario);

        CPU cpu = new CPU(memory, regist);
        Instrucoes inst = new Instrucoes(memory, cpu, regist);
        cpu.setInstrucoes(inst);

        cpu.executarPrograma();

        memory.imprimirMemoria(90);
        regist.imprimirBancoRegistradores();

    }
}
