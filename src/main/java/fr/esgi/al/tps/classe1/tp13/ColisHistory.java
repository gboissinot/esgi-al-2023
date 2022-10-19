package fr.esgi.al.tps.classe1.tp13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//VO
final class ColisHistory {

    private final List<ColisStatus> history;

    private ColisHistory(List<ColisStatus> history) {
        this.history = history;
    }

    public static ColisHistory create(ColisStatus initialStatus) {
        final List<ColisStatus> history = new ArrayList<>();
        history.add(initialStatus);
        return new ColisHistory(history);
    }

    public ColisHistory add(ColisStatus status) {
        //history.add(status); breaks immutability

        //Following code makes the objet immutable
        List<ColisStatus> list = new ArrayList<>(history);
        list.add(status);
        return new ColisHistory(list);
    }

    public List<ColisStatus> value() {
        return Collections.unmodifiableList(history);
    }

    @Override
    public String toString() {
        return "ColisHistory{" +
                "history=" + history +
                '}';
    }
}
