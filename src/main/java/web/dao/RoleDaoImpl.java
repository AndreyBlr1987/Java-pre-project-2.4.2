package web.dao;

import org.springframework.stereotype.Repository;
import web.Model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r ", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery(
                "from Role r where r.role=:name"
        ).setParameter("name", name).getSingleResult();
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(getRoleByName(role));
        }
        return (HashSet) roleSet;
    }
}
