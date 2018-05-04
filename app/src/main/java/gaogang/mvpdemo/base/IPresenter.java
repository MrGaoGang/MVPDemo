package gaogang.mvpdemo.base;

/**
 * Created by 高岗 on 2017/8/19.
 */
public interface IPresenter<V extends IView> {
    /**
    *@Desciption:
    *@Author : 高岗
    *@Date : 2017/8/19 13:34
    *@Params:
    **/
    void attachView(V view);

    void deAttachView();

    V getIView();
}
