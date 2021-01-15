package Source.Structure.Actions.Mutate.RandomGenerators;

import Source.MyLogger;
import Source.MyLoggerFactory;

import java.util.Random;

public class DefaultRandomGenerator implements IRandomGenerator {
    private Random rnd = new Random();
    private MyLogger logger;
    private boolean isReady = false;

    public DefaultRandomGenerator(){
        this.logger = MyLoggerFactory.getLogger(DefaultRandomGenerator.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public float getRandomFloat() {
        float res = rnd.nextFloat();
        logger.info("Get Default random");
        return res;
    }

    @Override
    public DefaultRandomGenerator cloneObj() {
        logger.info("Clone DefaultRandomGenerator");
        DefaultRandomGenerator res = null;
        try {
            res = (DefaultRandomGenerator) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public String toString() {
        return "DefaultRandomGenerator{" +
                "isReady=" + isReady +
                '}';
    }

    public void setStatus(boolean status){
        logger.info("Set status " + status);
        this.isReady = status;
    }
}
