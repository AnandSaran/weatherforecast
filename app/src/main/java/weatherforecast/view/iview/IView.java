package weatherforecast.view.iview;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import weatherforecast.presenter.ipresenter.IPresenter;


public interface IView {

    void showMessage(String message);

    void showMessage(int resId);


    void showProgressbar();

    void dismissProgressbar();

    FragmentActivity getActivity();

    void showSnackBar(String message);

    void showSnackBar(@NonNull View view, String message);

    void showNetworkMessage();


    void bindPresenter(IPresenter iPresenter);

    boolean checkNetWork();


}
