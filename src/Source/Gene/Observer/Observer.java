package Source.Gene.Observer;

import Source.MyLogger;

public abstract class Observer {
    protected int counter = 0;
    protected MyLogger logger;

    public Observer(MyLogger logger){
        this.logger = logger;
    }

    public abstract void update();

    public int getCounter() {
        return counter;
    }
}
