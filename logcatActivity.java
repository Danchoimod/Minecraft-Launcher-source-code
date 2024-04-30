package com.mojang.minecraftVN;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.webkit.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.firebase.FirebaseApp;
import com.zip4j.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class LogcatActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String log_ = "";
	private boolean a = false;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear5;
	private LinearLayout accountbutton;
	private LinearLayout linear8;
	private LinearLayout accountwhite;
	private ImageView imageview5;
	private TextView textview6;
	private LinearLayout linear15;
	private LinearLayout navigationbar;
	private LinearLayout accountmenu;
	private TextView title;
	private LinearLayout linear90;
	private ImageView imageview7;
	private LinearLayout nut1;
	private LinearLayout run;
	private LinearLayout linear91;
	private TextView textview8;
	private LinearLayout Thanhxanh1;
	private TextView textview34;
	private LinearLayout thanhxanh1;
	private TextView textview35;
	private ScrollView vscroll1;
	private LinearLayout linear89;
	private ImageView imageview6;
	private TextView logcat;
	
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.logcat);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear5 = findViewById(R.id.linear5);
		accountbutton = findViewById(R.id.accountbutton);
		linear8 = findViewById(R.id.linear8);
		accountwhite = findViewById(R.id.accountwhite);
		imageview5 = findViewById(R.id.imageview5);
		textview6 = findViewById(R.id.textview6);
		linear15 = findViewById(R.id.linear15);
		navigationbar = findViewById(R.id.navigationbar);
		accountmenu = findViewById(R.id.accountmenu);
		title = findViewById(R.id.title);
		linear90 = findViewById(R.id.linear90);
		imageview7 = findViewById(R.id.imageview7);
		nut1 = findViewById(R.id.nut1);
		run = findViewById(R.id.run);
		linear91 = findViewById(R.id.linear91);
		textview8 = findViewById(R.id.textview8);
		Thanhxanh1 = findViewById(R.id.Thanhxanh1);
		textview34 = findViewById(R.id.textview34);
		thanhxanh1 = findViewById(R.id.thanhxanh1);
		textview35 = findViewById(R.id.textview35);
		vscroll1 = findViewById(R.id.vscroll1);
		linear89 = findViewById(R.id.linear89);
		imageview6 = findViewById(R.id.imageview6);
		logcat = findViewById(R.id.logcat);
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Logcat.Save(LogcatActivity.this);
			}
		});
		
		run.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (a) {
					    a = false;
					    thanhxanh1.setVisibility(View.INVISIBLE);
					    // Gán giá trị null cho biến log_
					    log_ = null;
					    // Hủy timer task nếu nó đang chạy
					    if (t != null) {
						        t.cancel();
						        t = null;
						    }
				} else {
					    a = true;
					    thanhxanh1.setVisibility(View.VISIBLE);
					    // Khởi tạo và chạy timer task để lấy log từ thiết bị
					    t = new TimerTask() {
						        @Override
						        public void run() {
							            runOnUiThread(new Runnable() {
								                @Override
								                public void run() {
									                    log_ = Logcat.getCurrentDeviceLog();
									                    logcat.setText(log_);
									                }
								            });
							        }
						    };
					    _timer.scheduleAtFixedRate(t, (int)(100), (int)(100));
				}
				/*
if (a) {
a = false;
thanhxanh1.setVisibility(View.INVISIBLE);
// Gán giá trị null cho biến log_
log_ = null;
}
else {
a = true;
thanhxanh1.setVisibility(View.VISIBLE);
t = new TimerTask() {
@Override
public void run() {
runOnUiThread(new Runnable() {
@Override
public void run() {
log_ = Logcat.getCurrentDeviceLog();
logcat.setText(log_);
}
});
}
};
_timer.scheduleAtFixedRate(t, (int)(100), (int)(100));
}
*/
			}
		});
		
		textview35.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				// Xoá logcat
				Logcat.Clear(getApplicationContext());
			}
		});
	}
	
	private void initializeLogic() {
		thanhxanh1.setVisibility(View.INVISIBLE);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){ getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }View decorView = getWindow().getDecorView();
		// Hide both the navigation bar and the status bar.
		// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
		// a general rule, you should design your app to hide the status bar whenever you
		// hide the navigation bar.
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
		              | View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
	}
	
	public void _logcatLibrary() {
	}
	// This project developed by r-owner of epic mods and all rights reversed:) ©2077
	// converted to moreblock and added get current log is by DidDog
	//DidDog channel link https://youtube.com/channel/UCxuyWS7wdHw6hq05b75hmZg
	public static class Logcat {
		    public static void Clear(android.content.Context context) {
			        try {
				            Runtime.getRuntime().exec("logcat -c");
				            android.widget.Toast.makeText(context, "Logcat cleared", android.widget.Toast.LENGTH_LONG).show();
				        } catch (java.io.IOException e) {
				            android.widget.Toast.makeText(context, "There was an error saving logcat to file", android.widget.Toast.LENGTH_LONG).show();
				            e.printStackTrace();
				        }
			    }
		
		    public static void Save(android.content.Context context) {
			        java.io.File path = null;
			        try {
				            java.lang.Process process = Runtime.getRuntime().exec("logcat -d");
				            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(
				                    new java.io.InputStreamReader(process.getInputStream()));
				
				            StringBuilder log = new StringBuilder();
				            String line = "";
				            while ((line = bufferedReader.readLine()) != null) {
					                log.append(line + "\n");
					            }
				            long unixTime = System.currentTimeMillis() / 1000L;
				            if (android.os.Build.VERSION.SDK_INT >= 30) {
					                path = new java.io.File("/storage/emulated/0/Documents/");
					            } else {
					                path = new java.io.File(context.getExternalFilesDir(null) + "/mcbelauncher");
					            }
				
				            java.io.File folder = new java.io.File(String.valueOf(path));
				            folder.mkdirs();
				
				            java.io.File file = new java.io.File(path + "/log-Launcher.txt");
				            file.createNewFile();
				
				            try {
					                java.io.BufferedWriter buf = new java.io.BufferedWriter(new java.io.FileWriter(file));
					                buf.append(log.toString());
					                buf.newLine();
					                buf.close();
					                android.widget.Toast.makeText(context, "Logcat saved successfully to: " + file.toString(), android.widget.Toast.LENGTH_LONG).show();
					                android.widget.Toast.makeText(context, "Logcat saved successfully to: " + file.toString(), android.widget.Toast.LENGTH_LONG).show();
					            } catch (java.io.IOException e) {
					                android.widget.Toast.makeText(context, "There was an error saving logcat to file: " + e.getLocalizedMessage(), android.widget.Toast.LENGTH_LONG).show();
					                e.printStackTrace();
					            }
				        } catch (java.io.IOException e) {
				            android.widget.Toast.makeText(context, "There was an error saving logcat to file: " + Log.getStackTraceString(e), android.widget.Toast.LENGTH_LONG).show();
				            e.printStackTrace();
				        }
			    }
		
		    public static String getCurrentDeviceLog() {
			        String string = "null";
			        try {
				            java.lang.Process process = Runtime.getRuntime().exec("logcat -d");
				            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(
				                    new java.io.InputStreamReader(process.getInputStream()));
				
				            StringBuilder log = new StringBuilder();
				            String line = "";
				            while ((line = bufferedReader.readLine()) != null) {
					                log.append(line + "\n");
					            }
				            long unixTime = System.currentTimeMillis() / 1000L;
				            string = log.toString();
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
			        return string;
			    }
		
	}
	
	{
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