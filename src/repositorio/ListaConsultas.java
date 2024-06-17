package repositorio;

import entidades.Consulta;
import java.util.ArrayList;
import java.util.List;

public class ListaConsultas {
    private static List<Consulta> consultas = new ArrayList<>();
    private static int nextId = 1;

    public static List<Consulta> listar() {
        return new ArrayList<>(consultas);
    }

    public static Consulta buscarPorId(int id) {
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                return consulta;
            }
        }
        return null;
    }

    public static void adicionar(Consulta consulta) {
        consulta.setId(nextId++);
        consultas.add(consulta);
    }

    public static boolean remover(int id) {
        Consulta consulta = buscarPorId(id);
        if (consulta != null) {
            return consultas.remove(consulta);
        }
        return false;
    }

    public static boolean alterar(int id, Consulta novosDados) {
        Consulta consulta = buscarPorId(id);
        if (consulta != null) {
            consulta.setNomeNutricionista(novosDados.getNomeNutricionista());
            consulta.setNomePaciente(novosDados.getNomePaciente());
            consulta.setDataHora(novosDados.getDataHora());
            consulta.setConsultaRealizada(novosDados.isConsultaRealizada());
            return true;
        }
        return false;
    }
}
