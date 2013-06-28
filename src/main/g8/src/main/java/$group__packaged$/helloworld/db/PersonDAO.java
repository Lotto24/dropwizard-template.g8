package org.example.helloworld.db;

import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.example.helloworld.core.Person;
import com.google.common.base.Optional;
import org.hibernate.SessionFactory;

import java.util.List;

public class PersonDAO extends AbstractDAO<Person> {
    public PersonDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Person> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Person create(Person person) {
        return persist(person);
    }

    public List<Person> findAll() {
        return list(namedQuery("org.example.helloworld.core.Person.findAll"));
    }
}
