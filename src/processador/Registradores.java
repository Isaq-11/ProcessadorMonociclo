package processador;

public class Registradores {

    private short[] bancoRegistradores = new short[32];

    public short getBancoRegistradores(int indice){
        return bancoRegistradores[indice];
    }

    public void escreverNoRegistrador(int indice, short valor){
        bancoRegistradores[indice] = valor;
    }

    public short lerRegistrador(int indice){
        return bancoRegistradores[indice];
    }

    public void imprimirBancoRegistradores() {
        for (int i = 0; i < bancoRegistradores.length; i++) {
            System.out.printf("R%d: %04x\n", i, bancoRegistradores[i]);
        }
    }

}
