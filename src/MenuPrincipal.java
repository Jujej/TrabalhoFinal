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
        System.out.println("Regras do Jogo\n" + //
                        "\n" + //
                        "Bem-vindo ao nosso jogo de RPG inspirado em Dungeons & Dragons! Aqui estão as regras básicas para você entender como jogar e aproveitar ao máximo a sua aventura.\n" + //
                        "\n" + //
                        "    Criação da Party:\n" + //
                        "        Você começará criando uma party de três heróis.\n" + //
                        "        Cada herói deve ter um nome, raça e classe.\n" + //
                        "        As raças disponíveis são: Anão, Elfo, Halfling, Humano, Draconato, Gnomo, Meio-Elfo, Meio-Orc, e Tiefling.\n" + //
                        "        As classes disponíveis são: Guerreiro, Mago, Ladino, Patrulheiro e Monge.\n" + //
                        "        Cada classe possui atributos específicos que influenciam suas habilidades de combate.\n" + //
                        "\n" + //
                        "    Atributos dos Heróis:\n" + //
                        "        HP (Pontos de Vida): A quantidade de dano que um herói pode suportar antes de ser derrotado.\n" + //
                        "        CA (Classe de Armadura): A capacidade do herói de evitar ataques.\n" + //
                        "        Iniciativa: Determina a ordem de ação no combate.\n" + //
                        "        Atributos Específicos: Cada classe possui atributos únicos que influenciam suas habilidades de ataque e defesa.\n" + //
                        "\n" + //
                        "    Combate:\n" + //
                        "        O combate é baseado em turnos, e a ordem de ação é determinada pela rolagem de iniciativa.\n" + //
                        "        Em cada turno, um herói pode realizar um ataque normal ou um ataque especial.\n" + //
                        "        Ataque Normal: Um ataque padrão que causa dano baseado na classe do herói.\n" + //
                        "        Ataque Especial: Um ataque mais poderoso com maior potencial de dano, mas pode ter limitações ou condições especiais.\n" + //
                        "        O combate continua até que todos os heróis ou inimigos sejam derrotados.\n" + //
                        "\n" + //
                        "");
    }
}
