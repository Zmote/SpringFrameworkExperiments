package ch.zmotions.domain;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaPersistableEntityInformation;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@FilterDef(name="ageFilter", parameters = @ParamDef(name="ageParam", type="integer"))
@Filter(name="ageFilter", condition = "alter >= :ageParam")
@Table(name = "Users")
public class UserEO{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;

    @Column
    private String vorname;

    @Column
    private String nachname;

    @Column
    private Integer alter;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = RoleEO.class)
    @JoinColumn(name = "id")
    private RoleEO role;

    public UserEO() {
        this.vorname = "Muster";
        this.nachname ="Meier";
        this.alter = 20;
    }

    public UserEO(String vorname, String nachname, Integer alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    public Long getPk() {
        return pk;
    }

    public RoleEO getRole() {
        return role;
    }

    public void setRole(RoleEO role) {
        this.role = role;
    }
}
