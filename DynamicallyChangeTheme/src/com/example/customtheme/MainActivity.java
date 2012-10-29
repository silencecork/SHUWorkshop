package com.example.customtheme;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        final int theme = pref.getInt("theme", 0);
        
        setTheme((theme == 0) ? R.style.AppTheme : android.R.style.Theme);
        setContentView(R.layout.activity_main);
        
        Button button = (Button) findViewById(R.id.button1);
        if (button != null) {
        	button.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Editor edit = pref.edit();
					edit.putInt("theme", (theme == 0) ? 1 : 0);
					edit.commit();
					finish();
					startActivity(new Intent(MainActivity.this, MainActivity.class));
				}
			});
        }
    }

    
}
