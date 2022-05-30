import algorithm.CaaAlgorithm;
import database.ImportCSV;
import design.MainFrame;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {



        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        /**
         * this part is used for inserting the data in the database
         */
//        EntityTransaction entityTransaction
//                = entityManager.getTransaction();
//        ImportCSV importCSV = new ImportCSV();
//        importCSV.importToGlobal(entityManager,entityTransaction);
//        importCSV.importToTables(entityManager,entityTransaction);

        /**
         * we need this part to run the application in the console,
         * but we skip it as we use the frame from design package
         */
//        CaaAlgorithm caaAlgorithm = new CaaAlgorithm("Suceava","Suceava", "Romania", entityManager);
//        System.out.println(caaAlgorithm.getCityName() + " "+
//                caaAlgorithm.getStateName() + " " +
//                caaAlgorithm.getCountryName());
//
//        if (!caaAlgorithm.checkCity())
//            System.out.println("Wrong");
//        else {
//            System.out.println("ok");
//            caaAlgorithm.checkState();
//            caaAlgorithm.checkCountry();
//        }
//
//        System.out.println(caaAlgorithm.getCityName() + " "+
//                caaAlgorithm.getStateName() + " " +
//                caaAlgorithm.getCountryName());

        new MainFrame().setVisible(true);
    }
}
