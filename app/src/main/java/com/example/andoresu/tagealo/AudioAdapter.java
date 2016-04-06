package com.example.andoresu.tagealo;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;


public class AudioAdapter extends BaseAdapter{

    private static final String TAG = "AS_ListView";
    private Context context;
    private String[] values;
    private AudioRecording audioRecord;

    public AudioAdapter(Context context, String[] values, AudioRecording audioRecord){
        this.context = context;
        this.values = values;
        this.audioRecord = audioRecord;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String s = values[position];
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.audio_row, null);
        }
        final TextView audioName = (TextView) convertView.findViewById(R.id.audioNameLs);
        ImageButton playBtn = (ImageButton) convertView.findViewById(R.id.playBtnLs);
        playBtn.setFocusableInTouchMode(false);
        playBtn.setFocusable(false);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String audio = audioName.getText().toString();
                Log.d("AUDIO_NAME", audio);
                audioRecord.playAudio(audio);
            }
        });
        ImageButton pauseBtn = (ImageButton) convertView.findViewById(R.id.pauseBtnLs);
        pauseBtn.setFocusableInTouchMode(false);
        pauseBtn.setFocusable(false);
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioRecord.stopAudio();
            }
        });

        audioName.setText(s);
        convertView.setTag(s);
        return convertView;
    }
}
