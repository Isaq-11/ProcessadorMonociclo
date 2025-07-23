package processador;

import memoria.*;

public class Instrucoes {

    private Lib lib = new Lib();
    private Registradores registradores = new Registradores();
    private CPU cpu;
    private Memoria memoria;

    private short instrucao;

    public Instrucoes(Memoria memoria, CPU cpu){
        this.memoria = memoria;
        this.cpu = cpu;
    }

    public void setInstrucoes(short novaInstrucao){
        this.instrucao = novaInstrucao;
    }

    public void executarInstrucao(short instrucao){
        
        short tipoInstrucao = lib.extract_bits(instrucao, 15, 1);

        if(tipoInstrucao == 0){
            short opcode = lib.extract_bits(instrucao, 9, 6);
            short destino = lib.extract_bits(instrucao, 6, 3);
            short reg1 = lib.extract_bits(instrucao, 3, 3);
            short reg2 = lib.extract_bits(instrucao, 0, 3);

            destino &= 0x7;
            reg1 &= 0x7;
            reg2 &= 0x7;

            if(opcode == 0){ //soma
                short soma = (short)(registradores.getBancoRegistradores(reg1) + registradores.getBancoRegistradores(reg2));
                registradores.escreverNoRegistrador(destino, soma);
            }

            else if(opcode == 1){ //subtração
                short subtracao = (short)(registradores.getBancoRegistradores(reg1) - registradores.getBancoRegistradores(reg2));
                registradores.escreverNoRegistrador(destino, subtracao);
            }

            else if(opcode == 2){ //multiplicação
                short multiplicacao = (short)(registradores.getBancoRegistradores(reg1) * registradores.getBancoRegistradores(reg2));
                registradores.escreverNoRegistrador(destino, multiplicacao);
            }

            else if(opcode == 3){ //divisão
                short registradorDivisor = registradores.getBancoRegistradores(reg2);
                if(registradorDivisor != 0){
                    short divisao = (short)(registradores.getBancoRegistradores(reg1) / registradores.getBancoRegistradores(reg2));
                    registradores.escreverNoRegistrador(destino, divisao);
                } else{
                    System.out.println("Erro na divisão. Valor será 0.");
                    registradores.escreverNoRegistrador(destino, (short)0);
                }
            }

            else if(opcode == 4){ //compara se igual
                short cmpEqual;
                if(registradores.getBancoRegistradores(reg1) == registradores.getBancoRegistradores(reg2)){
                    cmpEqual = 1;
                } else{
                    cmpEqual = 0;
                }
                registradores.escreverNoRegistrador(destino, cmpEqual);
            }

            else if(opcode == 5){ //compara se desigual
                short cmpNequal;
                if(registradores.getBancoRegistradores(reg1) != registradores.getBancoRegistradores(reg2)){
                    cmpNequal = 1;
                } else{
                    cmpNequal = 0;
                }
                registradores.escreverNoRegistrador(destino, cmpNequal);
            }

            else if(opcode == 15){ //load
                short endereco = registradores.getBancoRegistradores(reg1);
                short valorEndereco = memoria.lerMemoria(endereco);
                registradores.escreverNoRegistrador(destino, valorEndereco);
            }

            else if(opcode == 16){ //store
                short endereco = registradores.getBancoRegistradores(reg1);
                short valor = registradores.getBancoRegistradores(reg2);
                memoria.escreverNaMemoria(endereco, valor);
            }

            else if(opcode == 63){ //syscall
                short servico = registradores.getBancoRegistradores(0);

                if(servico == 0){
                    cpu.setPc((short)(memoria.getTamanho() -1));
                }
            }

        }
        else if(tipoInstrucao == 1){
            short opcode = lib.extract_bits(instrucao, 13, 2);
            short reg = lib.extract_bits(instrucao, 10, 3);
            short imediato = lib.extract_bits(instrucao, 0, 10);

            reg &= 0x7;
            imediato &= 0x3FF;

            if(opcode == 0){ //jump
                cpu.setPc(imediato);
            }

            else if(opcode == 1){ //jump_cond
                if(registradores.getBancoRegistradores(reg) != 0){
                    cpu.setPc(imediato);
                }
            }
            
            else if(opcode == 3){ //mov
                registradores.escreverNoRegistrador(reg, imediato);
            }
        }

    }



}
