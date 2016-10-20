package com.chenenyu.support_2500;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import org.byteam.superadapter.SuperAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private SuperAdapter<AppInfo> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AppInfoAdapter(this, getAppInfo(), R.layout.item_app_info);
        mRecyclerView.setAdapter(mAdapter);
        // New in recyclerview-25.0.0
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, mLayoutManager.getOrientation()));

        // new in design-25.0.0
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private List<AppInfo> getAppInfo() {
        PackageManager pm = getPackageManager();
        List<PackageInfo> list = pm.getInstalledPackages(0);
        List<AppInfo> appInfos = new ArrayList<>();
        for (PackageInfo packageInfo : list) {
            AppInfo appInfo = new AppInfo();
            appInfo.label = packageInfo.applicationInfo.loadLabel(pm);
            appInfo.icon = packageInfo.applicationInfo.loadIcon(pm);
            //应用包名
            appInfo.packageName = packageInfo.applicationInfo.packageName;

            appInfos.add(appInfo);
        }
        return appInfos;
    }


}
