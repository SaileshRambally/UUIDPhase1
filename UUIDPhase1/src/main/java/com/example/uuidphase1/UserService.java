package com.example.uuidphase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;



// STILL WORKING ON THIS completed
@Service
public class UserService {

    private UuidRepository uuidRepository;
    @Autowired
    public UserService(UuidRepository uuidRepository) {
        this.uuidRepository = uuidRepository;
    }

    public List<UserEntity> getAllUsers(){
        return  uuidRepository.findAll();
    }


    public UserEntity getUserById(UUID id){
        return uuidRepository.findById(id).orElse(null);
    }

    //Generating UUID randomly
    public UserEntity saveUser(UserEntity userEntity){
        userEntity.setId(UUID.randomUUID());
        return uuidRepository.save(userEntity);

    }


    public void deleteUser(UUID id){
        uuidRepository.deleteById(id);
    }
}



