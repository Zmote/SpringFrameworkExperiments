package ch.zmotions.domain;


import javax.persistence.*;

@Entity
@Table(name="Roles")
public class RoleEO {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer code;

    @Column
    private Boolean enabled;

    public RoleEO() {
    }

    public RoleEO(String name, Integer code, Boolean enabled) {
        this.name = name;
        this.code = code;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
