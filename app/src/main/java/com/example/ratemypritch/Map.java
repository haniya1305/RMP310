package com.example.ratemypritch;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
//import android.support.v4.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Map extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap map;
    private ApiInterface apiInterface;
    private List<LatLng> polylinelist;
    private PolylineOptions plo;
    private LatLng org, dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        Retrofit rf = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl("http://maps.googleapis.com/")
                .build();

        apiInterface = rf.create(ApiInterface.class);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setTrafficEnabled(true);
        org = new LatLng(49.2606, 123.2460);
        dest = new LatLng(49.9394, 119.3948);
        getDirection("49.2606"+","+"123.2460","49.9394"+","+"119.3948"
        );

    }

    private void getDirection(String origin, String destination){
           apiInterface.getDirection("driving","less_driving",origin,destination, getString(R.string.api_key)
                   ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new SingleObserver<Result>() {
                       @Override
                       public void onSubscribe(Disposable d) {

                       }

                       @Override
                       public void onSuccess(Result result) {
                           polylinelist = new ArrayList<>();
                           List<Route> r1= result.getR();
                           for(Route ro : r1) {
                               String pl = ro.getOp().getPoints();
                               polylinelist.addAll(decodePoly(pl));
                           }
                           plo = new PolylineOptions();
                           plo.color(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                           plo.width(8);
                           plo.startCap(new ButtCap());
                           plo.jointType(JointType.ROUND);
                           plo.addAll(polylinelist);
                           map.addPolyline(plo);

                           LatLngBounds.Builder b = new LatLngBounds.Builder();
                           b.include(org);
                           b.include(dest);
                           map.animateCamera(CameraUpdateFactory.newLatLngBounds(b.build(), 100));
                       }

                       @Override
                       public void onError(Throwable e) {

                       }
                   });

    }

    private List<LatLng> decodePoly(String encoded){
        List<LatLng> p = new ArrayList<>();
        int idx = 0, l = encoded.length();
        int lat = 0, lng = 0;

        while(idx < l){
            int b, shift = 0, res = 0;
            do{
                b = encoded.charAt(idx++) - 63;
                res |= (b & 0x1f) <<shift;
                shift+=5;
            } while (b>=0x20);
            int dlat = ((res & 1) != 0 ? ~(res >> 1) : (res >> 1));
            lat+=dlat;

            shift = 0;
            res = 0;

            do{
                b = encoded.charAt(idx++) - 63;
                res |= (b & 0x1f) <<shift;
                shift+=5;
            } while (b>=0x20);
            int dlng = ((res & 1) != 0 ? ~(res >> 1) : (res >> 1));
            lng+=dlng;

            LatLng l1 = new LatLng((((double) lat/1E5)),
                    (((double) lng/1E5)));
            p.add(l1);
        }
        return p;

    }
}