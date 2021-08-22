import java.util.Scanner;

public class MainDeTodos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        MediaAri ma;
        ma = new MediaAri();
        Reajuste re;
        re = new Reajuste();
        Pagar pagar;
        pagar = new Pagar();
        Idade idade;
        idade = new Idade();
        Salarios salarios;
        salarios = new Salarios();
        AntecessorSucessor antSuc;
        antSuc = new AntecessorSucessor();

        System.out.println("Digite o numero da atividade que quer ver a solucao:");
        System.out.println("\n1. Fazer um programa que imprima a média aritmética de 3 números. " +
                "Mais a média de outros 3 números. A soma das duas médias. A média das médias.");
        System.out.println("\n2. Faça um algoritmo que leia a idade de uma pessoa expressa em anos, " +
                "meses e dias e mostre-a expressa em dias. Leve em consideração o ano com 365 dias e o " +
                "mês com 30. (Ex: 3 anos, 2 meses e 15 dias = 1170 dias.)");
        System.out.println("\n3. Informar um saldo e imprimir o saldo com reajuste de 1%.");
        System.out.println("\n4. Escrever um algoritmo que lê: - a porcentagem do IPI a ser acrescido no " +
                "valor das peças - o código da peça 1, valor unitário da peça 1, quantidade de peças 1 - o " +
                "código da peça 2, valor unitário da peça 2, quantidade de peças 2 O algoritmo deve calcular" +
                " o valor total a ser pago e apresentar o resultado. Fórmula : (valor1*quant1 + valor2*" +
                "quant2)*(IPI/100 + 1)");
        System.out.println("\n5. Crie um algoritmo que leia o valor do salário mínimo e o valor do salário de " +
                "um usuário, calcule a quantidade de salários mínimos esse usuário ganha e imprima o resultado." +
                " (1SM=R$788,00)");
        System.out.println("\n6. Desenvolva um algoritmo em Java que leia um número inteiro e imprima o seu " +
                "antecessor e seu sucessor.");
        System.out.println("\n7. Sair");
        int opcoes = s.nextInt();

        switch (opcoes) {
            case 1:
                System.out.println("Valores 1");
                System.out.println("Informe o 1º valor para o array: ");
                ma.array1[0] = s.nextInt();
                System.out.println("Informe o 2º valor para o array: ");
                ma.array1[1] = s.nextInt();
                System.out.println("Informe o 3º valor para o array: ");
                ma.array1[2] = s.nextInt();

                System.out.println("\nValores 2");
                System.out.println("Informe o 1º valor para o array: ");
                ma.array2[0] = s.nextInt();
                System.out.println("Informe o 2º valor para o array: ");
                ma.array2[1] = s.nextInt();
                System.out.println("Informe o 3º valor para o array: ");
                ma.array2[2] = s.nextInt();

                System.out.printf("%nMédia Geral: %.2f", ma.media());
                break;

            case 2:
                System.out.println("Informe o saldo:");
                re.saldo = s.nextDouble();

                System.out.println("Saldo com reajuste " + re.reajuste());
                break;

            case 3:
                System.out.println("Informe o 1º valor: ");
                pagar.valor1 = s.nextDouble();
                System.out.println("Informe a 2º quantidade: ");
                pagar.quant1 = s.nextDouble();
                System.out.println("Informe o 1º valor: ");
                pagar.valor2 = s.nextDouble();
                System.out.println("Informe a 2º quantidade: ");
                pagar.quant2 = s.nextDouble();
                System.out.println("Informe o IPI: ");
                pagar.IPI = s.nextDouble();

                System.out.println(pagar.formula());
                break;
            case 4:
                System.out.println("Qual a sua idade? ");
                System.out.println("Anos:");
                idade.anos = s.nextInt();
                System.out.println("Meses");
                idade.meses = s.nextInt();
                System.out.println("Dias:");
                idade.dias = s.nextInt();

                System.out.println("Sua idade em dias: " + idade.dias());
                break;

            case 5:
                salarios.salarioMinimo = 788.00;

                System.out.println("Informe o salario: ");
                salarios.valorSalario = s.nextDouble();

                System.out.println("Resultado: R$ " + salarios.quantSalarios());
                break;

            case 6:
                System.out.println("Informe um numero: ");
                antSuc.numero = s.nextInt();

                System.out.println("Antecessor: " + antSuc.antecessor() + "\nSucessor:" + antSuc.sucessor());
                break;
            case 7:
                System.out.println("Voce saiu");
                break;
            default:
                System.out.println("Digite um numero valido");
        }
    }
}