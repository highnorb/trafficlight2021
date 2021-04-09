import trafficlight.ctrl.TrafficLightCtrl;


public class MCP {
    public static void main(String[] args) {
        //SINGLETON-PATTERN:
        //Instead of always creating a new object, checkInstace is called here.
        //checkInstance checks, if there is already an object existiting. If not, it creates one.
        TrafficLightCtrl ctrl = TrafficLightCtrl.checkInstance();
        ctrl.run();
    }
}