package entidades;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    public int id;
    public String nome;
    public int idade;
    public double peso;
    public double altura;
    public double pressaoArterial;
    public double frequenciaCardiaca;
    public String dietaAlimentar;
    public List<String> atividadesFisicas;

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

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public void setFrequenciaCardiaca(double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public void setDietaAlimentar(String dietaAlimentar) {
        this.dietaAlimentar = dietaAlimentar;
    }
}
