package com.example.chegyujielong.repository;

import com.example.chegyujielong.dao.Idiom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IdiomRepository extends CrudRepository<Idiom,Integer> {
    List<Idiom> findByWord(String word);
    List<Idiom> findByFirstCharacterPinyin(String word);
     Idiom findById(int id);

    long count();
}
