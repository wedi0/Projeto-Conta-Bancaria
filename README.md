# Projeto-Conta-Bancaria
**Projeto:** Criar um programa que gerencia contas bancarias usando conceitos de POO
  
 **Disponibilizado:** Digital Inovation One
   
  **Resumo**: Este projeto tem como objetivo explorar os conceitos de programação orientada a objetos utilizando Java. Para tal objetivo, foi feito um programa de gestão de contas bancárias.
  
  
## Programação Orientada a Objetos
  
  **Definição:** *É um paradigma de programação baseado no conceito de "objetos", que podem conter dados na forma de campos, também conhecidos como atributos, e códigos, na forma de procedimentos, também conhecidos como métodos.*
  
  Dentro deste contexto, os principais pilares do POO é: 
  * Abstração
  * Encapsulamento
  * Herança
  * Polimorfismo
   
   
  -----------------
### Abstração

  *Abstrair algo significa esconder os detalhes da implementação dentro de algo – às vezes um protótipo, às vezes em uma função. Portanto, quando você chama a função, não precisa entender exatamente o que ela está fazendo*
  
  No nosso projeto isso pode ser visto, por exemplo, na hora de criar a conta: 
  
  ````java
  Conta c1 = new Conta_Poupanca(1, "RONALDINHO");
  ````
 *Nessa parte criamos uma conta apenas passando o tipo da agência( 1 poupança e 2 corrente) e o nome como parametro*
 
 A partir disso cria-se uma conta do zero sem o usuário saber o que no processo. Neste códgio a criação do usuário está sendo feito pela classe Conta, ocultando os seguintes códigos: 
 ````java
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
    
    // continua...
 
   ````
   -----------
   ### Encapsulamento 
 
   *É a técnica utilizada para esconder uma ideia, ou seja, não expôr detalhes internos para o usuário, tornando partes do sistema mais independentes possível. Por exemplo, quando um controle remoto estraga apenas é trocado ou consertado o controle e não a televisão inteira. Nesse exemplo do controle remoto, acontece a forma clássica de encapsulamento, pois quando o usuário muda de canal não se sabe que programação acontece entre a televisão e o controle para efetuar tal ação.*
   
   Em um processo de encapsulamento os atributos das classes são do tipo *private*. Para acessar esses tipos de modificadores, é necessário criar métodos *setters* e *getters*.
   
   Um bom exemplo no nosso código é a classe Cliente:
   
   ````java
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
   ````
   -----------------
  ### Herança
  
  *A herança permite que um objeto adquira as propriedades e métodos de outro objeto.* 
  
  Para efetuar uma herança de uma classe é utilizada a palavra reservada chamada extends. Segue abaixo o exemplo de como isso foi aplicado no código:
  
  ````java
  public class Conta_Corrente extends Conta {

    public Conta_Corrente(int agencia, String nome) {
        super(agencia, nome);
        //TODO Auto-generated constructor stub
    } 
}
```` 
----------------
  
  ### Polimorfismo
  
   *Polimorfismo significa "muitas formas", é o termo definido em linguagens orientadas a objeto, como por exemplo Java, C# e C++, que permite ao desenvolvedor usar o mesmo elemento de formas diferentes. Polimorfismo denota uma situação na qual um objeto pode se comportar de maneiras diferentes ao receber uma mensagem. No Polimorfismo temos dois tipos:*

*Polimorfismo Estático ou Sobrecarga*
*Polimorfismo Dinâmico ou Sobreposição*

*O Polimorfismo Estático se dá quando temos a mesma operação implementada várias vezes na mesma classe.*
*O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o método original.*

No código, toda "marca" de banco podem ter as mesmas funções só que agindo de maneiras diferentes:

````java
public interface IBanco {
    
    public void setConta(Conta conta);

    public void consultarConta(Conta conta);

    public void consultarExtrato(Conta conta);
}
````
````java
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
        
        conta.consultarExtrato();
        
    }
}
````

*A imagem acima mostra o código do banco*

## Fontes:

https://www.devmedia.com.br/uso-de-polimorfismo-em-java/26140#:~:text=Polimorfismo%20significa%20%22muitas%20formas%22%2C,diferentes%20ao%20receber%20uma%20mensagem.
  
https://www.devmedia.com.br/abstracao-encapsulamento-e-heranca-pilares-da-poo-em-java/26366
   
https://www.freecodecamp.org/portuguese/news/os-quatro-pilares-da-programacao-orientada-a-objetos-com-javascript/#:~:text=Abstra%C3%A7%C3%A3o%20na%20Programa%C3%A7%C3%A3o%20Orientada%20a,o%20que%20ela%20est%C3%A1%20fazendo.
  
  
https://pt.wikipedia.org/wiki/Programa%C3%A7%C3%A3o_orientada_a_objetos

