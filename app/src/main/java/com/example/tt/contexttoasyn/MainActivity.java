package com.example.tt.contexttoasyn;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ContextToAsyn(this).execute("Hellooooooooooooooo");
    }

   private class ContextToAsyn extends AsyncTask<String, Void,String>{
        Activity a;

      public ContextToAsyn(Activity a) {
          this.a = a;

       }
       @Override
       protected String doInBackground(String... params) {

           return params[0];
       }

       @Override
       protected void onPostExecute(String s) {
           TextView tx = new TextView(a);
           tx.setText(s);
         RelativeLayout r =(RelativeLayout) a.findViewById(R.id.cotainer);
           r.addView(tx);
       }
   }
}
