package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Can extends View {

    Paint paint;
    Path path;
    public Can(Context context, AttributeSet attrs) {
        super(context,attrs);
        paint = new Paint();
        path = new Path();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        Float xPos=event.getX();
        Float yPos=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos,yPos);
                break;

                case MotionEvent.ACTION_MOVE:
                    path.lineTo(xPos,yPos);
                    break;

            default:
                break;
        }

        invalidate();
        return true;
    }
}
