package com.mojang.minecraftVN;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.media.SoundPool;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.webkit.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.zip4j.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;;

public class MenuloginActivity extends AppCompatActivity {
	
	private double sef = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear4;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private TextView titlelogin;
	private TextView textview6;
	private LinearLayout linear7;
	private TextView textview4;
	private LinearLayout linear8;
	private TextView textview5;
	private LinearLayout linear13;
	private LinearLayout linear10;
	private Button buttonlogin;
	private EditText email;
	private EditText mk;
	private LinearLayout linear14;
	private ImageView hide;
	private ImageView show;
	private TextView createlog;
	private TextView UnderlinedTextView;
	
	private AlertDialog.Builder d;
	private Intent i = new Intent();
	private SoundPool sound;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private SharedPreferences jv;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.menulogin);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear4 = findViewById(R.id.linear4);
		linear3 = findViewById(R.id.linear3);
		linear6 = findViewById(R.id.linear6);
		titlelogin = findViewById(R.id.titlelogin);
		textview6 = findViewById(R.id.textview6);
		linear7 = findViewById(R.id.linear7);
		textview4 = findViewById(R.id.textview4);
		linear8 = findViewById(R.id.linear8);
		textview5 = findViewById(R.id.textview5);
		linear13 = findViewById(R.id.linear13);
		linear10 = findViewById(R.id.linear10);
		buttonlogin = findViewById(R.id.buttonlogin);
		email = findViewById(R.id.email);
		mk = findViewById(R.id.mk);
		linear14 = findViewById(R.id.linear14);
		hide = findViewById(R.id.hide);
		show = findViewById(R.id.show);
		createlog = findViewById(R.id.createlog);
		UnderlinedTextView = findViewById(R.id.UnderlinedTextView);
		d = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		jv = getSharedPreferences("jv", Activity.MODE_PRIVATE);
		
		buttonlogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (email.getText().toString().equals("") || mk.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Please enter password or email");
					textview4.setTextColor(0xFFF44336);
					textview5.setTextColor(0xFFF44336);
				}
				else {
					
					final AlertDialog dialog = new AlertDialog.Builder(MenuloginActivity.this).create();
					LayoutInflater inflater = getLayoutInflater();
					
					View convertView = (View) inflater.inflate(R.layout.loading, null);
					dialog.setView(convertView);
					dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
					TextView t1 = (TextView)
					convertView.findViewById(R.id.t1);
					LinearLayout gr = (LinearLayout)
					convertView.findViewById(R.id.gr);
					// Tìm tham chiếu đến ImageView trong convertView
					ImageView anh1 = convertView.findViewById(R.id.anh1);
					
					// Tạo đường dẫn của hình ảnh trong thư mục 'android_asset'
					String imagePath = "file:///android_asset/loading.gif";
					
					// Sử dụng Glide để tải hình ảnh vào ImageView
					Glide.with(anh1.getContext()).load(Uri.parse(imagePath)).into(anh1);
					dialog.setCanceledOnTouchOutside(false); // Ngăn dialog đóng khi chạm vào bên ngoài
					dialog.show();
					auth.signInWithEmailAndPassword(email.getText().toString(), mk.getText().toString()).addOnCompleteListener(MenuloginActivity.this, _auth_sign_in_listener);
				}
			}
		});
		
		hide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				mk.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
				show.setVisibility(View.VISIBLE);
				hide.setVisibility(View.GONE);
			}
		});
		
		show.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				mk.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
				show.setVisibility(View.GONE);
				hide.setVisibility(View.VISIBLE);
			}
		});
		
		createlog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("Email and password");
				d.setMessage("Still under development");
				d.setPositiveButton(" Copy", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "Example@email.com"));
					}
				});
				d.create().show();
			}
		});
		
		UnderlinedTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Noanimation(i);
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					if (FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
						i.setClass(getApplicationContext(), LoadingscreenActivity.class);
						startActivity(i);
						overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
						finish();
					}
					else {
						FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification().addOnCompleteListener(auth_emailVerificationSentListener);
						SketchwareUtil.showMessage(getApplicationContext(), "Please verify email");
						i.setClass(getApplicationContext(), MenuloginActivity.class);
						i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						startActivity(i);
						finish();
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Login failed");
					i.setClass(getApplicationContext(), MenuloginActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(i);
					finish();
				}
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		/*
getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
View.SYSTEM_UI_FLAG_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
Window w = this.getWindow();
w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
w.setStatusBarColor(Color.parseColor("#33000000"));
}
*/
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){ getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }View decorView = getWindow().getDecorView();
		// Hide both the navigation bar and the status bar.
		// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
		// a general rule, you should design your app to hide the status bar whenever you
		// hide the navigation bar.
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
		decorView.setSystemUiVisibility(uiOptions);
		createlog.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robotofont.ttf"), 1);
		TextView textView = (TextView) findViewById(R.id.UnderlinedTextView); textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
		buttonlogin.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/mcten.ttf"), 1);
		titlelogin.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fontmcv2.ttf"), 1);
		mk.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		show.setVisibility(View.GONE);
		hide.getDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		show.getDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		sound = new SoundPool((int)(1), AudioManager.STREAM_MUSIC, 0);
		sef = sound.load(getApplicationContext(), R.raw.click, 1);
		EditText mk = findViewById(R.id.mk);
		mk.setSingleLine(true);
		EditText email = findViewById(R.id.email);
		email.setSingleLine(true);
		if (jv.contains("tiengviet")) {
			//bên ngoài
			textview6.setText("Sử dụng tài khoản LastFom của bạn để đăng nhập vào Minecraft.");
			titlelogin.setText("Đăng nhập");
			textview5.setText("Mật khẩu");
			createlog.setText("bạn không có tài khoản");
			UnderlinedTextView.setText("nhấn vào đây để tạo");
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), StartmenuActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
		finish();
	}
	
	public void _Noanimation(final Intent _intent) {
		_intent.setClass(getApplicationContext(), RegisterActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(_intent);
		finish();
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}