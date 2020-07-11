package ru.job4j.chapter001.exercise2;

import java.util.Objects;

public class User extends Base {
    private String id;

    protected User(String id) {
        //this.id = id;
        super(id);
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            /*и верните */
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(user.getId(), id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
