public class Singleton {
    /**
     *
     * 单例设计模式
     */
    private Singleton(){};

    public Singleton getInstance(){
        return new Singleton();
    }
}
