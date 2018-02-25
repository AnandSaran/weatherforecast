package weatherforecast.view.iview;


import weatherforecast.model.dto.response.Current;


public interface IThreeDaysFragmentView extends IView {

    void setData(Current forecastday);
}
