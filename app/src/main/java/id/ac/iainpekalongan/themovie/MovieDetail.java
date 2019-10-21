package id.ac.iainpekalongan.themovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView txtName, txtDescription;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        setTitle("Movie Detail");
        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        txtName = findViewById(R.id.txt_name);
        txtDescription = findViewById(R.id.txt_description);
        imgPhoto = findViewById(R.id.img_photo);

        txtName.setText(movie.getName());
        txtDescription.setText(movie.getDescription());
        imgPhoto.setImageResource(movie.getPhoto());
    }
}
