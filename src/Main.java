import entidades.*;
import repositorio.*;
import java.time.format.DateTimeFormatter;
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
                    cadastrarFuncionario();
                    break;
                case 8:
                    listarFuncionarios();
                    break;
                case 9:
                    cadastrarNutricionista();
                    break;
                case 10:
                    cadastrarConsulta();
                    break;
                case 11:
                    listarConsultas();
                    break;
                case 12:
                    realizarConsulta();
                    break;
                case 13:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (opcao != 13);

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
        System.out.println("7 - Cadastrar um novo funcionário");
        System.out.println("8 - Listar todos os funcionários");
        System.out.println("9 - Cadastrar um novo nutricionista");
        System.out.println("10 - Cadastrar consulta");
        System.out.println("11 - Listar todas as consultas");
        System.out.println("12 - Realizar consulta");
        System.out.println("13 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarPaciente() {
        System.out.println("Você escolheu cadastrar um novo paciente.");

        System.out.print("Nome do Paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Idade do Paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Peso do Paciente (kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Altura do Paciente (m): ");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Pressão Arterial do Paciente: ");
        double pressaoArterial = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Frequência Cardíaca do Paciente: ");
        double frequenciaCardiaca = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Dieta Alimentar do Paciente: ");
        String dietaAlimentar = scanner.nextLine();

        Paciente novoPaciente = new Paciente(nome, idade, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar);
        ListaPaciente.adicionar(novoPaciente);

        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void listarPacientes() {
        System.out.println("Você escolheu listar todos os pacientes:");

        List<Paciente> pacientes = ListaPaciente.listar();
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            for (int i = 0; i < pacientes.size(); i++) {
                Paciente paciente = pacientes.get(i);
                System.out.println((i + 1) + " - " + paciente.getNome());
            }
        }
    }

    private static void alterarPaciente() {
        System.out.println("Você escolheu alterar informações do paciente.");
        listarPacientes();

        System.out.print("Digite o id do paciente que deseja alterar: ");
        int idPaciente = scanner.nextInt();
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

            ListaPaciente.alterar(paciente.getId(), novoPeso, novaAltura, novaPressaoArterial, novaFrequenciaCardiaca, novaDietaAlimentar);
            System.out.println("Informações do paciente alteradas com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
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
            System.out.println("Paciente não encontrado.");
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
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void removerPaciente() {
        System.out.println("Você escolheu remover um paciente.");
        listarPacientes();

        System.out.print("Digite o id do paciente que deseja remover: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine();

        if (ListaPaciente.remover(idPaciente)) {
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Falha ao remover paciente.");
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("Você escolheu cadastrar um novo funcionário.");

        // Cadastro das informações do funcionário
        System.out.print("Nome do funcionário: ");
        String nomeFuncionario = scanner.nextLine();

        System.out.print("Idade do funcionário: ");
        int idadeFuncionario = scanner.nextInt();
        scanner.nextLine();

        // Cadastro do endereço do funcionário
        System.out.println("Cadastro do endereço do funcionário:");
        Endereco enderecoFuncionario = cadastrarEndereco();

        System.out.print("Salário do funcionário: ");
        double salarioFuncionario = scanner.nextDouble();
        scanner.nextLine();

        // Criação do objeto Funcionario
        Funcionario novoFuncionario = new Funcionario(nomeFuncionario, idadeFuncionario, enderecoFuncionario, salarioFuncionario);

        // Adiciona o funcionário à lista
        ListaFuncionarios.adicionar(novoFuncionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static Endereco cadastrarEndereco() {
        System.out.print("Logradouro: ");
        String logradouro = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Número: ");
        String numero = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        return new Endereco(logradouro, estado, cidade, numero, cep);
    }

    private static void listarFuncionarios() {
        System.out.println("Você escolheu listar todos os funcionários:");

        // Listar funcionários
        List<Funcionario> funcionarios = ListaFuncionarios.listar();
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Funcionários:");
            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                System.out.println((i + 1) + " - " + funcionario.getNome());
            }
        }

        // Listar nutricionistas
        List<Nutricionista> nutricionistas = ListaNutricionistas.listar();
        if (nutricionistas.isEmpty()) {
            System.out.println("Não há nutricionistas cadastrados.");
        } else {
            System.out.println("\nNutricionistas:");
            for (int i = 0; i < nutricionistas.size(); i++) {
                Nutricionista nutricionista = nutricionistas.get(i);
                System.out.println((i + 1) + " - " + nutricionista.getNome());
            }
        }
    }


    private static void cadastrarNutricionista() {
        System.out.println("Você escolheu cadastrar um novo nutricionista.");

        // Cadastro das informações do nutricionista
        String nomeNutricionista;
        do {
            System.out.print("Nome do nutricionista: ");
            nomeNutricionista = scanner.nextLine();

            // Verifica se já existe um nutricionista com o mesmo nome
            if (ListaNutricionistas.nutricionistaRepetido(nomeNutricionista)) {
                System.out.println("Já existe um nutricionista com esse nome. Por favor, insira outro nome.");
            }
        } while (ListaNutricionistas.nutricionistaRepetido(nomeNutricionista));

        System.out.print("Idade do nutricionista: ");
        int idadeNutricionista = scanner.nextInt();
        scanner.nextLine();

        // Cadastro do endereço do nutricionista
        System.out.println("Cadastro do endereço do nutricionista:");
        // Aqui você pode chamar o método para cadastrar um endereço
        Endereco enderecoNutricionista = cadastrarEndereco();

        System.out.print("Número de registro do nutricionista: ");
        String numeroRegistro = scanner.nextLine();

        // Criação do objeto Nutricionista
        Nutricionista novoNutricionista = new Nutricionista(nomeNutricionista, idadeNutricionista, enderecoNutricionista, numeroRegistro);

        // Adiciona o nutricionista à lista
        ListaNutricionistas.adicionar(novoNutricionista);

        System.out.println("Nutricionista cadastrado com sucesso!");
    }

    private static void cadastrarConsulta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Você escolheu cadastrar uma nova consulta.");

        // Listar os nutricionistas disponíveis
        System.out.println("Nutricionistas disponíveis:");
        List<Nutricionista> nutricionistas = ListaNutricionistas.listar();
        for (int i = 0; i < nutricionistas.size(); i++) {
            Nutricionista nutricionista = nutricionistas.get(i);
            System.out.println((i + 1) + " - " + nutricionista.getNome());
        }

        // Selecionar o nutricionista da lista
        System.out.print("Selecione o nutricionista (Digite o número correspondente): ");
        int indexNutricionista = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Nutricionista nutricionistaSelecionado = nutricionistas.get(indexNutricionista - 1);

        // Listar os pacientes disponíveis
        System.out.println("Pacientes disponíveis:");
        List<Paciente> pacientes = ListaPaciente.listar();
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.get(i);
            System.out.println((i + 1) + " - " + paciente.getNome());
        }

        // Selecionar o paciente da lista
        System.out.print("Selecione o paciente (Digite o número correspondente): ");
        int indexPaciente = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Paciente pacienteSelecionado = pacientes.get(indexPaciente - 1);

        // Cadastro da data e hora da consulta
        System.out.print("Data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHoraStr = scanner.nextLine();

        // Criação do objeto Consulta
        Consulta novaConsulta = new Consulta();
        novaConsulta.setNutricionista(nutricionistaSelecionado);
        novaConsulta.setPaciente(pacienteSelecionado);
        novaConsulta.setDataHoraFormatada(dataHoraStr);
        novaConsulta.setConsultaRealizada(false);

        // Adicionar a consulta à lista (exemplo, supondo que haja uma lista de consultas)
        ListaConsultas.adicionar(novaConsulta);

        System.out.println("Consulta cadastrada com sucesso!");
    }


    private static void listarConsultas() {
        System.out.println("Você escolheu listar todas as consultas:");

        List<Consulta> consultas = ListaConsultas.listar();
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas cadastradas.");
        } else {
            for (int i = 0; i < consultas.size(); i++) {
                Consulta consulta = consultas.get(i);
                String dataHoraFormatada = consulta.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                System.out.println((i + 1) + " - Paciente: " + consulta.getPaciente().getNome() + ", Nutricionista: " + consulta.getNutricionista().getNome() + ", Data e Hora: " + dataHoraFormatada);
            }
        }
    }


    private static void realizarConsulta() {
        System.out.println("Você escolheu realizar uma consulta.");
        listarConsultas();

        System.out.print("Digite o id da consulta: ");
        int idConsulta = scanner.nextInt();
        scanner.nextLine();

        Consulta consulta = ListaConsultas.buscarPorId(idConsulta);
        if (consulta != null) {
            consulta.realizar();
            System.out.println("Consulta realizada com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}

