package tp06.dao.impl;


import tp06.dao.ClientDAO;
import tp06.entities.Client;
import tp06.exception.NullObjectException;
import tp06.util.ConnectionManagerDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public List<Client> searchClientByQuery(String query) {
        List<Client> clients = new ArrayList<>();
        String searchQuery = "SELECT * FROM client WHERE nom LIKE ? OR prenom LIKE ? OR email LIKE ? OR adresse LIKE ?";

        try (Connection connection = ConnectionManagerDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(searchQuery)) {

            String param = "%" + query + "%";

            statement.setString(1, param);
            statement.setString(2, param);
            statement.setString(3, param);
            statement.setString(4, param);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    long ID_client = resultSet.getLong("ID_client");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String email = resultSet.getString("email");
                    String adresse = resultSet.getString("adresse");

                    Client client = new Client(ID_client, nom, prenom, email, adresse);
                    clients.add(client);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error searching clients: " + e.getMessage());
        }

        return clients;
    }

    @Override
    public void save(Client client) {
        if(client == null)
            throw new NullObjectException("save","client");
        String query = "INSERT INTO client (Nom, Prenom, Email, Adresse) VALUES (?, ?, ?, ?)";

        try(Connection connection = ConnectionManagerDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1,client.getNom());
            statement.setString(2,client.getPrenom());
            statement.setString(3,client.getEmail());
            statement.setString(4,client.getAdresse());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving client: " + e.getMessage());
        }
    }

    @Override
    public void removeById(Long id) {
        String query = "DELETE FROM client WHERE ID_Client=?";

        try(Connection connection = ConnectionManagerDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setLong(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting client: " + e.getMessage());
        }
    }

    @Override
    public List<Client> getAll() {
        String query = "SELECT * FROM client";
        List<Client> clients = new ArrayList<>();
        try(Connection connection = ConnectionManagerDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                long id_client = Long.parseLong(resultSet.getString(1));
                String nom = resultSet.getString(2);
                String prenom = resultSet.getString(3);
                String email = resultSet.getString(4);
                String adresse = resultSet.getString(5);

                Client client = new Client(id_client,nom, prenom, email,adresse);

                clients.add(client);
            }

        }catch (SQLException e){
            throw new RuntimeException("Error get all clients : " + e.getMessage());
        }
        return clients;
    }


    @Override
    public void update(Client client) {
        String query = "UPDATE clients SET nom = ?, prenom = ?, email = ?, adresse = ? WHERE ID_client = ?";

        try (Connection connection = ConnectionManagerDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getAdresse());
            statement.setLong(5, client.getID_client());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating client: " + e.getMessage());
        }
    }
}
