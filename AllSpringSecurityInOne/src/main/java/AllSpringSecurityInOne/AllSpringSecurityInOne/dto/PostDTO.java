package AllSpringSecurityInOne.AllSpringSecurityInOne.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PostDTO {

    private int id;

    private String name;

    private String dis;

    public PostDTO() {
    }

    public PostDTO(int id, String name, String dis) {
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
