package id.ac.iainpekalongan.themovie;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] movieName, movieDesc;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = new Movie();
                movie.setName(movies.get(position).getName());
                movie.setDescription(movies.get(position).getDescription());
                movie.setPhoto(movies.get(position).getPhoto());

                Intent detailIntent = new Intent(MainActivity.this, MovieDetail.class);
                detailIntent.putExtra(MovieDetail.EXTRA_MOVIE, movie);
                startActivity(detailIntent);
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < movieName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPoster.getResourceId(i, -1));
            movie.setName(movieName[i]);
            movie.setDescription(movieDesc[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        movieName = getResources().getStringArray(R.array.data_name);
        movieDesc= getResources().getStringArray(R.array.data_description);
        dataPoster = getResources().obtainTypedArray(R.array.data_photo);
    }
}
