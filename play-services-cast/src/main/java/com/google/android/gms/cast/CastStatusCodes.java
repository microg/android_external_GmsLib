// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.google.android.gms.cast;


public final class CastStatusCodes
{

    private CastStatusCodes()
    {
    }

    public static final int SUCCESS = 0;
    public static final int NETWORK_ERROR = 7;
    public static final int TIMEOUT = 15;
    public static final int INTERRUPTED = 14;
    public static final int AUTHENTICATION_FAILED = 2000;
    public static final int INVALID_REQUEST = 2001;
    public static final int CANCELED = 2002;
    public static final int NOT_ALLOWED = 2003;
    public static final int APPLICATION_NOT_FOUND = 2004;
    public static final int APPLICATION_NOT_RUNNING = 2005;
    public static final int MESSAGE_TOO_LARGE = 2006;
    public static final int MESSAGE_SEND_BUFFER_TOO_FULL = 2007;
    public static final int FAILED = 2100;
    public static final int REPLACED = 2103;
    public static final int INTERNAL_ERROR = 8;
    public static final int UNKNOWN_ERROR = 13;
}
