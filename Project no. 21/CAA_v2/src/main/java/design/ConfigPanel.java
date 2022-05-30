package design;

import algorithm.CaaAlgorithm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {

    final MainFrame mainFrame;
    JLabel goodInput, badInput;
    JLabel wrongCity, addressMessage;
    JLabel cityTitle, stateTitle, countryTitle;
    JTextField cityText, stateText, countryText;
    String city, state, country;
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("default");
    EntityManager entityManager =
            entityManagerFactory.createEntityManager();
    JButton checkBtn;

    public ConfigPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        init();
    }

    //TODO create the app window
    private void init() {

        setPreferredSize(new Dimension(600, 500));
        this.setLayout(new GridLayout(11, 1, 50, 0));

        cityTitle = new JLabel("Please insert a city: ");
        add(cityTitle);
        cityText = new JTextField();
        add(cityText);
        stateTitle = new JLabel("Please insert a state: ");
        add(stateTitle);
        stateText = new JTextField();
        add(stateText);
        countryTitle = new JLabel("Please insert a country: ");
        add(countryTitle);
        countryText = new JTextField();
        add(countryText);

        wrongCity = new JLabel("City doesn't exist!");
        wrongCity.setVisible(false);
        add(wrongCity);
        goodInput = new JLabel("The input credentials are correct. Well done!");
        goodInput.setVisible(false);
        add(goodInput);
        badInput = new JLabel("The input credentials are wrong!");
        badInput.setVisible(false);
        add(badInput);

        addressMessage = new JLabel();
        addressMessage.setVisible(false);
        add(addressMessage);

        checkBtn = new JButton("Check your input!");
        checkBtn.addActionListener(this::checkAddress);
        add(checkBtn);
    }

    //TODO implemented CaaAlgorithm for graphics input
    public void checkAddress(ActionEvent e) {
        city = cityText.getText();
        state = stateText.getText();
        country = countryText.getText();

        goodInput.setVisible(false);
        badInput.setVisible(false);
        addressMessage.setVisible(false);
        wrongCity.setVisible(false);

        CaaAlgorithm caaAlgorithm = new CaaAlgorithm(city, state, country, entityManager);

        if (!caaAlgorithm.checkCity()) {
            wrongCity.setVisible(true);

        } else {
            if (state.length() == 0 || country.length() == 0) {
                badInput.setText("Some fields are not completed. Try again.");
                badInput.setVisible(true);

            } else {
                if (!caaAlgorithm.checkState()) {
                    badInput.setText("The input credentials are wrong!");
                    badInput.setVisible(true);
                    caaAlgorithm.checkState();
                    caaAlgorithm.checkCountry();

                    addressMessage.setText("The correct address is: City: " +
                            caaAlgorithm.getCityName() + " State: " + caaAlgorithm.getStateName() +
                            " Country: " + caaAlgorithm.getCountryName());
                    addressMessage.setVisible(true);

                } else if (!caaAlgorithm.checkCountry()) {
                    badInput.setText("The input credentials are wrong!");
                    badInput.setVisible(true);
                    caaAlgorithm.checkState();
                    caaAlgorithm.checkCountry();

                    addressMessage.setText("The correct address is: City: " +
                            caaAlgorithm.getCityName() + " State: " + caaAlgorithm.getStateName() +
                            " Country: " + caaAlgorithm.getCountryName());

                    addressMessage.setVisible(true);

                } else{
                    goodInput.setVisible(true);

                    caaAlgorithm.checkState();
                    caaAlgorithm.checkCountry();

                    addressMessage.setText("The correct address is: City: " +
                            caaAlgorithm.getCityName() + " State: " + caaAlgorithm.getStateName() +
                            " Country: " + caaAlgorithm.getCountryName());

                    addressMessage.setVisible(true);
                }

            }
        }
    }
}
