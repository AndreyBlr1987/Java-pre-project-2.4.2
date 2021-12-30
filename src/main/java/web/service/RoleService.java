package web.service;

import web.Model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleByName(String name);

    HashSet<Role> getSetOfRoles(String[] roleNames);

    void add(Role role);

    void edit(Role role);

    Role getById(int id);
}
