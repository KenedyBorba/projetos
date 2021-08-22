import java.util.Scanner;

public class ContaCorrente {
    public String agencia;
    public Integer numero;
    public Double saldo;
    public Double limite;
    public Titular titular;
    static Integer ultimaConta = 1;

    Scanner tc = new Scanner(System.in);

    public ContaCorrente() {
        this.numero = ultimaConta;
        ultimaConta++;
        lerDados();
    }

    public ContaCorrente(int numero) {
        this.numero = numero;
    }

    private void lerDados() {
        System.out.println("Digite a agencia:");
        this.agencia = tc.next();
        this.saldo = 0.0;
        this.titular = new Titular();

        definirLimite();
    }


    public void mostrarDados() {
        System.out.println("Agência: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.println("Nome: " + this.titular.nome);
        System.out.println("Idade: " + this.titular.idade);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);
        System.out.println("Renda" + this.titular.renda);
    }

    public void definirLimite() {
        if (this.titular.idade >= 16) {
            if (this.titular.idade < 18) {
                this.limite = 100.0;
            } else if (this.titular.idade > 60) {
                this.limite = 1000.0;
            } else {
                this.limite = 300.0;
            }
        }
    }

    public void editar() {
        System.out.println("Digite o nome:");
        this.titular.nome = tc.next();
        System.out.println("Digite a idade:");
        this.titular.idade = tc.nextInt();
        definirLimite();
        System.out.println("Digite a data de nascimento:");
        this.titular.dataNascimento = tc.next();
    }

    public boolean sacar(Double valor) {
        if (valor <= (this.limite + this.saldo)) {
            this.saldo -= valor;
            System.out.println("Saque Realizado!");
            return true;
        } else return false;
    }

    public boolean depositar(Double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Deposito Realizado!");
            return true;
        } else return false;
    }

    public boolean emprestimo(Double valor) {
        if (valor > 0 && valor <= titular.renda * 5) {
            this.titular.renda += valor;
            System.out.println("Empréstimo realizado com sucesso!!");
            return true;
        } else return false;
    }

    public boolean transferir(Double valor, ContaCorrente destino) {
        if (sacar(valor)) {
            System.out.println("Tranferencia realizada");
            return destino.depositar(valor);
        } else return false;
    }

}
