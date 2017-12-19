package com.techfest.tf2017.abcd;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techfest.tf2017.abcd.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QRFragment extends Fragment implements ZXingScannerView.ResultHandler {
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 99;
    private ZXingScannerView mScannerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    android.Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                //Request Location Permission
                checkCameraPermission();
            }

        }
        View qrcodeview = inflater.inflate(com.techfest.tf2017.abcd.R.layout.fragment_qr, container, false);

        mScannerView = (ZXingScannerView) qrcodeview.findViewById(R.id.scanner_view);
        return qrcodeview;
    }

    private void checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            // No explanation needed, we can request the permission.
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    android.Manifest.permission.CAMERA)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(getActivity())
                        .setTitle("Camera Permission Needed")
                        .setMessage("This app needs the camera permission, please accept to use camera functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(getActivity(),
                                        new String[]{android.Manifest.permission.CAMERA},
                                        MY_PERMISSIONS_REQUEST_CAMERA);
                            }
                        })
                        .create()
                        .show();


            } else ActivityCompat.requestPermissions(getActivity(),
                    new String[]{android.Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);
        }
    }

    public void onButtonPressed(Uri uri) {

    }
    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result result) {
        // Do something with the result here
        final SpannableString message =
                new SpannableString(result.getText());
        Linkify.addLinks(message, Linkify.ALL);
        final AlertDialog scanDialog = new AlertDialog.Builder(getActivity())
                .setTitle("Scanned Message")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // If you would like to resume scanning, call this method below:
                        resumeCamera();
                    }
                })
                .create();

        scanDialog.show();
        ((TextView) scanDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void resumeCamera() {
        mScannerView.resumeCameraPreview(this);
    }


}
