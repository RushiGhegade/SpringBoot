package AllSpringSecurityInOne.AllSpringSecurityInOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "postTable")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String dis;

    public PostEntity() {
    }

    public PostEntity(int id, String name, String dis) {
        this.id = id;
        this.name = name;
        this.dis = dis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }
}
