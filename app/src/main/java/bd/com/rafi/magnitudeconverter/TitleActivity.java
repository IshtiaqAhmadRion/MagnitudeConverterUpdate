package bd.com.rafi.magnitudeconverter;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class TitleActivity extends AppCompatActivity {

    private FlowingDrawer mDrawer;


    TextView tvHome, tvShare, tvContract, tvAbout;

    AlertDialog.Builder builder;
    AlertDialog alertDialog;

    View dialogView;






    void showContactDialogueBox(){
        mDrawer.closeMenu(true);
        View dialogView = getLayoutInflater().inflate(R.layout.contact_us, null);
        builder.setView(null);
        builder.setView(dialogView);

        alertDialog = builder.create();

        alertDialog.setCanceledOnTouchOutside(true);

        alertDialogDismiss();

        alertDialog.show();


    }

    private void alertDialogDismiss(){
        if (alertDialog.isShowing()){
            alertDialog.dismiss();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawer=findViewById(R.id.drawerlayout);
        setupToolbar();

        builder = new AlertDialog.Builder(TitleActivity.this);


        tvHome = findViewById(R.id.tv_home);
        tvContract = findViewById(R.id.tv_contact);
        tvShare = findViewById(R.id.tv_share);
        tvAbout = findViewById(R.id.tv_about);

        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHomeDialogueBox();
            }
        });


        tvContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContactDialogueBox();
            }
        });

        tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShareDialougeBox();
            }
        });

        tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAboutDialogueBox();
            }
        });





        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        final AdView mAdView = findViewById(R.id.adView);




        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.

                Log.e("status","adLoaded");

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.

                Log.e("status","ad Load Failed "+errorCode);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.

                Log.e("status","adLoaded and opened");
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });


        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }




    public void click(View v){

        if(v.getId()==R.id.currencyimage||v.getId()==R.id.currencytext){
            Intent i=new Intent(TitleActivity.this,ConvertActivity.class);
            i.putExtra("value","Currency");
            startActivity(i);

        }
        else if(v.getId()==R.id.lengthtext1||v.getId()==R.id.lenthgimage){
            Intent i=new Intent(TitleActivity.this,ConvertActivity.class);
            i.putExtra("value","Length");
            startActivity(i);

        }
        else if(v.getId()==R.id.numberimage||v.getId()==R.id.numbertext2){
            Intent i=new Intent(TitleActivity.this,ConvertActivity.class);
            i.putExtra("value","Number");
            startActivity(i);
        }
        else if(v.getId()==R.id.wordimage||v.getId()==R.id.wordtext3){
            Intent i=new Intent(TitleActivity.this,ConvertActivity.class);
            i.putExtra("value","Word");
            startActivity(i);
        }
        else if(v.getId()==R.id.pressureimage||v.getId()==R.id.pressuretext4){
            Intent i=new Intent(TitleActivity.this,ConvertActivity.class);
            i.putExtra("value","Pressure");
            startActivity(i);
        }
        else if(v.getId()==R.id.temparatureimage||v.getId()==R.id.temparaturetext5){
            Intent i=new Intent(TitleActivity.this,ConvertActivity.class);
            i.putExtra("value","Temperature");
            startActivity(i);
        }
        else if(v.getId()==R.id.timetext6||v.getId()==R.id.timeiamge){
            Intent i=new Intent(TitleActivity.this,ConvertActivity.class);
            i.putExtra("value","Time");
            startActivity(i);
        }
        else if(v.getId()==R.id.weightimage||v.getId()==R.id.weighttext7){
            Intent i=new Intent(TitleActivity.this,ConvertActivity.class);
            i.putExtra("value","Weight");
            startActivity(i);
        }
    }

    protected void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.menuwhite);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.toggleMenu();
            }
        });
    }

    void showHomeDialogueBox(){
        mDrawer.closeMenu(true);
    }

    void showShareDialougeBox(){
        mDrawer.closeMenu(true);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "https://play.google.com/store/apps/magnitudeconverter";
        String shareSub = "ToDo";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }

    void showAboutDialogueBox(){
        mDrawer.closeMenu(true);

        dialogView = getLayoutInflater().inflate(R.layout.aboutus, null);
        builder.setView(null);
        builder.setView(dialogView);

        alertDialog=builder.create();
        alertDialog.setCanceledOnTouchOutside(true);

        alertDialogDismiss();
        alertDialog.show();

    }
}