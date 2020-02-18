package com.google.android.gms.vision.barcode;

import android.os.RemoteException;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.internal.client.BarcodeDetector;
import com.google.android.gms.vision.barcode.internal.client.BarcodeDetectorOptions;
import com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector;
import com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator;

public class ChimeraNativeBarcodeDetectorCreator extends INativeBarcodeDetectorCreator.Stub {
    @Override
    public INativeBarcodeDetector create(IObjectWrapper unk, BarcodeDetectorOptions options) throws RemoteException {
        return new BarcodeDetector(options);
    }
}
