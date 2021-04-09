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

    //Variable for Singleton-Pattern.
    private static TrafficLightCtrl singleton = null;

    //checkInstance is being called in the MCP.
    // It checks, if there is already an object existing. If not, it creates one.
    //return = existing or new object.
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

    //States are being initialized.
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

    //Actual state is being called and switches to the next one.
    //gui-Object calls setLight and sets currentState.
    //(sout would have the purpose to visualize the changing states).
    public void nextState() {
        //TODO handle GUi request and update GUI... DONE
        //Call actual state (Method, that returns actual state), then set nextState and then hand over object.

        getCurrentState().nextState(this);
        gui.setLight(currentState.getState());
        //System.out.println(currentState);
    }
}