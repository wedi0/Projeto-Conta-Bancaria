public interface IConta {
    
    public void saque(double valor);

    public void deposito (double valor, Conta conta);

    public void deposito (double valor);

    public void consultarConta();

    public void consultarExtrato();

}
