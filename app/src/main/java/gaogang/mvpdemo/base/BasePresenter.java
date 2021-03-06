package gaogang.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
 * Created by 高岗 on 2017/8/19.
 */
public abstract class BasePresenter<V extends IView> implements IPresenter {

    WeakReference<V> mIViewRe;
    @Override
    public void attachView(IView view) {
        mIViewRe=new WeakReference(view);
    }

    @Override
    public void deAttachView() {
        if (mIViewRe!=null){
            mIViewRe.clear();
            mIViewRe=null;
        }
    }

    @Override
    public V getIView() {
        if (mIViewRe!=null){
            return mIViewRe.get();
        }
        else {
            return null;
        }

    }

    public  abstract void onDestroy();
}
