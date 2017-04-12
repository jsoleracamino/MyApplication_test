package jsolerac.cmu.edu.myapplication;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        for (String st:MainActivity.listOfApps){
            String msg=intent.getStringExtra(st);
            System.out.println(st);
            TextView tv=new TextView(this);
            tv.setText(st+":"+msg);
            ((LinearLayout)findViewById(R.id.lauyout2)).addView(tv);
        }
    }
}
