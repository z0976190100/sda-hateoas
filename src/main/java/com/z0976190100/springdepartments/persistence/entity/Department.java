package com.z0976190100.springdepartments.persistence.entity;

import javax.persistence.*;

// TODO: lombok
// TODO: finals- are necessary?
// TODO: configure table, column properties and etc.

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;

    // only for the sake of JPA, so its protected
    protected Department() {
    }

    public Department(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (!getId().equals(that.getId())) return false;
        if (!getTitle().equals(that.getTitle())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTitle().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "Department [id=%d, title='%s']",
                id, title);
    }
}
