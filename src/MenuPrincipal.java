import java.util.Scanner;

public class MenuPrincipal {
    private GerDeParty GerDeParty = new GerDeParty();
    MenuCampanha menuCampanha = new MenuCampanha();

    //menu1 do README
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Criar minha party");
            System.out.println("2 - Ver regras");
            System.out.println("3 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    GerDeParty.criarParty(scanner);
                    menuCampanha.exibirMenuCampanha();
                    break;
                case 2:
                    exibirRegras();
                    break;
                case 3:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }

    //regras tem que fazer, vou fazer no trabalho rapidinho e te passo
    private void exibirRegras() {
        System.out.println("--REGRAS--");
        // Exibir regras do jogo
    }
}
    
