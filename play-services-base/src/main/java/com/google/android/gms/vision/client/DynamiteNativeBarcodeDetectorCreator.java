package com.google.android.gms.vision.client;

import android.os.RemoteException;
import android.util.Log;

import com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator;
import com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector;
import com.google.android.gms.vision.barcode.internal.client.BarcodeDetectorOptions;

public class DynamiteNativeBarcodeDetectorCreator extends INativeBarcodeDetectorCreator.Stub {
    @Override
    public INativeBarcodeDetector create(BarcodeDetectorOptions options) throws RemoteException {
        if (options != null) {
            Log.d("barcoder", "Called with options: " + options.toString());
        } else {
            Log.d("barcoder", "Called with no options");
        }
        // TODO: Create BarcodeDetector here
        return null;
    }
}
