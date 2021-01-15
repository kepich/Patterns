package Source.Structure.Actions.Mutate.RandomGenerators;

public interface IRandomGenerator extends Cloneable {
    float getRandomFloat();

    IRandomGenerator cloneObj();
}
