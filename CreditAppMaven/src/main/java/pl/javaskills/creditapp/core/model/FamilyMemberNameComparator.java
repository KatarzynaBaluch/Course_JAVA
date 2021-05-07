package pl.javaskills.creditapp.core.model;

import java.io.Serializable;
import java.util.Comparator;

public class FamilyMemberNameComparator implements Comparator<FamilyMember>, Serializable {

    public static final long serialVersionID=1l;

    public FamilyMemberNameComparator() {
    }

    @Override
    public int compare(FamilyMember o1,FamilyMember o2) {

        return o1.getName().compareTo(o2.getName());
    }
}
