import java.util.Objects;
import java.util.Scanner;

public class Titular {
    String nome;
    String cpf = null;
    Integer idade;
    Double renda;
    String dataNascimento;
    Scanner tc = new Scanner(System.in);

    public Titular() {
        lerDados();
    }

    private void lerDados() {
        System.out.println("Digite nome:");
        this.nome = tc.next();
        System.out.println("Digite idade:");
        this.idade = tc.nextInt();
        System.out.println("Digite data de nascimento:");
        this.dataNascimento = tc.next();
        System.out.println("Informe a sua renda");
        this.renda = tc.nextDouble();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titular titular = (Titular) o;
        return Objects.equals(cpf, titular.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}