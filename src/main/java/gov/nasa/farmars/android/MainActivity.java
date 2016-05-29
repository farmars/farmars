package gov.nasa.farmars.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gov.nasa.farmars.R;
import gov.nasa.farmars.server.send.SendToServer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mLight, mHumidity, mAir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mAir = (Button) findViewById(R.id.air);
        mHumidity = (Button) findViewById(R.id.humidity);
        mLight = (Button) findViewById(R.id.light);
        mAir.setOnClickListener(this);
        mHumidity.setOnClickListener(this);
        mLight.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        SendToServer mSendToServer = new SendToServer();
        switch (v.getId()) {

            case R.id.air:
                mSendToServer.turnAir(true);
                break;
            case R.id.humidity:
                mSendToServer.turnHumidity(true);
                break;
            case R.id.light:
                mSendToServer.turnLamp(true);
                break;
        }


    }
}
