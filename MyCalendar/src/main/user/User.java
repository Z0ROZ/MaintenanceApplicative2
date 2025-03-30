package user;

import user.primitives.Password;
import user.primitives.Username;

import java.io.Serial;
import java.io.Serializable;



public final class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Username username;
    private final Password password;

    public User(Username username, Password password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username et Password ne peuvent pas être null");
        }
        this.username = username;
        this.password = password;
    }

    public Username getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return username.getValue().equals(user.username.getValue());
    }

    @Override
    public int hashCode() {
        return username.getValue().hashCode();
    }
}