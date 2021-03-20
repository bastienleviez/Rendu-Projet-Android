package fr.epsi.testepsi;

import android.os.Handler;
import android.os.Looper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

public class WSCall {
    public interface Callback {
        void onComplete(String result);
        void onError(Exception e);
    }

    private final ExecutorService executor = Executors.newSingleThreadExecutor(); // change according to your requirements
    private final Handler handler = new Handler(Looper.getMainLooper());
    private  Callback callback;
    private String wsUrl;

    public WSCall(String wsUrl,Callback callback){
        this.wsUrl=wsUrl;
        this.callback=callback;
    }

    public void run() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream inputStream = null;
                    URL url = new URL(wsUrl);
                    HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.connect();
                    inputStream = httpURLConnection.getInputStream();
                    postRun(convertStreamToString(inputStream));
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                    postRun(e);
                } catch (Exception e) {
                    e.printStackTrace();
                    postRun(e);
                }
            }
        });
    }

    private void postRun(Object o){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (o instanceof Exception) {
                    callback.onError((Exception) o);
                } else {
                    callback.onComplete(o.toString());
                }
            }
        });
    }

    private static String convertStreamToString(InputStream is){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            StringBuilder stringBuffer = new StringBuilder("");
            String line;

            String NL = System.getProperty("line.separator");
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line).append(NL);
            }
            bufferedReader.close();
            return stringBuffer.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
