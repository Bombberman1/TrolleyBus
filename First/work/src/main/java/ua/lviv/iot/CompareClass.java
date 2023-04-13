package ua.lviv.iot;

import java.io.Serializable;
import java.util.Comparator;

public final class CompareClass implements
        Comparator<AbstractTransport>, Serializable {
    @Override
    public int compare(final AbstractTransport object1,
                       final AbstractTransport object2) {
        if (object1 instanceof Bus && !(object2 instanceof Bus)) {
            return -1;
        } else if (object1 instanceof TrolleyBus && !(object2 instanceof Bus)
                && !(object2 instanceof TrolleyBus)) {
            return -1;
        } else if (object1 instanceof Car && !(object2 instanceof Bus)
                && !(object2 instanceof TrolleyBus)
                && !(object2 instanceof Car)) {
            return -1;
        } else {
            return 0;
        }
    }
}
