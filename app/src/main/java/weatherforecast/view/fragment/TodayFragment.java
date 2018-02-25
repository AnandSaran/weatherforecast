package weatherforecast.view.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import weatherforecast.R;
import weatherforecast.databinding.FragmentTodayBinding;
import weatherforecast.model.dto.response.Current;
import weatherforecast.presenter.TodayFragmentPresenter;
import weatherforecast.presenter.ipresenter.ITodayFragmentPresenter;
import weatherforecast.view.iview.ITodayFragmentView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends BaseFragment implements ITodayFragmentView {
    FragmentTodayBinding binding;
    private ITodayFragmentPresenter iTodayFragmentPresenter;

    public TodayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_today, container, false);
        View rootView = binding.getRoot();

        iTodayFragmentPresenter = new TodayFragmentPresenter(this);
        iTodayFragmentPresenter.onCreatePresenter(getArguments());
        return rootView;


    }

    @Override
    public void setData(Current current) {
        binding.date.setText(current.getLast_updated());
        binding.temp.setText(current.getTemp_c()+ " "+getString(R.string.degree_c));
        binding.tempCondition.setText(current.getCondition().getText());
        Glide.with(getActivity()).load("http:"+current.getCondition().getIcon()).into(binding.tempImage);

        binding.windSpeed.setText(getString(R.string.wind_speed)+" "+current.getWind_kph()+" kph");
        binding.windDegree.setText(getString(R.string.wind_degree)+" "+current.getWind_degree());
        binding.humidity.setText(getString(R.string.humidity)+" "+current.getHumidity());
        binding.cloud.setText(getString(R.string.cloud)+" "+current.getCloud());


    }
}
