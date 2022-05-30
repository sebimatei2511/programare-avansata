package database;

import entities.Global;
import entities.City;
import entities.Country;
import entities.State;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ImportCSV {

    //TODO this method does the import from .csv to the global table from database
    public void importToGlobal(
            EntityManager entityManager,
            EntityTransaction entityTransaction) {

        String file = "cities.csv";
        BufferedReader bufferedReader;
        String line;

        try{
            int loading = 0;
            bufferedReader = new BufferedReader(new FileReader(file));
            Global global = new Global();

            entityTransaction.begin();

            //TODO first, line gets the header of the .csv
            line = bufferedReader.readLine();

            int index;

            while ( (line = bufferedReader.readLine()) != null ) {

                //TODO the index is needed
                index=0;
                //TODO the separator
                String[] row = line.split(",");
                //TODO starting reading from .csv with the first column, the id of the city
                global.setId(Integer.parseInt(row[index]));
                index ++;

                if (row[index].startsWith("\"") && !row[index].endsWith("\"")) {
                    global.setName(row[index] + row[index+1]);
                    index = index + 2;
                }
                else {
                    global.setName(row[index]);
                    index ++;
                }

                global.setStateId(Integer.parseInt(row[index]));
                index ++;
                global.setStateCode(row[index]);
                index ++;

                if (row[index].startsWith("\"") && !row[index].endsWith("\"")) {
                    global.setStateName(row[index] + row[index+1]);
                    index = index + 2;
                }
                else {
                    global.setStateName(row[index]);
                    index ++;
                }

                global.setCountryId(Integer.parseInt(row[index]));
                index++;
                global.setCountryCode(row[index]);
                index ++;

                if (row[index].startsWith("\"") && !row[index].endsWith("\"")) {
                    global.setCountryName(row[index] + row[index+1]);
                    index = index + 2;
                }
                else {
                    global.setCountryName(row[index]);
                    index ++;
                }

                global.setLatitude(row[index]);
                index ++;
                global.setLongitude(row[index]);
                index ++;

                if (row.length > index)
                    global.setWikidataid(row[index]);
                else
                    global.setWikidataid("none");

                entityManager.merge(global);

                System.out.println(loading);
                loading ++;
            }
            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO this method imports from the global table to the other tables (cities,states,countries)
    public void importToTables(
            EntityManager entityManager,
            EntityTransaction entityTransaction ) {

        City city = new City();
        State state = new State();
        Country country = new Country();

        TypedQuery<Global> globalTypedQuery = entityManager.createNamedQuery("Global.findAll", Global.class);
        List<Global> globalList = globalTypedQuery.getResultList();

        entityTransaction.begin();
        int loading=0;
        //TODO take from global table and insert into the other tables
        for (Global global : globalList) {

            city.setId(global.getId());
            city.setName(global.getName());
            city.setStateId(global.getStateId());

            state.setStateId(global.getStateId());
            state.setCountryId(global.getCountryId());
            state.setStateCode(global.getStateCode());
            state.setStateName(global.getStateName());

            country.setCountryId(global.getCountryId());
            country.setCountryCode(global.getCountryCode());
            country.setCountryName(global.getCountryName());

            entityManager.merge(city);
            entityManager.merge(state);
            entityManager.merge(country);

            System.out.println(loading);
            loading++;
        }
        entityTransaction.commit();
    }
}
