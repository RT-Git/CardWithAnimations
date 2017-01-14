package com.wordpress.obliviouscode.cardwithanimations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String leftHead[]={"Questions Attempted","Correct Questions","Incorrect Questions"};
    String rightHead[]={"101/120","97","4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.lv);
        ArrayList<Item> realList = new ArrayList<Item>();
        realList.add(new Item("Questions Attempted","101/123"));
        realList.add(new Item("Correct Questions","97"));
        realList.add(new Item("Incorrect Questions","4"));
        CustomList customList = new CustomList(this,R.layout.list_item,realList);
        listView.setAdapter(customList);
        TextView t = (TextView) findViewById(R.id.rank);
        startCountAnimation(0, 9, 900, t);
    }

    private void startCountAnimation(int Start, int Stop, int Time, final TextView textView) {
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(Start, Stop);
        animator.setDuration(Time);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText("" + (int) animation.getAnimatedValue());

            }

        });

        animator.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();
                ((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(300);
                // done
            }
        });
        animator.start();
    }
}
