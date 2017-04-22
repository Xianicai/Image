package com.example.lenovo.kuaikan.community;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.base.BaseActivity;
import com.example.lenovo.kuaikan.utils.ListUtil;
import com.example.lenovo.kuaikan.utils.ToastUtil;
import com.example.lenovo.kuaikan.widget.BrowseImageViewPager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class BrowseImageActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    BrowseImageViewPager mViewPager;
    @BindView(R.id.tv_hint)
    TextView mTvHint;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    private BrowsImageViewPagerAdapter mViewPagerAdapter;
    private String[] imageTypes = new String[] { ".jpg",".png", ".jpeg","webp"};
    private int mPosition;
    private List<String> mImagesUrls;

    @Override
    public int getlayoutId() {
        return R.layout.activity_browse_image;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String imageBase = intent.getStringExtra("imageBase");
        mPosition = intent.getIntExtra("position", 0);
        List<String> images = intent.getStringArrayListExtra("images");
        mImagesUrls = new ArrayList<>();
        mTvHint.setText(mPosition + 1 + "/" + images.size());
        for (int i = 0; i < images.size(); i++) {
            mImagesUrls.add(imageBase + images.get(i));
        }

        if (mViewPagerAdapter == null && ListUtil.isNotEmpty(mImagesUrls)) {
            mViewPagerAdapter = new BrowsImageViewPagerAdapter(this, mImagesUrls);
            mViewPager.setAdapter(mViewPagerAdapter);
            mViewPager.setCurrentItem(mPosition);
            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    mPosition = position;
                    mTvHint.setText(position + 1 + "/" + mImagesUrls.size());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }


    @OnClick(R.id.tv_save)
    public void onViewClicked() {
        saveImage();
    }
    public void saveImage(){
        //利用Picasso加载图片

        final String imageUrl = mImagesUrls.get(mPosition);

        Glide.with(this).load(imageUrl).asBitmap().into(new Target<Bitmap>() {
            @Override
            public void onLoadStarted(Drawable placeholder) {

            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                // 创建目录
                File appDir = new File(Environment.getExternalStorageDirectory(), "JellyImage");
                if (!appDir.exists()) {
                    appDir.mkdir();
                }

                String imageType = getImageType(imageUrl); //获取图片类型
                String fileName = System.currentTimeMillis() + "." + imageType;
                File file = new File(appDir, fileName);
                //保存图片
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    if(TextUtils.equals(imageType,"jpg")) imageType = "jpeg";
                    imageType = imageType.toUpperCase();
                    resource.compress(Bitmap.CompressFormat.valueOf(imageType), 100, fos);
                    fos.flush();
                    fos.close();
                    ToastUtil.showMessage("保存成功");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 其次把文件插入到系统图库
                try {
                    MediaStore.Images.Media.insertImage(BrowseImageActivity.this.getContentResolver(), file.getAbsolutePath(), fileName, null);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                // 最后通知图库更新
                BrowseImageActivity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getPath())));
            }

            @Override
            public void onLoadCleared(Drawable placeholder) {

            }

            @Override
            public void getSize(SizeReadyCallback cb) {

            }

            @Override
            public void setRequest(Request request) {

            }

            @Override
            public Request getRequest() {
                return null;
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onDestroy() {

            }
        });
    }
    public String getImageType(String imageUrl){
        String imageType = "";
        if(imageUrl.endsWith(imageTypes[0])){
            imageType = "jpg";
        }else if(imageUrl.endsWith(imageTypes[1])){
            imageType = "png";
        }else{
            imageType = "jpeg";
        }
        return imageType;
    }
}
