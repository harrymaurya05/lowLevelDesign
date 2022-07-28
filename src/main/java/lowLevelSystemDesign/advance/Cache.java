package lowLevelSystemDesign.advance;


import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Cache<KEY,VALUE> {
    private final Map<KEY,VALUE> map;
    private final PersistenceAlgorithm persistenceAlgorithm;
    private final EvictionAlgorithm evictionAlgorithm;
    private static final Integer THESHOLD_SIZE = 500;
    private final DataSource<KEY,VALUE> dataSource;

    public Cache(Map<KEY, VALUE> map, PersistenceAlgorithm persistenceAlgorithm, EvictionAlgorithm evictionAlgorithm, DataSource<KEY, VALUE> dataSource) {
        this.map = map;
        this.persistenceAlgorithm = persistenceAlgorithm;
        this.evictionAlgorithm = evictionAlgorithm;
        this.dataSource = dataSource;
    }


    public Future<VALUE> get(KEY key){
        if(map.containsKey(key)){
            return CompletableFuture.completedFuture(map.get(key));
        }else {
            return dataSource.get(key);
        }
    }
    public Future<Void> set(KEY key,VALUE value){
        if (!map.containsKey(key) && map.size() < THESHOLD_SIZE) {
            if(persistenceAlgorithm.equals(PersistenceAlgorithm.LRU)){

            } else{

            }
        }
        if(evictionAlgorithm.equals(EvictionAlgorithm.RIGHT_THROUGH)){
            return dataSource.persist(key,value).thenAccept(res->
                    map.put(key,value));
        }else{
            map.put(key,value);
            dataSource.persist(key,value);
            return CompletableFuture.completedFuture(null);
        }
    }
}