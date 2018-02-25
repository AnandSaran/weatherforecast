package weatherforecast.presenter;

import android.os.Bundle;
import android.util.Log;

import weatherforecast.R;
import weatherforecast.model.ForecastModel;
import weatherforecast.model.dto.response.WeatherResponse;
import weatherforecast.presenter.ipresenter.IHomeActivityPresenter;
import weatherforecast.retrofit.ResponseListener;
import weatherforecast.view.iview.IHomeActivityView;


public class HomeActivityPresenter extends BasePresenter implements IHomeActivityPresenter {
    private IHomeActivityView iHomeActivityView;

    public HomeActivityPresenter(IHomeActivityView iHomeActivityView) {
        super(iHomeActivityView);
        this.iHomeActivityView = iHomeActivityView;
    }

    @Override
    public void callForecastADI() {
        if (iHomeActivityView.checkNetWork()) {
            iHomeActivityView.showProgressbar();
            ForecastModel newsModel = new ForecastModel(getForecastListener);
            newsModel.getForecast(0,"1db1f346c5ce46e7944161149182202","Bangalore",5);
        } else {
            iHomeActivityView.showSnackBar(iHomeActivityView.getActivity().getString(R.string.no_network));

        }

    }
    private ResponseListener<WeatherResponse> getForecastListener = new ResponseListener<WeatherResponse>() {
        @Override
        public void onSuccess(WeatherResponse mResponse, long flag) {
            Log.e(TAG, "onSuccess" + mResponse.toString());
            iHomeActivityView.dismissProgressbar();

            iHomeActivityView.setAdapter(mResponse);

        }


        @Override
        public void onFailureApi(Throwable mThrowable) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage("Server error,try again!");

        }

        @Override
        public void showErrorDialog(WeatherResponse mResponse, long flag) {
            iHomeActivityView.dismissProgressbar();
            iHomeActivityView.showMessage("Server error, try again!");

        }
    };

    @Override
    public void onCreatePresenter(Bundle bundle) {

    }
}
