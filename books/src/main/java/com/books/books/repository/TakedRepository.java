package com.books.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.books.books.model.Taked;

public interface TakedRepository extends JpaRepository<Taked, Integer> {
    
}
