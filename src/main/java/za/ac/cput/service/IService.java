package za.ac.cput.service;

import java.util.Set;

public interface IService<T, ID>
{
    T save(T t);
    T read(ID id);
    boolean delete (ID id);
    Set<T> findAll();
    Set<T> getAll();

}
