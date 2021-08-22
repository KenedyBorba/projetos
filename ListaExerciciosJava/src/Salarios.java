public class Salarios {
    Double valorSalario;
    Double salarioMinimo;

    Double quantSalarios() {
        return valorSalario / salarioMinimo;
    }
}
/*
Crie um algoritmo que leia o valor do salário mínimo e o valor do salário de um usuário,
calcule a quantidade de salários mínimos esse usuário ganha e imprima o resultado.
(1SM=R$788,00)
*/