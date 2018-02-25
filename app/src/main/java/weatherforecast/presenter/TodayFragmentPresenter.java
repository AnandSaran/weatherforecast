package weatherforecast.presenter;

import android.os.Bundle;

import weatherforecast.model.dto.response.Current;
import weatherforecast.presenter.ipresenter.ITodayFragmentPresenter;
import weatherforecast.util.Constants;
import weatherforecast.view.iview.ITodayFragmentView;


public class TodayFragmentPresenter extends BasePresenter implements ITodayFragmentPresenter {
    private ITodayFragmentView iTodayFragmentView;

    public TodayFragmentPresenter(ITodayFragmentView iTodayFragmentView) {
        super(iTodayFragmentView);
        this.iTodayFragmentView = iTodayFragmentView;
    }


    @Override
    public void onCreatePresenter(Bundle bundle) {
        Current current = (Current) bundle.getSerializable(Constants.BundleKey.TODAY_WEATHER);
        if (current != null) {
            iTodayFragmentView.setData(current);
        }

    }
}
