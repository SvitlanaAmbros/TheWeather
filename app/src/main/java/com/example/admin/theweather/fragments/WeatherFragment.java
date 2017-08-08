package com.example.admin.theweather.fragments;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EdgeEffect;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.theweather.App;
import com.example.admin.theweather.Forecast;
import com.example.admin.theweather.ListCreator;
import com.example.admin.theweather.R;
import com.example.admin.theweather.adapters.CityAdapter;
import com.example.admin.theweather.listeners.FindConnectionListener;
import com.example.admin.theweather.receivers.NetworkReceiver;

import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;

/**
 * Created by Admin on 04.08.2017.
 */

public class WeatherFragment extends Fragment implements AdapterView.OnItemClickListener{
    private CityAdapter cityAdapter;

    @BindView(R.id.city_list)
    ListView cityList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_fragment, null);
        ButterKnife.bind(this, view);

        cityAdapter = new CityAdapter(getActivity(), new ListCreator().createCityList());

        cityList.setAdapter(cityAdapter);
        cityList.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getContext(), Forecast.class);
        startActivity(intent);
    }
}
