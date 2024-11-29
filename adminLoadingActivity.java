package com.lastfom.lflauncher;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.webkit.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.facebook.shimmer.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class JavacodeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double n1 = 0;
	private HashMap<String, Object> cacheMap = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> cache = new ArrayList<>();
	
	private LinearLayout bin;
	private LinearLayout toolbar;
	private LinearLayout search_bar;
	private LinearLayout voi;
	private TextView textview1;
	private ImageView search_btn;
	private EditText edittext1;
	private ImageView close;
	private ListView listview1;
	private LinearLayout linear2;
	private LinearLayout linear_simmer;
	private LinearLayout linear61;
	private LinearLayout linear66;
	private LinearLayout linear71;
	private LinearLayout linear76;
	private LinearLayout linear81;
	private LinearLayout linear86;
	private LinearLayout linear91;
	private LinearLayout linear96;
	private LinearLayout linear101;
	private LinearLayout linear106;
	private LinearLayout linear_;
	private LinearLayout linear7;
	private ShimmerFrameLayout linears;
	private ShimmerFrameLayout l;
	private LinearLayout linear62;
	private LinearLayout linear63;
	private ShimmerFrameLayout linears1;
	private ShimmerFrameLayout l1;
	private LinearLayout linear67;
	private LinearLayout linear68;
	private ShimmerFrameLayout linears2;
	private ShimmerFrameLayout l2;
	private LinearLayout linear72;
	private LinearLayout linear73;
	private ShimmerFrameLayout linears3;
	private ShimmerFrameLayout l3;
	private LinearLayout linear77;
	private LinearLayout linear78;
	private ShimmerFrameLayout linears4;
	private ShimmerFrameLayout l4;
	private LinearLayout linear82;
	private LinearLayout linear83;
	private ShimmerFrameLayout linears5;
	private ShimmerFrameLayout l5;
	private LinearLayout linear87;
	private LinearLayout linear88;
	private ShimmerFrameLayout linears6;
	private ShimmerFrameLayout l6;
	private LinearLayout linear92;
	private LinearLayout linear93;
	private ShimmerFrameLayout linears7;
	private ShimmerFrameLayout l7;
	private LinearLayout linear97;
	private LinearLayout linear98;
	private ShimmerFrameLayout linears8;
	private ShimmerFrameLayout l8;
	private LinearLayout linear102;
	private LinearLayout linear103;
	private ShimmerFrameLayout linears9;
	private ShimmerFrameLayout l9;
	private LinearLayout linear107;
	private LinearLayout linear108;
	private ShimmerFrameLayout linears10;
	private ShimmerFrameLayout l10;
	
	private Intent i = new Intent();
	private DatabaseReference code = _firebase.getReference("code");
	private ChildEventListener _code_child_listener;
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
	
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.javacode);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bin = findViewById(R.id.bin);
		toolbar = findViewById(R.id.toolbar);
		search_bar = findViewById(R.id.search_bar);
		voi = findViewById(R.id.voi);
		textview1 = findViewById(R.id.textview1);
		search_btn = findViewById(R.id.search_btn);
		edittext1 = findViewById(R.id.edittext1);
		close = findViewById(R.id.close);
		listview1 = findViewById(R.id.listview1);
		linear2 = findViewById(R.id.linear2);
		linear_simmer = findViewById(R.id.linear_simmer);
		linear61 = findViewById(R.id.linear61);
		linear66 = findViewById(R.id.linear66);
		linear71 = findViewById(R.id.linear71);
		linear76 = findViewById(R.id.linear76);
		linear81 = findViewById(R.id.linear81);
		linear86 = findViewById(R.id.linear86);
		linear91 = findViewById(R.id.linear91);
		linear96 = findViewById(R.id.linear96);
		linear101 = findViewById(R.id.linear101);
		linear106 = findViewById(R.id.linear106);
		linear_ = findViewById(R.id.linear_);
		linear7 = findViewById(R.id.linear7);
		linears = findViewById(R.id.linears);
		l = findViewById(R.id.l);
		linear62 = findViewById(R.id.linear62);
		linear63 = findViewById(R.id.linear63);
		linears1 = findViewById(R.id.linears1);
		l1 = findViewById(R.id.l1);
		linear67 = findViewById(R.id.linear67);
		linear68 = findViewById(R.id.linear68);
		linears2 = findViewById(R.id.linears2);
		l2 = findViewById(R.id.l2);
		linear72 = findViewById(R.id.linear72);
		linear73 = findViewById(R.id.linear73);
		linears3 = findViewById(R.id.linears3);
		l3 = findViewById(R.id.l3);
		linear77 = findViewById(R.id.linear77);
		linear78 = findViewById(R.id.linear78);
		linears4 = findViewById(R.id.linears4);
		l4 = findViewById(R.id.l4);
		linear82 = findViewById(R.id.linear82);
		linear83 = findViewById(R.id.linear83);
		linears5 = findViewById(R.id.linears5);
		l5 = findViewById(R.id.l5);
		linear87 = findViewById(R.id.linear87);
		linear88 = findViewById(R.id.linear88);
		linears6 = findViewById(R.id.linears6);
		l6 = findViewById(R.id.l6);
		linear92 = findViewById(R.id.linear92);
		linear93 = findViewById(R.id.linear93);
		linears7 = findViewById(R.id.linears7);
		l7 = findViewById(R.id.l7);
		linear97 = findViewById(R.id.linear97);
		linear98 = findViewById(R.id.linear98);
		linears8 = findViewById(R.id.linears8);
		l8 = findViewById(R.id.l8);
		linear102 = findViewById(R.id.linear102);
		linear103 = findViewById(R.id.linear103);
		linears9 = findViewById(R.id.linears9);
		l9 = findViewById(R.id.l9);
		linear107 = findViewById(R.id.linear107);
		linear108 = findViewById(R.id.linear108);
		linears10 = findViewById(R.id.linears10);
		l10 = findViewById(R.id.l10);
		auth = FirebaseAuth.getInstance();
		
		search_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_TransitionManager(search_bar, 200);
				search_bar.setVisibility(View.VISIBLE);
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (edittext1.getText().toString().length() > 0) {
					_searchInListmap(edittext1.getText().toString().toLowerCase(), cache, "title");
					listview1.setAdapter(new Listview1Adapter(cache));
					if (cache.size() > 0) {
						listview1.setVisibility(View.VISIBLE);
					}
					else {
						listview1.setVisibility(View.GONE);
					}
				}
				else {
					listview1.setAdapter(new Listview1Adapter(maplist));
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_TransitionManager(bin, 200);
				search_bar.setVisibility(View.GONE);
				if (edittext1.getText().toString().length() > 0) {
					listview1.setAdapter(new Listview1Adapter(maplist));
					search_bar.setVisibility(View.GONE);
					edittext1.setText("");
					cache.clear();
				}
			}
		});
		
		_code_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				code.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						maplist = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								maplist.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(maplist));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						linear2.setVisibility(View.GONE);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		code.addChildEventListener(_code_child_listener);
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		user.addChildEventListener(_user_child_listener);
		
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
		toolbar.setElevation((float)6);
		search_bar.setElevation((float)6);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fontinhoa.ttf"), 1);
		search_btn.setColorFilter(0xFF2B4360, PorterDuff.Mode.MULTIPLY);
		search_bar.setVisibility(View.GONE);
		
		final androidx.swiperefreshlayout.widget.SwipeRefreshLayout sketch44 = new androidx.swiperefreshlayout.widget.SwipeRefreshLayout(JavacodeActivity.this);
		sketch44.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.MATCH_PARENT));
		sketch44.setColorSchemeResources(R.color.colorAccent);
		voi.removeView(listview1);
		sketch44.addView(listview1);
		voi.addView(sketch44);
		
		
		
		sketch44.setOnRefreshListener(new androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				sketch44.setRefreshing(false);
				
				_refresh();
				
			}
		} );
		_simmer();
	}
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _searchInListmap(final String _value, final ArrayList<HashMap<String, Object>> _listmap, final String _key) {
		_listmap.clear();
		n1 = 0;
		for(int _repeat13 = 0; _repeat13 < (int)(maplist.size()); _repeat13++) {
			if (maplist.get((int)n1).get(_key).toString().toLowerCase().contains(_value)) {
				cacheMap = maplist.get((int)n1);
				_listmap.add(cacheMap);
			}
			n1++;
		}
	}
	
	
	public void _gd(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public void _Round_loading_dialog(final boolean _visibility) {
		if (_visibility) {
			if (LoadingDialog== null){
					LoadingDialog = new ProgressDialog(this);
					
				LoadingDialog.setCancelable(false);
					LoadingDialog.setCanceledOnTouchOutside(false);
					
					LoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); 
					LoadingDialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
					
			}
			LoadingDialog.show();
			LoadingDialog.setContentView(R.layout.loading_bar);
			
			LinearLayout loading_bar_layout = (LinearLayout)LoadingDialog.findViewById(R.id.loading_bar_layout);
			
			
			loading_bar_layout.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFFFFFFFF));
		}
		else {
			if (LoadingDialog != null){
				LoadingDialog.dismiss();
			}
		}
	}
	private ProgressDialog LoadingDialog;
	{
	}
	
	
	public void _round_corner_and_ripple(final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	public void _refresh() {
		listview1.setAdapter(new Listview1Adapter(maplist));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		cache.clear();
		search_bar.setVisibility(View.GONE);
		edittext1.setText("");
	}
	
	
	public void _simmer() {
		/*
linear_simmer.setElevation((float)4);
linear_simmer.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear61.setElevation((float)4);
linear61.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear66.setElevation((float)4);
linear66.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear71.setElevation((float)4);
linear71.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear76.setElevation((float)4);
linear76.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear81.setElevation((float)4);
linear81.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear91.setElevation((float)4);
linear91.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear96.setElevation((float)4);
linear96.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear101.setElevation((float)4);
linear101.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear106.setElevation((float)4);
linear106.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
linear86.setElevation((float)4);
linear86.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
l.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
l10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
linears10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
*/
	}
	
	
	public void _sort(final ArrayList<HashMap<String, Object>> _mylist, final String _key) {
		Comparator list_sorter = new Comparator<HashMap<String, Object>>(){
			@Override
			public int compare(HashMap<String, Object> map2, HashMap<String, Object> map1){
				
				try {
					Double num1 = Double.parseDouble(map1.get(_key).toString());
					Double num2 = Double.parseDouble(map2.get(_key).toString());
					return Double.compare(num2, num1);
				} catch (NumberFormatException e){
					return map2.get(_key).toString().compareTo(map1.get(_key).toString());
				}
				
			}
		};
		
		Collections.sort(_mylist, list_sorter);
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.javas, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			linear1.setElevation((float)5);
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)0, 0xFF131519));
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fontinhoa.ttf"), 1);
			textview1.setText(_data.get((int)_position).get("title").toString());
			textview1.setTextColor(0xFFFFFFFF);
			if (_data.get((int)_position).containsKey("title")) {
				textview1.setText(_data.get((int)_position).get("title").toString());
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					i.setClass(getApplicationContext(), CodeviewActivity.class);
					i.putExtra("key", _data.get((int)_position).get("key").toString());
					startActivity(i);
				}
			});
			
			return _view;
		}
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