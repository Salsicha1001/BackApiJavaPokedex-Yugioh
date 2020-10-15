package com.training.demo.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.training.demo.Firebase.FireInit;
import com.training.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class CustomUserDetaisService  implements UserDetailsService {

    @Autowired
    private FireInit dbFire;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User login = new User();
        CollectionReference users = dbFire.getdb().collection("users");
        Query query = users.whereEqualTo("email", s);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        try {
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                login = document.toObject(User.class);
                login.setUid(document.getId());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new org.springframework.security.core.userdetails.User(login.getEmail(), login.getPassword(),new ArrayList<>());
    }


}

