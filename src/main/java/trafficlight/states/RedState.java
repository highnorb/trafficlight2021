package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class RedState implements State {

    @Override
    public TrafficLightColor getState(){
        return TrafficLightColor.RED;
    }

    //After change, previous state is red and the new one is yellow.
    @Override
    public void nextState(TrafficLightCtrl space){
        space.setCurrentState(space.getYellowState());
        space.setPreviousState(space.getRedState());
    }

}

