//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import org.json.JSONArray;
import org.microg.gms.common.Objects;
import org.microg.safeparcel.AutoSafeParcelable;
import org.microg.safeparcel.SafeParcelUtil;
import org.microg.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;


public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new AutoSafeParcelable.AutoCreator<>(WebImage.class);
    private final int versionCode;
    private final Uri url;
    private final int width;
    private final int height;

    WebImage(int versionCode, Uri url, int width, int height) {
        this.versionCode = versionCode;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public WebImage(Uri url, int width, int height) throws IllegalArgumentException {
        this(1, url, width, height);
        if(url == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if(width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(Uri url) throws IllegalArgumentException {
        this(url, 0, 0);
    }

    public WebImage(JSONObject json) throws IllegalArgumentException {
        this(parseUrl(json), json.optInt("width", 0), json.optInt("height", 0));
    }

    int getVersionCode() {
        return this.versionCode;
    }

    private static Uri parseUrl(JSONObject json) {
        if(json.has("url")) {
            try {
                return Uri.parse(json.getString("url"));
            } catch (JSONException var3) {
                // ignore
            }
        }
        return null;
    }

    public Uri getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String toString() {
        return String.format("Image %dx%d %s", this.width, this.height, this.url.toString());
    }

    public JSONObject toJson() {
        JSONObject var1 = new JSONObject();

        try {
            var1.put("url", this.url.toString());
            var1.put("width", this.width);
            var1.put("height", this.height);
        } catch (JSONException var3) {
            // ignore
        }

        return var1;
    }

    public boolean equals(Object other) {
        if(this == other) {
            return true;
        } else if(other != null && other instanceof WebImage) {
            WebImage var2 = (WebImage)other;
            return Objects.equals(this.url, var2.url) && this.width == var2.width && this.height == var2.height;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.url, this.width, this.height);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        SafeParcelUtil.writeObject(this, out, flags);
    }

    public static void writeToJson(JSONObject json, List<WebImage> images) {
        if(images != null && !images.isEmpty()) {
            JSONArray array = new JSONArray();

            for(WebImage image : images)
                array.put(image.toJson());

            try {
                json.put("images", array);
            } catch (JSONException var5) {
                // ignore
            }
        }
    }

    public static void parseFromJson(List<WebImage> images, JSONObject json) {
        try {
            images.clear();
            JSONArray var2 = json.getJSONArray("images");
            int var3 = var2.length();

            for(int var4 = 0; var4 < var3; ++var4) {
                JSONObject var5 = var2.getJSONObject(var4);

                try {
                    images.add(new WebImage(var5));
                } catch (IllegalArgumentException var7) {
                    // ignore
                }
            }
        } catch (JSONException var8) {
            // ignore
        }

    }
}
