package com.mapsa.datajpademo.repo;

import com.mapsa.datajpademo.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
