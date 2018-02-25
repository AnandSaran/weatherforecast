package weatherforecast.presenter;

import android.os.Bundle;

import weatherforecast.model.dto.response.Forecastday;
import weatherforecast.presenter.ipresenter.ITomorrowFragmentPresenter;
import weatherforecast.util.Constants;
import weatherforecast.view.iview.ITomorrowFragmentView;


public class TomorrowFragmentPresenter extends BasePresenter implements ITomorrowFragmentPresenter {
    private ITomorrowFragmentView iTomorrowFragmentView;

    public TomorrowFragmentPresenter(ITomorrowFragmentView iTomorrowFragmentView) {
        super(iTomorrowFragmentView);
        this.iTomorrowFragmentView = iTomorrowFragmentView;
    }


    @Override
    public void onCreatePresenter(Bundle bundle) {
        Forecastday forecastday = (Forecastday) bundle.getSerializable(Constants.BundleKey.TODAY_WEATHER);
        if (forecastday != null) {
            iTomorrowFragmentView.setData(forecastday);
        }

    }
}
