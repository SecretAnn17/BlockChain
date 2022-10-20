class Singleton {
    private final static Singleton INSTANCE = new Singleton();
    int counter;
    private Singleton() {
    }

    static Singleton getInstance(){
        return INSTANCE;
    }
}