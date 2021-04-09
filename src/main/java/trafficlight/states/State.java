package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

//Template for the sub-classes.
public interface State {

    public TrafficLightColor getState();

    public void nextState(TrafficLightCtrl trial);

}