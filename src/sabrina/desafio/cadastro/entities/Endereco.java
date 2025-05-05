package sabrina.desafio.cadastro.entities;

public class Endereco {
    private Integer numeroCasa;
    private String cidade;
    private int rua;


    public Endereco(int numeroCasa, String cidade, int rua) {
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.rua = rua;

    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public int getRua() {
        return rua;
    }

    public void setRua(int rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
