package fsociety.encenderlinterna;

import android.hardware.Camera;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.Policy;

public class Linterna extends AppCompatActivity  {

    Camera camera;
    private Button Encender;
    private boolean x;
    Camera.Parameters parameters;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_linterna);

        Encender= (Button) findViewById(R.id.buttonEncender);
        x=true;
        camera= android.hardware.Camera.open();
        Encender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (x == true) {
                        parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        Encender.setText("Apagar Linterna");
                        camera.startPreview();
                        x = false;

                    } else {

                        parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.ANTIBANDING_OFF);
                        camera.setParameters(parameters);
                        Encender.setText("Encender Linterna");
                        camera.stopPreview();
                        x = true;
                    }

                }catch (RuntimeException a){

                }
            }
        });
    }
}
