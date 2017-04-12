package jsolerac.cmu.edu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //proxy list of apps
    public static String[] listOfApps={"facebook", "whatsapp", "messenger", "snapchat"};
    Switch[] listOfSwitches=new Switch[listOfApps.length];
    HashMap<String, Integer> stateOfSwitches=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i=0;
        for (String s:listOfApps){
            Switch sw=new Switch(this);
            sw.setText(s);
            sw.setId(i+1);
            System.out.println();
            listOfSwitches[i++]=sw;
            ((LinearLayout)findViewById(R.id.listOfApps)).addView(sw);
        }
        Button done=new Button(this);
        done.setText("Done");
        done.setOnClickListener(new View.OnClickListener(){
            public void onClick(View viewParam) {
                int i=0;
                for (Switch sw:listOfSwitches){
                    stateOfSwitches.put(sw.getText().toString(),(sw.isChecked()?1:0));
                }
                submit();
            }
        });
        ((LinearLayout)findViewById(R.id.listOfApps)).addView(done);
    }
    public void submit() {
        Intent intent = new Intent(this, Main2Activity.class);
        for (String s : stateOfSwitches.keySet()) {
            String key=s + ": " + stateOfSwitches.get(s);
            System.out.println(key);
            intent.putExtra(s, stateOfSwitches.get(s).toString());
        }
        startActivity(intent);
    }
}
