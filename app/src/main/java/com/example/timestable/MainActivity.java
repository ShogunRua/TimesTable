package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ListView ListViewNumbers;

    private ArrayList<Integer> numbers;
    private int max = 20;
    private int min = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        // метод setMax установит максимальное значение у нашего сикбара-20
        seekBar.setMax(max);
        ListViewNumbers = findViewById(R.id.ListViewNumbers);
        numbers = new ArrayList<>();
        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        ListViewNumbers.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                numbers.clear();
                if(progress < min){
                    seekBar.setProgress(min);
                }
                // теперь если наш прогресс изменился давайте заполним наш массив новыми значениями
                for (int i = min; i <= count; i++) {
                    // теперь давайте добавить значения прогресса умноженное на i в массив numbers
                    numbers.add(seekBar.getProgress() * i);
                }
                // нужно сообщить нашему адаптеру о происходящем
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}