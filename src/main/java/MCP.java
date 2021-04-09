import trafficlight.ctrl.TrafficLightCtrl;


public class MCP {
    public static void main(String[] args) {
        //TrafficLightCtrl ctrl = new TrafficLightCtrl();
        //COMMENT
        TrafficLightCtrl ctrl = TrafficLightCtrl.checkInstance();
        ctrl.run();
    }
}