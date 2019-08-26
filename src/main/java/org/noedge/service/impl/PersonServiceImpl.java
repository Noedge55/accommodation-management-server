package org.noedge.service.impl;

import org.noedge.dao.PersonDao;
import org.noedge.domain.Person;
import org.noedge.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonDao personDao;


    public void add(Person person) {
        personDao.insert(person);
    }

    public void remove(Integer id) {
        personDao.delete(id);
    }

    public void edit(Person person) {
        personDao.update(person);
    }

    public Person getBasicInfoById(Integer id) {
        return personDao.selectBasicInfoById(id);
    }

    public Person getAllInfoById(Integer id) {
        return personDao.selectAllInfoById(id);
    }

    public Person getAllInfoByLoginId(String loginId) {
        return personDao.selectAllInfoByLoginId(loginId);
    }

    public List<Person> getAll() {
        return personDao.selectAll();
    }
}
