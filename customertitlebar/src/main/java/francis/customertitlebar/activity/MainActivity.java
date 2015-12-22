package francis.customertitlebar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import francis.customertitlebar.R;
import francis.customertitlebar.view.CustomerTitleBar;

public class MainActivity extends AppCompatActivity {

    private CustomerTitleBar customerTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        customerTitleBar = (CustomerTitleBar) findViewById(R.id.topbar);
        customerTitleBar.setOnCustomerTitleBarClickListener(new CustomerTitleBar.customerTitleBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(getApplicationContext(),"leftButton clicked",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(getApplicationContext(),"rightButton clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
