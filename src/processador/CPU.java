package processador;

import memoria.*;

public class CPU {

    private Memoria memoria;
    private Instrucoes instrucoes;

    private short pc = 0;

    public CPU(Memoria memoria){
        this.memoria = memoria;
    }

    public void setInstrucoes(Instrucoes instrucoes){
        this.instrucoes = instrucoes;
    }

    public short getPc(){
        return pc;
    }

    public void setPc(short novoPc){
        this.pc = novoPc;
    }

    private boolean executando = true;

    public void encerrarPrograma(){
        this.executando = false;
    }

    public void executarPrograma(){
        while(pc < memoria.getTamanho()){
            short instrucao = memoria.lerMemoria(pc);
            instrucoes.executarInstrucao(instrucao);
            System.out.println(pc);
            pc++;
        }
    }

}
