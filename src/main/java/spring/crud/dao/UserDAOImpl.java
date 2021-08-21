package spring.crud.dao;

import org.springframework.stereotype.Repository;
import spring.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> readAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void createUser(User user) {
            entityManager.persist(user);
//        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        entityManager.remove(readUser(userId));
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User readUser(Integer userId) {
        return entityManager.find(User.class, userId);
    }
}
