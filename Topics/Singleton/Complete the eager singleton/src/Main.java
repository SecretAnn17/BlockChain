class SimpleCounter {
    private final static SimpleCounter INSTANCE = new SimpleCounter();
    int counter;
    private SimpleCounter() {
    }

    static SimpleCounter getInstance(){
        return INSTANCE;
    }
}