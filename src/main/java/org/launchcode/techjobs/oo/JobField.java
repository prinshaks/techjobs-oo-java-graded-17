package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobField(String value) {
        this();
        this.value = value;

    }
    public JobField() {
        id = nextId;
        nextId++;
    }


    public int getId() {
        return id;
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobfield = (JobField) o;
        return getId() == jobfield.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
