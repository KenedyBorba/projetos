public class Main {

    public static void main(String[] args) {
        int[] arrei = {7, 4, 5, 3, 50};

        int resultadoMaior = maior(arrei, 0, arrei.length - 1);

        int resultadoSoma = soma(arrei, 0);

        System.out.println("Soma dos valores do array: " + resultadoSoma);

        System.out.println("Maior número: " + resultadoMaior);
    }

    private static int maior(int[] arrei, int inicio, int fim) {
        if (inicio == fim) {
            return arrei[inicio];
        } else {
            int esquerda, direita;
            int meio;

            meio = (inicio + fim) / 2;
            esquerda = maior(arrei, inicio, meio);
            direita = maior(arrei, meio + 1, fim);

            if (esquerda > direita) {
                return esquerda;
            } else {
                return direita;
            }
        }
    }

    private static int soma(int[] arrei, int i) {
        if (i < arrei.length) {
            return arrei[i] + soma(arrei, i + 1);
        } else {
            return 0;
        }
    }
}