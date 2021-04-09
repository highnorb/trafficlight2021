package trafficlight.ctrl;

import trafficlight.gui.TrafficLightGui;
import trafficlight.states.*;

public class TrafficLightCtrl {

    private State greenState;

    private State redState;

    private State yellowState;

    private State currentState;

    private State previousState;

    private TrafficLightGui gui;

    //COMMENT
    private static TrafficLightCtrl singleton = null;

    //COMMENT. Erstellen eines Objektes sofern es noch keines gibt.
    //return = bestehendes oder neues Objekt.
    public static TrafficLightCtrl checkInstance(){
        if(singleton == null){
            singleton = new TrafficLightCtrl();
        }
        return singleton;
    }

    private TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
    }

    //States are initialized.
    private void initStates() {
        //TODO create the states and set current and previous state... DONE

        greenState = new FactoryState().factory("GREEN");
        redState = new FactoryState().factory("RED");
        yellowState = new FactoryState().factory("YELLOW");

        currentState = new OffState();
        previousState = new RedState();

    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public State getCurrentState() { return currentState; }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public void run() {
        gui.run();
    }

    //Aktueller state wird aufgerufen und schaltet weiter.
    //gui-Objekt rud setLight auf und setzt den currentState dorthin.
    //sout wäre um mitchecken zu können, wie die states wechseln.
    public void nextState() {
        //TODO handle GUi request and update GUI... DONE
        //Aktuellen State aufrufen (Methode die aktuellen State returned), dann .setNextState und dann...
        //..Objekt übergeben.

        getCurrentState().nextState(this);
        gui.setLight(currentState.getState());
        //System.out.println(currentState);
    }
}