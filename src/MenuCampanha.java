import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuCampanha {
    private Scanner scanner = new Scanner(System.in);
    private GerDeParty gerDeParty = new GerDeParty();

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
                    iniciarCombate();
                    break;
                case 2:
                    gerDeParty.listarParty();
                    break;
                case 3:
                    gerDeParty.editarMembroParty(scanner);
                    break;
                case 4:
                    gerDeParty.excluirParty();
                    break;
                case 5:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private void iniciarCombate() {
        List<Heroi> herois = gerDeParty.getParty();
        List<Inimigo> inimigos = gerarInimigos();

        if (herois.isEmpty()) {
            System.out.println("Nenhuma party disponível. Crie uma party antes de iniciar o combate.");
            return;
        }

        List<Combatente> combatentes = new ArrayList<>();

        for (Heroi heroi : herois) {
            combatentes.add(new Combatente(heroi, heroi.rolarIniciativa()));
        }

        for (Inimigo inimigo : inimigos) {
            combatentes.add(new Combatente(inimigo, inimigo.rolarIniciativa()));
        }

        Collections.sort(combatentes, Comparator.comparingInt(Combatente::getIniciativa).reversed());

        boolean combateEmAndamento = true;

        while (combateEmAndamento) {
            for (Combatente combatente : combatentes) {
                if (herois.stream().allMatch(h -> h.getHp() <= 0)) {
                    System.out.println("Os inimigos venceram!");
                    combateEmAndamento = false;
                    break;
                }

                if (inimigos.stream().allMatch(i -> i.getHp() <= 0)) {
                    System.out.println("Os heróis venceram!");
                    combateEmAndamento = false;
                    break;
                }

                if (combatente.getHp() > 0) {
                    if (combatente.isHeroi()) {
                        Heroi heroi = (Heroi) combatente.getPersonagem();
                        Inimigo alvo = escolherAlvoInimigo(inimigos);
                        realizarAtaqueHeroi(heroi, alvo);
                    } else {
                        Inimigo inimigo = (Inimigo) combatente.getPersonagem();
                        Heroi alvo = escolherAlvoHeroi(herois);
                        realizarAtaque(inimigo, alvo);
                    }
                }
            }
        }
    }

    private List<Inimigo> gerarInimigos() {
        List<Inimigo> inimigos = new ArrayList<>();
        inimigos.add(new Goblin("Goblin 1"));
        inimigos.add(new Goblin("Goblin 2"));
        inimigos.add(new Goblin("Goblin 3"));
        return inimigos;
    }

    private Heroi escolherAlvoHeroi(List<Heroi> herois) {
        return herois.stream().filter(h -> h.getHp() > 0).findFirst().orElse(null);
    }

    private Inimigo escolherAlvoInimigo(List<Inimigo> inimigos) {
        System.out.println("Escolha o alvo inimigo:");
        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);
            if (inimigo.getHp() > 0) {
                System.out.println((i + 1) + " - " + inimigo.getNome() + " (HP: " + inimigo.getHp() + ")");
            }
        }

        int opcao = -1;
        while (opcao < 1 || opcao > inimigos.size()) {
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao < 1 || opcao > inimigos.size() || inimigos.get(opcao - 1).getHp() <= 0) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }

        return inimigos.get(opcao - 1);
    }

    private void realizarAtaqueHeroi(Heroi heroi, Inimigo alvo) {
        System.out.println(heroi.getNome() + " (HP: " + heroi.getHp() + ") está atacando " + alvo.getNome() + " (HP: " + alvo.getHp() + ")");
        System.out.println("Escolha o tipo de ataque:");
        System.out.println("1 - Ataque normal");
        System.out.println("2 - Ataque especial");

        int tipoAtaque = -1;
        while (tipoAtaque < 1 || tipoAtaque > 2) {
            try {
                tipoAtaque = Integer.parseInt(scanner.nextLine());
                if (tipoAtaque < 1 || tipoAtaque > 2) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }

        int dano = (tipoAtaque == 1) ? heroi.atacar() : heroi.ataqueEspecial();
        alvo.setHp(alvo.getHp() - dano);
        System.out.println(heroi.getNome() + " causou " + dano + " de dano em " + alvo.getNome() + ".");
    }

    private void realizarAtaque(Ataque atacante, Ataque alvo) {
        int dano = atacante.atacar();
        if (alvo instanceof Heroi) {
            Heroi heroi = (Heroi) alvo;
            heroi.setHp(heroi.getHp() - dano);
            System.out.println(atacante.getClass().getSimpleName() + " atacou " + heroi.getNome() + " causando " + dano + " de dano.");
        } else if (alvo instanceof Inimigo) {
            Inimigo inimigo = (Inimigo) alvo;
            inimigo.setHp(inimigo.getHp() - dano);
            System.out.println(atacante.getClass().getSimpleName() + " atacou " + inimigo.getNome() + " causando " + dano + " de dano.");
        }
    }

    private class Combatente {
        private Ataque personagem;
        private int iniciativa;

        public Combatente(Ataque personagem, int iniciativa) {
            this.personagem = personagem;
            this.iniciativa = iniciativa;
        }

        public Ataque getPersonagem() {
            return personagem;
        }

        public int getIniciativa() {
            return iniciativa;
        }

        public int getHp() {
            if (personagem instanceof Heroi) {
                return ((Heroi) personagem).getHp();
            } else if (personagem instanceof Inimigo) {
                return ((Inimigo) personagem).getHp();
            }
            return 0;
        }

        public boolean isHeroi() {
            return personagem instanceof Heroi;
        }
    }
}
