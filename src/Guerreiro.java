import java.io.Serializable;

class Guerreiro extends Heroi implements Serializable {

    //atributos
    private int forca;

    //construtores
    public Guerreiro(String nome, String raca) {
        super(nome, raca);
        inicializarAtributos();
    }

    //modulos
    @Override
    public void inicializarAtributos() {
        this.hp = 50;
        this.ca = 18;
        this.iniciativa = 2;
        this.forca = 3;
    }

    //acoes
    @Override
    public int rolarIniciativa() {
        return rolarD20() + iniciativa;
    }

    @Override
    public int atacar() {
        int hit = rolarD20() + forca;
        int dmg = rolarD10() + forca;
        return dmg;
    }

    @Override
    public int ataqueEspecial() {
        int hit = (rolarD8() * 2) + forca;
        int dmg = (rolarD8() * 2) + forca;
        return dmg;
    }

    //getter
    public int getForca() {
        return forca;
    }

    //to string
    @Override
    public String toString() {
        String txt = "Guerreiro" + "\n" + nome + "\n(" + raca + ")\n";
        return txt;
    }
}
