import java.io.Serializable;
import java.util.Random;

abstract class Inimigo implements Ataque, Serializable {
    protected String nome;
    protected int hp;
    protected int ca;
    protected int iniciativa;

    public Inimigo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getCa() {
        return ca;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public int rolarD20() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public int rolarD8() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }

    public abstract void inicializarAtributos();
    
    @Override
    public abstract int atacar();

    @Override
    public abstract int ataqueEspecial();
}