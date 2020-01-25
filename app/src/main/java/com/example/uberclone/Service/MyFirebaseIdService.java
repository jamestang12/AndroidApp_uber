package com.example.uberclone.Service;


import androidx.annotation.NonNull;

import com.example.uberclone.Common.Common;
import com.example.uberclone.Model.Token;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseIdService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        //String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        String refreshedToken = s;
        updateTokenToServer(refreshedToken);//When refresh token, need update to Realtime database

    }

    private void updateTokenToServer(String refreshedToken){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference tokens = db.getReference(Common.token_tbl);

        Token token = new Token(refreshedToken);
        if(FirebaseAuth.getInstance().getCurrentUser() != null){  //If already login, it will update Token
            tokens.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(token);

        }
    }
}
