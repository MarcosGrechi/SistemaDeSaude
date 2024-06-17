package repositorio;

import entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class ListaFuncionarios {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static int nextId = 1;

    public static List<Funcionario> listar() {
        return new ArrayList<>(funcionarios);
    }

    public static Funcionario buscarPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public static void adicionar(Funcionario funcionario) {
        funcionario.setId(nextId++);
        funcionarios.add(funcionario);
    }

    public static boolean remover(int id) {
        Funcionario funcionario = buscarPorId(id);
        if (funcionario != null) {
            return funcionarios.remove(funcionario);
        }
        return false;
    }

    public static boolean alterar(int id, Funcionario novosDados) {
        Funcionario funcionario = buscarPorId(id);
        if (funcionario != null) {
            funcionario.setNome(novosDados.getNome());
            funcionario.setIdade(novosDados.getIdade());
            funcionario.setEndereco(novosDados.getEndereco());
            funcionario.setSalario(novosDados.getSalario());
            return true;
        }
        return false;
    }
}
