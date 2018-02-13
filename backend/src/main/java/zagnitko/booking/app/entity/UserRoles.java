package zagnitko.booking.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * User roles entity.
 * @author zagnitko
 */
@Entity
@Table(name = "user_roles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRoles {

    public UserRoles() {
    }

    public UserRoles(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
