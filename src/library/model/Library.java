package library.model;

import library.exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Library implements Serializable {

    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Collection<Publication> getSortedPublications(Comparator<Publication> comparator) {
       List<Publication> collection = new ArrayList<>(publications.values());
       collection.sort(comparator);
       return collection;
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public Collection<LibraryUser> getSortedUsers(Comparator<LibraryUser> comparator) {
        List<LibraryUser> collection = new ArrayList<>(users.values());
        collection.sort(comparator);
        return collection;
    }

    private void increasePublicationCopies(Publication publication){
        Publication p = publications.get(publication.getTitle());
        p.setCopies(p.getCopies() + 1);
        System.out.println("The number of copies of the publication has been increased");
    }

    public void addPublication(Publication publication) {
        if (publications.containsKey(publication.getTitle())) {            
            increasePublicationCopies(publication);
        }
        publications.put(publication.getTitle(), publication);        
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
