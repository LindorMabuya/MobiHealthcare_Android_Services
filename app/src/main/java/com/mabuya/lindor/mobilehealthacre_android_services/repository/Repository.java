package com.mabuya.lindor.mobilehealthacre_android_services.repository;

import java.util.Set;

/**
 * Created by 213036223 on 4/22/2016.
 */
public interface Repository<E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}