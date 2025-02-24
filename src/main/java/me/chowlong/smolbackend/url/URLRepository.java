package me.chowlong.smolbackend.url;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface URLRepository extends CrudRepository<URL, Long> {
    List<URL> findByIp_Id(String ipId);
    URL findByCustomLink(String customLink);
    Boolean existsByCustomLink(String customLink);
    Boolean existsByNameAndIp_Id(String name, String ipId);
}
