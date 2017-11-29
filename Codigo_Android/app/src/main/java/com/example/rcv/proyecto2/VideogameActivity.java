package com.example.rcv.proyecto2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.session.MediaSession;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.concurrent.ExecutionException;

import com.example.rcv.SyncTaskClass.loginSyncTask;
import com.example.rcv.SyncTaskClass.videogameSyncTask;
import com.videogames_api.model.MessagesCodeMessage;
import com.videogames_api.model.MessagesVideogameInput;

public class VideogameActivity extends AppCompatActivity {

    Button btnVideogame;
    EditText edtTitle;
    EditText edtDeveloper;
    EditText edtPublisher;
    EditText edtYear;
    EditText edtDescription;
    EditText edtGenre;
    EditText edtImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videogame);

        btnVideogame = (Button) findViewById(R.id.btnVideogame);

        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtDeveloper = (EditText) findViewById(R.id.edtDeveloper);
        edtPublisher = (EditText) findViewById(R.id.edtPublisher);
        edtYear = (EditText) findViewById(R.id.edtYear);
        edtDescription = (EditText) findViewById(R.id.edtDescription);
        edtGenre = (EditText) findViewById(R.id.edtGenre);

        edtImage = (EditText) findViewById(R.id.edtImage);
        //edtImage.setText("https://adsoft-iosclient.appspot.com/images/team-img3.jpg");
        edtImage.setText("https://scriptroutine.files.wordpress.com/2017/07/halo-3-cover-art.jpg?w=1200");

        btnVideogame.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String title =  edtTitle.getText().toString().trim();
                String developer = edtDeveloper.getText().toString().trim();
                String publisher = edtPublisher.getText().toString().trim();
                String year = edtYear.getText().toString().trim();
                String description = edtDescription.getText().toString().trim();
                String genre = edtGenre.getText().toString().trim();
                String image = edtImage.getText().toString().trim();

                if ((title.length() == 0) || (description.length() == 0) || (developer.length() == 0) || (publisher.length() == 0) || (year.length() == 0) || (genre.length() == 0))
                {
                    Toast.makeText(VideogameActivity.this,
                            "Necesitas ingresar toda la info.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = getIntent();
                String token = intent.getStringExtra("Token");

                Toast.makeText(VideogameActivity.this, title + " , " +  description + " " + token,
                        Toast.LENGTH_LONG).show();

                //key en vez de URL-safe "5649391675244544"
                //En realidad, user key no importa. En VideogameMessageInput es required=false y en videogames_api.add no se usa
                String[] params = {token, "aiBwfnByb3llY3RvMi1yYWZhZWxhbnRvbmlvY29tb25mb3IVCxIIVXN1YXJpb3MYgICAgPjChAoM", title, developer, publisher, year, description, genre, image};
                Toast.makeText(VideogameActivity.this, "title: " + title + " imageURL: " + image, Toast.LENGTH_LONG).show();

                AsyncTask<String, Void, MessagesCodeMessage> execute =
                        new videogameSyncTask(VideogameActivity.this).execute(params);
                String Message = new String();

                /*LoginTask(LoginActivity.this).execute(params);*/
                try {
                    Message = execute.get().getMessage();
                    //Toast.makeText(LoginActivity.this,"Token: "+execute.get().getToken(),Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e){
                    e.printStackTrace();
                }
                finally
                {
                    if(Message != null) {

                        Toast.makeText(VideogameActivity.this," Message: "+ Message,Toast.LENGTH_SHORT).show();

                        //Intent myIntent = new Intent(TweetActivity.this, TweetActivity.class);

                        //myIntent.putExtra("Message: ", Message);
                        //startActivity(intent);
                    }

                }
            }
        });

    }
}