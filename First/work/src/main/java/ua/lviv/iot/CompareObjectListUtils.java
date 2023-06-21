package ua.lviv.iot;

import java.io.Serializable;
import java.util.Comparator;

public final class CompareObjectListUtils implements
        Comparator<AbstractTransport>, Serializable {
    @Override
    public int compare(final AbstractTransport object1,
                       final AbstractTransport object2) {
        return object1.getClass().getName()
                .compareTo(object2.getClass().getName());
    }
}