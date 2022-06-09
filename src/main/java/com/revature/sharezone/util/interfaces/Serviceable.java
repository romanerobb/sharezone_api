package com.revature.sharezone.util.interfaces;


import java.util.List;

public interface Serviceable<T> {

    // Create
    T create(T newObject);


    // Read
    List<T> readAll();

    T readById(String id);

    // Update
    T update(T updatedObject);

    // Delete
    boolean delete(String id);

    boolean validateInput(T object);
}

