package ru.kpfu.itis.akhmetova.model;

import javax.persistence.*;

@Entity
@Table(name = "appeal")
public class Appeal {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//cascade нужен чтобы каскадно изменять и дочерние сущности в бд
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_id")
    private Weather weather;

    public Appeal(User user, Weather weather) {
        this.user = user;
        this.weather = weather;
    }

    public Appeal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }


}
