package laboratorio._1.jpa.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ofertas") // Nome da tabela no banco de dados
public class Oferta {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "tag")
    private String tag;

    @Column(name = "aviso")
    private String aviso;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "cnpjNome")
    private String cnpjNome;

    @Column(name = "localGps")
    private Integer localGps;

    @Column(name = "pending")
    private Boolean pending;

    // Getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCnpjNome() {
        return cnpjNome;
    }

    public void setCnpjNome(String cnpjNome) {
        this.cnpjNome = cnpjNome;
    }

    public Integer getLocalGps() {
        return localGps;
    }

    public void setLocalGps(Integer localGps) {
        this.localGps = localGps;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }
}
