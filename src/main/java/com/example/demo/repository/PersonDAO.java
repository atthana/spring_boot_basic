package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Person;

public interface PersonDAO {
    void save(Person person);
    void delete(Integer id);  // เราจะมาออกแบบ interface ก่อนนะ เหมือนสร้าง abstract class > แล้วค่อยไป implement โดยการ override method ที่อยู่ใน interface นี้
    Person get(Integer id);  // ผมเราจะได้ object Person กลับมานะ เลยไม่ใช้ void แล้ว (Retrieve)
    List<Person> getAll();  // get all ไม่ต้องนับ id นะ เพราะเอาทั้งหมดเลยไง
    void update(Person person);
}
