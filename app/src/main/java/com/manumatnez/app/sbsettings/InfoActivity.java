package com.manumatnez.app.sbsettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.manumatnez.app.sbsettings.settings.Adapter;
import com.manumatnez.app.sbsettings.settings.BaseSetting;
import com.manumatnez.app.sbsettings.settings.HeaderSetting;
import com.manumatnez.app.sbsettings.settings.IconSetting;
import com.manumatnez.app.sbsettings.settings.TextSetting;

import java.util.ArrayList;

import static com.manumatnez.app.sbsettings.BuildConfig.VERSION_NAME;

public class InfoActivity extends AppCompatActivity {

    private ArrayList<BaseSetting> infoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        infoList = new ArrayList<>();

        infoList.add(0, new HeaderSetting(getString(R.string.info_title)));

        Adapter adapter = new Adapter(this, infoList, new Adapter.ChangeListener() {
            @Override
            public void onChange() {
            }
        });

        TextSetting app_name = new TextSetting(getString(R.string.app_name),null);
        IconSetting version = new IconSetting(getDrawable((R.drawable.android)), getString(R.string.info_version), VERSION_NAME,null);
        IconSetting mod = new IconSetting(getDrawable((R.drawable.manumatnez)), getString(R.string.info_author), getString(R.string.info_author_name),null);
        IconSetting author = new IconSetting(getDrawable((R.drawable.blank)), getString(R.string.info_original_author), getString(R.string.info_original_author_name),null);

        infoList.add(app_name);
        infoList.add(version);
        infoList.add(mod);
        infoList.add(author);

        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.setPadding((int) getResources().getDimension(R.dimen.padding_round_small), 0, (int) getResources().getDimension(R.dimen.padding_round_small), (int) getResources().getDimension(R.dimen.padding_round_large));
        recyclerView.setClipToPadding(false);

        setContentView(recyclerView);
    }
}
