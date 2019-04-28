package com.spring.hibernate.repository;

import java.util.List;
import java.util.Optional;

interface Dao<T> {

        Object get(int id);

        List<T> getAll();

        long save(T t);

        void update(T t);

        void delete(T t);
    }

