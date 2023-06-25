package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseEntity {
    private long Id;
    private String CreationDate;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        CreationDate = formattedDateTime;
    }

    public void setCreationDate(String creationDate) {
        this.CreationDate = creationDate;
    }
}
