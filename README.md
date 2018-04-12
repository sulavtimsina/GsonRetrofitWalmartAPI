# GsonRetrofitWalmartAPI

This project will take a JSON response from a Walmart API, read it and convert it into POJO(Normal Java Object) using GSON.

The JSON string is the reponse I got when calling a Walmart API. It has many objects but my Product model only has 2 fields which I want to display in my text view.
This is the simplest possible demo of Gson and Retrofit2 library.

Make sure to add the gson dependency in build.gradle file for the app.
    
    compile group: 'com.google.code.gson', name: 'gson', version: '2.8.2'
    compile 'com.squareup.retrofit2:retrofit:2.4.0'
    compile 'com.squareup.retrofit2:converter-gson:2.4.0'


At the time when you are viewing it, the gson version may have changed, so make sure you enter the recent version.
