package za.ac.cput.repository;

import za.ac.cput.domain.Client;

import java.util.HashSet;
import java.util.Set;

public class ClientRepository implements iClientRepository {
    private static ClientRepository repository = null;
    private Set<Client> clientDB = null;

    private ClientRepository(){
        clientDB = new HashSet<Client>();
    }

    public static ClientRepository getRepository(){
        if (repository == null) {
            repository = new ClientRepository();
        }
        return repository;
    }
    @Override
    public Client create(Client client) {
        boolean success = clientDB.add(client);
        if(!success)
            return null;
        return client;
    }

    @Override
    public Client read(String clientID) {
        Client client = clientDB.stream()
                .filter(c -> c.getClientID().equals(clientID))
                .findAny()
                .orElse(null);
        return client;
    }

    @Override
    public Client update(Client client) {
        Client oldClient = read(client.getClientID());
        if( oldClient != null){
            clientDB.remove(oldClient);
            clientDB.add(client);
            return client;
        }
        return null;
    }

    @Override
    public boolean delete(String clientID) {
        Client clientToDelete = read(clientID);
         if(clientToDelete == null)
             return false;
         clientDB.remove(clientToDelete);
        return true;
    }

    @Override
    public Set<Client> getAll() {
        return clientDB;
    }
}
