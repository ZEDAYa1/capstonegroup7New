package za.ac.cput.repository;

import za.ac.cput.domain.Client;

import java.util.Set;

public interface IClientRepository extends iRepository<Client, String> {
    public  Set<Client> getAll();
}
