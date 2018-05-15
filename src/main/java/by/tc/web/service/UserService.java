package by.tc.web.service;

import by.tc.web.service.exception.ServiceException;

import java.util.List;

public interface UserService<T> {
    void delete(T object) throws ServiceException;

    void save(T object) throws ServiceException;

    void update(T object) throws ServiceException;

    List<T> getAllUsers() throws ServiceException;

    boolean block(int userId) throws ServiceException;

    boolean unblock(int userId) throws ServiceException;

    T readByID(int id) throws ServiceException;

    boolean confirm(int id) throws ServiceException;


}
