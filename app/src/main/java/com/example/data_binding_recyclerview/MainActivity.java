package com.example.data_binding_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.data_binding_recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        populateData();
    }

    private void populateData() {
        List<DataModel> dataModelList = new ArrayList<>();

        dataModelList.add(new DataModel("Android Oreo", "8.1"));
        dataModelList.add(new DataModel("Android Pie", "9.0"));
        dataModelList.add(new DataModel("Android Nougat", "7.0"));
        dataModelList.add(new DataModel("Android Marshmallow", "6.0"));
        dataModelList.add(new DataModel("Android Oreo", "8.1"));
        dataModelList.add(new DataModel("Android Pie", "9.0"));
        dataModelList.add(new DataModel("Android Nougat", "7.0"));
        dataModelList.add(new DataModel("Android Marshmallow", "6.0"));
        dataModelList.add(new DataModel("Android Oreo", "8.1"));
        dataModelList.add(new DataModel("Android Pie", "9.0"));
        dataModelList.add(new DataModel("Android Nougat", "7.0"));
        dataModelList.add(new DataModel("Android Marshmallow", "6.0"));

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataModelList, this);
        binding.setMyAdapter(myRecyclerViewAdapter);
    }
}