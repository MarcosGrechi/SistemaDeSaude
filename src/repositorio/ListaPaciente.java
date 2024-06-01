package repositorio;

import entidades.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ListaPaciente {
    private static List<Paciente> pacientes = new ArrayList<>();
    private static int nextId = 1; // Gerador de ID

    public static List<Paciente> listar() {
        return new ArrayList<>(pacientes); // Retorna uma cópia da lista para evitar modificações diretas
    }

    public static Paciente buscarPorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.id == id) {
                return paciente;
            }
        }
        return null; // Retorna null se o paciente não for encontrado
    }

    public static void adicionar(Paciente paciente) {
        paciente.id = nextId++; // Atribui um ID único ao paciente
        pacientes.add(paciente);
    }

    public static boolean remover(int id) {
        Paciente paciente = buscarPorId(id);
        if (paciente != null) {
            return pacientes.remove(paciente);
        }
        return false;
    }

    public static boolean alterar(int id, double novoPeso, double novaAltura, double novaPressaoArterial, double novaFrequenciaCardiaca, String novaDietaAlimentar) {
        Paciente paciente = buscarPorId(id);
        if (paciente != null) {
            paciente.setPeso(novoPeso);
            paciente.setAltura(novaAltura);
            paciente.setPressaoArterial(novaPressaoArterial);
            paciente.setFrequenciaCardiaca(novaFrequenciaCardiaca);
            paciente.setDietaAlimentar(novaDietaAlimentar);
            return true;
        }
        return false;
    }
}
