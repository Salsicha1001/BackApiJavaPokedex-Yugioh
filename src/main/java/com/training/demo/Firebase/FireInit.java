package com.training.demo.Firebase;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.io.InputStream;



@Service
public class FireInit {

    @PostConstruct
    public void Initalize() throws IOException {
        InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream("./static/bancoFirebase.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("##################################")
                .build();

        FirebaseApp.initializeApp(options);


    }

    public Firestore getdb(){
        return FirestoreClient.getFirestore();
    }



}
