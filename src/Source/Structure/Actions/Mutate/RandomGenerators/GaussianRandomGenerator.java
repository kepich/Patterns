package Source.Structure.Actions.Mutate.RandomGenerators;

import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Structure.Actions.Mutate.RandomGenerators.GaussianRandom.GaussianRandom;

public class GaussianRandomGenerator implements IRandomGenerator {
    private final GaussianRandom gaussianRandom = new GaussianRandom();
    private final MyLogger logger;

    public GaussianRandomGenerator(){
        this.logger = MyLoggerFactory.getLogger(GaussianRandomGenerator.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public float getRandomFloat() {
        logger.info("Get Gaussian random (Adapter)");
        float res = gaussianRandom.getGaussianRandomFloat();
        return res;
    }

    @Override
    public GaussianRandomGenerator cloneObj() {
        logger.info("Clone GaussianRandomGenerator");
        GaussianRandomGenerator res = null;
        try {
            res = (GaussianRandomGenerator) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return res;
    }
}
