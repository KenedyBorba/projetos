public class Pagar {
    Double valor1;
    Double quant1;
    Double valor2;
    Double quant2;
    Double IPI;

    double formula() {
        return (valor1 * quant1 + valor2 * quant2) * (IPI / 100 + 1);
    }
}
/*
Escrever um algoritmo que lê:
- a porcentagem do IPI a ser acrescido no valor das peças
- o código da peça 1, valor unitário da peça 1, quantidade de peças 1
- o código da peça 2, valor unitário da peça 2, quantidade de peças 2
O algoritmo deve calcular o valor total a ser pago e apresentar o resultado.
Fórmula : (valor1*quant1 + valor2*quant2)*(IPI/100 + 1)
*/