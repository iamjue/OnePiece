package com.iamjue.onepiece;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    CircleImageView imgPhoto;
    TextView tvName, tvName2, tvNickname, tvBounty, tvBounty2, tvDesc;
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_NICKNAME = "extra_nickname";
    public static String EXTRA_BOUNTY = "extra_bounty";
    public static String EXTRA_PHOTO = "extra_photo";
    public static String EXTRA_DESC = "extra_desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgPhoto = findViewById(R.id.img_photo);
        tvName = findViewById(R.id.tv_name);
        tvName2 = findViewById(R.id.tv_name2);
        tvNickname = findViewById(R.id.tv_nickname);
        tvBounty = findViewById(R.id.tv_bounty);
        tvBounty2 = findViewById(R.id.tv_bounty2);
        tvDesc = findViewById(R.id.tvDesc);


        Glide.with(this).load(getIntent().getStringExtra(EXTRA_PHOTO)).into(imgPhoto);
        tvName.setText(getIntent().getStringExtra(EXTRA_NAME));
        tvBounty.setText(getIntent().getStringExtra(EXTRA_BOUNTY));
        tvName2.setText(": " + getIntent().getStringExtra(EXTRA_NAME));
        tvBounty2.setText(": " + getIntent().getStringExtra(EXTRA_BOUNTY));
        tvNickname.setText(": " + getIntent().getStringExtra(EXTRA_NICKNAME));
        tvDesc.setText(getIntent().getStringExtra(EXTRA_DESC));
    }
}
