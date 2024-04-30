package com.mojang.minecraftVN;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
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

public class StartmenuActivity extends AppCompatActivity {
	
	private double sef = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear4;
	private LinearLayout linear3;
	private LinearLayout linear14;
	private ImageView imageview1;
	private LinearLayout linear7;
	private TextView textview6;
	private TextView UnderlinedTextView;
	private LinearLayout linear10;
	private Button button3;
	private LinearLayout linear19;
	private Button button1;
	
	private SoundPool sound;
	private Intent i = new Intent();
	private SharedPreferences monerako;
	private Intent intent = new Intent();
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
	
	private RequestNetwork internet;
	private RequestNetwork.RequestListener _internet_request_listener;
	private SharedPreferences jv;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.startmenu);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear4 = findViewById(R.id.linear4);
		linear3 = findViewById(R.id.linear3);
		linear14 = findViewById(R.id.linear14);
		imageview1 = findViewById(R.id.imageview1);
		linear7 = findViewById(R.id.linear7);
		textview6 = findViewById(R.id.textview6);
		UnderlinedTextView = findViewById(R.id.UnderlinedTextView);
		linear10 = findViewById(R.id.linear10);
		button3 = findViewById(R.id.button3);
		linear19 = findViewById(R.id.linear19);
		button1 = findViewById(R.id.button1);
		monerako = getSharedPreferences("monerako", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		internet = new RequestNetwork(this);
		jv = getSharedPreferences("jv", Activity.MODE_PRIVATE);
		
		UnderlinedTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sound = new SoundPool((int)(sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f)), AudioManager.STREAM_MUSIC, 0);
				i.setClass(getApplicationContext(), RegisterActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(i);
				finish();
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Noanimation(intent);
				sound = new SoundPool((int)(sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f)), AudioManager.STREAM_MUSIC, 0);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sound = new SoundPool((int)(sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f)), AudioManager.STREAM_MUSIC, 0);
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					auth.signInAnonymously().addOnCompleteListener(StartmenuActivity.this, _auth_sign_in_listener);
					
					final AlertDialog dialog = new AlertDialog.Builder(StartmenuActivity.this).create();
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
				}
				else {
					i.setClass(getApplicationContext(), LoadingscreenActivity.class);
					startActivity(i);
					finish();
				}
			}
		});
		
		_internet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
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
					i.setClass(getApplicationContext(), LoadingscreenActivity.class);
					startActivity(i);
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
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
		UnderlinedTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robotofont.ttf"), 1);
		TextView textView = (TextView) findViewById(R.id.UnderlinedTextView); textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
		sound = new SoundPool((int)(1), AudioManager.STREAM_MUSIC, 0);
		sef = sound.load(getApplicationContext(), R.raw.click, 1);
		if (jv.contains("tiengviet")) {
			//bên ngoài
			button3.setText("đăng nhập");
			button1.setText("đăng nhập với tài khoản khách");
			textview6.setText("bạn không có tài khoản");
			UnderlinedTextView.setText("tạo một tài khoản");
		}
	}
	
	@Override
	public void onBackPressed() {
		if (jv.contains("tiengviet")) {
			
			final AlertDialog dialog = new AlertDialog.Builder(StartmenuActivity.this).create();
			LayoutInflater inflater = getLayoutInflater();
			
			View convertView = (View) inflater.inflate(R.layout.custom_dialog, null);
			dialog.setView(convertView);
			dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
			TextView b1 = (TextView)
			convertView.findViewById(R.id.b1);
			TextView b2 = (TextView)
			convertView.findViewById(R.id.b2);
			TextView t1 = (TextView)
			convertView.findViewById(R.id.t1);
			TextView t2 = (TextView)
			convertView.findViewById(R.id.t2);
			t1.setText("Thông báo");
			t2.setText("Bạn có muốn thoát khỏi launcher?");
			b1.setText("không");
			b2.setText("có");
			LinearLayout gr = (LinearLayout)
			convertView.findViewById(R.id.gr);
			b1.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					
					dialog.dismiss();
				}
			});
			b2.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					
					_trans();
					dialog.dismiss();
				}
			});
			dialog.show();
		}
		else {
			
			final AlertDialog dialog = new AlertDialog.Builder(StartmenuActivity.this).create();
			LayoutInflater inflater = getLayoutInflater();
			
			View convertView = (View) inflater.inflate(R.layout.custom_dialog, null);
			dialog.setView(convertView);
			dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
			TextView b1 = (TextView)
			convertView.findViewById(R.id.b1);
			TextView b2 = (TextView)
			convertView.findViewById(R.id.b2);
			TextView t1 = (TextView)
			convertView.findViewById(R.id.t1);
			TextView t2 = (TextView)
			convertView.findViewById(R.id.t2);
			t1.setText("Notification");
			t2.setText("Do you want to exit the launcher?");
			LinearLayout gr = (LinearLayout)
			convertView.findViewById(R.id.gr);
			b1.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					
					dialog.dismiss();
				}
			});
			b2.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					
					_trans();
					dialog.dismiss();
				}
			});
			dialog.show();
		}
	}
	
	public void _Noanimation(final Intent _intent) {
		_intent.setClass(getApplicationContext(), MenuloginActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(_intent);
		finish();
	}
	
	
	public void _trans() {
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