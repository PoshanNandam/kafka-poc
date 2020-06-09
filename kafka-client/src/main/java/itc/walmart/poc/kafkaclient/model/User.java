package itc.walmart.poc.kafkaclient.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table("user_table")
public class User implements Serializable {

    @Column("id")
    private String id;

    @PrimaryKeyColumn(name = "name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Column("name")
    private  String name;

    @Column("created_time")
    private Date createdTime = new Date();

    public User(String id, String name, Date createdTime) {
        this.id = id;
        this.name = name;
        this.createdTime = createdTime;
    }
}
