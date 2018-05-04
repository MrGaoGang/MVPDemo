package gaogang.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gaogang.mvpdemo.base.BaseActivity;
import gaogang.mvpdemo.presenter.MainPresenterImpl;

public class MainActivity extends BaseActivity {

    MainPresenterImpl mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mainPresenter!=null){
            mainPresenter.attachView(this);
        }
        initView();
        initData();
    }

    private void initView(){

    }
    private void initData(){
        mainPresenter.doLogin("用户民","密码");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainPresenter!=null)
        {
            mainPresenter.deAttachView();
        }

    }
}
