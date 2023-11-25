package tp06.service.impl;

import tp06.dao.ClientDAO;
import tp06.entities.Client;
import tp06.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public void addClient(Client client) {
        clientDAO.save(client);
    }

    @Override
    public void deleteClientBy(long id) {
        clientDAO.removeById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDAO.getAll();
    }

    @Override
    public void updateClient(Client client) {
        clientDAO.update(client);
    }

    @Override
    public List<Client> searchClientByQuery(String query) {
        return clientDAO.searchClientByQuery(query);
    }
}
