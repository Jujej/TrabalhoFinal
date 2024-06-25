class Patrulheiro extends Heroi {

    //atributos
    private int precisao;

    //construtores
    public Patrulheiro(String nome, String raca) {
        super(nome, raca);
        inicializarAtributos();
    }

    //modulos
    @Override
    public void inicializarAtributos() {
        this.hp = 35;
        this.ca = 14;
        this.iniciativa = 3;
        this.precisao = 5;
    }

    //acoes
    @Override
    public int rolarIniciativa() {
        return rolarD20() + iniciativa;
    }

    @Override
    public int atacar() {
        int hit = rolarD20() + precisao;
        int dmg = rolarD8() + precisao;
        return dmg;
    }

    @Override
    public int ataqueEspecial() {
        int hit = rolarD12() + precisao;
        int dmg = (rolarD8() * 3) + precisao;
        return dmg;
    }

    //getter
    public int getprecisao() {
        return precisao;
    }

    //to string
    @Override
    public String toString() {
        String txt = "Patrulheiro" + "\n" + nome + "\n(" + raca + ")\n";
        return txt;
    }
}
