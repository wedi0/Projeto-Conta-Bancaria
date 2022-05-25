public class Cliente {

    private String nome;


    public Cliente(String nome) {
        this.nome = nome;
    }

    //Um metodo get caso precise usar o nome do cliente;
    public String getNome() {
        return nome;
    }

    //Um metodo set caso precise alterar o nome do cliente;
    public void setNome(String nome) {
        this.nome = nome;
    }

}
