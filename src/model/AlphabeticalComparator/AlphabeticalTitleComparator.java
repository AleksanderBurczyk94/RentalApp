package model.AlphabeticalComparator;

import model.Publication;

import java.util.Comparator;

    // TODO czemu to jest w packagu model, jeśli to nie ma nic wspólnego z modelem?
public class AlphabeticalTitleComparator implements Comparator<Publication> {
    // TODO linie xd

    @Override
    public int compare(Publication p1, Publication p2) {
        // TODO klamry przy ifach, elsach itd, jest to hiper nieczytelne jak dla mnie
        if (p1 == null && p2 == null)
            return 0;
        else if (p1 == null)
            return 1;
        else if (p2 == null)
            return -1;
        return p1.getTitle().compareToIgnoreCase(p2.getTitle());
    }
}
