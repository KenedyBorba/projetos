public class Idade {
    int anos;
    int meses;
    int dias;

    int dias() {
        return dias += (anos * 365) + (meses * 30);
    }
}
/*
Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e mostre-a expressa em dias.
Leve em consideração o ano com 365 dias e o mês com 30. (Ex: 3 anos, 2 meses e 15 dias = 1170 dias.)
 */