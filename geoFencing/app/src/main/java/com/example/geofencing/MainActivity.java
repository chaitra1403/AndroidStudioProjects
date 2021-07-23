package com.example.geofencing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private GeofencingClient geofencingClient;
    @Override
    public void onCreate(Bundle savedInstanceState) {
// ...
        geofencingClient = LocationServices.getGeofencingClient(this);
    }
geofenceList.add(new Geofence.Builder()
// Set the request ID of the geofence. This is a string to identify this
// geofence.
        .setRequestId(entry.getKey())
            .setCircularRegion(
            entry.getValue().latitude,
            entry.getValue().longitude,
    Constants.GEOFENCE_RADIUS_IN_METERS
)

        .setExpirationDuration(Constants.GEOFENCE_EXPIRATION_IN_MILLISEC-
            ONDS)

.setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER |
            Geofence.GEOFENCE_TRANSITION_EXIT)
.build());
    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        builder.addGeofences(geofenceList);
        return builder.build();
    }




}