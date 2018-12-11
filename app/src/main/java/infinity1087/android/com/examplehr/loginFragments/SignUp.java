package infinity1087.android.com.examplehr.loginFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import infinity1087.android.com.examplehr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {


    public SignUp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

}
