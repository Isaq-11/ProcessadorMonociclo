package processador;

import memoria.*;

public class CPU {

    private Memoria memoria;
    private Instrucoes instrucoes;

    private short pc = 0;

    public CPU(Memoria memoria){
        this.memoria = memoria;
    }

    public short getPc(){
        return pc;
    }

    public void setPc(short novoPc){
        this.pc = novoPc;
    }

    public void executar(){
        while(true){
            short instrucao = memoria.lerMemoria(pc);
            
        }
    }

}
