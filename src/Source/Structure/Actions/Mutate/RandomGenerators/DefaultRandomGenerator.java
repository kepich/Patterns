package Source.Structure.Actions.Mutate.RandomGenerators;

import Source.MyLogger;

import java.util.Random;

public class DefaultRandomGenerator implements IRandomGenerator {
    private final Random rnd = new Random();
    private final MyLogger logger;

    public DefaultRandomGenerator(){
        this.logger = new MyLogger(DefaultRandomGenerator.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public float getRandomFloat() {
        float res = rnd.nextFloat();
        logger.info("Get Default random");
        return res;
    }
}
