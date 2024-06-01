import entidades.Paciente;
import repositorio.ListaPaciente;

import java.util.Scanner;
import java.util.List;


public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    alterarPaciente();
                    break;
                case 4:
                    mostrarInformacoesPaciente();
                    break;
                case 5:
                    registrarAtividadeFisica();
                    break;
                case 6:
                    removerPaciente();
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (opcao != 7);

        scanner.close(); // Fechar o scanner
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Cadastrar um novo paciente");
        System.out.println("2 - Listar todos os pacientes");
        System.out.println("3 - Alterar informações do paciente");
        System.out.println("4 - Mostrar informações de um paciente");
        System.out.println("5 - Registrar atividade física para um paciente");
        System.out.println("6 - Remover paciente");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarPaciente() {
        System.out.println("Você escolheu cadastrar um novo paciente.");

        System.out.print("Nome do entidades.Paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Idade do entidades.Paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Peso do entidades.Paciente (kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Altura do entidades.Paciente (m): ");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Pressão Arterial do entidades.Paciente: ");
        double pressaoArterial = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Frequência Cardíaca do entidades.Paciente: ");
        double frequenciaCardiaca = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Dieta Alimentar do entidades.Paciente: ");
        String dietaAlimentar = scanner.nextLine();

        Paciente novoPaciente = new Paciente(nome, idade, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar);
        ListaPaciente.adicionar(novoPaciente);

        System.out.println("entidades.Paciente cadastrado com sucesso!");
    }

    private static void listarPacientes() {
        System.out.println("Você escolheu listar todos os pacientes:");

        List<Paciente> pacientes = ListaPaciente.listar();
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            for (int i = 0; i < pacientes.size(); i++) {
                Paciente paciente = pacientes.get(i);
                System.out.println((i + 1) + " - " + paciente.nome);
            }
        }
    }

    private static void alterarPaciente() {
        System.out.println("Você escolheu alterar informações do paciente.");
        listarPacientes();

        System.out.print("Digite o id do paciente que deseja alterar: ");
        int idPaciente = scanner.nextInt() ;
        scanner.nextLine();

        Paciente paciente = ListaPaciente.buscarPorId(idPaciente);
        if (paciente != null) {
            System.out.print("Novo peso (kg): ");
            double novoPeso = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Nova altura (m): ");
            double novaAltura = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Nova pressão arterial: ");
            double novaPressaoArterial = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Nova frequência cardíaca: ");
            double novaFrequenciaCardiaca = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Nova dieta alimentar: ");
            String novaDietaAlimentar = scanner.nextLine();

            ListaPaciente.alterar(paciente.id, novoPeso, novaAltura, novaPressaoArterial, novaFrequenciaCardiaca, novaDietaAlimentar);
            System.out.println("Informações do paciente alteradas com sucesso!");
        } else {
            System.out.println("entidades.Paciente não encontrado.");
        }
    }

    private static void mostrarInformacoesPaciente() {
        System.out.println("Você escolheu mostrar informações de um paciente.");
        listarPacientes();

        System.out.print("Digite o id do paciente que deseja ver as informações: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = ListaPaciente.buscarPorId(idPaciente);
        if (paciente != null) {
            System.out.println(paciente.monitorarPaciente());
        } else {
            System.out.println("entidades.Paciente não encontrado.");
        }
    }

    private static void registrarAtividadeFisica() {
        System.out.println("Você escolheu registrar atividade física para um paciente.");
        listarPacientes();

        System.out.print("Digite o id do paciente que deseja registrar a atividade: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = ListaPaciente.buscarPorId(idPaciente);
        if (paciente != null) {
            System.out.print("Digite a atividade física realizada: ");
            String atividade = scanner.nextLine();
            paciente.registrarAtividadeFisica(atividade);
            System.out.println("Atividade registrada com sucesso!");
        } else {
            System.out.println("entidades.Paciente não encontrado.");
        }
    }

    private static void removerPaciente() {
        System.out.println("Você escolheu remover um paciente.");
        listarPacientes();

        System.out.print("Digite o id do paciente que deseja remover: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine();

        if (ListaPaciente.remover(idPaciente)) {
            System.out.println("entidades.Paciente removido com sucesso!");
        } else {
            System.out.println("Falha ao remover paciente.");
        }
    }
}
