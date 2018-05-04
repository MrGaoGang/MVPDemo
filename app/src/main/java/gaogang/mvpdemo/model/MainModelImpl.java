package gaogang.mvpdemo.model;

import android.content.Context;

import gaogang.mvpdemo.base.BaseModel;
import gaogang.mvpdemo.contact.MainContact;

/**
 * @Desciption: 主要执行一些网络请求操作或者比较耗时的操作
 * @Author : 高岗
 * @Date : 2017/8/19 16:15
 * @Params:
 **/
public class MainModelImpl extends BaseModel implements MainContact.MainModel {


    public MainModelImpl() {
    }

    @Override
    public void login(String user, String pwd, Context context, final IDataCallBack listenter) {
        /**
         *@Desciption: 执行网络请求操作
         *@Author : 高岗
         *@Date : 2017/8/19 16:16
         *@Params: [user, pwd, context]
         **/

        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = null;
                /***
                 * 执行一系列操作
                 */
                if (result != null) {
                    listenter.requestSuccess(result);
                } else {
                    listenter.requestFaild("返回失败");
                }


            }
        }).start();

    }

    @Override
    public void onDestroy() {

    }

    public interface IDataCallBack {
        void requestSuccess(String result);

        void requestFaild(String errorMsg);
    }
}
