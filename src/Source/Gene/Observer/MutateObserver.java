package Source.Gene.Observer;

import Source.MyLoggerFactory;

public class MutateObserver extends Observer {
    public MutateObserver() {
        super(MyLoggerFactory.getLogger(MutateObserver.class.getName()));
        this.logger.info("(OBSERVER) MutateObserver created");
    }

    @Override
    public void update() {
        this.logger.info("(OBSERVER) Update");
        this.counter += 1;
    }
}
