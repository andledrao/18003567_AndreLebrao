package br.maua.dao;

import java.util.List;

public interface DAO<T> {
    List<T> get(String codition);
    List<T> getAll();
    void update(T t);
    void create(T t);
    void delete(T t);
}
