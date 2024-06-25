class Mago extends Heroi {

    //atributos
    private int magia;

    //construtores
    public Mago(String nome, String raca) {
        super(nome, raca);
        inicializarAtributos();
    }

    //modulos
    @Override
    public void inicializarAtributos() {
        this.hp = 25;
        this.ca = 13;
        this.iniciativa = 1;
        this.magia = 2;
    }

    //acoes
    @Override
    public int rolarIniciativa() {
        return rolarD20() + iniciativa;
    }

    @Override
    public int atacar() {
        int hit = rolarD20() + magia;
        int dmg = rolarD8() + magia;
        return dmg;
    }

    @Override
    public int ataqueEspecial() {
        int hit = rolarD10() + magia;
        int dmg = (rolarD10() * 3) + magia;
        return dmg;
    }

    //getter
    public int getmagia() {
        return magia;
    }

    //to string
    @Override
    public String toString() {
        String txt = "Mago" + "\n" + nome + "\n(" + raca + ")\n";
        return txt;
    }
}
