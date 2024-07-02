package library.model.comparator;

import library.model.Publication;

import java.util.Comparator;

public class DateComparator implements Comparator<Publication> {

    @Override
    public int compare(Publication o1, Publication o2) {
        if (o1 == null && o2 == null) return 0;
        else if (o1 == null) return 1;
        else if (o2 == null) return -1;
        return -Integer.compare(o1.getYear(), o2.getYear());
    }
}
