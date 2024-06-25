import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class GerDeParty {
    private List<Heroi> party = new ArrayList<>();

    //Carrega do txt, tem uma grande chance de ser isso que ta cagando com
    // a droga do script
    public GerDeParty() {
        carregarParty();
    }

    public List<Heroi> getParty() {
        return party;
    }

    //menuzinho de criação do char (funciona, mas verifique a parte do txt)
    public void criarParty(Scanner scanner) {
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

    // seleção da raça (funciona)
    private String escolherRaca(Scanner scanner) {
        String[] racas = {"Anão", "Elfo", "Halfling", "Humano", "Draconato", "Gnomo", "Meio-Elfo", "Meio-Orc", "Tiefling"};
        for (int i = 0; i < racas.length; i++) {
            System.out.println((i + 1) + " - " + racas[i]);
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return racas[opcao - 1];
    }

    //seleção da classe (funciona)
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

    //listar membros (as vezes funciona, não entendi bem o criterio,mas 
    //acho que é o terminal)
    public void listarParty() {
        if (party.isEmpty()) {
            System.out.println("A party está vazia.");
            return;
        }

        for (Heroi heroi : party) {
            System.out.println(heroi);
        }
    }

    //editar membros (funciona)
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

    //excluir (funciona)
    public void excluirParty() {
        party.clear();
        salvarParty();
        System.out.println("Party excluída com sucesso.");
    }

    //salvar no txt (não faço a menor ideia de como isso funciona, arrume!!)
    private void salvarParty() {
        try (FileOutputStream fos = new FileOutputStream("party.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(party);
            System.out.println("Party salva com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar a party: " + e.getMessage());
        }
    }

    //não me pergunte o que é isso
    @SuppressWarnings("unchecked")
    private void carregarParty() {
        try (FileInputStream fis = new FileInputStream("party.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            party = (List<Heroi>) ois.readObject();
            System.out.println("Party carregada com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Nenhuma party salva encontrada.");
        } catch (Exception e) {
            System.out.println("Erro ao carregar a party: " + e.getMessage());
        }
    }
}