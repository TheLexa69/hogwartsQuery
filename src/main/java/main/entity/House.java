package main.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "house")
public class House {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "head_teacher", nullable = false)
    private main.entity.Person headTeacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public main.entity.Person getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(main.entity.Person headTeacher) {
        this.headTeacher = headTeacher;
    }

}