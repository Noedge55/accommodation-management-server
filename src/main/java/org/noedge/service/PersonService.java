package org.noedge.service;

import org.noedge.domain.Person;

import java.util.List;

public interface PersonService {
    void add(Person department);
    void remove(Integer id);
    void edit(Person department);
    Person getBasicInfoById(Integer id);
    Person getAllInfoById(Integer id);
    Person getAllInfoByLoginId(String loginId);
    List<Person> getAll();
}
