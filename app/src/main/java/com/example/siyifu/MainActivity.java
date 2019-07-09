package com.example.siyifu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

//public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
//
//    private ImageView iv;
//    private int startx;
//    private int starty;
//    private Bitmap newbitmap;
//    private int newx;
//    private int newy;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        initView();
//        initDate();
//        initEvent();
//    }
//
//    private void initEvent() {
//        iv.setOnTouchListener(this);
//
//    }
//
//    private void initDate() {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pre19);
//        newbitmap = bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
//
//        Canvas canvas = new Canvas(newbitmap);
//
//        Paint paint = new Paint();
//        paint.setColor(Color.BLACK);
//
//        canvas.drawBitmap(bitmap,new Matrix(),paint);
//
//    }
//
//    private void initView() {
//        setContentView(R.layout.activity_main);
//        iv = findViewById(R.id.iv);
//
//    }
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (event.getAction()){
//
//            case MotionEvent.ACTION_DOWN:
//                startx = (int) event.getX();
//
//                starty = (int) event.getY();
//
//
//
//                        newbitmap.setPixel(startx,starty,Color.TRANSPARENT);
//
//
//
//                iv.setImageBitmap(newbitmap);
//
//
//                break;
//            case MotionEvent.ACTION_MOVE:
//
//
//                newx = (int) event.getX();
//                newy = (int) event.getY();
//
//                for(int i=-4;i<=4;i++)
//                {
//
//                    for (int j=-4;j<=4;j++) {
//
//
//                            newbitmap.setPixel(newx + i, newy + j, Color.TRANSPARENT);
//
//
//
//
//
//
//                }
//                }
//                iv.setImageBitmap(newbitmap);
//
//
//                break;
//            case MotionEvent.ACTION_UP:
//
//                break;
//
//    }
//        return true;
//    }
//}
public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView mIv;
    private int mStartX;
    private int mStartY;
    private Bitmap mNewBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        mIv.setOnTouchListener(this);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pre19);

        // 得到原图的拷贝
        mNewBitmap = bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

        Canvas canvas = new Canvas(mNewBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
    }

    /**
     * 初始化界面
     */
    private void initView() {
        setContentView(R.layout.activity_main);
        mIv = findViewById(R.id.iv);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = (int) event.getX();
                mStartY = (int) event.getY();
                System.out.println("按下：" + mStartX + ", " + mStartY);
                mNewBitmap.setPixel(mStartX, mStartY, Color.TRANSPARENT);
                mIv.setImageBitmap(mNewBitmap);
                break;
            case MotionEvent.ACTION_MOVE:
                int newX = (int) event.getX();
                int newY = (int) event.getY();
                System.out.println("移动：" + newX + ", " + newY);
                for (int i = -3; i < 4; i++) {
                    for (int j = -3; j < 4; j++) {

                        mNewBitmap.setPixel(newX + i, newY + j, Color.TRANSPARENT);

                    }
                }
                mIv.setImageBitmap(mNewBitmap);
                break;
            case MotionEvent.ACTION_UP:

                break;

            default:
                break;
        }
        return true;
    }
}
