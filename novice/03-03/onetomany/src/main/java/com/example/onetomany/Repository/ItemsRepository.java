package com.example.onetomany.Repository;

import com.example.onetomany.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items,Long> {

}
