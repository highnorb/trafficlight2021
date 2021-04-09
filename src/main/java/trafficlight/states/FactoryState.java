package trafficlight.states;

public class FactoryState {

    public State factory(String check) {
        if (check.equals("GREEN")) {
            return new GreenState();
        } else if (check.equals("YELLOW")) {
            return new YellowState();
        } else if (check.equals("RED")) {
            return new RedState();
        } else {
            return new OffState();
        }
    }
}
