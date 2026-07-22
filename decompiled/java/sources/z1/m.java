package z1;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;

/* loaded from: /root/release/classes.dex */
public class m {
    GoogleSignInClient a(Context context, GoogleSignInOptions googleSignInOptions) {
        return GoogleSignIn.getClient(context, googleSignInOptions);
    }

    GoogleSignInAccount b(Context context) {
        return GoogleSignIn.getLastSignedInAccount(context);
    }

    boolean c(GoogleSignInAccount googleSignInAccount, Scope scope) {
        return GoogleSignIn.hasPermissions(googleSignInAccount, scope);
    }

    void d(Activity activity, int i3, GoogleSignInAccount googleSignInAccount, Scope[] scopeArr) {
        GoogleSignIn.requestPermissions(activity, i3, googleSignInAccount, scopeArr);
    }
}
