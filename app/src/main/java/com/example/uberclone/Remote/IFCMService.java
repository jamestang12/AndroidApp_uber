package com.example.uberclone.Remote;

import com.example.uberclone.Model.FCMResponse;
import com.example.uberclone.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAeiJvN1M:APA91bHyd4iBY-9QMuDVOmXsUdPIjnPtxutXck1weOIAcqDp9mBqG65bbb7qtN1kp0vSfAJ21_jh1mrHJ0I8ba35GY9uMAbKBYkf0fuKUojdLc0JvEvk1spaDFl4EyHobw33Lztp9hD5"
    })
    @POST("fcm/send")
    Call<FCMResponse> sendMessage(@Body Sender body);

}
