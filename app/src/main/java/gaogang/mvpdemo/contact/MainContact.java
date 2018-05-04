package gaogang.mvpdemo.contact;

import android.content.Context;

import gaogang.mvpdemo.model.MainModelImpl;

/**
 * Created by 高岗 on 2017/8/19.
 */
public class MainContact {
    public static final int LOGIN_OK=0;
    public static final int LOGIN_FAILD=1;
    /**
     * Created by 高岗 on 2017/8/19.
     */
    public  interface MainView{
    }

    /**
     * Created by 高岗 on 2017/8/19.
     */
    public  interface MainPresenter {

        void doLogin(String user, String pwd);
    }

    /**
     * Created by 高岗 on 2017/8/19.
     */
    public  interface MainModel {

        void login(String user, String pwd, Context context, MainModelImpl.IDataCallBack dataCallBack);
    }
}
