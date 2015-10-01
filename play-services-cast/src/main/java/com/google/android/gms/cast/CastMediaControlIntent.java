// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;

import android.text.TextUtils;
import java.util.*;

public final class CastMediaControlIntent
{

    public static String categoryForRemotePlayback(String applicationId)
        throws IllegalArgumentException
    {
        if(TextUtils.isEmpty(applicationId))
            throw new IllegalArgumentException("applicationId cannot be null or empty");
        else
            return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", applicationId, null);
    }

    public static String categoryForRemotePlayback()
    {
        return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", null, null);
    }

    public static String categoryForCast(String applicationId)
        throws IllegalArgumentException
    {
        if(applicationId == null)
            throw new IllegalArgumentException("applicationId cannot be null");
        else
            return zza("com.google.android.gms.cast.CATEGORY_CAST", applicationId, null);
    }

    public static String categoryForCast(Collection namespaces)
        throws IllegalArgumentException
    {
        if(namespaces == null)
            throw new IllegalArgumentException("namespaces cannot be null");
        else
            return zza("com.google.android.gms.cast.CATEGORY_CAST", null, namespaces);
    }

    public static String categoryForCast(String applicationId, Collection namespaces)
    {
        if(applicationId == null)
            throw new IllegalArgumentException("applicationId cannot be null");
        if(namespaces == null)
            throw new IllegalArgumentException("namespaces cannot be null");
        else
            return zza("com.google.android.gms.cast.CATEGORY_CAST", applicationId, namespaces);
    }

    private static String zza(String s, String s1, Collection collection)
        throws IllegalArgumentException
    {
        StringBuffer stringbuffer = new StringBuffer(s);
        if(s1 != null)
        {
            String s2 = s1.toUpperCase();
            if(!s2.matches("[A-F0-9]+"))
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid application ID: ").append(s1).toString());
            stringbuffer.append("/").append(s2);
        }
        if(collection != null)
        {
            if(collection.isEmpty())
                throw new IllegalArgumentException("Must specify at least one namespace");
            for(Iterator iterator = collection.iterator(); iterator.hasNext();)
            {
                String s3 = (String)iterator.next();
                if(TextUtils.isEmpty(s3) || s3.trim().equals(""))
                    throw new IllegalArgumentException("Namespaces must not be null or empty");
            }

            if(s1 == null)
                stringbuffer.append("/");
            stringbuffer.append("/").append(TextUtils.join(",", collection));
        }
        return stringbuffer.toString();
    }

    public static String languageTagForLocale(Locale locale)
    {
        final StringBuilder ret = new StringBuilder(20);
        ret.append(locale.getLanguage());

        final String var2 = locale.getCountry();
        if(!TextUtils.isEmpty(var2)) {
            ret.append('-').append(var2);
        }

        final String var3 = locale.getVariant();
        if(!TextUtils.isEmpty(var3)) {
            ret.append('-').append(var3);
        }

        return ret.toString();
    }

    private CastMediaControlIntent()
    {
    }

    public static final String CATEGORY_CAST = "com.google.android.gms.cast.CATEGORY_CAST";
    public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
    public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";
    public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";
    public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";
    public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";
    public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";
    public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";
    public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";
    public static final int ERROR_CODE_REQUEST_FAILED = 1;
    public static final int ERROR_CODE_SESSION_START_FAILED = 2;
    public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;
}
