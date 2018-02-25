package weatherforecast.view.iview;


import weatherforecast.model.dto.response.WeatherResponse;


public interface IHomeActivityView extends IView {

    void setAdapter(WeatherResponse mResponse);
}
