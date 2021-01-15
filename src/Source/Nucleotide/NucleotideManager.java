package Source.Nucleotide;

import Source.MyLogger;
import Source.MyLoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class NucleotideManager {
    private Map<NucleotideEnum, Nucleotide> sharedNucleotides = new HashMap<>();
    private static MyLogger logger = MyLoggerFactory.getLogger(NucleotideManager.class.getName());

    static NucleotideManager instance = null;

    private NucleotideManager(){
        logger.info("(POOL)Create NucleotideManager");
    }

    public Nucleotide getNucleotide(NucleotideEnum type){
        Nucleotide res;
        if(sharedNucleotides.containsKey(type)){
            res = sharedNucleotides.get(type);
            logger.info("(POOL) Get Nucleotide with type " + type.name());
        } else {
            res = new Nucleotide(type);
            sharedNucleotides.put(type, res);
            logger.info("(POOL) Create and Get Nucleotide with type " + type.name());
        }

        return res;
    }

    public static NucleotideManager instance(){
        if (instance == null){
            logger.info("(SINGLETON) Create and get NucleotideManager");
            instance = new NucleotideManager();
        } else {
            logger.info("(SINGLETON) Get NucleotideManager");
        }

        return instance;
    }
}
