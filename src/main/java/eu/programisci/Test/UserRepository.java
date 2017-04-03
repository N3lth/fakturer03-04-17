package eu.programisci.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRepository {

    private static long sequence = 1L;
    private static List<UserDTO> users = new ArrayList<>();

    public static void initializeSequence() {
        for (UserDTO u : users) {
            if (u.getId() > sequence) {
                sequence = u.getId();
            }
        }
    }

    public static List<UserDTO> save(List<UserDTO> users) {
        for (UserDTO u : users) {
            save(u);
        }
        return users;
    }

    public static UserDTO save(UserDTO user) {
        if (user.getId() == null) {
            return create(user);
        } else {
            return update(user);
        }
    }

    private static UserDTO create(UserDTO user) {
        user.setId(sequence++);
        user.setCreationDate(new Date());
        users.add(user);
        return user;
    }

    private static UserDTO update(UserDTO user) {
        for (UserDTO u : users) {
            if (u.getId().equals(user.getId())) {
                u.setName(user.getName());
                u.setLastname(user.getLastname());
                u.setLogin(user.getLogin());
                u.setPassword(user.getPassword());
                u.setEmail(user.getEmail());
                return u;
            }
        }
        return null;
    }

    public static UserDTO findOne(Long id) {
        for (UserDTO u : users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public static List<UserDTO> findAll() {
        return users;
    }

    public static void deleteOne(Long id) {
        for (UserDTO u : users) {
            if (u.getId().equals(id)) {
                System.out.println("Usuwam tego uzytkownika o imieniu: "+u.getName());
                users.remove(u);
                System.out.println("Pomyslnie usunieto uzytkownika o id "+id);
                return;
            }
        }
    }

    public static void deleteAll() {
        users = new ArrayList<>();
    }
}
