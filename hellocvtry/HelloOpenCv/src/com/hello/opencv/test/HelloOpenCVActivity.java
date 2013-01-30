package com.hello.opencv.test;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;

public class HelloOpenCVActivity extends Activity {
	private HelloOpenCVView mView;
	public void onCreate (Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	      mView = new HelloOpenCVView(this);
	     setContentView (mView);
	 }

	 protected void onPause() {
	     super.onPause();
	     mView.cameraRelease();
	 }

	 protected void onResume() {
	     super.onResume();
	     if( !mView.cameraOpen() ) {
	         // MessageBox and exit app
	         AlertDialog ad = new AlertDialog.Builder(this).create();
	         ad.setCancelable(false); // This blocks the "BACK" button
	         ad.setMessage("Fatal error: can't open camera!");
	         ad.setButton("OK", new DialogInterface.OnClickListener() {
	             public void onClick(DialogInterface dialog, int which) {
	                 dialog.dismiss();
	                 finish();
	             }
	         });
	         ad.show();
	     }
	 }

}
