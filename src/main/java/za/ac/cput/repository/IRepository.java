package za.ac.cput.repository;

@Deprecated
public interface IRepository<T,ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
