import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        ValidaCPF validaCPF = new ValidaCPF();

        ArrayList<ContaCorrente> contas = new ArrayList<>();

        /*Trabalho em dupla feito na faculdade */

        int op = 0;

        do {
            System.out.println("Selecione uma operação:" +
                    "\n1 - Criar, " +
                    "2 - Editar, " +
                    "3 - Visualizar, " +
                    "4 - Remover, " +
                    "5 - Depositar, " +
                    "6 - Sacar, " +
                    "7 - Transferir, " +
                    "8 - Empréstimo, " +
                    "9 - Sair");
            op = tc.nextInt();

            switch (op) {
                case 1: {
                    System.out.println("Digite o seu CPF:");
                    String cpf = tc.next();
                    if (validaCPF.isCPF(cpf)) {
                        if (contas.size() > 0) {
                            boolean CPFexiste = false;

                            for (int i = 0; i < contas.size(); i++) {
                                if (contas.get(i).titular.cpf.equals(cpf)) {
                                    System.out.println("CPF JA EXISTE");
                                    CPFexiste = true;
                                    break;
                                }
                            }
                            if (!CPFexiste) {
                                ContaCorrente contaCorrente = new ContaCorrente();
                                contaCorrente.titular.cpf = cpf;
                                contas.add(contaCorrente);
                            }
                        } else {
                            ContaCorrente contaCorrente = new ContaCorrente();
                            contaCorrente.titular.cpf = cpf;
                            contas.add(contaCorrente);
                        }
                    } else {
                        System.out.println("CPF INVALIDO");
                    }
                    break;
                }

                case 2: {
                    if (contas.size() > 0) {
                        System.out.println("Digite o numero da conta que gostaria de editar:");
                        int numero = tc.nextInt();
                        ContaCorrente buscar = new ContaCorrente(numero);
                        int p = contas.indexOf(buscar);

                        if (p != -1) {
                            buscar = contas.get(p);
                            buscar.editar();
                            System.out.println("Conta Atualizada!");

                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    } else {
                        System.out.println("Não há contas cadastradas!");
                    }
                    break;
                }

                case 3: {
                    if (contas.size() > 0) {
                        for (int i = 0; i < contas.size(); i++) {
                            contas.get(i).mostrarDados();
                        }
                    } else {
                        System.out.println("Não há contas cadastradas");
                    }

                    break;
                }

                case 4: {
                    if (contas.size() > 0) {
                        System.out.println("Digite o numero da conta que deseja remover:");
                        int numero = tc.nextInt();
                        ContaCorrente remover = new ContaCorrente(numero);
                        if (contas.remove(remover)) {
                            System.out.println("Conta removida!");
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    } else {
                        System.out.println("Não há contas cadastradas");
                    }
                    break;
                }

                case 5: {
                    if (contas.size() > 0) {
                        System.out.println("Digite o numero da conta que deseja depositar:");
                        int numero = tc.nextInt();
                        ContaCorrente depositar = new ContaCorrente(numero);
                        int p = contas.indexOf(depositar);
                        if (p != -1) {
                            depositar = contas.get(p);
                            System.out.println("Digite o valor que deseja depositar:");
                            double valor = tc.nextDouble();
                            if (!depositar.depositar(valor)) {
                                System.out.println("Não foi possivel depositar");
                            }
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    } else {
                        System.out.println("Não há contas cadastradas");
                    }
                    break;
                }

                case 6: {
                    if (contas.size() > 0) {
                        System.out.println("Digite o numero da conta que deseja sacar:");
                        int numero = tc.nextInt();
                        ContaCorrente sacar = new ContaCorrente(numero);
                        int p = contas.indexOf(sacar);
                        if (p != -1) {
                            sacar = contas.get(p);
                            System.out.println("Digite o valor que deseja sacar");
                            double valor = tc.nextDouble();
                            if (!sacar.sacar(valor)) {
                                System.out.println("Saldo insuficiente");
                            }
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    } else {
                        System.out.println("Não há contas cadastradas");
                    }
                    break;
                }

                case 7: {
                    if (contas.size() > 0) {
                        System.out.println("Digite o numero da sua conta:");
                        int numero1 = tc.nextInt();
                        System.out.println("Digite o numero da conta que deseja transferir:");
                        int numero2 = tc.nextInt();
                        ContaCorrente origem = new ContaCorrente(numero1);
                        ContaCorrente destino = new ContaCorrente(numero2);
                        int p1 = contas.indexOf(origem);
                        int p2 = contas.indexOf(destino);
                        if (p1 != -1 && p2 != -1) {
                            origem = contas.get(p1);
                            destino = contas.get(p2);
                            System.out.println("Digite o valor que deseja transferir:");
                            double valor = tc.nextDouble();
                            if (!origem.transferir(valor, destino)) {
                                System.out.println("Erro ao transferir");
                            }
                        } else {
                            System.out.println("Uma das contas não foi encotrada");
                        }
                    } else {
                        System.out.println("Não há contas cadastradas");
                    }
                    break;
                }

                case 8: {
                    if (contas.size() > 0) {
                        System.out.println("Digite o numero da conta que deseja realizar o empréstimo:");
                        int numero = tc.nextInt();
                        ContaCorrente emprestimo = new ContaCorrente(numero);
                        int p = contas.indexOf(emprestimo);
                        if (p != -1) {
                            emprestimo = contas.get(p);
                            System.out.println("Digite o valor que deseja depositar:");
                            double valor = tc.nextDouble();
                            if (!emprestimo.emprestimo(valor)) {
                                System.out.println("Empréstimo negado!!");
                            }
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    } else {
                        System.out.println("Não há contas cadastradas");
                    }
                    break;
                }

                case 9: {
                    System.out.println("Obrigado!");
                    break;
                }
            }
        } while (op != 9);

    }
}
