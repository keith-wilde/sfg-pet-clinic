package kw.springframework.sfgpetclinic.model;

/**
 * Created by keith on 10/21/18.
 */
public class Specialty extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
