package infinity1087.android.com.examplehr.loginFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;

import infinity1087.android.com.examplehr.MainActivity;
import infinity1087.android.com.examplehr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = SignIn.class.getSimpleName();
    private static final int RC_SIGN_IN = 430;
    public static GoogleSignInClient mGoogleSignInClient;
    public SignInButton google_sign_in;
    public Button btn_fb_signin, google;
    public CallbackManager callbackManager;

    public SignIn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        google_sign_in = view.findViewById(R.id.btn_google_sign_in);
        googlesignin();
        return view;


    }

    private void googlesignin() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        google_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });


    }


    @Override
    public void onClick(View v) {
        v = google;
    }
    @Override
    public void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());


//        AccessToken accessToken = AccessToken.getCurrentAccessToken();
//        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();


        if (account != null) {
            Intent i = new Intent(getActivity(), MainActivity.class);
            startActivity(i);
        }
//        else if (isLoggedIn)
//        {
//            Intent i = new Intent(getActivity(), MainActivity.class);
//            startActivity(i);
//        }


        //OptionalPendingResult opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }


    @Override
    public void onActivityResult(int requestCode, int responseCode,
                                 Intent data) {
        if (requestCode == RC_SIGN_IN) {
       /*     GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleGPlusSignInResult(result)*/;
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        } else {
            super.onActivityResult(requestCode, responseCode, data);
            callbackManager.onActivityResult(requestCode, responseCode, data);
        }
    }


    private void handleSignInResult(Task<GoogleSignInAccount> task) {



        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            if (account !=null)
            {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }

            // Signed in successfully, show authenticated UI.

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
          /*  Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);*/
        }

    }

    private void updateUI(boolean isSignedIn) {
        if (isSignedIn) {
            google_sign_in.setVisibility(View.GONE);
        } else {
            google_sign_in.setVisibility(View.VISIBLE);
        }
    }

}
