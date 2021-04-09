package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class GreenState implements State {

    @Override
    public TrafficLightColor getState(){
        return TrafficLightColor.GREEN;
    }

    @Override
    public void nextState(TrafficLightCtrl space){
        space.setCurrentState(space.getYellowState());
        space.setPreviousState(space.getGreenState());
    }

}
