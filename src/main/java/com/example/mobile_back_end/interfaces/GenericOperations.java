package com.example.mobile_back_end.interfaces;

import java.util.List;

public interface GenericOperations<T, N>{

    public T create(T entity);

    public T read( N id);

    public List<T> readAll();

    //PATCH
    public T updatePart(N id, T entity);

    //PUT
    public T updateAll(N id, T entity);

    public void delete(N id);
}
