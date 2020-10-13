package com.training.demo.Controller;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.protobuf.Api;
import com.training.demo.Firebase.FireInit;
import com.training.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Document;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private FireInit dbFire;
    private boolean Authen= false;


    @PostMapping("/auth/register")
        public Object registerUser(@RequestBody User user) throws FirebaseAuthException, ExecutionException, InterruptedException {
        String email = user.getEmail();
        User login = new User();
        CollectionReference users = dbFire.getdb().collection("users");
        Query query = users.whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            login = document.toObject(User.class);
        }
        if(login.getEmail().equals(email)){
            return false;
        }else {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setDisplayName(user.getFirstName())
                    .setEmail(user.getEmail())
                    .setPassword(user.getPassword())
                    .setEmailVerified(false);

            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            ApiFuture<DocumentReference> addDocUser = dbFire.getdb().collection("users").add(user);
    return user;
        }
    }

        @PostMapping(value = "/auth/login")
        public Object LoginUser(@RequestBody User user) throws ExecutionException, InterruptedException {
            String email = user.getEmail();
             User login = new User();
            CollectionReference users = dbFire.getdb().collection("users");
            Query query = users.whereEqualTo("email", email);
            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                login = document.toObject(User.class);
                login.setUid(document.getId());
            }
            if(login.getEmail() == null){
                return false;
            }else{
                System.out.println(login);
            String pass = login.getPassword();
            String password = user.getPassword();

            if(pass.equals(password)){
                Authen = true;
                return login;
            }else {
                return false;
            }
            }

        }
        @GetMapping(value = "/auth/authenticated")
        public boolean Authenticated(){
            return Authen;
        }

        @GetMapping(value = "/auth/getuser")
        public Object GetUser(@RequestBody User uid) throws ExecutionException, InterruptedException {
            DocumentReference documentReference = dbFire.getdb().collection("users").document(uid.getUid());
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot document = future.get();
            User users = new User();
            users = document.toObject(User.class);
            return users;
        }


}
