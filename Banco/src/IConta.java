public interface IConta {
    
    public void saque(double valor);

    public void deposito (double valor, Conta conta);

    public void deposito (double valor);

    public void consultarConta(Conta conta);

    public void consultarExtrato(Conta conta);

}
