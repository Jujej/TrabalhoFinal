class Goblin extends Inimigo {
    public Goblin(String nome) {
        super(nome);
        inicializarAtributos();
    }

    @Override
    public void inicializarAtributos() {
        this.hp = 20;
        this.ca = 12;
        this.iniciativa = rolarD20();
    }

    @Override
    public int rolarIniciativa() {
        return rolarD20() + iniciativa;
    }

    @Override
    public int atacar() {
        int hit = rolarD20();
        int dmg = rolarD8();
        return dmg;
    }

    @Override
    public int ataqueEspecial() {
        int hit = rolarD20();
        int dmg = rolarD8() * 2;
        return dmg;
    }

    @Override
    public String toString() {
        return "Goblin\n" + nome + "\nHP: " + hp + "\nCA: " + ca + "\nIniciativa: " + iniciativa + "\n";
    }
}