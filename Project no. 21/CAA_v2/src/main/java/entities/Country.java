package entities;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Country.findAll", query = "select c from Country c"),
        @NamedQuery(name = "Country.findByCountryId", query = "select c from Country c where c.countryId = :countryId")
})
public class Country {
    @Id
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country_code", length = 30)
    private String countryCode;

    @Column(name = "country_name", length = 100)
    private String countryName;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}