package repositorio;

import entidades.Nutricionista;
import java.util.ArrayList;
import java.util.List;

public class ListaNutricionistas {
    private static List<Nutricionista> nutricionistas = new ArrayList<>();
    private static int nextId = 1;

    public static List<Nutricionista> listar() {
        return new ArrayList<>(nutricionistas);
    }

    public static Nutricionista buscarPorId(int id) {
        for (Nutricionista nutricionista : nutricionistas) {
            if (nutricionista.getId() == id) {
                return nutricionista;
            }
        }
        return null;
    }

    public static void adicionar(Nutricionista nutricionista) {
        // Verifica se já existe um nutricionista com o mesmo nome
        for (Nutricionista n : nutricionistas) {
            if (n.getNome().equalsIgnoreCase(nutricionista.getNome())) {;
                return; // Retorna sem adicionar o nutricionista
            }
        }

        // Se não existe um nutricionista com o mesmo nome, adiciona à lista
        nutricionista.setId(nextId++);
        nutricionistas.add(nutricionista);
    }

    public static boolean nutricionistaRepetido(String nome) {
        for (Nutricionista nutricionista : nutricionistas) {
            if (nutricionista.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }


    public static boolean remover(int id) {
        Nutricionista nutricionista = buscarPorId(id);
        if (nutricionista != null) {
            return nutricionistas.remove(nutricionista);
        }
        return false;
    }

    public static boolean alterar(int id, Nutricionista novosDados) {
        Nutricionista nutricionista = buscarPorId(id);
        if (nutricionista != null) {
            nutricionista.setNome(novosDados.getNome());
            nutricionista.setIdade(novosDados.getIdade());
            nutricionista.setEndereco(novosDados.getEndereco());
            return true;
        }
        return false;
    }


}
