import java.util.ArrayList;
import java.util.List;

public class Banco implements IBanco{

    private List<Conta> contas = new ArrayList<>();

    //Aqui adiciona-se as contas para lista do banco. 
    @Override
    public void setConta(Conta conta) {
        contas.add(conta);
        
    }

    //Aqui consulta-se a conta por intermédio do banco;
    @Override
    public void consultarConta(Conta conta) {
        
        conta.consultarConta(conta);
        
    }

    //Aqui consulta-se o extrato da conta por intermédio do banco;
    @Override
    public void consultarExtrato(Conta conta) {
        
        conta.consultarExtrato(conta);
        
    }

    
    
}
