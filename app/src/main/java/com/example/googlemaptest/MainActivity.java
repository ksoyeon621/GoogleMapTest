package com.example.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap googleMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map/*설정해둔 아이디*/);
        mapFragment.getMapAsync(this);
    }

    public static final int ITEM_SATELLITE=1;
    public static final int ITEM_NORMAL=2;
    public static final int SCHOOL=3;
    public static final int KangNam_Station=4;
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,ITEM_SATELLITE,0,"위성 지도");
        menu.add(0,ITEM_NORMAL,0,"일반 지도");
        SubMenu hotMenu=menu.addSubMenu("HOT PLACE");
        hotMenu.add(0,SCHOOL,0,"미림여자정보과학고등학교");
        hotMenu.add(0,KangNam_Station,0,"강남역");
//      menu.add(0,HOT_PLACE,0,"미림여자정보과학고등학교");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case ITEM_SATELLITE: googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case ITEM_NORMAL: googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case SCHOOL:  googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4663282,126.9307139),17));
                return true;
            case KangNam_Station:  googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.498078,127.027610),17));
                return true;
        }
        return false;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
      this.googleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE/*위성지도*/);
        //위치 바꾸기
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(27.4681796,126.9432436),17));
        //줌인, 줌아웃 버튼 생성
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }
}
