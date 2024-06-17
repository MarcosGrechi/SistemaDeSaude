package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private int id;
    private String nomeNutricionista;
    private String nomePaciente;
    private LocalDateTime dataHora;
    private boolean consultaRealizada;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private Paciente paciente; // Adiciona o atributo paciente
    private Nutricionista nutricionista; // Adiciona o atributo nutricionista

    public Consulta() {
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeNutricionista() {
        return nomeNutricionista;
    }

    public void setNomeNutricionista(String nomeNutricionista) {
        this.nomeNutricionista = nomeNutricionista;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

    // Método para retornar data e hora formatadas
    public String getDataHoraFormatada() {
        return dataHora.format(FORMATTER);
    }

    public void setDataHoraFormatada(String dataHoraStr) {
        this.dataHora = LocalDateTime.parse(dataHoraStr, FORMATTER);
    }

    // Getters e Setters para paciente
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Getters e Setters para nutricionista
    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }

    public void realizar() {
    }
}
