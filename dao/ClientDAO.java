package tp06.dao;
import tp06.entities.Client;

import java.util.List;

public interface ClientDAO extends DAO<Client, Long>{
    List<Client> searchClientByQuery(String query);
}
