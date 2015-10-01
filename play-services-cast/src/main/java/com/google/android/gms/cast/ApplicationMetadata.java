// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.images.WebImage;
import org.microg.gms.common.Objects;
import org.microg.safeparcel.AutoSafeParcelable;
import org.microg.safeparcel.SafeParcelUtil;
import org.microg.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {

    public static final android.os.Parcelable.Creator<ApplicationMetadata> CREATOR = new AutoSafeParcelable.AutoCreator<>(ApplicationMetadata.class);

    private final int versionCode;
    String applicationId;
    String name;
    List<WebImage> images;
    List<String> namespaces;
    String senderAppIdentifier;
    Uri senderAppLaunchUrl;

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.versionCode = versionCode;
        this.applicationId = applicationId;
        this.name = name;
        this.images = images;
        this.namespaces = namespaces;
        this.senderAppIdentifier = senderAppIdentifier;
        this.senderAppLaunchUrl = senderAppLaunchUrl;
    }

    private ApplicationMetadata() {
        versionCode = 1;
        images = new ArrayList<>();
        namespaces = new ArrayList<>();
    }

    int getVersionCode() {
        return versionCode;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getName() {
        return name;
    }

    public boolean isNamespaceSupported(String namespace) {
        return namespaces != null && namespaces.contains(namespace);
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.namespaces != null && this.namespaces.containsAll(namespaces);
    }

    public String getSenderAppIdentifier() {
        return senderAppIdentifier;
    }

    public Uri zzhh() {
        return senderAppLaunchUrl;
    }

    public List<WebImage> getImages() {
        return images;
    }

    public String toString() {
        return (new StringBuilder()).append("applicationId: ").append(applicationId).append(", name: ").append(name).append(", images.count: ").append(images != null ? images.size() : 0).append(", namespaces.count: ").append(namespaces != null ? namespaces.size() : 0).append(", senderAppIdentifier: ").append(senderAppIdentifier).append(", senderAppLaunchUrl: ").append(senderAppLaunchUrl).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        SafeParcelUtil.writeObject(this, out, flags);
    }

    public int hashCode() {
        return Objects.hash(versionCode, applicationId, name, images, namespaces, senderAppIdentifier, senderAppLaunchUrl);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        } else {
            ApplicationMetadata applicationmetadata = (ApplicationMetadata) obj;
            return Objects.equals(applicationId, applicationmetadata.applicationId) && Objects.equals(images, applicationmetadata.images) && Objects.equals(name, applicationmetadata.name) && Objects.equals(namespaces, applicationmetadata.namespaces) && Objects.equals(senderAppIdentifier, applicationmetadata.senderAppIdentifier) && Objects.equals(senderAppLaunchUrl, applicationmetadata.senderAppLaunchUrl);
        }
    }
}
