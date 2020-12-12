package Source.Structure.Actions.Mutate.RandomGenerators.GaussianRandom;

import Source.MyLogger;

import java.util.Random;

public class GaussianRandom {
    private final Random rnd = new Random();
    private final MyLogger logger;

    public GaussianRandom(){
        this.logger = new MyLogger(GaussianRandom.class.getName());
        this.logger.info("Created " + this.toString());
    }

    public float getGaussianRandomFloat(){
        float res = rnd.nextFloat();
        logger.info("Get Gaussian Random");
        return res;
    }
}
