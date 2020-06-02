package itc.walmart.poc.kafkaclient.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Table("user_table")
public class User implements Serializable {

    @Column("id")
    private String id;

    @PrimaryKeyColumn(name = "name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Column("name")
    private  String name;

    @Column("created_time")
    private Date createdTime = new Date();

    public User() {
    }

    public User(String id, String name, Date createdTime) {
        this.id = id;
        this.name = name;
        this.createdTime = createdTime;
    }

//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
