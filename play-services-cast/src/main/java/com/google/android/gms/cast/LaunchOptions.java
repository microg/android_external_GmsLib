// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;

import org.microg.gms.common.Objects;
import org.microg.safeparcel.AutoSafeParcelable;

import java.util.Locale;

// Referenced classes of package com.google.android.gms.cast:
//            zzc

public class LaunchOptions extends AutoSafeParcelable
{
    public static final android.os.Parcelable.Creator<LaunchOptions> CREATOR = new AutoSafeParcelable.AutoCreator<>(LaunchOptions.class);

    private final int versionCode;
    private boolean relaunchIfRunning;
    private String language;

    public static final class Builder
    {

        public Builder setRelaunchIfRunning(boolean relaunchIfRunning)
        {
            launchOptions.setRelaunchIfRunning(relaunchIfRunning);
            return this;
        }

        public Builder setLocale(Locale locale)
        {
            launchOptions.setLanguage(CastMediaControlIntent.languageTagForLocale(locale));
            return this;
        }

        public LaunchOptions build()
        {
            return launchOptions;
        }

        private LaunchOptions launchOptions;

        public Builder()
        {
            launchOptions = new LaunchOptions();
        }
    }

    LaunchOptions(int versionCode, boolean relaunchIfRunning, String language)
    {
        this.versionCode = versionCode;
        this.relaunchIfRunning = relaunchIfRunning;
        this.language = language;
    }

    public LaunchOptions()
    {
        this(1, false, CastMediaControlIntent.languageTagForLocale(Locale.getDefault()));
    }

    int getVersionCode()
    {
        return versionCode;
    }

    public void setRelaunchIfRunning(boolean relaunchIfRunning)
    {
        this.relaunchIfRunning = relaunchIfRunning;
    }

    public boolean getRelaunchIfRunning()
    {
        return relaunchIfRunning;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getLanguage()
    {
        return language;
    }

    public String toString()
    {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", relaunchIfRunning, language);
    }

    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;
        if(!(obj instanceof LaunchOptions))
        {
            return false;
        } else
        {
            LaunchOptions launchoptions = (LaunchOptions)obj;
            return relaunchIfRunning == launchoptions.relaunchIfRunning && Objects.equals(language, launchoptions.language);
        }
    }

    public int hashCode()
    {
        return Objects.hash(relaunchIfRunning, language);
    }

}
