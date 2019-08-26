package org.noedge.dao;

import org.noedge.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 */
@Repository("personDao")
public interface PersonDao {
    int insert(Person person);
    int delete(Integer id);
    int update(Person person);
    Person selectBasicInfoById(Integer id);
    Person selectAllInfoById(Integer id);
    Person selectAllInfoByLoginId(String loginId);
    List<Person> selectAll();
}
