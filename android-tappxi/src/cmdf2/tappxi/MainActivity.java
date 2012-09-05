package cmdf2.tappxi;

import java.io.IOException;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import cmdf2.tappxi.api.Client;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class MainActivity extends FragmentActivity {
	Facebook facebook;
	Client client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        facebook = new Facebook(getString(R.string.facebook_app_id));
        
        final TextView helloWorld = (TextView) findViewById(R.id.helloWorld);
        helloWorld.setText( helloWorld.getText() + " - ");
        
        facebook.authorize(this, new DialogListener() {
            @Override
            public void onComplete(Bundle values) {
                client = new Client(values.getString("access_token"));
            	
                new AsyncTask<Void, Void, Void>() {
                    protected Void doInBackground(Void... params) {
                    	try {
							client.connect();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							Log.e("tappxi", "IOException", e);
						}
						return null;
                    }
                    protected void onPostExecute(Void result) {
                    	
                    }
                }.execute();
            }

            @Override
            public void onFacebookError(FacebookError error) {
            	helloWorld.setText( helloWorld.getText() + "FacebookError");
            }

            @Override
            public void onError(DialogError e) {
            	helloWorld.setText( helloWorld.getText() + "Error");
            }

            @Override
            public void onCancel() {
            	helloWorld.setText( helloWorld.getText() + "Cancel");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        facebook.authorizeCallback(requestCode, resultCode, data);
    }
}
