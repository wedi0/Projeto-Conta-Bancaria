import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta  {
    
    //Aqui é definido como constante o tipo de conta:
    private static final String POUPANCA = "019"; 
    private static final String CORRENTE = "013";

    //Aqui será definido a sequencia para se gerar o numero da conta:
    private static int SEQUENCIA = 1;

    //Aqui é os atritubos pertecentes a cada conta:
    protected double saldo;
    protected String agencia;
    protected String numero;
    protected Cliente cliente;
    protected List<Double> extrato; 

    //Construtor:
    public Conta( int agencia, String nome) {
        this.saldo = 0.0f; //Toda conta começa com o saldo zerado.

        //Aqui define qual agencia foi escolhida:
        if ( agencia == 1 ){
            this.agencia = POUPANCA;
        }
        if (agencia == 2){
            this.agencia = CORRENTE;
        }
        
        this.numero = gerarNumeroConta(); //Chama metódo para gerar numero da conta;
        this.cliente = new Cliente(nome); // Instancia-se um objeto da classe Cliente para alocar o nome do cliente;
        this.extrato = new ArrayList<>(); //Instancia-se um arraylist para guardar os extratos da conta;
        this.extrato.add(saldo);
    }

    //Gera um numero para conta com base na sequência de criação;
    public String gerarNumeroConta(){
        String n = "0000-" + SEQUENCIA;
        SEQUENCIA++;

        return n;
    }


    //Aqui será feito do saque:
    @Override
    public void saque (double valor) {
        //Aqui faz-se o tratamento da informação, se o valor for maior que o saldo lança-se uma execption.
        try {
            if (valor > saldo){
                IllegalArgumentException erro = new IllegalArgumentException();
                throw erro;
            }
            else {
                this.saldo -= valor;
                this.extrato.add(saldo); //Adiciona o valor alterado do saldo para o extrato;
            }
        } catch (Exception erro) {
            System.out.println("!ERRO! ---- VALOR DE ENTRADA INCORRETO ---- !ERRO!");
        }

    }

    //Deposito para contas de terceiros;
    @Override
    public void deposito (double valor, Conta conta) {
        //Aqui faz-se o tratamento de informação, se o valor do saque for negativo lança-se uma exception.
        try {
            if ( valor < 0 || valor > saldo){
                IllegalArgumentException e = new IllegalArgumentException();
                throw e;
            }
            else {
                this.saldo -= valor;
                this.extrato.add(saldo); //Adiciona o valor alterado do saldo para o extrato;
                conta.saque(valor);
                conta.extrato.add(saldo); //Adiciona o valor alterado do saldo para o extrato;
            }
        } catch (Exception e) {
            System.out.println("!ERRO! ---- VALOR DE ENTRADA INCORRETO ---- !ERRO!");
        }
        
    }

    //Deposito para propria conta;
    public void deposito (double valor){
        //Aqui faz-se o tratamento de informação, se o valor do saque for negativo lança-se uma exception:
        try {
            if ( valor < 0){
                IllegalArgumentException e = new IllegalArgumentException();
                throw e;
            }
            else {
                this.saldo += valor;
                extrato.add(saldo); //Adiciona o valor alterado do saldo para o extrato;
               
            }
        } catch (Exception e) {
            System.out.println("!ERRO! ---- VALOR DE ENTRADA INCORRETO ---- !ERRO!");
        }
    }

    //Exibe dados da conta;
    @Override
    public void consultarConta (Conta conta) {
        System.out.println("--- EXIBIR CONTA ---\n Nome:" + cliente.getNome() +"\n Agencia: " + agencia + "\n Numero: " + numero + "\n Saldo: " + saldo);
    }
    //Exibe o extratos dos depositos ou saques feitos;
    @Override
    public void consultarExtrato(Conta conta) {
        System.out.println (" --- EXIBIR EXTRATO --- \n" + extrato);
       
    }


    
}
