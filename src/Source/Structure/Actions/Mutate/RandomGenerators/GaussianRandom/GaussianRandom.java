package Source.Structure.Actions.Mutate.RandomGenerators.GaussianRandom;

import Source.MyLogger;
import Source.MyLoggerFactory;

import java.util.Random;

public class GaussianRandom {
    private final Random rnd = new Random();
    private final MyLogger logger;

    public GaussianRandom(){
        this.logger = MyLoggerFactory.getLogger(GaussianRandom.class.getName());
        this.logger.info("Created " + this.toString());
    }

    public float getGaussianRandomFloat(){
        float res = rnd.nextFloat();
        logger.info("Get Gaussian Random");
        return res;
    }
}
