package weatherforecast.view.iview;


import weatherforecast.model.dto.response.Forecastday;


public interface ITomorrowFragmentView extends IView {

    void setData(Forecastday forecastday);
}
