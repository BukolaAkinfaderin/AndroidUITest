package davolusoft.com.youtubefeedca.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;

import java.util.List;

import  davolusoft.com.youtubefeedca.R;
import  davolusoft.com.youtubefeedca.contract.MainActivityContract.Presenter;
import  davolusoft.com.youtubefeedca.contract.MainActivityContract.View;
import davolusoft.com.youtubefeedca.model.UsersVideos;
import davolusoft.com.youtubefeedca.model.YoutubeVideos;
import  davolusoft.com.youtubefeedca.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements View {

    private RecyclerView recyclerView;
    private Presenter mPresenter;



    //a list to store all the videos
    List<YoutubeVideos> videoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);



        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mPresenter = new MainActivityPresenter(this);

        //this method is getting the data
        mPresenter.loadHomeFeed(MainActivity.this);

   }

    @Override
    public void initView()
    {//initialize your view

    }

    @Override
    public void setViewData(String data) {

        //this method is returning a list of videos from the network

        UsersVideos usersVideos = new Gson().fromJson(data, UsersVideos.class);

        List<YoutubeVideos> videos = usersVideos.getVideos();





    }
}