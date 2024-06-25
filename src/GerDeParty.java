import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerDeParty {
    private List<Heroi> party = new ArrayList<>();

    public GerDeParty() {
        carregarParty();
    }

    public List<Heroi> getParty() {
        return party;
    }

    public void criarParty(Scanner scanner) {
        party.clear(); // Esvazia a lista de heróis antes de criar uma nova party
        System.out.println("Aqui você criará seus três personagens para sua aventura!");

        for (int i = 1; i <= 3; i++) {
            System.out.println("--HEROI N°" + i + "--");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.println("Raça: ");
            String raca = escolherRaca(scanner);

            System.out.println("Classe: ");
            Heroi heroi = escolherClasse(scanner, nome, raca);

            party.add(heroi);
        }

        salvarParty();
    }

    private String escolherRaca(Scanner scanner) {
        String[] racas = {"Anão", "Elfo", "Halfling", "Humano", "Draconato", "Gnomo", "Meio-Elfo", "Meio-Orc", "Tiefling"};
        for (int i = 0; i < racas.length; i++) {
            System.out.println((i + 1) + " - " + racas[i]);
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return racas[opcao - 1];
    }

    private Heroi escolherClasse(Scanner scanner, String nome, String raca) {
        System.out.println("1 - Guerreiro\n2 - Mago\n3 - Ladino\n4 - Patrulheiro\n5 - Monge");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return new Guerreiro(nome, raca);
            case 2:
                return new Mago(nome, raca);
            case 3:
                return new Ladino(nome, raca);
            case 4:
                return new Patrulheiro(nome, raca);
            case 5:
                return new Monge(nome, raca);
            default:
                throw new IllegalArgumentException("Classe inválida.");
        }
    }

    public void listarParty() {
        if (party.isEmpty()) {
            System.out.println("A party está vazia.");
            return;
        }

        for (Heroi heroi : party) {
            System.out.println(heroi);
        }
    }

    public void editarMembroParty(Scanner scanner) {
        listarParty();
        if (party.isEmpty()) return;

        System.out.println("Escolha o número do herói que deseja editar:");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < party.size()) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();

            System.out.println("Nova raça: ");
            String raca = escolherRaca(scanner);

            System.out.println("Nova classe: ");
            Heroi heroi = escolherClasse(scanner, nome, raca);

            party.set(index, heroi);
            salvarParty();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void excluirParty() {
        party.clear();
        salvarParty();
        System.out.println("Party excluída com sucesso.");
    }

    private void salvarParty() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("party.txt"))) {
            for (Heroi heroi : party) {
                bw.write(heroi.getClass().getSimpleName() + "," + heroi.getNome() + "," + heroi.getRaca());
                bw.newLine();
            }
            System.out.println("Party salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a party: " + e.getMessage());
        }
    }

    private void carregarParty() {
        try (BufferedReader br = new BufferedReader(new FileReader("party.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String classe = dados[0];
                String nome = dados[1];
                String raca = dados[2];

                switch (classe) {
                    case "Guerreiro":
                        party.add(new Guerreiro(nome, raca));
                        break;
                    case "Mago":
                        party.add(new Mago(nome, raca));
                        break;
                    case "Ladino":
                        party.add(new Ladino(nome, raca));
                        break;
                    case "Patrulheiro":
                        party.add(new Patrulheiro(nome, raca));
                        break;
                    case "Monge":
                        party.add(new Monge(nome, raca));
                        break;
                    default:
                        System.out.println("Classe desconhecida encontrada no arquivo: " + classe);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhuma party salva encontrada.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar a party: " + e.getMessage());
        }
    }
}