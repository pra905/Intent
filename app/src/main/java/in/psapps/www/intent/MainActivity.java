package in.psapps.www.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonClicks(View view){
        Intent intent=null,chooser=null;

        if(view.getId()==R.id.MapButton){
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:19.25,71.5777"));
                chooser = Intent.createChooser(intent, "Search In");
                startActivity(chooser);
        }

        if(view.getId()==R.id.MarketButton) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://search?q=PS_Apps"));
            chooser = Intent.createChooser(intent, "Search In");
            startActivity(chooser);
        }

        if(view.getId()==R.id.EmailButton) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"sender1@mail.com", "sender2@mail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "XYZSubject");
            intent.putExtra(Intent.EXTRA_TEXT, "bla bla bla ........");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Mail Using");
            startActivity(chooser);
        }

        if(view.getId()==R.id.ImageButton){
            Uri imageUri=Uri.parse("android.resource://psapps.in/drawable"+R.drawable.ic_launcher);
            intent=new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.putExtra(Intent.EXTRA_TEXT, "Sendingiconimage");
            chooser=Intent.createChooser(intent,"Send Image");
            startActivity(chooser);
        }

    }
}
