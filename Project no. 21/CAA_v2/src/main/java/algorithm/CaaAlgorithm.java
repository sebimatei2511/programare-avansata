package algorithm;

import entities.City;
import entities.Country;
import entities.State;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CaaAlgorithm {

    private final String cityName;
    private String stateName;
    private String countryName;
    int stateId;
    int countryId;
    EntityManager entityManager;
    boolean check = false;

    public CaaAlgorithm(String cityName,
                        String stateName,
                        String countryName,
                        EntityManager entityManager) {
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
        this.entityManager = entityManager;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    /**
        here are the methods that check if the city/state/country
        exists in the database
     */
    public boolean checkCity() {

        check = false;
        TypedQuery<City> cityTypedQuery
                = this.entityManager.createNamedQuery(
                "City.findAll", City.class);

        List<City> cityList = cityTypedQuery.getResultList();

        for (City city : cityList) {
            if (this.cityName.equals(city.getName())) {
                stateId = city.getStateId();
                check = true;
            }
        }
        return check;
    }


    public boolean checkState() {

        check = false;
        TypedQuery<State> stateTypedQuery
                = this.entityManager.createNamedQuery(
                "State.findAll", State.class);

        List<State> stateList = stateTypedQuery.getResultList();

        for (State state : stateList) {
            if (this.stateName.equals(state.getStateName())) {
                stateId = state.getStateId();
                countryId = state.getCountryId();
                check = true;
            }
        }

        if (!check) {
            for (State state : stateList) {
                if (stateId == state.getStateId()) {
                    stateName = state.getStateName();
                    countryId = state.getCountryId();
                }
            }
        }
        return check;
    }

    public boolean checkCountry() {

        check = false;
        TypedQuery<Country> countryTypedQuery
                = this.entityManager.createNamedQuery(
                "Country.findAll", Country.class);

        List<Country> countryList = countryTypedQuery.getResultList();

        for (Country country : countryList) {
            if (this.countryName.equals(country.getCountryName())) {
                countryId = country.getCountryId();
                check = true;
            }
        }

        if (!check) {
            for (Country country : countryList) {
                if (this.countryId == country.getCountryId()) {
                    this.countryName = country.getCountryName();
                }
            }
        }
        return check;
    }
}
