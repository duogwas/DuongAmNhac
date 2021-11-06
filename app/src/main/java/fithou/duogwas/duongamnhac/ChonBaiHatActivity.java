package fithou.duogwas.duongamnhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChonBaiHatActivity extends AppCompatActivity {
    TextView tv_idSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_bai_hat);

        tv_idSelect=findViewById(R.id.tv_idSelect);

        Intent intent=getIntent();
        int idPlayingNow = intent.getIntExtra("idPlayNow",1);
        tv_idSelect.setText(""+idPlayingNow);
    }

    public void idSongSelect(View view){
        Button btn =(Button) view;
        tv_idSelect.setText(btn.getText());
    }

    public void transferIdSongSelect(View view){
        int idSelect = Integer.parseInt(tv_idSelect.getText().toString());
        Intent intent =new Intent(this, MainActivity.class);
        intent.putExtra("idSelect",idSelect);
        startActivity(intent);
        finish();
    }
}