package com.mojang.minecraftVN;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import java.util.regex.*;
import org.json.*;

public class DebugActivity extends AppCompatActivity {
	
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
	private LinearLayout nut1;
	private TextView textview8;
	private LinearLayout Thanhxanh1;
	private ScrollView vscroll1;
	private LinearLayout linear89;
	private ImageView imageview6;
	private TextView textview30;
	private TextView error;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.debug);
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
		nut1 = findViewById(R.id.nut1);
		textview8 = findViewById(R.id.textview8);
		Thanhxanh1 = findViewById(R.id.Thanhxanh1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear89 = findViewById(R.id.linear89);
		imageview6 = findViewById(R.id.imageview6);
		textview30 = findViewById(R.id.textview30);
		error = findViewById(R.id.error);
		
		error.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", error.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "copied");
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		View decorView = getWindow().getDecorView();
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w = this.getWindow();
			// Hide both the navigation bar and the status bar.
			// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
			// a general rule, you should design your app to hide the status bar whenever you
			// hide the navigation bar.
			int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
			decorView.setSystemUiVisibility(uiOptions);
			w.setStatusBarColor(Color.parseColor("#272727"));}
		error.setText(getIntent().getStringExtra("error"));
		//test
		
		final AlertDialog dialog = new AlertDialog.Builder(DebugActivity.this).create();
		LayoutInflater inflater = getLayoutInflater();
		
		View convertView = (View) inflater.inflate(R.layout.error, null);
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
		//t1.setText("Custom Dialog");
		//t2.setText("This is a simple dialog");
		LinearLayout gr = (LinearLayout)
		convertView.findViewById(R.id.gr);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				//nút 1
				_exit();
				dialog.dismiss();
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				//nút hai
				dialog.dismiss();
			}
		});
		dialog.setCanceledOnTouchOutside(false); // Ngăn dialog đóng khi chạm vào bên ngoài
		dialog.show();
	}
	
	public void _exit() {
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