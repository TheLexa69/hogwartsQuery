package main.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "house_points")
@NamedQuery(name = "HousePoint.maxPoints", query = "select giver, sum(points) from HousePoint group by giver order by sum(points) desc limit 1")
public class HousePoint {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giver")
    private main.entity.Person giver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver")
    private main.entity.Person receiver;

    @Column(name = "points")
    private Integer points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public main.entity.Person getGiver() {
        return giver;
    }

    public void setGiver(main.entity.Person giver) {
        this.giver = giver;
    }

    public main.entity.Person getReceiver() {
        return receiver;
    }

    public void setReceiver(main.entity.Person receiver) {
        this.receiver = receiver;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}