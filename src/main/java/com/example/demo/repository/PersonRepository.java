package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PersonRepository implements PersonDAO { // เป็นการเอา interace PersonDAO มา implement ต่อนะ
    private EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override // จากนั้นจะต้อง override method ที่อยู่ใน interface นั้น
    @Transactional // เพื่อให้รู้ว่า db จะมีการเปลี่ยนแปลง
    public void save(Person person) {
        System.out.println("Person Saved: " + person);
        entityManager.persist(person); // save data to database จะได้ new row นะ
    }

    @Override
    @Transactional // การลบก็ส่งผลกับ data นะเลยต้องมี @Transactional ด้วย
    public void delete(Integer id) { // รับ id เข้ามานะ (เราใช้ entiryManager เป็นหลักเลยนะ)
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person); // delete data from database จะได้ remove row นะ
    }

    @Override // แต่ get ไม่ได้มีการเปลี่ยนแปลงข้อมูลใน database นะ จึงไม่ต้องมี
              // @Transactional
    public Person get(Integer id) { // รับ id เข้ามานะ (เราใช้ entiryManager เป็นหลักเลยนะ)
        return entityManager.find(Person.class, id); // จะได้ object Person กลับมานะ
    }

    @Override
    public List<Person> getAll() {
        // return entityManager.createQuery(
        // "FROM Person", Person.class).getResultList(); // จะได้ list ของ Person
        // กลับมานะ FROM Person คือคำสั่ง SQL นะ

        TypedQuery<Person> query = entityManager.createQuery("FROM Person", Person.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Person person) {
        entityManager.merge(person); // จะได้ update row นะ
    }

}
