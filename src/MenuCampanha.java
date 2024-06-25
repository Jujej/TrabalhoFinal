import java.util.Scanner;

public class MenuCampanha {
    private Scanner scanner = new Scanner(System.in);
    private GerDeParty GerDeParty = new GerDeParty();

    //menu2 do README
    public void exibirMenuCampanha() {
        int opcao;

        do {
            System.out.println("1 - Iniciar combate 3X3");
            System.out.println("2 - Listar party");
            System.out.println("3 - Editar membro da party");
            System.out.println("4 - Excluir party");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    //fazer combate
                    break;
                case 2:
                    GerDeParty.listarParty();
                    break;
                case 3:
                    GerDeParty.editarMembroParty(scanner);
                    break;
                case 4:
                    GerDeParty.excluirParty();
                    break;
                case 5:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }
}
