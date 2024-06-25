class Ladino extends Heroi {

    //atributos
    private int furtividade;

    //construtores
    public Ladino(String nome, String raca) {
        super(nome, raca);
        inicializarAtributos();
    }

    //modulos
    @Override
    public void inicializarAtributos() {
        this.hp = 30;
        this.ca = 14;
        this.iniciativa = 5;
        this.furtividade = 4;
    }

    //acoes
    @Override
    public int rolarIniciativa() {
        return rolarD20() + iniciativa;
    }

    @Override
    public int atacar() {
        int hit = rolarD20() + furtividade;
        int dmg = rolarD8() + furtividade;
        return dmg;
    }

    @Override
    public int ataqueEspecial() {
        int hit = rolarD20();
        int dmg = (rolarD6() * 3) + furtividade;
        return dmg;
    }

    //getter
    public int getfurtividade() {
        return furtividade;
    }

    //to string
    @Override
    public String toString() {
        String txt = "Ladino" + "\n" + nome + "\n(" + raca + ")\n";
        return txt;
    }
}
