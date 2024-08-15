package com.example.uuidphase1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface UuidRepository extends JpaRepository<UserEntity, UUID> {


}


