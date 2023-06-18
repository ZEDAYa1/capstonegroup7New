package za.ac.cput.service;

import java.util.Set;

public interface IService<T,ID >{
    T create(T t);
    T save (T t);
    T read (ID id);
    T update(T t);
    boolean delete(ID id);
    Set<T> findAll();

}
