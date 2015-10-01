//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.images.WebImage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_USER = 100;

    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";

    private static final String[] zzIZ = new String[]{null, "String", "int", "double", "ISO-8601 date String"};

    private static final MediaMetadata.zza zzJa = (new MediaMetadata.zza()).zzb("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).zzb("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).zzb("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).zzb("com.google.android.gms.cast.metadata.TITLE", "title", 1).zzb("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).zzb("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).zzb("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).zzb("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).zzb("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).zzb("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).zzb("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).zzb("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).zzb("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).zzb("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).zzb("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).zzb("com.google.android.gms.cast.metadata.WIDTH", "width", 2).zzb("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).zzb("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).zzb("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).zzb("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);

    private final List<WebImage> images;
    private final Bundle bundle;
    private int mediaType;

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int mediaType) {
        this.images = new ArrayList<>();
        this.bundle = new Bundle();
        this.mediaType = mediaType;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public void clear() {
        this.bundle.clear();
        this.images.clear();
    }

    public boolean containsKey(String key) {
        return this.bundle.containsKey(key);
    }

    public Set<String> keySet() {
        return this.bundle.keySet();
    }

    public void putString(String key, String value) {
        this.zzf(key, 1);
        this.bundle.putString(key, value);
    }

    public String getString(String key) {
        this.zzf(key, 1);
        return this.bundle.getString(key);
    }

    public void putInt(String key, int value) {
        this.zzf(key, 2);
        this.bundle.putInt(key, value);
    }

    public int getInt(String key) {
        this.zzf(key, 2);
        return this.bundle.getInt(key);
    }

    public void putDouble(String key, double value) {
        this.zzf(key, 3);
        this.bundle.putDouble(key, value);
    }

    public double getDouble(String key) {
        this.zzf(key, 3);
        return this.bundle.getDouble(key);
    }

    public void putDate(String key, Calendar value) {
        this.zzf(key, 4);
        this.bundle.putString(key, serializeCalendar(value));
    }

    public Calendar getDate(String key) {
        this.zzf(key, 4);
        String var2 = this.bundle.getString(key);
        return var2 != null?parseCalendar(var2):null;
    }

    public String getDateAsString(String key) {
        this.zzf(key, 4);
        return this.bundle.getString(key);
    }

    private void zzf(String var1, int var2) throws IllegalArgumentException {
        if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        } else {
            int var3 = zzJa.zzaG(var1);
            if(var3 != var2 && var3 != 0) {
                throw new IllegalArgumentException("Value for " + var1 + " must be a " + zzIZ[var2]);
            }
        }
    }

    public JSONObject toJson() {
        JSONObject var1 = new JSONObject();

        try {
            var1.put("metadataType", this.mediaType);
        } catch (JSONException var3) {
            ;
        }

        WebImage.writeToJson(var1, this.images);
        switch(this.mediaType) {
            case 0:
                this.zza(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            case 1:
                this.zza(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            case 2:
                this.zza(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"});
                break;
            case 3:
                this.zza(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            case 4:
                this.zza(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"});
                break;
            default:
                this.zza(var1, new String[0]);
        }

        return var1;
    }

    public void zzd(JSONObject var1) {
        this.clear();
        this.mediaType = 0;

        try {
            this.mediaType = var1.getInt("metadataType");
        } catch (JSONException var3) {
            ;
        }

        WebImage.parseFromJson(this.images, var1);
        switch(this.mediaType) {
            case 0:
                this.zzb(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            case 1:
                this.zzb(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            case 2:
                this.zzb(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"});
                break;
            case 3:
                this.zzb(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"});
                break;
            case 4:
                this.zzb(var1, new String[]{"com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"});
                break;
            default:
                this.zzb(var1, new String[0]);
        }

    }

    private void zza(JSONObject var1, String... var2) {
        try {
            String[] var3 = var2;
            int var4 = var2.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String var6 = var3[var5];
                if(this.bundle.containsKey(var6)) {
                    int var7 = zzJa.zzaG(var6);
                    switch(var7) {
                        case 1:
                        case 4:
                            var1.put(zzJa.zzaE(var6), this.bundle.getString(var6));
                            break;
                        case 2:
                            var1.put(zzJa.zzaE(var6), this.bundle.getInt(var6));
                            break;
                        case 3:
                            var1.put(zzJa.zzaE(var6), this.bundle.getDouble(var6));
                    }
                }
            }

            Iterator var9 = this.bundle.keySet().iterator();

            while(var9.hasNext()) {
                String var10 = (String)var9.next();
                if(!var10.startsWith("com.google.")) {
                    Object var11 = this.bundle.get(var10);
                    if(var11 instanceof String) {
                        var1.put(var10, var11);
                    } else if(var11 instanceof Integer) {
                        var1.put(var10, var11);
                    } else if(var11 instanceof Double) {
                        var1.put(var10, var11);
                    }
                }
            }
        } catch (JSONException var8) {
            ;
        }

    }

    private void zzb(JSONObject var1, String... var2) {
        HashSet var3 = new HashSet(Arrays.asList(var2));

        try {
            Iterator var4 = var1.keys();

            while(var4.hasNext()) {
                String var5 = (String)var4.next();
                if(!"metadataType".equals(var5)) {
                    String var6 = zzJa.zzaF(var5);
                    Object var7;
                    if(var6 != null) {
                        if(var3.contains(var6)) {
                            try {
                                var7 = var1.get(var5);
                                if(var7 != null) {
                                    switch(zzJa.zzaG(var6)) {
                                        case 1:
                                            if(var7 instanceof String) {
                                                this.bundle.putString(var6, (String) var7);
                                            }
                                            break;
                                        case 2:
                                            if(var7 instanceof Integer) {
                                                this.bundle.putInt(var6, ((Integer) var7).intValue());
                                            }
                                            break;
                                        case 3:
                                            if(var7 instanceof Double) {
                                                this.bundle.putDouble(var6, ((Double) var7).doubleValue());
                                            }
                                            break;
                                        case 4:
                                            if(var7 instanceof String) {
                                                Calendar var8 = parseCalendar((String) var7);
                                                if(var8 != null) {
                                                    this.bundle.putString(var6, (String) var7);
                                                }
                                            }
                                    }
                                }
                            } catch (JSONException var9) {
                                ;
                            }
                        }
                    } else {
                        var7 = var1.get(var5);
                        if(var7 instanceof String) {
                            this.bundle.putString(var5, (String) var7);
                        } else if(var7 instanceof Integer) {
                            this.bundle.putInt(var5, ((Integer) var7).intValue());
                        } else if(var7 instanceof Double) {
                            this.bundle.putDouble(var5, ((Double) var7).doubleValue());
                        }
                    }
                }
            }
        } catch (JSONException var10) {
            ;
        }

    }

    public boolean equals(Object other) {
        if(this == other) {
            return true;
        } else if(!(other instanceof MediaMetadata)) {
            return false;
        } else {
            MediaMetadata var2 = (MediaMetadata)other;
            return this.zza(this.bundle, var2.bundle) && this.images.equals(var2.images);
        }
    }

    public int hashCode() {
        int var1 = 17;
        Set var2 = this.bundle.keySet();

        String var4;
        for(Iterator var3 = var2.iterator(); var3.hasNext(); var1 = 31 * var1 + this.bundle.get(var4).hashCode()) {
            var4 = (String)var3.next();
        }

        var1 = 31 * var1 + this.images.hashCode();
        return var1;
    }

    public List<WebImage> getImages() {
        return this.images;
    }

    public boolean hasImages() {
        return this.images != null && !this.images.isEmpty();
    }

    public void clearImages() {
        this.images.clear();
    }

    public void addImage(WebImage image) {
        this.images.add(image);
    }

    private boolean zza(Bundle var1, Bundle var2) {
        if(var1.size() != var2.size()) {
            return false;
        } else {
            Set var3 = var1.keySet();
            Iterator var6 = var3.iterator();

            Object var5;
            String var7;
            label38:
            do {
                Object var4;
                do {
                    if(!var6.hasNext()) {
                        return true;
                    }

                    var7 = (String)var6.next();
                    var4 = var1.get(var7);
                    var5 = var2.get(var7);
                    if(var4 instanceof Bundle && var5 instanceof Bundle && !this.zza((Bundle)var4, (Bundle)var5)) {
                        return false;
                    }

                    if(var4 == null) {
                        continue label38;
                    }
                } while(var4.equals(var5));

                return false;
            } while(var5 == null && var2.containsKey(var7));

            return false;
        }
    }

    private static class zza {
        private final Map<String, String> zzJd = new HashMap();
        private final Map<String, String> zzJe = new HashMap();
        private final Map<String, Integer> zzJf = new HashMap();

        public zza() {
        }

        public MediaMetadata.zza zzb(String var1, String var2, int var3) {
            this.zzJd.put(var1, var2);
            this.zzJe.put(var2, var1);
            this.zzJf.put(var1, Integer.valueOf(var3));
            return this;
        }

        public String zzaE(String var1) {
            return (String)this.zzJd.get(var1);
        }

        public String zzaF(String var1) {
            return (String)this.zzJe.get(var1);
        }

        public int zzaG(String var1) {
            Integer var2 = (Integer)this.zzJf.get(var1);
            return var2 != null?var2.intValue():0;
        }
    }

    static String serializeCalendar(Calendar var0) {
        if(var0 == null) {
            Log.d("MetadataUtils", "Calendar object cannot be null");
            return null;
        } else {
            String dateFormat = "yyyyMMdd\'T\'HHmmssZ";
            if(var0.get(Calendar.HOUR_OF_DAY) == 0 && var0.get(Calendar.MINUTE) == 0 && var0.get(Calendar.SECOND) == 0) {
                dateFormat = "yyyyMMdd";
            }

            SimpleDateFormat var2 = new SimpleDateFormat(dateFormat);
            var2.setTimeZone(var0.getTimeZone());
            String var3 = var2.format(var0.getTime());
            if(var3.endsWith("+0000")) {
                var3 = var3.replace("+0000", "Z");
            }

            return var3;
        }
    }

    static Calendar parseCalendar(String date) {
        if(TextUtils.isEmpty(date)) {
            Log.d("MetadataUtils", "Input string is empty or null");
            return null;
        } else {
            String var1 = parseDatePart(date);
            if(TextUtils.isEmpty(var1)) {
                Log.d("MetadataUtils", "Invalid date format");
                return null;
            } else {
                String var2 = parseTimePart(date);
                String dateFormat = "yyyyMMdd";
                if(!TextUtils.isEmpty(var2)) {
                    var1 = var1 + "T" + var2;
                    if(var2.length() == "HHmmss".length()) {
                        dateFormat = "yyyyMMdd\'T\'HHmmss";
                    } else {
                        dateFormat = "yyyyMMdd\'T\'HHmmssZ";
                    }
                }

                Calendar var4 = GregorianCalendar.getInstance();

                Date var5;
                try {
                    var5 = (new SimpleDateFormat(dateFormat)).parse(var1);
                } catch (ParseException var7) {
                    Log.d("MetadataUtils", String.format("Error parsing string: %s", var7.getMessage()));
                    return null;
                }

                var4.setTime(var5);
                return var4;
            }
        }
    }

    private static String parseDatePart(String var0) {
        if(TextUtils.isEmpty(var0)) {
            Log.d("MetadataUtils", "Input string is empty or null");
            return null;
        } else {
            try {
                return var0.substring(0, "yyyyMMdd".length());
            } catch (IndexOutOfBoundsException var2) {
                Log.i("MetadataUtils", String.format("Error extracting the date: %s", var2.getMessage()));
                return null;
            }
        }
    }

    private static String parseTimePart(String var0) {
        if(TextUtils.isEmpty(var0)) {
            Log.d("MetadataUtils", "string is empty or null");
            return null;
        } else {
            int var1 = var0.indexOf(84);
            if(var1++ != "yyyyMMdd".length()) {
                Log.d("MetadataUtils", "T delimeter is not found");
                return null;
            } else {
                String var2;
                try {
                    var2 = var0.substring(var1);
                } catch (IndexOutOfBoundsException var4) {
                    Log.d("MetadataUtils", String.format("Error extracting the time substring: %s", var4.getMessage()));
                    return null;
                }

                if(var2.length() == "HHmmss".length()) {
                    return var2;
                } else {
                    char var3 = var2.charAt("HHmmss".length());
                    switch(var3) {
                        case '+':
                        case '-':
                            if(whichTimePart(var2)) {
                                return var2.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                            }
                        default:
                            return null;
                        case 'Z':
                            return var2.length() == "HHmmssZ".length() ?var2.substring(0, var2.length() - 1) + "+0000":null;
                    }
                }
            }
        }
    }

    private static boolean whichTimePart(String var0) {
        int var1 = var0.length();
        int var2 = "HHmmss".length();
        return var1 == var2 + "+hh".length() || var1 == var2 + "+hhmm".length() || var1 == var2 + "+hh:mm".length();
    }
}
