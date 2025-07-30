package processador;

import memoria.*;

public class CPU {

    private Memoria memoria;
    private Instrucoes instrucoes;

    private Registradores registradores;

    private short pc = 0;

    public CPU(Memoria memoria, Registradores registradores){
        this.memoria = memoria;
        this.registradores = registradores;
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
        while(executando == true && pc < memoria.getTamanho()){
            short instrucao = memoria.lerMemoria(pc);
            //System.out.println(pc);
            boolean mudouPc = instrucoes.executarInstrucao(instrucao);
            if(!mudouPc){
                setPc((short)(getPc()+1)); 
            }
        }
    }

}
