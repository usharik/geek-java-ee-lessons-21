package ru.geekbrains.persist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ToDoCategoryRepositoryImpl implements ToDoCategoryRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public ToDoCategory findById(long id) {
        return em.find(ToDoCategory.class, id);
    }

    public List<ToDoCategory> findAll() {
        return em.createQuery("from ToDoCategory t", ToDoCategory.class)
                .getResultList();
    }
}
