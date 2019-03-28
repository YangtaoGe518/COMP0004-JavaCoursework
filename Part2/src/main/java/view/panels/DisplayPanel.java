package view.panels;

import javax.swing.*;

public class DisplayPanel extends JPanel{
    public JLabel id, birthdate, deathdate, ssn, drivers, passport;
    public JLabel prefix, first, last, suffix, maiden;
    public JLabel marital, race, ethnicity, gender;
    public JLabel birthplace, address, city, state, zip;

    public DisplayPanel(){
        init();

        setupPanel();
        setupLayout();
    }

    private void init(){
        id = new JLabel("id: ");
        birthdate = new JLabel("birthdate: ");
        deathdate = new JLabel("deathdate: ");
        ssn = new JLabel("ssn: ");
        drivers = new JLabel("driver: ");
        passport = new JLabel("passport: ");
        prefix = new JLabel("prefix: ");
        first = new JLabel("first: ");
        last = new JLabel("last: ");
        suffix = new JLabel("suffix: ");
        maiden = new JLabel("maiden: ");
        marital = new JLabel("marital: ");
        race = new JLabel("race: ");
        ethnicity = new JLabel("ethnicity: ");
        gender = new JLabel("gender: ");
        birthplace = new JLabel("birthplace: ");
        address = new JLabel("address: ");
        city = new JLabel("city: ");
        state = new JLabel("state: ");
        zip = new JLabel("zip: ");
    }

    private void setupPanel(){
        this.setSize(1280, 720);
        this.add(id);
        this.add(birthdate);
        this.add( deathdate);
        this.add(ssn);
        this.add(drivers);
        this.add( passport);
        this.add( prefix);
        this.add(first);
        this.add(last);
        this.add(suffix);
        this.add(maiden);
        this.add(marital);
        this.add(race);
        this.add(ethnicity);
        this.add(gender);
        this.add(birthplace);
        this.add(address);
        this.add(city);
        this.add(state);
        this.add(zip);
    }

    private void setupLayout(){
        /* use box layout */
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
}
