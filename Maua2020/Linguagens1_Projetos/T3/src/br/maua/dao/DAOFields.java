package br.maua.dao;

/**
 * Interface de preparo dos comandos de Java para SQL
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 28/09/2020
 */
public interface DAOFields {
    String getTableName();
    String getInsertString(String table);
    String getSelectAllString(String table);
}
