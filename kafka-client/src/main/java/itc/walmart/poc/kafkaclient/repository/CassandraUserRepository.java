package itc.walmart.poc.kafkaclient.repository;

import itc.walmart.poc.kafkaclient.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassandraUserRepository extends CassandraRepository<User, String> {

}
