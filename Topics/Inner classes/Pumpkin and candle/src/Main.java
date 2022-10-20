class Pumpkin {

    private boolean forHalloween;

    public Pumpkin(boolean forHalloween) {
        this.forHalloween = forHalloween;
    }

    public void addCandle() {
        if(this.forHalloween){
            Pumpkin outer = new Pumpkin(this.forHalloween);
            Pumpkin.Candle inner = outer.new Candle();
            inner.burning();
        } else {
            System.out.println("We don't need a candle.");
        }
    }
    // create method addCandle()

    class Candle {

        void burning() {
            System.out.println("The candle is burning! Boooooo!");
        }
    }
}
