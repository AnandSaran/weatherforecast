package weatherforecast.view.iview;


import weatherforecast.model.dto.response.Current;


public interface ITodayFragmentView extends IView {

    void setData(Current forecastday);
}
