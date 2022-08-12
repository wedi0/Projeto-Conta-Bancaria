
public class App {
    public static void main(String[] args) throws Exception {
       
        Banco banco = new Banco();

        Conta c1 = new Conta_Poupanca(1, "RONALDINHO");
        Conta c2 = new Conta_Corrente(2, "Rodrigo");
        Conta c3 = new Conta_Corrente(2, "Camilly");
        
        banco.setConta(c1);
        banco.setConta(c2);
        banco.setConta(c3);

         //Operação de teste das 3 funções principais.
        c3.deposito(1000);
        c3.saque(400); 
        c3.deposito(300, c1);

        // Fase de consulta onde se verifica os valores das contas.
        banco.consultarConta(c1);
        banco.consultarConta(c2);
        banco.consultarConta(c3);
        banco.consultarExtrato(c3);


    }
}
