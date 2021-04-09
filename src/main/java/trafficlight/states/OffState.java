package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class OffState implements State{

    @Override
    public TrafficLightColor getState(){
        return TrafficLightColor.OFF;
    }

    //Traffic light starts at red.
    @Override
    public void nextState(TrafficLightCtrl space){
        space.setCurrentState(space.getRedState());
    }

}
