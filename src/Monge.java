import java.io.Serializable;

class Monge extends Heroi implements Serializable {

    //atributos
    private int velocidade;

    //construtores
    public Monge(String nome, String raca) {
        super(nome, raca);
        inicializarAtributos();
    }

    //modulos
    @Override
    public void inicializarAtributos() {
        this.hp = 40;
        this.ca = 16;
        this.iniciativa = 4;
        this.velocidade = 3;
    }

    //acoes
    @Override
    public int rolarIniciativa() {
        return rolarD20() + iniciativa;
    }

    @Override
    public int atacar() {
        int hit = rolarD20() + velocidade;
        int dmg = (rolarD6() * 2) + velocidade;
        return dmg;
    }

    @Override
    public int ataqueEspecial() {
        int hit = (rolarD8() * 2) + velocidade;
        int dmg = (rolarD6() * 4) + velocidade;
        return dmg;
    }

    //getter
    public int getvelocidade() {
        return velocidade;
    }

    //to string
    @Override
    public String toString() {
        String txt = "Monge" + "\n" + nome + "\n(" + raca + ")\n";
        return txt;
    }
}
