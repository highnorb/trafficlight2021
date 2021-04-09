package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class YellowState implements State {

    @Override
    public TrafficLightColor getState(){
        return TrafficLightColor.YELLOW;
    }

    //If checks if it was green or red -> dependent on that, it jumps to red or green.
    @Override
    public void nextState(TrafficLightCtrl space){
        if(space.getPreviousState() == space.getGreenState()) {
            space.setCurrentState(space.getRedState());
        } else if (space.getPreviousState() == space.getRedState()) {
            space.setCurrentState(space.getGreenState());
        }
    }
}
