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

    public void executarPrograma(){
        while(pc < memoria.getTamanho() && pc > -1){
            instrucoes.setInstrucoes(pc);
            short instrucao = memoria.lerMemoria(pc);
            instrucoes.executarInstrucao(instrucao);
            pc++;
        }
    }

}
