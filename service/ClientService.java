package tp06.service;

import tp06.entities.Client;

import java.util.List;

public interface ClientService {
    public void addClient(Client clients);
    public void deleteClientBy(long id);
    public List<Client> getAllClients();
    public void updateClient(Client client);
    public List<Client> searchClientByQuery(String query);
}
