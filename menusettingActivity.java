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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.zip4j.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;;

public class MenusettingActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double sef = 0;
	private boolean a = false;
	private HashMap<String, Object> map = new HashMap<>();
	private String imageName = "";
	private String imagePath = "";
	private String name = "";
	private String path = "";
	
	private ArrayList<HashMap<String, Object>> inf = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> aaa = new ArrayList<>();
	private ArrayList<String> filePath = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private LinearLayout linear24;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private LinearLayout linear3;
	private LinearLayout linear19;
	private LinearLayout linear6;
	private LinearLayout linear14;
	private TextView Minecrafttitle;
	private ImageView imageview3;
	private LinearLayout linear23;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private LinearLayout linear30;
	private LinearLayout linear33;
	private LinearLayout lang;
	private LinearLayout linear107;
	private LinearLayout chucnang;
	private LinearLayout linear59;
	private LinearLayout info;
	private CardView cardview2;
	private LinearLayout linear29;
	private ImageView avatar;
	private TextView playername;
	private LinearLayout linear116;
	private TextView accounttext;
	private ImageView xbicon;
	private Button loginbt;
	private LinearLayout button1;
	private TextView English;
	private LinearLayout linear32;
	private ImageView arrow1;
	private LinearLayout linear111;
	private LinearLayout linear112;
	private LinearLayout linear113;
	private LinearLayout linear114;
	private TextView TV;
	private TextView TBN;
	private TextView textview60;
	private TextView textview53;
	private TextView textview59;
	private TextView textview54;
	private TextView launcg;
	private LinearLayout linear108;
	private ImageView arrow3;
	private LinearLayout config;
	private LinearLayout linear109;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private LinearLayout linear53;
	private CheckBox checkbox1;
	private CheckBox checkbox4;
	private CheckBox checkbox3;
	private TextView betatext;
	private Button button2;
	private CheckBox checkbox2;
	private TextView about;
	private LinearLayout linear60;
	private ImageView arrow2;
	private TextView launchertext;
	private TextView textview6;
	private TextView bootrap;
	private TextView textview10;
	private TextView Ui;
	private TextView textview8;
	private TextView Creator;
	private TextView textview14;
	private TextView textview12;
	private TextView textview11;
	private TextView textview15;
	
	private Intent i = new Intent();
	private SoundPool sound;
	private SharedPreferences jv;
	private SharedPreferences monerako;
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
	
	private DatabaseReference UDB = _firebase.getReference("users");
	private ChildEventListener _UDB_child_listener;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.menusetting);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		vscroll1 = findViewById(R.id.vscroll1);
		linear24 = findViewById(R.id.linear24);
		linear20 = findViewById(R.id.linear20);
		linear21 = findViewById(R.id.linear21);
		linear3 = findViewById(R.id.linear3);
		linear19 = findViewById(R.id.linear19);
		linear6 = findViewById(R.id.linear6);
		linear14 = findViewById(R.id.linear14);
		Minecrafttitle = findViewById(R.id.Minecrafttitle);
		imageview3 = findViewById(R.id.imageview3);
		linear23 = findViewById(R.id.linear23);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		linear30 = findViewById(R.id.linear30);
		linear33 = findViewById(R.id.linear33);
		lang = findViewById(R.id.lang);
		linear107 = findViewById(R.id.linear107);
		chucnang = findViewById(R.id.chucnang);
		linear59 = findViewById(R.id.linear59);
		info = findViewById(R.id.info);
		cardview2 = findViewById(R.id.cardview2);
		linear29 = findViewById(R.id.linear29);
		avatar = findViewById(R.id.avatar);
		playername = findViewById(R.id.playername);
		linear116 = findViewById(R.id.linear116);
		accounttext = findViewById(R.id.accounttext);
		xbicon = findViewById(R.id.xbicon);
		loginbt = findViewById(R.id.loginbt);
		button1 = findViewById(R.id.button1);
		English = findViewById(R.id.English);
		linear32 = findViewById(R.id.linear32);
		arrow1 = findViewById(R.id.arrow1);
		linear111 = findViewById(R.id.linear111);
		linear112 = findViewById(R.id.linear112);
		linear113 = findViewById(R.id.linear113);
		linear114 = findViewById(R.id.linear114);
		TV = findViewById(R.id.TV);
		TBN = findViewById(R.id.TBN);
		textview60 = findViewById(R.id.textview60);
		textview53 = findViewById(R.id.textview53);
		textview59 = findViewById(R.id.textview59);
		textview54 = findViewById(R.id.textview54);
		launcg = findViewById(R.id.launcg);
		linear108 = findViewById(R.id.linear108);
		arrow3 = findViewById(R.id.arrow3);
		config = findViewById(R.id.config);
		linear109 = findViewById(R.id.linear109);
		linear51 = findViewById(R.id.linear51);
		linear52 = findViewById(R.id.linear52);
		linear53 = findViewById(R.id.linear53);
		checkbox1 = findViewById(R.id.checkbox1);
		checkbox4 = findViewById(R.id.checkbox4);
		checkbox3 = findViewById(R.id.checkbox3);
		betatext = findViewById(R.id.betatext);
		button2 = findViewById(R.id.button2);
		checkbox2 = findViewById(R.id.checkbox2);
		about = findViewById(R.id.about);
		linear60 = findViewById(R.id.linear60);
		arrow2 = findViewById(R.id.arrow2);
		launchertext = findViewById(R.id.launchertext);
		textview6 = findViewById(R.id.textview6);
		bootrap = findViewById(R.id.bootrap);
		textview10 = findViewById(R.id.textview10);
		Ui = findViewById(R.id.Ui);
		textview8 = findViewById(R.id.textview8);
		Creator = findViewById(R.id.Creator);
		textview14 = findViewById(R.id.textview14);
		textview12 = findViewById(R.id.textview12);
		textview11 = findViewById(R.id.textview11);
		textview15 = findViewById(R.id.textview15);
		jv = getSharedPreferences("jv", Activity.MODE_PRIVATE);
		monerako = getSharedPreferences("monerako", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		
		Minecrafttitle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sound = new SoundPool((int)(sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f)), AudioManager.STREAM_MUSIC, 0);
				startActivity(new Intent(MenusettingActivity.this, MainmenuActivity.class)); Animatoo.animateSlideRight(MenusettingActivity.this);
				finish();
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sound = new SoundPool((int)(sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f)), AudioManager.STREAM_MUSIC, 0);
				startActivity(new Intent(MenusettingActivity.this, StartmenuActivity.class)); Animatoo.animateFade(MenusettingActivity.this);
				monerako.edit().remove("monerako").commit();
				FirebaseAuth.getInstance().signOut();
				finish();
			}
		});
		
		linear107.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (a) {
					a = false;
					config.setVisibility(View.GONE);
					arrow3.setImageResource(R.drawable.ic_arrow_drop_down_white);
				}
				else {
					a = true;
					config.setVisibility(View.VISIBLE);
					arrow3.setImageResource(R.drawable.ic_arrow_drop_up_white);
				}
			}
		});
		
		linear59.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (a) {
					a = false;
					info.setVisibility(View.GONE);
					arrow2.setImageResource(R.drawable.ic_arrow_drop_down_white);
				}
				else {
					a = true;
					info.setVisibility(View.VISIBLE);
					arrow2.setImageResource(R.drawable.ic_arrow_drop_up_white);
				}
			}
		});
		
		avatar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		loginbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sound = new SoundPool((int)(sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f)), AudioManager.STREAM_MUSIC, 0);
				startActivity(new Intent(MenusettingActivity.this, MenuloginActivity.class)); Animatoo.animateFade(MenusettingActivity.this);
				monerako.edit().remove("monerako").commit();
				FirebaseAuth.getInstance().signOut();
				finish();
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (a) {
					a = false;
					lang.setVisibility(View.GONE);
					arrow1.setImageResource(R.drawable.ic_arrow_drop_down_white);
				}
				else {
					a = true;
					lang.setVisibility(View.VISIBLE);
					arrow1.setImageResource(R.drawable.ic_arrow_drop_up_white);
				}
			}
		});
		
		linear111.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				jv.edit().putString("tiengviet", "tiengviet").commit();
				jv.edit().remove("TBN").commit();
				
				final AlertDialog dialog = new AlertDialog.Builder(MenusettingActivity.this).create();
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
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
								i.setClass(getApplicationContext(), MenusettingActivity.class);
								startActivity(i);
								finish();
							}
						});
					}
				};
				_timer.schedule(t, (int)(1000));
			}
		});
		
		linear112.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				jv.edit().putString("TBN", "TBN").commit();
				jv.edit().remove("tiengviet").commit();
			}
		});
		
		linear113.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear114.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				jv.edit().remove("tiengviet").commit();
				jv.edit().remove("TBN").commit();
				
				final AlertDialog dialog = new AlertDialog.Builder(MenusettingActivity.this).create();
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
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								i.setClass(getApplicationContext(), MenusettingActivity.class);
								i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
								startActivity(i);
								finish();
							}
						});
					}
				};
				_timer.schedule(t, (int)(1000));
			}
		});
		
		checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					jv.edit().putString("jv", "jv").commit();
					jv.edit().putString("a", "a").commit();
					button2.setVisibility(View.VISIBLE);
				}
				else {
					jv.edit().remove("jv").commit();
					jv.edit().remove("a").commit();
					button2.setVisibility(View.GONE);
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_UDB_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
				if (user != null) {
					    // Đối tượng FirebaseUser tồn tại, có thể gọi các phương thức trên đối tượng này
					loginbt.setVisibility(View.INVISIBLE);
					//ngăn cách
					UDB.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							inf = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									inf.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
								playername.setText(_childValue.get("username").toString());
							}
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
					  String uid = user.getUid();
					    // Thực hiện các công việc khác với uid
				} else {
					    // Đối tượng FirebaseUser là null, xử lý theo cách phù hợp
					SketchwareUtil.showMessage(getApplicationContext(), "Please login to your account");
				}
				// Kiá»m tra xem ngÆ°á»i dÃ¹ng cÃ³ pháº£i lÃ  anonymous hay khÃ´ng
				FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
				if (currentUser != null && currentUser.isAnonymous()) {
					    // Náº¿u lÃ  anonymous, thay Äá»i ná»i dung cá»§a TextView thÃ nh "Guest"
					    playername.setText("Anonymous user");
					    accounttext.setText("Guest Account");
					    loginbt.setVisibility(View.VISIBLE);
					    xbicon.setVisibility(View.INVISIBLE);
				} else {
					    // Náº¿u khÃ´ng pháº£i anonymous, hiá»n thá» tÃªn ngÆ°á»i dÃ¹ng hoáº·c thÃ´ng tin khÃ¡c
					    String displayName = (currentUser != null) ? currentUser.getDisplayName() : "Guest";
					    playername.setText(displayName);
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
				if (user != null) {
					    // Đối tượng FirebaseUser tồn tại, có thể gọi các phương thức trên đối tượng này
					loginbt.setVisibility(View.INVISIBLE);
					UDB.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							inf = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>