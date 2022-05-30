package entities;

import javax.persistence.*;

@Entity
@Table(name = "states")
@NamedQueries({
        @NamedQuery(name = "State.findAll", query = "select s from State s"),
        @NamedQuery(name = "State.findByStateId", query = "select s from State s where s.stateId = :stateId")
})
public class State {
    @Id
    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "state_code", length = 30)
    private String stateCode;

    @Column(name = "state_name", length = 100)
    private String stateName;

    @Column(name = "country_id")
    private Integer countryId;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

}