import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Analise {
    private String data;
    private List<Double> valoresCloro;
    private List<Double> valoresFluor;
    private List<Double> valoresPH;
    private List<Double> valoresTemperatura;
    private List<Double> valoresTurbidez;
    private List<Double> valoresCor;
    private List<Double> valoresEcoli;

    public Analise(String data) {
        this.data = data;
        valoresCloro = new ArrayList<>();
        valoresFluor = new ArrayList<>();
        valoresPH = new ArrayList<>();
        valoresTemperatura = new ArrayList<>();
        valoresTurbidez = new ArrayList<>();
        valoresCor = new ArrayList<>();
        valoresEcoli = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public List<Double> getValoresCloro() {
        return valoresCloro;
    }

    public List<Double> getValoresFluor() {
        return valoresFluor;
    }

    public List<Double> getValoresPH() {
        return valoresPH;
    }

    public List<Double> getValoresTemperatura() {
        return valoresTemperatura;
    }

    public List<Double> getValoresTurbidez() {
        return valoresTurbidez;
    }

    public List<Double> getValoresCor() {
        return valoresCor;
    }

    public List<Double> getValoresEcoli() {
        return valoresEcoli;
    }
}

class SistemaAnalises {
    private Map<String, Analise> analises;
    private Scanner scanner;

    public SistemaAnalises() {
        analises = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void realizarAnalises() {
        System.out.println("----- Realização de Análises -----");

        System.out.print("Data da análise: ");
        String data = scanner.nextLine();

        Analise analise = new Analise(data);

        System.out.println("Informe os valores para cada análise:");

        lerValores(analise.getValoresCloro(), "Cloro");
        lerValores(analise.getValoresFluor(), "Fluor");
        lerValores(analise.getValoresPH(), "pH");
        lerValores(analise.getValoresTemperatura(), "Temperatura");
        lerValores(analise.getValoresTurbidez(), "Turbidez");
        lerValores(analise.getValoresCor(), "Cor");
        lerValores(analise.getValoresEcoli(), "E.coli");

        analises.put(data, analise);

        System.out.println("Análise registrada com sucesso!");
        System.out.println("---------------------------------");
    }

    private void lerValores(List<Double> listaValores, String tipo) {
        for (int i = 0; i < 5; i++) {
            System.out.print(tipo + " " + (i + 1) + ": ");
            double valor = scanner.nextDouble();
            listaValores.add(valor);
        }
    }

    public void consultarAnalisePorData() {
        System.out.println("----- Consulta de Análises por Data -----");

        System.out.print("Informe a data da análise: ");
        String data = scanner.nextLine();

        Analise analise = analises.get(data);

        if (analise != null) {
            System.out.println("Data: " + analise.getData());
            System.out.println("Valores de Cloro: " + analise.getValoresCloro());
            System.out.println("Valores de Fluor: " + analise.getValoresFluor());
            System.out.println("Valores de pH: " + analise.getValoresPH());
            System.out.println("Valores de Temperatura: " + analise.getValoresTemperatura());
            System.out.println("Valores de Turbidez: " + analise.getValoresTurbidez());
            System.out.println("Valores de Cor: " + analise.getValoresCor());
            System.out.println("Valores de E.coli: " + analise.getValoresEcoli());
        } else {
            System.out.println("Não foram encontradas análises para a data informada.");
        }

        System.out.println("----------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaAnalises sistema = new SistemaAnalises();
        try (Scanner scanner = new Scanner(System.in)) {
			int opcao;

			do {
			    System.out.println("----- Sistema de Análises -----");
			    System.out.println("1. Realizar Análises");
			    System.out.println("2. Consultar Análises por Data");
			    System.out.println("3. Sair");
			    System.out.print("Escolha uma opção: ");
			    opcao = scanner.nextInt();
			    scanner.nextLine(); // Consumir a nova linha após a leitura do número

			    switch (opcao) {
			        case 1:
			            sistema.realizarAnalises();
			            break;
			        case 2:
			            sistema.consultarAnalisePorData();
			            break;
			        case 3:
			            System.out.println("Encerrando o programa...");
			            break;
			        default:
			            System.out.println("Opção inválida!");
			    }
			} while (opcao != 3);
		}
    }
}