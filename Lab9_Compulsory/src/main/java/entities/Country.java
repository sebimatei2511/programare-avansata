package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Country.findAll",
                query = "select e from Country e order by e.name"),
})

public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Integer code;

    @Column(name = "continent")
    private Integer continent;

    public Country(String name,
                   Integer code,
                   Integer continent) {
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    public Country() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getContinent() {
        return continent;
    }

    public void setContinent(Integer continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", continent=" + continent +
                '}';
    }
}
