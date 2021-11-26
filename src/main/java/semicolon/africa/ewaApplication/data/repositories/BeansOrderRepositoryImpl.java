package semicolon.africa.ewaApplication.data.repositories;

import org.springframework.boot.jdbc.DatabaseDriver;
import semicolon.africa.ewaApplication.data.models.BeansOrder;

import javax.xml.crypto.Data;
import java.util.*;

public class BeansOrderRepositoryImpl implements BeansOrderRepository {
    private  static Map<Integer, BeansOrder> database = new HashMap<>();
    @Override
    public BeansOrder save(BeansOrder beansOrder) {
        Integer id = null;
        if(beansOrder.getId() == null){
            id = database.size() + 1;
            beansOrder.setId(id);
        }
        id = beansOrder.getId();
        database.put(id, beansOrder);
        return database.get(id);
    }

    @Override
    public Optional<BeansOrder> findBeansOrderById(Integer beansOrderId) {
        if(database.containsKey(beansOrderId)) return Optional.of(database.get(beansOrderId));
        return Optional.empty();
    }

    @Override
    public List<BeansOrder> findAllBeansOrders() {
        List<BeansOrder> beansOrders = new ArrayList<>();
        Set<Integer> keysInDB = database.keySet();
        for(Integer key : keysInDB){
            beansOrders.add(database.get(key));
        }
        return beansOrders;
    }

    @Override
    public void deleteBeansOrderById(Integer beansOrderId) {
        database.remove(beansOrderId);

    }

    @Override
    public void delete(BeansOrder beansOrder) {
        database.remove(beansOrder.getId());

    }

    @Override
    public void deleteAll() {
        database.clear();

    }
}
