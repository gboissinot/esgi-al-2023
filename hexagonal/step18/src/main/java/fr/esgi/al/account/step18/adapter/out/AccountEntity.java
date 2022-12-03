package fr.esgi.al.account.step18.adapter.out;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "T_ACCOUNT")
public final class AccountEntity {

    @Id
    private String id;

    @ElementCollection
    private List<EventEntity> recordedEvents;

    public AccountEntity() {
    }

    public AccountEntity(String id, List<EventEntity> recordedEvents) {
        this.id = id;
        this.recordedEvents = recordedEvents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<EventEntity> getRecordedEvents() {
        return recordedEvents;
    }

    public void setRecordedEvents(List<EventEntity> recordedEvents) {
        this.recordedEvents = recordedEvents;
    }
}
