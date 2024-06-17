package entidades;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private double pressaoArterial;
    private double frequenciaCardiaca;
    private String dietaAlimentar;
    private List<String> atividadesFisicas;

    public Paciente() {
        this.atividadesFisicas = new ArrayList<>();
    }

    public Paciente(String nome, int idade, double peso, double altura, double pressaoArterial, double frequenciaCardiaca, String dietaAlimentar) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.pressaoArterial = pressaoArterial;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.dietaAlimentar = dietaAlimentar;
        this.atividadesFisicas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public double getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public String getDietaAlimentar() {
        return dietaAlimentar;
    }

    public void setDietaAlimentar(String dietaAlimentar) {
        this.dietaAlimentar = dietaAlimentar;
    }

    public List<String> getAtividadesFisicas() {
        return atividadesFisicas;
    }

    public void setAtividadesFisicas(List<String> atividadesFisicas) {
        this.atividadesFisicas = atividadesFisicas;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String monitorarPaciente() {
        double imc = calcularIMC();
        String interpretacaoIMC = (imc < 18.5) ? "Abaixo do peso" :
                (imc < 24.9) ? "Peso normal" :
                        (imc < 29.9) ? "Sobrepeso" : "Obesidade";

        String interpretacaoPressao = (pressaoArterial < 120) ? "Pressão arterial normal" :
                (pressaoArterial < 130) ? "Pressão arterial elevada" :
                        (pressaoArterial < 140) ? "Hipertensão estágio 1" : "Hipertensão estágio 2";

        String interpretacaoFrequencia = (frequenciaCardiaca < 60) ? "Bradicardia" :
                (frequenciaCardiaca <= 100) ? "Normal" : "Taquicardia";

        return String.format(
                "Nome: %s\nIdade: %d\nPeso: %.2f kg\nAltura: %.2f m\nPressão Arterial: %.2f (%s)\nFrequência Cardíaca: %.2f (%s)\nDieta Alimentar: %s\nAtividades Físicas: %s\nIMC: %.2f (%s)",
                nome, idade, peso, altura, pressaoArterial, interpretacaoPressao, frequenciaCardiaca, interpretacaoFrequencia, dietaAlimentar, atividadesFisicas, imc, interpretacaoIMC
        );
    }

    public void registrarAtividadeFisica(String atividade) {
        atividadesFisicas.add(atividade);
    }
}
