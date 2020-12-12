package Source.Structure.Actions.Mutate.RandomGenerators;

import Source.MyLogger;
import Source.Structure.Actions.Mutate.RandomGenerators.GaussianRandom.GaussianRandom;

public class GaussianRandomGeneratorAdapter implements IRandomGenerator {
    private final GaussianRandom gaussianRandom = new GaussianRandom();
    private final MyLogger logger;

    public GaussianRandomGeneratorAdapter(){
        this.logger = new MyLogger(GaussianRandomGeneratorAdapter.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public float getRandomFloat() {
        logger.info("Get Gaussian random (Adapter)");
        float res = gaussianRandom.getGaussianRandomFloat();
        return res;
    }
}
