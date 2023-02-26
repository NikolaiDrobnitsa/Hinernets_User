package Models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Client", schema = "dbo", catalog = "db_a94eab_juzzdba")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long age;
    private LocalDate birth_date;

    public Client(String name,Long age,LocalDate birth_date){
        this.name = name;
        this.age = age;
        this.birth_date = birth_date;
    }
    public Client(){

    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }
}
