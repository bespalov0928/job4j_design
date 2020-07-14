package ru.job4j.chapter001.generic;

import java.util.Objects;

public class Role extends Base {
    private String id;

    public Role(String id) {
        super(id);
        this.id = id;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass() || obj == null) {
            return false;
        }
        Role role = (Role) obj;
        return Objects.equals(id, ((Role) obj).id);
    }
}
