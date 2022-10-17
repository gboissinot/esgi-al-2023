package fr.esgi.al.tps.classe2.tp12;

import java.util.ArrayList;
import java.util.List;

final class History {

    private final List<Status> history;

    private History(List<Status> history) {
        this.history = history;
    }

    public static History create(Status initialStatus) {
        final ArrayList<Status> list = new ArrayList<>();
        list.add(initialStatus);
        return new History(list);
    }

    public History addStatus(Status status) {
        List<Status> statusList = new ArrayList<>(history);
        statusList.add(status);
        return new History(statusList);
    }

    @Override
    public String toString() {
        return "History{" +
                "history=" + history +
                '}';
    }
}
