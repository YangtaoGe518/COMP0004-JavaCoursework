package controller;

import model.Factory;
import model.Model;
import view.MainFrame;

public class MainController {

    private MainFrame appFrame;
    private Model appModel;  // this has to be changed to Model (build later)

    public MainController(){
        appModel = new Model();
    }

    public void start(){
        appFrame = new MainFrame(this);
    }

    public Model getAppModel(){
        return appModel;
    }

    public MainFrame getAppFrame(){
        return appFrame;
    }

}