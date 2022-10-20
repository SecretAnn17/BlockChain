class EnjoyVehicle {

    public static void startVehicle() {
        Vehicle outer = new Vehicle();
        Vehicle.Engine inner = outer.new Engine();
        inner.start();
    }
}
