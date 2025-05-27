package sabrina.desafio.cadastro.entities;

import static sabrina.desafio.cadastro.entities.Pet.NAO_INFORMADO;

public class Endereco {
    private String numeroCasa;
    private String cidade;
    private String rua;

    public Endereco() {
    }

    public Endereco(String numeroCasa, String cidade, String rua) {
        if (numeroCasa.isEmpty()){
            this.numeroCasa = NAO_INFORMADO;
        }else {
            this.numeroCasa = numeroCasa;
        }
        this.cidade = cidade;
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rua ");
        sb.append(rua + ", ");
        sb.append(numeroCasa + " - ");
        sb.append(cidade);
        return sb.toString();
    }
}
