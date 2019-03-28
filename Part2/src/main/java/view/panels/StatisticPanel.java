package view.panels;

import javax.swing.*;

public class StatisticPanel extends JPanel {
    public JButton caculateButton;
    public ButtonGroup buttonGroup;

    public JRadioButton distribution;
    public JRadioButton average;
    public JRadioButton commonYear;

    public JLabel reuslt;

    public StatisticPanel() {
        init();

        setupPanel();
        setupLayout();
    }

    private void init() {
        caculateButton = new JButton("Calculate");
        buttonGroup = new ButtonGroup();

        distribution = new JRadioButton("Distribution");
        average = new JRadioButton("Average");
        commonYear = new JRadioButton("Common Year");

        reuslt = new JLabel("");
    }

    private void setupPanel() {
        this.setSize(1280, 720);
        setupRadioButton();
        this.add(distribution);
        this.add(average);
        this.add(commonYear);
        this.add(caculateButton);
        this.add(reuslt);
    }

    private void setupLayout() {

    }

    private void setupRadioButton()
    {
        buttonGroup.add(distribution);
        buttonGroup.add(average);
        buttonGroup.add(commonYear);
    }
}
