import java.util.Scanner;

public class MenuPrincipal {
    private GerDeParty gerDeParty = new GerDeParty();
    private MenuCampanha menuCampanha = new MenuCampanha();

    // menu1 do README
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Criar minha party");
            System.out.println("2 - Carregar party existente");
            System.out.println("3 - Ver regras");
            System.out.println("4 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    gerDeParty.criarParty(scanner);
                    menuCampanha.exibirMenuCampanha();
                    break;
                case 2:
                    if (!gerDeParty.getParty().isEmpty()) {
                        System.out.println("Party carregada com sucesso!");
                        menuCampanha.exibirMenuCampanha();
                    } else {
                        System.out.println("Nenhuma party salva encontrada.");
                    }
                    break;
                case 3:
                    exibirRegras();
                    break;
                case 4:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }

    // regras tem que fazer, vou fazer no trabalho rapidinho e te passo
    private void exibirRegras() {
        System.out.println("--REGRAS--");
        // Exibir regras do jogo
    }
}
