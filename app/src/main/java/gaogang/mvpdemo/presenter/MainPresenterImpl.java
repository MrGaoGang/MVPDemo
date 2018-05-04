package gaogang.mvpdemo.presenter;

import com.google.gson.Gson;

import gaogang.mvpdemo.MainActivity;
import gaogang.mvpdemo.base.BasePresenter;
import gaogang.mvpdemo.contact.MainContact;
import gaogang.mvpdemo.model.MainModelImpl;

/**
 * @Desciption: 主要执行一些操作
 * @Author : 高岗
 * @Date : 2017/8/19 16:15
 * @Params:
 **/
public class MainPresenterImpl extends BasePresenter<MainActivity> implements MainContact.MainPresenter, MainModelImpl.IDataCallBack {

    MainModelImpl mainModel;

    public MainPresenterImpl() {
        mainModel = new MainModelImpl();
    }

    @Override
    public void doLogin(String user, String pwd) {
        mainModel.login(user, pwd, getIView(), this);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void requestSuccess(final String result) {
        /**
         *@Desciption: 数据返回成功的操作
         *@Author : 高岗
         *@Date : 2017/8/19 16:23
         *@Params: [result]
         **/
        getIView().runOnUiThread(new Runnable() {//回到子线程处理数据，改变界面
            @Override
            public void run() {
                Gson gson = new Gson();
                //    User user=gson.fromJson(result,User.class);,返回的是一个对象的情况
                //将JSON字符串转换成数组
                // List<User> list=gson.fromJson(result,new TypeToken<List<User>>(){}.getType());
            }
        });

    }

    @Override
    public void requestFaild(String errorMsg) {
        /**
         *@Desciption: 数据返回失败的操作
         *@Author : 高岗
         *@Date : 2017/8/19 16:23
         *@Params: [errorMsg]
         **/
        getIView().runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
