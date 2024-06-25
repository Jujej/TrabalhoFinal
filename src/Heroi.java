import java.io.Serializable;
import java.util.Random;

abstract class Heroi implements Ataque, Serializable {

    //atributos
    protected String nome;
    protected String raca;
    protected int hp;
    protected int ca;
    protected int iniciativa;

    //construtores
    public Heroi(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    //getters
    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
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

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
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

    //jogar dados
    public int rolarD20() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public int rolarD12() {
        Random random = new Random();
        return random.nextInt(12) + 1;
    }

    public int rolarD10() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    public int rolarD8() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }

    public int rolarD6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    //puxando modulo
    public abstract void inicializarAtributos();
    
}

