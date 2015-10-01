// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;

import android.os.*;
import com.google.android.gms.common.images.WebImage;
import org.microg.gms.common.Objects;
import org.microg.safeparcel.AutoSafeParcelable;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice extends AutoSafeParcelable {
    public static final android.os.Parcelable.Creator<CastDevice> CREATOR = new AutoSafeParcelable.AutoCreator<>(CastDevice.class);

    private final int versionCode;
    private String deviceId;
    String hostAddress;
    private Inet4Address inetaddress;
    private String friendlyName;
    private String modelName;
    private String deviceVersion;
    private int servicePort;
    private List<WebImage> icons;
    private int capabilities;
    private int status;

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort,
               List<WebImage> icons, int capabilities, int status) {
        this.versionCode = versionCode;
        this.deviceId = deviceId;
        this.hostAddress = hostAddress;
        if (this.hostAddress != null)
            try {
                InetAddress inetaddress = InetAddress.getByName(this.hostAddress);
                if (inetaddress instanceof Inet4Address)
                    this.inetaddress = (Inet4Address) inetaddress;
            } catch (UnknownHostException unknownhostexception) {
                this.inetaddress = null;
            }
        this.friendlyName = friendlyName;
        this.modelName = modelName;
        this.deviceVersion = deviceVersion;
        this.servicePort = servicePort;
        this.icons = icons;
        this.capabilities = capabilities;
        this.status = status;
    }

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList<WebImage>(), 0, -1);
    }

    int getVersionCode() {
        return versionCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Inet4Address getIpAddress() {
        return inetaddress;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public int getServicePort() {
        return servicePort;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(icons);
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        if (icons.isEmpty())
            return null;
        if (preferredWidth <= 0 || preferredHeight <= 0)
            return (WebImage) icons.get(0);
        WebImage webimage = null;
        WebImage webimage1 = null;
        for (final WebImage webimage2 : icons) {
            int i = webimage2.getWidth();
            int j = webimage2.getHeight();
            if (i >= preferredWidth && j >= preferredHeight) {
                if (webimage == null || webimage.getWidth() > i && webimage.getHeight() > j)
                    webimage = webimage2;
            } else if (i < preferredWidth && j < preferredHeight && (webimage1 == null || webimage1.getWidth() < i && webimage1.getHeight() < j))
                webimage1 = webimage2;
        }
        if (webimage != null)
            return webimage;
        else if (webimage1 != null)
            return webimage1;
        else
            return icons.get(0);
    }

    public boolean hasIcons() {
        return !icons.isEmpty();
    }

    public int getCapabilities() {
        return capabilities;
    }

    public int getStatus() {
        return status;
    }

    public String toString() {
        return String.format("\"%s\" (%s)", friendlyName, deviceId);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof CastDevice))
            return false;
        CastDevice castdevice = (CastDevice) obj;
        if (getDeviceId() == null)
            return castdevice.getDeviceId() == null;
        else
            return Objects.equals(deviceId, castdevice.deviceId) && Objects.equals(inetaddress, castdevice.inetaddress) && Objects.equals(modelName, castdevice.modelName) && Objects.equals(friendlyName, castdevice.friendlyName) && Objects.equals(deviceVersion, castdevice.deviceVersion) && servicePort == castdevice.servicePort && Objects.equals(icons, castdevice.icons) && capabilities == castdevice.capabilities && status == castdevice.status;
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null)
            return false;
        if (getDeviceId() == null)
            return castDevice.getDeviceId() == null;
        else
            return Objects.equals(getDeviceId(), castDevice.getDeviceId());
    }

    public int hashCode() {
        return deviceId != null ? deviceId.hashCode() : 0;
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null)
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        } else {
            extras.setClassLoader(CastDevice.class.getClassLoader());
            return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
        }
    }

    public boolean isOnLocalNetwork() {
        return !deviceId.startsWith("__cast_nearby__");
    }
}
