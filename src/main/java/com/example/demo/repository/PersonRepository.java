package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PersonRepository implements PersonDAO {  // เป็นการเอา interace PersonDAO มา implement ต่อนะ
    private EntityManager entityManager;
    
    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override  // จากนั้นจะต้อง override method ที่อยู่ใน interface นั้น
    @Transactional  // เพื่อให้รู้ว่า db จะมีการเปลี่ยนแปลง
    public void save(Person person) {
        System.out.println("Person Saved: " + person);
        entityManager.persist(person);  // save data to database จะได้ new row นะ
    }

}
