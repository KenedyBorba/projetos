public class MediaAri {
    int[] array1 = new int[3];
    int[] array2 = new int[3];

    Double soma1 = 0.0;
    Double soma2 = 0.0;
    Double media1 = 0.0;
    Double media2 = 0.0;

    Double media() {
        for (int i = 0; i < array1.length; i++) {
            soma1 += array1[i];
            media1 = soma1 / array1.length;
        }
        System.out.printf("Média do 1º array: %.2f", media1);
        for (int j = 0; j < array2.length; j++) {
            soma2 += array2[j];
            media2 = soma2 / array2.length;
        }
        System.out.printf("%nMédia do 2º array: %.2f", media2);

        return (media1 + media2) / 2;
    }
}
/*
Fazer um programa que imprima a média aritmética de tres numeros.
A média de tres numeros. A soma das duas médias. A média das médias.
*/