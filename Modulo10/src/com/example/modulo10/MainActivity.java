package com.example.modulo10;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button passwordButton = (Button) findViewById(R.id.passwordButton);
	        passwordButton.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					String passwordText = ((EditText)findViewById(R.id.passwordText)).getText().toString();
					if(passwordText.compareTo("abc123") == 0){
						Intent intent = new Intent();
						intent.setAction("com.example.modulo10.SecondActivity");
						startActivity(intent);
					}else{
						TextView message = (TextView)findViewById(R.id.message);
						message.setText(R.string.passwordError);					
					}
				}
	        	
	        }
        );
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
