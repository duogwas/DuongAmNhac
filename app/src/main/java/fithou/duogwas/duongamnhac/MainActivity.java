package fithou.duogwas.duongamnhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_idPlay, tv_namePlay, tv_timePlay;
    Button btn_chonbai, btn_play, btn_pause;
    List<BaiHat> bh;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlView();
        addItemListBh();
        setOnClick();

        Intent intent = getIntent();
        int idSelect = intent.getIntExtra("idSelect", 1);
        updateSongPlay(idSelect);

    }

    private void controlView() {
        tv_idPlay = findViewById(R.id.tv_idPlay);
        tv_namePlay = findViewById(R.id.tv_namePlay);
        tv_timePlay = findViewById(R.id.tv_timePlay);
        btn_chonbai = findViewById(R.id.btn_chonbai);
        btn_play = findViewById(R.id.btn_play);
        btn_pause = findViewById(R.id.btn_pause);
    }

    private void addItemListBh() {
        bh = new ArrayList<>();
        bh.add(new BaiHat(1, R.raw.anhbietemcungbiet, "Anh biết, em cũng biết"));
        bh.add(new BaiHat(2, R.raw.breakfast, "Breakfast"));
        bh.add(new BaiHat(3, R.raw.chimotdemnuathoi, "Chỉ một đêm nữa thôi"));
        bh.add(new BaiHat(4, R.raw.luonbenanh, "Luôn bên anh"));
        bh.add(new BaiHat(5, R.raw.vangtrangkhoc, "Vầng trăng khóc"));
        bh.add(new BaiHat(6, R.raw.yoursmile, "YOUR SMILE"));
    }

    private void setOnClick() {
        btn_chonbai.setOnClickListener(this);
        btn_play.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_chonbai:
                Intent intent = new Intent(this, ChonBaiHatActivity.class);
                intent.putExtra("idPlayingNow", getSongPlayingNow().getId());
                if (mediaPlayer != null && mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                startActivity(intent);
                break;

            case R.id.btn_play:
                mediaPlayer.start();
                break;

            case R.id.btn_pause:
                if (mediaPlayer != null)
                    mediaPlayer.pause();
                break;

            default:
                break;
        }

    }

    private BaiHat getSongPlayingNow() {
        String idPlaying = tv_idPlay.getText().toString().split(" ")[1];
        Integer playingNow = Integer.parseInt(idPlaying);
        return bh.get(playingNow - 1);
    }

    private void updateSongPlay(int id) {
        // id bai dang phat
        tv_idPlay.setText("Bài " + id);
        //ten bai dang phat
        tv_namePlay.setText(getSongPlayingNow().getName());
        //duong dan file raw
        mediaPlayer = MediaPlayer.create(this, getSongPlayingNow().getUrl());
        //time dua ve milliseconds
        int time = mediaPlayer.getDuration();
        long min = TimeUnit.MILLISECONDS.toMinutes(time);
        long sec = (TimeUnit.MILLISECONDS.toSeconds(time) % 60);
        tv_timePlay.setText(min + " min, " + sec + " sec");
    }

}