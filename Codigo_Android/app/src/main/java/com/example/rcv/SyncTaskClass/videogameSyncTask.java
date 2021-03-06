package com.example.rcv.SyncTaskClass;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.session.MediaSession;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.videogames_api.VideogamesApi;
import com.videogames_api.model.MessagesVideogameInput;
import com.videogames_api.model.MessagesCodeMessage;

/**
 * Created by adsoft on 14/11/17.
 */

public class videogameSyncTask extends AsyncTask<String,Void,MessagesCodeMessage> {

    Context context;
    private ProgressDialog pd;
    MessagesCodeMessage respuesta;

    public videogameSyncTask(Context context) {this.context = context; }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        pd = new ProgressDialog(context);
        pd.setMessage("Login");
        pd.show();
    }



    @Override
    protected MessagesCodeMessage doInBackground(String... params) {

        respuesta = new MessagesCodeMessage();
        try
        {
            VideogamesApi.Builder builder =
                    new VideogamesApi.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
            VideogamesApi service = builder.build();
            MessagesVideogameInput log = new MessagesVideogameInput();
            //params es una lista de strings que funciona como argv
            //[0] = email, [1] = password
            log.setToken(params[0]);
            log.setUserKey(params[1]);
            log.setTitle(params[2]);
            log.setDeveloper(params[3]);
            log.setPublisher(params[4]);
            log.setYear(params[5]);
            log.setDescription(params[6]);
            log.setGenre(params[7]);
            log.setImage(params[8]);

            /*log.setTitle(params[0]);
            log.setDescription(params[1]);
            log.setToken(params[2]);
            log.setUrlImage(params[3]);*/
            respuesta = service.videogames().insert(log).execute();
        }
        catch (Exception e)
        {
            Log.d("ErrorOnVideogameInsert", e.getMessage(), e);
        }
        finally
        {
            return respuesta;
        }
    }


    @Override
    protected void onPostExecute(MessagesCodeMessage messagesTokenMessage)
    {
        pd.dismiss();
        if(respuesta.getCode() == 1)
            Toast.makeText(this.context, "Inserted succesfully " + respuesta.getMessage(), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this.context,"Error al insertar videojuego",Toast.LENGTH_SHORT).show();
    }
}

