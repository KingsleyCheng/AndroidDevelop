package com.numberpickerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.numberpickerview.widget.city.EasyCityListener;
import com.numberpickerview.widget.city.EasyCityView;
import com.numberpickerview.widget.radio.EasyPickerListener;
import com.numberpickerview.widget.radio.EasyPickerView;

public class MainActivity extends AppCompatActivity implements EasyPickerListener, EasyCityListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_number).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEasyFragment();
            }
        });
        findViewById(R.id.btn_city).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEasyCityDialog();
            }
        });
        textView = (TextView) findViewById(R.id.text);
    }

    private void initEasyCityDialog() {
        new EasyCityView
                .Builder(this)
                .setCancelable(true)
                .setTitle("请选择所在城市")
                .setProvinceName("陕西省") // 默认选中省
                .setCityName("西安市") //默认选中市
                .setAreaName("雁塔区") //默认选中区
                .setDividerColor(R.color.colorPrimary)
                .setSelectTextColor(R.color.colorPrimary)
                .show(getSupportFragmentManager(), "city");
    }

    private void initEasyFragment() {
        String[] value = new String[200];
        for (int i = 0; i < value.length; i++) {
            value[i] = String.valueOf(i);
        }
        new EasyPickerView
                .Builder(this)
                .setTextArray(value)
                .setCancelable(true)
                .setTitle("请选择身高")
                .setHintText("cm")
                .setValue(150)
                .setHintTextColor(R.color.colorPrimary)
                .setDividerColor(R.color.colorPrimary)
                .setSelectTextColor(R.color.colorPrimary)
                .show(getSupportFragmentManager(), "easy");
    }

    @Override
    public void onEasyCancel() {

    }

    @Override
    public void onEasyNext(String provinceValue, String cityValue, String areaValue) {
        textView.setText(provinceValue + "   " + cityValue + "   " + areaValue);
    }

    @Override
    public void onEasyNext(String value) {
        textView.setText(value);
    }
}
