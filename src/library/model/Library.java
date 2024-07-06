package library.model;

import library.exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Library implements Serializable {

    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    private void increasePublicationCopies(Publication publication){
        Publication p = publications.get(publication.getTitle());
        p.setCopies(p.getCopies() + 1);
        System.out.println("The number of copies of the publication has been increased");
    }

    public void addPublication(Publication publication) {
        if (publications.containsKey(publication.getTitle())) {
            System.out.println("The library already has this publication");
            increasePublicationCopies(publication);
        }
        publications.put(publication.getTitle(), publication);
        System.out.println("The publication has been added to the library");
    }

    public void addUser(LibraryUser user) {
        if (users.containsKey(user.getPesel()))
            throw new UserAlreadyExistsException("User with this PESEL already exists");
        users.put(user.getPesel(), user);
    }

    public boolean removePublication(Publication publication) {
        if (publications.containsValue(publication)) {
            publications.remove(publication.getTitle());
            return true;
        }
        return false;

    }
}
